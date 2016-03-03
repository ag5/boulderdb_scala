package com.ag5.boulderdb.core

import com.ag5.boulderdb.backend.{DataStoreBackEnd, HashKey}

import scala.collection.mutable

/**
  * Created by wouter on 3-3-16.
  */
class DataStore(backend: DataStoreBackEnd, headID: String) {
  def identityCacheGet(hashKey: HashKey): Option[Storable] = ???

  def get(hashKey: HashKey):Storable = ???

  def dataStoreWriterDo[X](aBlock: (DataStoreWriter) => X): X = {
    val writer = new DataStoreWriter(this)
    var res = aBlock(writer);
    writer.commit()
    return res
  }

  def put(instance: Storable) = {
      dataStoreWriterDo(writer => {
        writer.store(instance)
      })
  }



}
