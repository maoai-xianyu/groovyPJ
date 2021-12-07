package com.mao.gv05

import groovy.xml.XmlSlurper


final String xml = '''
    <response version-api="2.0">
        <value>
            <books id="1" classification="android">
                <book available="20" id="1">
                    <title>疯狂Android讲义</title>
                    <author id="1">李刚</author>
                </book>
                <book available="14" id="2">
                   <title>第一行代码</title>
                   <author id="2">郭林</author>
               </book>
               <book available="13" id="3">
                   <title>Android开发艺术探索</title>
                   <author id="3">任玉刚</author>
               </book>
               <book available="5" id="4">
                   <title>Android源码设计模式</title>
                   <author id="4">何红辉</author>
               </book>
           </books>
           <books id="2" classification="web">
               <book available="10" id="1">
                   <title>Vue从入门到精通</title>
                   <author id="4">李刚</author>
               </book>
           </books>
       </value>
    </response>
'''

// 开始解析xml数据
def xmlSlurper = new XmlSlurper()
// 解析成功
def response = xmlSlurper.parseText(xml)
println response.toString()
println response.value.books[0].book[0].title.text()

// @ 可以获取对应的节点
println response.value.books[1].book[0].@available

// 一般遍历
def list = []
response.value.books.each { books ->
    books.book.each { book ->
        def author = book.author.text()
        if (author.equals("李刚")) {
            list.add(book.title.text())
        }
    }
}

println list.toString()

// 深度遍历方法
def titles = response.depthFirst().findAll { book ->
    //return book.author.text().equals("李刚")  //[疯狂Android讲义李刚, Vue从入门到精通李刚]
    return book.author.text() == "李刚" ? true : false
}
println titles.toListString()


// '**' 深度遍历  可以代替 depthFirst
def tls = response.'**'.findAll { book ->
    //return book.author.text().equals("李刚")  //[疯狂Android讲义李刚, Vue从入门到精通李刚]
    return book.author.text() == "李刚" ? true : false
}
println tls.toListString()


// 广度遍历
def name = response.value.books.children().findAll { node ->
    node.name() == 'book' && node.@id == '2'
}.collect { node ->
    return node.title.text()
}
println  " name -- $name"

// '*' 广度遍历 代替 children() 方法
def names = response.value.books.'*'.findAll { node ->
    node.name() == 'book' && node.@id == '2'
}.collect { node ->
    return node.title.text()
}
println "names -- $names"

int temp = -101
println "只 $temp"


// 生成 xml
/**
 * 生成xml格式数据
 * <langs type='current' count='3' mainstream='true'>
 <language flavor='static' version='1.5'>Java</language>
 <language flavor='dynamic' version='1.6.0'>Groovy</language>
 <language flavor='dynamic' version='1.9'>JavaScript</language>
 </langs>
 */









