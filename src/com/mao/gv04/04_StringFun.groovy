package com.mao.gv04

def str = "groovy"

println str.center(7, 'a') // groovya center以字符串为中心，向两边进行填充。大于字符串长度之后，先填充右边，再填充左边
println str.center(8, 'a') // agroovya
println str.padLeft(8, 'a') // 填充字符串的左边 aagroovy

def str2 = 'Hello'
def str3 = 'sssss Hello'
println str > str2   // true > 使用操作符 直接比较字符串的大小
println str <=> str2  // 等价于 str.compareTo(str2)
println str2 > str3   // false

println str[0]
println str.getAt(0) //  => str[0]
println str[0..1] // gr

println str3 - str2 // sssss  =>对应 str3.minus(str2) -- 减法运算 除去 str3 中包含的 str2

println str.reverse() // 倒序
println str.capitalize() // 第一个字符大写

def numString = "6666"
println numString.isNumber() // true  是否是数字类型的num
