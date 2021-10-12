package com.mao.gv04.object
/**
 *
 * 1. groovy 中默认都是public
 * 2. 默认实现 GroovyObject
 *
 */
class Person implements Action {

    String name
    Integer age

    // 定义方法， def 是这个方法对的的返回值， object 类型
    def increaseAge(Integer years) {
        this.name += years
    }

    @Override
    void eat() {

    }

    @Override
    void drink() {

    }

    @Override
    void play() {

    }

    /**
     * 一个方法找不到时，且没有 methodMissing 方法时，调用invokeMethod代替。如果什么都美欧，就会报错
     * @param name
     * @param args
     * @return  person.cry()  -> the method is cry, the params is []
     */
    def invokeMethod(String name, Object args) {
        return "the method is ${name}, the params is ${args}"
    }

    /**
     *  一个方法找不到时，调用methodMissing代替。 当然还需要考虑 metaClass
     * @param name
     * @param args
     * @return  person.cry()  -> the method is missing
     */
    def methodMissing(String name, Object args) {
        return "the method is missing"
    }
}
