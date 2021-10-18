package com.mao.gv05.net

import groovy.json.JsonOutput
import groovy.json.JsonSlurper


def response = getNetworkData("https://wanandroid.com/wxarticle/chapters/json")

println response.data[0].name

def getNetworkData(String url){

    // 发送网络请求
    def connection = new URL(url).openConnection()
    connection.setRequestMethod('GET')
    connection.connect()
    def response = connection.content.text
    println JsonOutput.prettyPrint(response)
    println "-------"
    // 将json 转换为实体对象
    def jsonSlurper = new JsonSlurper()
    def text = jsonSlurper.parseText(response)
    return text
}