package com.mao.gv04

def name = 'this is single String'
println name.class  // class java.lang.String
name = 'this is \' single \' String'
println name

// '''''' 可以打出多行  \ 可有可没有
def tuppleName = '''\
this is trupple name,
and I am studying.
ok 
'''
println tuppleName
println tuppleName.class

// "" 为可扩展的字符串
def doubleName = "this us common String"
println doubleName.class // class java.lang.String

// $扩展表达式
def testName = "test ${doubleName}"
println testName
println testName.class // class org.codehaus.groovy.runtime.GStringImpl

def mathTest = "the sum 2 + 3 = ${2 + 3}"
println mathTest

def msg = echo(mathTest)
println msg // the sum 2 + 3 = 5
println msg.class //class java.lang.String

String echo(String msg) {
    return msg
}