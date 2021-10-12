package com.mao.gv04.metaclass

import com.mao.gv04.object.Person

/**
 *
 */
class Entry {

    // 应用入口
    static void main(def args) {
        println '应用程序正在启动...'

        // 调用咋其他类中注册的方法，报错 Exception in thread "main" groovy.lang.MissingMethodException
        // 因为不是全局注册
        //def person3 = Person.createPerson("zhangren",13)
        //println person3.name +" andd " + person3.age

        // 初始化
        ApplicationManager.init()
        println '应用程序初始化完成...'
        def person = PersonManager.createPerson("android", 25)
        println "the personMeta ${person.name}  age is ${person.age}"


    }
}
