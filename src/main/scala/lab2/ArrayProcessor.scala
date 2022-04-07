package com.github.durakin
package lab2

import scala.util.Random

trait ArrayProcessing:
  def ProcessArray(subject: Array[Int]): Int =
    subject.slice(subject.indexOf(0), subject.lastIndexOf(0)).sum

class ArrayProcessor(val subject: Array[Int]) extends ArrayProcessing :
  def this(n: Int) = this(Array.fill(n)(Random.nextInt(5)-2))

  def this(elements: Int*) = this(elements.toArray)

  private val _count = subject.count(p => true)

  def count: Int = _count

  def printArray(): Unit = subject.foreach(x => print(s"$x, "))

  def ProcessArray(): Int = super.ProcessArray(subject)

