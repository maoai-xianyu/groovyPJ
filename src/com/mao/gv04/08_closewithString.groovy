package com.mao.gv04

/**
 * 闭包和字符串的结合使用
 */

String str = "the 2 and 3 is 5"
// each 遍历 返回时 调用者 本身
println str.each {
    String tmp -> print tmp.multiply(2) // 2 倍
}

// find 来查找符合条件的第一个  -> 闭包的返回值必须是一个boolean类型
println str.find {
    String temp -> temp.isNumber()
}

// findALL 获取呼和条件的所有
def list = str.findAll {
    String s -> s.isNumber()
}
println list.toListString()

// any
def any = str.any {
        //  只要这个字符串包含数字就返回 true
    String s -> s.isNumber()
}
println any

// every
def every = str.every {
        // 每一项都是需要是数字
    String s -> s.isNumber()
}
println every

// collect
def listUP = str.collect {
    // 返回的每一个结果，应用添加到 list 集合
    String s -> s.toUpperCase()
}
println listUP.toListString()