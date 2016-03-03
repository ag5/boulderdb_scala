package com.ag5.boulderdb.core

import com.ag5.boulderdb.backend.Payload

/**
  * Created by wouter on 3-3-16.
  */
case class ObjectFormat() extends Storable {
  def buildPayload(instance: Storable, writer: DataStoreWriter, v: CoreMarshallerV1): Payload = {
    ???
  }

}
