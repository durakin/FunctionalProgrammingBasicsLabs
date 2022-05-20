package com.github.durakin
package lab3

case class Company (name: String, divisions: Array[Profit]) {
  override def toString: String = "Company " + name + ", divisions' profit last month:\n" + divisions.mkString(" ")
}
