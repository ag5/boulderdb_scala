package com.ag5.boulderdb.backend

import org.specs2.mutable.Specification

/**
  * Created by wouter on 3-3-16.
  */
class DataStoreBackEndTest extends Specification {
  "A datastore backend" should {
    "return stored Payloads" in {
      val hashKey: HashKey = new Array[Byte](20)
      scala.util.Random.nextBytes(hashKey)

      val payload: Payload = new Array[Byte](100)
      scala.util.Random.nextBytes(payload)

      val backend = new InMemoryBackend()
      backend.put(hashKey, payload)

      val value = backend.get(hashKey)
      value must beSome(payload)

    }

    "return stored headVersions" in {
      val hashKey: HashKey = new Array[Byte](20)
      scala.util.Random.nextBytes(hashKey)

      val backend = new InMemoryBackend()
      backend.putHeadVersion("Kaas" ,hashKey)

      val value = backend.getHeadVersion("Kaas")
      value must beSome(hashKey)

    }
  }
}
