package com.github.durakin
package lab3

enum Profit (val profit: Char){
  case Loss extends Profit('-')
  case Gain extends Profit('+')
}
