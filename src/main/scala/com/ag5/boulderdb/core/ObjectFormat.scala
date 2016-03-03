package com.ag5.boulderdb.core

import com.ag5.boulderdb.backend.{HashKey, Payload}

/**
  * Created by wouter on 3-3-16.
  */
case class ObjectFormat(slots: List[Slot]) extends Storable[ObjectFormat] {
  def keyForPayload(payload: Payload): HashKey = ???

  def buildPayload(instance: Storable, writer: DataStoreWriter, v: CoreMarshallerV1): Payload = {
    ???
  }

}
