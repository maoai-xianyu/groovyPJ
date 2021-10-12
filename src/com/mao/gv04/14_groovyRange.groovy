package com.mao.gv04

import org.w3c.dom.ranges.Range

/**
 * 范围的定义
 */

def range = 1..10
println range[0]
println range.contains(10)
println range.from // 起始
println range.to // 终止

// 遍历
range.each {
    println it
}
for(i in range){
    println i
}

groovy.lang.Range
def result = getGrade(90)
println result
// 返回值为 string
def getGrade(Number number){
    def result
    switch (number){
        case 0..<60:
            result = '不及格'
            break
        case 60..<70:
            result = '及格'
            break
        case 70..<80:
            result = '中等'
            break
        case 80..<90:
            result = '良好'
            break
        default:
            result = '优秀'
            break
    }
    return result
}
