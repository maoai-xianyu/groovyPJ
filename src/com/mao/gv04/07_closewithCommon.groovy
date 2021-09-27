package com.mao.gv04

def x = fabUp(5)
println x

def y = fabDown(5)
println y

// 求一个数的阶层 upto 中有for 循环，同时需要出入一个闭包
private static int fabUp(int number) {
    int result = 1
    1.upto(number, {
        result *= it
    })
    return result
}

// 同上的写法少有不同
private static int fabDown(int number) {
    int result = 1
    number.downto(1) {
        result *= it
    }
    return result
}

// 0+到100,使用 101，因为 times 方法
def time = plusOper(101)
println time // 5050

private static int plusOper(int number){
    int result = 0
    number.times {
        result += it
    }
    return result
}
