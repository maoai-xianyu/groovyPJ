package com.mao.gv04

//def lists = new ArrayList() // java 的定义方式
def list = [1, 2, 3, 4, 5] // groovy 定义方式
println list.class  // class java.util.ArrayList
println list.size()

def array = [1, 2, 3, 4, 5] as int[] // 转化为数组
int[] array2 = [1, 2, 3, 4, 5] as int[] // 转化为数组
println array.class  // class [I
println array2.class // class [I

/**
 * 列表的排序
 */
def sortList = [6, -3, 9, 2, -7, 1, 5]
// 按照绝对值大小进行排序
Comparator mc = {
    a, b -> a == b ? 0 : Math.abs(a) < Math.abs(b) ? -1 : 1
}
Collections.sort(sortList, mc) // java的写法 中的排序
println sortList.toListString()  //[-7, -3, 1, 2, 5, 6, 9]  / 有 mc [1, 2, -3, 5, 6, -7, 9]
println sortList  // [-7, -3, 1, 2, 5, 6, 9] / 有 mc [1, 2, -3, 5, 6, -7, 9]

def sortListOne = [6, -3, 9, 2, -7, 1, 5]
//sortListOne.sort() //  [-7, -3, 1, 2, 5, 6, 9]
sortListOne.sort { a, b ->
    a == b ? 0 : Math.abs(a) < Math.abs(b) ? 1 : -1
}
println sortListOne // [1, 2, -3, 5, 6, -7, 9]


def stringList = ["abc", "z", "hello", "groovy", "java"]
// 长度进行排序
stringList.sort {
    it -> it.size()
}
println stringList

println "---------------"
/**
 * list 查找
 */
def sortListFind = [6, -3, 9, 2, -7, 1, 5]
def findList = sortListFind.find {
    return it % 2 == 0
}
println findList

def findListALL = sortListFind.findAll {
    return it % 2 == 0
}
println findListALL

def any = sortListFind.any {
    return it % 2 == 0
}
println any

def every = sortListFind.every {
    return it % 2 == 0
}
println every

println sortListFind.min()
println sortListFind.max {
    return Math.abs(it)
}