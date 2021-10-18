package com.mao.gv05

import com.google.gson.Gson
import groovy.json.JsonOutput
import groovy.json.JsonSlurper

def list = [new People(name: "01", age: 22), new People(name: "02", age: 23)]
// 转换json 实体转json
def json = JsonOutput.toJson(list)
println json.toString()
println JsonOutput.prettyPrint(json)

// json 字符串转换为对象  使用 JsonSlurper 对象实现

def str = '''
[
    {
        "age": 22,
        "name": "01"
    },
    {
        "age": 23,
        "name": "02"
    }
]
'''
def jsonSlurper = new JsonSlurper()
def person = jsonSlurper.parseText(str) as List<People>
println person.toListString()

// 引入第三方的库  gson
def gson = new Gson()
def gsonStr = gson.toJson(list)
println gsonStr

