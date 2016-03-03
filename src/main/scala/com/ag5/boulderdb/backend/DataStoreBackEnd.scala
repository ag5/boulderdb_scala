package com.ag5.boulderdb.backend

import scala.collection.mutable.HashMap

/**
  * Created by Wouter on 3/3/2016.
  */


trait DataStoreBackEnd {
  def get(key: HashKey): Option[Payload]

  def put(key: HashKey, value: Payload)

  def getHeadVersion(key: String): Option[HashKey]

  def putHeadVersion(key: String, value: HashKey)

}