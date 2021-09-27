package com.mao.gv04

// 闭包
def closer = {
    println 'hello groovy'
}
closer.call() // hello groovy
closer()  //hello groovy   closer() 等价于 closer.call()

// 闭包中的参数
def closerOne ={ String str ->
    return "hello ${str}"
}
println closerOne("groovy!") // hello groovy!

// 返回值为 null
def closerTwo ={ String str ->
    println "hello ${str}"
}
println closerTwo("test") // null

