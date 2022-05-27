package com.github.durakin
package lab3

object CompanyListPrinter extends Printer [CompanyList] {
  override def print(companyList: CompanyList): Unit = {
    println(companyList.toString)
  }
}
