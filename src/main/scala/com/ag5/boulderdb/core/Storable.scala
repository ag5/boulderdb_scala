package com.ag5.boulderdb.core

import com.ag5.boulderdb.backend.HashKey

/**
  * Created by wouter on 3-3-16.
  */
trait Storable[T] {
  private var boulderKey: HashKey = null

  def magicallySetKey(newKey: HashKey): Unit = {
    boulderKey = newKey
  }

  def objectFormat: ObjectFormat[T]

  def hashKeyOption = Option(boulderKey)

}
