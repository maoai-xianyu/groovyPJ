package com.mao.gv04.metaclass
/**
 * 管理类
 */
class PersonManager {

    static PersonMeta createPerson(String name, int age) {
        return PersonMeta.createPersonMate(name, age)
    }
}
