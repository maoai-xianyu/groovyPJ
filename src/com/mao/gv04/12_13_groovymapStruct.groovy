package com.mao.gv04
/**
 * map 数据结构 映射关系
 */
//def map = new HashMap() // java 定义
def colorsTemp = [red  : 'ff0000',
                  green: 888,
                  blue : 1.346f] // 可以添加各种类型


def colors = [red  : 'ff0000',
              green: '00ff00',
              blue : '000000']
// 索引方式
println colors.red
println colors['blue']
println colors['xxxx'] // null
// 添加元素
colors.yellow = 'ffff00' // 直接添加
println colors.toMapString() // [red:ff0000, green:00ff00, blue:000000, yellow:ffff00]

// 添加多个元素
colors.complex = [a: 1, b: 2]
println colors.toMapString() // [red:ff0000, green:00ff00, blue:000000, yellow:ffff00, complex:[a:1, b:2]]
println colors.getClass() // class java.util.LinkedHashMap
println '---------------------'
/**
 * map 操作
 */
def students = [
        1: [number: '0001', name: 'Nob', score: 55, sex: 'male'],
        2: [number: '0002', name: 'Johnny', score: 62, sex: 'female'],
        3: [number: '0003', name: 'Claire', score: 73, sex: 'female'],
        4: [number: '0004', name: 'Amy', score: 66, sex: 'male']
]
// 遍历
students.each {
    def student ->
        println "this key is ${student.key} , this value is ${student.value}"
}
// 带索引的遍历
students.eachWithIndex { def student, int index ->
    println "index is ${index} this key is ${student.key} , this value is ${student.value}"
}
// 直接编列 key 和 value
students.each {
    key, value ->
        println "this key is ${key} , this value is ${value}"
}
students.eachWithIndex { key, value, int index ->
    println "index is ${index} this key is ${key} , this value is ${value}"
}
// 查找
def entry = students.find { def student ->
    return student.value.score >= 60
}
println entry

def entries = students.findAll { def student ->
    return student.value.score >= 60
}
println entries
def count = students.count {
    def student ->
        return student.value.score >= 60 && student.value.sex == 'male'
}
println count

def names = students.findAll { def student ->
    return student.value.score >= 60
}.collect { // collect 过滤名字
    return it.value.name
}
println names.toListString()

//分组
def group = students.groupBy {
    def student ->
        return student.value.score >= 60 ? '及格' : '不及格'
}
println group.toMapString()

// 排序，返回新的map
def sort = students.sort {
    def student1, def student2 ->
        Number score1 = student1.value.score
        Number score2 = student2.value.score
        return score1 == score2 ? 0 : score1 < score2 ? -1 : 1
}
println sort.toMapString()
