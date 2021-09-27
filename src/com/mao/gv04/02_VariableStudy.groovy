package com.mao.gv04

int x = 10
println x.class //class java.lang.Integer

double y = 31.4
println y.class //class java.lang.Double

// 弱类型，自己使用的是时候定义为弱类型。如果当前类用于其他模块，用强类型定义
def s = 1.24f
println s.class //class java.lang.Float

def y_1 = 3.14
println y_1.class // java.math.BigDecimal
def y_2 = "Android"
println y_2.class // java.lang.String
y_1 = "change value string"
println y_1.class // class java.lang.String
