package com.ag5.boulderdb.core

import com.ag5.boulderdb.backend.HashKey

import scala.collection.mutable

/**
  * Created by wouter on 3-3-16.
  */
class DataStoreWriter(store: DataStore) {
  val scheduled = new mutable.HashMap[HashKey, Storable]()
  def store(instance: Storable): HashKey = {
    /* First check whether the instance already has
         - a calculated key
            - and already exists in the store
            - or is already scheduled for write
         */
    val currentKey = instance.hashKeyOption()
    currentKey.map((hashKey)=> {
      val currentInstance = store.identityCacheGet(hashKey)
      currentInstance.map((inst) => { return hashKey })
      val currentScheduled = scheduled.get(hashKey)
      currentScheduled.map((inst) => { return hashKey })
      scheduled.put(hashKey, instance)
    })
    /* If the object is not stored or scheduled; store it: */
    /* First store its objectFormat: */
    val objectFormat = instance.objectFormat()
    store(objectFormat)
    /* Next; calculate the payload of this instance: */
    val payload = objectFormat.buildPayload(instance, this, new CoreMarshallerV1())

    if(!currentKey.isDefined) {
      val newKey = objectFormat.keyForPayload(payload)
      instance.magicallySetKey(newKey)
      val currentScheduled = scheduled.get(newKey)
      currentScheduled.map((inst) => { return newKey })
      scheduled.put(newKey, instance)
    }
  }

  def commit() = ???

}
