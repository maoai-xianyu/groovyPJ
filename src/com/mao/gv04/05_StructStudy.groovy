package com.mao.gv04

def x = 1.23
def result
// switch 可以添加任意数据类型 x or x.class
switch (x.class) {
    case 'foo':
        result = 'found food'
        break
    case 'bar':
        result = 'bar'
        break
    case [1.23, 4, 5, 6, 'inlist']:
        result = 'list'
        break
    case 12..30:
        result = 'range' // 数组的范围
        break
    case Integer:
        result = 'Integer'
        break
    case BigDecimal:
        result = 'BigDecimal'
        break
    default:
        result = 'default'
}
println result // list


// -------- for
def sum = 0
for (i in 0..9) {
    sum += i
}
println sum + " = for in range"

sum = 0
/**
 * 对list的循环 [1,2,3,4,5,5] list 比较想java 中的数字
 */
for (i in [1, 2, 3, 4, 5, 6]) {
    sum += i
}
println sum + " = for in list"

sum = 0
/**
 * 对Map进行循环
 */
for (i in ['lili': 1, 'luck': 2]) {
    sum += i.value
}
println sum + " = for in map"
