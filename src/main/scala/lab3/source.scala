package com.github.durakin
package lab3

import lab3.Profit.*

@main
def Main(): Unit =
  val list = CompanyList()
  list.add(Company("General motors", Array(Gain, Loss, Loss, Loss)))
  list.add(Company("Chrysler group", Array(Gain, Gain, Loss, Loss)))
  list.add(Company("Ford Motor", Array(Loss, Gain, Gain, Gain, Gain, Gain)))
  println(list.toString)
  println(list.isProfitable("General motors"))
  println(list.isProfitable("Chrysler group"))
  println(list.isProfitable("Ford Motor"))
  println(list.countProfitable())
  println(list.where(x => x.divisions.length > 4 ).toString())