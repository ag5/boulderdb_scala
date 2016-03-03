package com.ag5.boulderdb.core

/**
  * Created by wouter on 3/3/2016.
  */
case class Slot(key: Symbol, `type`: Type) extends Storable[Slot] {
  override def getSlots(): List[Slot] = ???
}
