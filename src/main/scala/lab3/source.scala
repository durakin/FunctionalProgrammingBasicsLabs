package com.github.durakin
package lab3

import lab3.Profit.*

@main
def Main(): Unit =
  val list = CompanyList()
  val c1 = Company("General motors", Array(Gain, Loss, Loss, Loss))
  val c2 = Company("Chrysler group", Array(Gain, Gain, Loss, Loss))
  val c3 = Company("Ford Motor", Array(Loss, Gain, Gain, Gain, Gain, Gain))
  list.add(c1)
  list.add(c2)
  list.add(c3)
  //println(list.toString)
  //println(list.isProfitable("General motors"))
  //println(list.isProfitable("Chrysler group"))
  //println(list.isProfitable("Ford Motor"))
  //println(list.countProfitable())
  //println(list.where(x => x.divisions.length > 4 ).toString())


  def printCompanyList(printer: Printer, companyList: CompanyList): Unit = {
    printer.print(companyList)
  }

  def printCompany(printer: Printer, company: Company): Unit = {
    printer.print(company)
  }

