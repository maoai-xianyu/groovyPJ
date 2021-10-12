package com.mao.gv04.object

/**
 * 2. 无论直接,还是调用get/set 方法，最终都是调用的 get/set 方法
 */
def person = new Person(name: 'Oandroid', age: 36)
println "this name is ${person.name}， the age is ${person.age}"
println "this name is ${person.getName()}， the age is ${person.getAge()}"
println "this name is ${person.getProperty('name')}， the age is ${person.getProperty('age')}"

person.increaseAge(10)

println person.cry()


// 为类动态的添加一个属性
Person.metaClass.sex = 'male'
def personS = new Person(name: 'Oandroid', age: 37)
println personS.sex

personS.sex = "famale"
println "the new sex is ${personS.sex}"

// 为类动态的添加方法
Person.metaClass.sexUpperCase = { -> sex.toUpperCase() }
def personF = new Person(name: 'OandroidF', age: 36)
println personF.sexUpperCase()

// 为类动态的添加静态的方法
Person.metaClass.static.createPerson = {
    String name, int age -> new Person(name: name, age : age)
}

def person3 = Person.createPerson("zhangren",13)
println person3.name +" andd " + person3.age

