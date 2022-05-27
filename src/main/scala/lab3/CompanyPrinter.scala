package com.github.durakin
package lab3

object CompanyPrinter extends Printer[Company] {
  override def print(company: Company): Unit = {
    println(company.toString)
  }
}