package com.github.durakin
package lab1

import scala.annotation.tailrec
import scala.io.StdIn.readLine
import scala.sys.exit


@main
def Main(): Unit =
  val x0 = scanDouble("Enter X0")
  val x1 = scanDouble("Enter Xn")
  val dx = math.abs(scanDouble("Enter dX (sign will be omitted)"))
  val e = math.abs(scanDouble("Enter required precision (sign will be omitted)"))
  val result = taylorArtanhInterval(x0, x1, dx, e)
  println("Every X with absolute value not above 1 will be skipped")
  val s = "%-8s | %-12s | %-12s | %-18s | %-8s | Iterations"
  println(s.format("x", "~f(x)", "f(x)", "delta", "delta/e"))
  result.foreach(x => println(f"${x._1}%08.4f | ${x._2._1}%012.9f | ${artanh(x._1)}%012.9f | ${math.abs(x._2._1 - artanh(x._1))}%1.16f | ${math.abs(x._2._1 - artanh(x._1)) / e}%08.6f | ${x._2._2}%6d"))
  exit(0)

def artanh(x: Double): Double =
  0.5 * math.log((1.0 + x) / (x - 1.0))

def taylorArtanhMono(x: Double, n: Int): Double =
  1.0 / ((2 * n + 1) * math.pow(x, 2 * n + 1))

@tailrec
def taylorArtanhRow(x: Double, e: Double, n: Int = 0, res: Double = 0): (Double, Int) =
  if math.abs(taylorArtanhMono(x, n)) < e then (res, n)
  else
    taylorArtanhRow(x, e, n + 1, res + taylorArtanhMono(x, n))


def taylorArtanhInterval(x0: Double, x1: Double, dx: Double, e: Double): List[(Double, (Double, Int))] =
  if x0 >= x1 then Nil
  else if math.abs(x0) > 1.1 then List((x0, taylorArtanhRow(x0, e))) ::: taylorArtanhInterval(x0 + dx, x1, dx, e)
  else taylorArtanhInterval(x0 + dx, x1, dx, e)


def scanDouble(msg: String = ""): Double =
  println(msg)
  try
    readLine().toDouble
  catch
    case nfe: NumberFormatException =>
      println("Got a NumberFormatException.")
      exit(-1)
