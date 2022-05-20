package com.github.durakin
package lab3

import com.github.durakin.lab3.Profit.{Gain, Loss}

import scala.collection.mutable.ListBuffer

class CompanyList {
  private val list: ListBuffer[Company] = ListBuffer()

  def this(companies: ListBuffer[Company]) = {
    this()
    companies.foreach(x => add(x))
  }

  def add(company: Company): Unit = {
    list.append(company)
  }

  def deleteByName(name: String): Unit = {
    delete(findIndexByName(name))
  }

  def isProfitable(name: String): Boolean = {
    isProfitable(findByName(name))
  }

  def countProfitable(): Int = {
    list.count(x => isProfitable(x)) - list.count(x => !isProfitable(x))
  }

  private def findIndexByName(name: String): Int = {
    list.indexWhere(x => x.name == name)
  }

  private def findByName(name: String): Company = {
    list.find(x => x.name == name).get
  }

  private def delete(index: Int): Unit = {
    list.remove(index)
  }

  private def isProfitable(company: Company): Boolean = {
    company.divisions.count(x => x == Gain) >= company.divisions.count(x => x == Loss)
  }

  def where(filter: Company => Boolean): CompanyList = {
    CompanyList(list.filter(filter))
  }

  override def toString: String = list.mkString("\n")
}
