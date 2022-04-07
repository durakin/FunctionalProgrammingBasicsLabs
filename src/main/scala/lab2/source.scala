package com.github.durakin
package lab2

import scala.sys.exit

@main
def Main(): Unit =
  val c = new ArrayProcessor(2, 0, 4, 7, 0, 7)
  c.printArray()
  println(c.count)
  println(c.ProcessArray())
  val d = new ArrayProcessor(10)
  d.printArray()
  println()
  println(d.ProcessArray())

