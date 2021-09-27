package com.mao.gv04

/**
 * 闭包的三个重要变量： 默认都是最近的封闭类对象
 * this  代表闭包定义处的类。 -> 不能被修改
 * owner 代表闭包定义处的类或者对象，闭包内部可以嵌套闭包，那么就是临近闭包的那个定义处的类。 -> 不能被修改
 * delegate 代表任意对象，默认与owner一致。 delegate 可以被修改  -> 可以被修改
 *
 * 总结：
 * 1. this owner 和 delegate 在大多数情况下是一致
 * 2. 在闭包中定义闭包的时候  this owner 和 delegate 就不一样了
 * 3. 修改了闭包中的 delegate， 闭包中的 delegate 和 owner 就不一样了
 */

def scriptCloser = {
    println "script this = ${this}"
    println "script owner = ${owner}" // 目前 owner 代表是当前类
    println "script delegate = ${delegate}"
}
scriptCloser.call()

println "----------------------"

// 定义了一个内部类
class Person {

    // static 指向是类
    def static classClouser = {
        println "classClouser this = ${this}" // 代表 Person  -> classClouser this = class com.mao.gv04.Person
        println "classClouser owner = ${owner}" // 代表 Person -> classClouser owner = class com.mao.gv04.Person
        println "classClouser delegate = ${delegate}" // 代表 Person -> classClouser delegate = class com.mao.gv04.Person
    }

    def static say() {
        def classClouser = {
            println "method classClouser this = ${this}"
            // 代表 Person -> method classClouser this = class com.mao.gv04.Person
            println "method classClouser owner = ${owner}"
            // 代表 Person -> method classClouser owner = class com.mao.gv04.Person
            println "method classClouser delegate = ${delegate}"
            // 代表 Person -> method classClouser delegate = class com.mao.gv04.Person
        }
        classClouser.call()
    }

    // 非静态方法返回的是类的实例对象
    def sayNotStatic() {
        def classClouser = {
            println "sayNotStatic classClouser this = ${this}"
            // 代表 Person -> sayNotStatic classClouser this = com.mao.gv04.Person@4ce1d6d0
            println "sayNotStatic classClouser owner = ${owner}"
            // 代表 Person -> sayNotStatic classClouser owner = com.mao.gv04.Person@4ce1d6d0
            println "sayNotStatic classClouser delegate = ${delegate}"
            // 代表 Person -> sayNotStatic classClouser delegate = com.mao.gv04.Person@4ce1d6d0
        }
        classClouser.call()
    }
}

Person.classClouser.call()
Person.say()

Person p = new Person()
p.sayNotStatic()

println "----------------------"

// 闭包中定义一个闭包
def nestClouser = {

    // 在闭包中的闭包 使用 ${owner}  ${delegate} 会导致循环引用
    def innerClosuerRecycle = {
        println "innerClosuerRecycle this = ${this}"
        println "innerClosuerRecycle owner = ${owner}"
        println "innerClosuerRecycle delegate = ${delegate}"
    }
    // 会导致循环调用
    //innerClosuerRecycle.call()

    def innerClosuer = {
        println "innerClosuer this = " + this // innerClosuer this = com.mao.gv04.09_closeup@7241a47d
        println "innerClosuer owner = " + owner // innerClosuer owner = com.mao.gv04.09_closeup$_run_closure2@6179e425
        println "innerClosuer delegate = " + delegate
        // innerClosuer delegate = com.mao.gv04.09_closeup$_run_closure2@6179e425
    }
    innerClosuer.call()

    // 修改 delegate
    def innerClosuerMerge = {
        println "innerClosuerMerge this = " + this // innerClosuerMerge this = com.mao.gv04.09_closeup@7241a47d
        println "innerClosuerMerge owner = " + owner
        // innerClosuerMerge owner = com.mao.gv04.09_closeup$_run_closure2@6179e425
        println "innerClosuerMerge delegate = " + delegate // innerClosuerMerge delegate = com.mao.gv04.Person@ebaa6cb
    }
    // owner 和 this 是修改不了的
    innerClosuerMerge.delegate = p // 修改默认的 delegate 对象
    innerClosuerMerge.call()

}
nestClouser.call()

println "----------------------"

// 闭包的委托策略
class Student {
    String name
    String msg
    def pretty = { "Student name is ${name}  -- ${msg}" }

    @Override
    String toString() {
        return pretty.call()
    }
}

class Teacher {
    String name
}

def stu = new Student(name: 'zhang', msg: "学生的")
def tea = new Teacher(name: "jone")
println stu.toString() // Student name is zhang -- 学生的
stu.pretty.delegate = tea
println "修改 delegate 后 " + stu.toString() // 修改 delegate 后 Student name is zhang  -- 学生的
// 还需修改闭包的委托策略  默认策略是 Closure.OWNER_FIRST
stu.pretty.resolveStrategy = Closure.DELEGATE_ONLY  //  从 delegate 获取
//  Closure.DELEGATE_FIRST delegate 先从委托中查找，查不到就去 owner 中找
//  Closure.DELEGATE_ONLY 只从委托中找，没有就报错 -> groovy.lang.MissingPropertyException: No such property: msg for class: com.mao.gv04.Teacher
println "修改 resolveStrategy 委托策略 后 " + stu.toString() // 修改 resolveStrategy 委托策略 后 Student name is jone  -- 学生的