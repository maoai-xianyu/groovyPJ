package com.mao.gv04.object

/**
 * 适配器模式
 * trait 也是接口，方法可以有空实现
 */
trait DefaultAction {

    abstract void eat()

    void play() {
        println 'i can play'
    }

}