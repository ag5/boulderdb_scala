package com.ag5.boulderdb.backend

import scala.collection.mutable

/**
  * Created by wouter on 3-3-16.
  */
class InMemoryBackend extends DataStoreBackEnd {
  private var map = new mutable.HashMap[HashKey, Payload]()
  private var headVersions = new mutable.HashMap[String, HashKey]()

  override def get(key: HashKey): Option[Payload] = map.get(key)

  override def put(key: HashKey, value: Payload): Unit = map.put(key, value)

  override def getHeadVersion(key: String): Option[HashKey] = headVersions.get(key)

  override def putHeadVersion(key: String, value: HashKey): Unit =
    headVersions.put(key, value)
}
