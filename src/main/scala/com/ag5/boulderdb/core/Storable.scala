package com.ag5.boulderdb.core

import com.ag5.boulderdb.backend.HashKey

/**
  * Created by wouter on 3-3-16.
  */
trait Storable {
  def objectFormat(): ObjectFormat = ???

  def hashKeyOption(): Option[HashKey] = ???

}
