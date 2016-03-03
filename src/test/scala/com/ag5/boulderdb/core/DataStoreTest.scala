package com.ag5.boulderdb.core

import com.ag5.boulderdb.backend.InMemoryBackend
import org.specs2.mutable.Specification

/**
  * Created by wouter on 3-3-16.
  */
class DataStoreTest extends Specification {
  "A DataStore" should {
    "save and restore an object" {
      val user = TestObject (foo="bar")
      val datastore = new DataStore(backend=new InMemoryBackend(), headID="KaasDB")
      val hashKey = datastore.put(user)

      val user = datastore.get(hashKey)
    }
  }

}

case class TestObject(foo: String)
