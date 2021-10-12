package com.mao.gv04.metaclass

/**
 * 应用的管理类，
 */
class ApplicationManager {

    static void init() {
        // 全局注册 mataClass
        ExpandoMetaClass.enableGlobally()
        // 为第三方类添加方法，可以让其他也可以使用
        PersonMeta.metaClass.static.createPersonMate = {
            String name, int age ->
                return new PersonMeta(name: name, age: age)
        }
    }
}
