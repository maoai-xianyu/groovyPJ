package com.mao.gv05

def file = new File("../../../../groovyPJ.iml")
file.eachLine {
    println it
}
println "-----------------"
def text = file.getText()
println text

println "--------------------"
def result = file.readLines()
println result.toListString()

println "--------------------"

// 读取文件部分内容
def reader = file.withReader { reader ->
    char[] buffer = new char[100]
    // 将数据读入 buffer
    reader.read(buffer)
    return buffer
}

println reader.toString()

copy("../../../../groovyPJ.iml", "../../../../groovyPJ2.iml")

// 读取文件复制到另外一个文件中
static def copy(String sourcePath, String destanionPath) {
    try {
        // 创建目标文件
        def desFile = new File(destanionPath)
        if (!desFile.exists()) {
            desFile.createNewFile()
        }
        // copy
        new File(sourcePath).withReader { reader ->
            def lines = reader.readLines()
            desFile.withWriter { writer ->
                lines.each { line ->
                    writer.append(line + "\r\n")
                }
            }
            return true
        }

    } catch (Exception e) {
        e.printStackTrace()
    }
    return false
}

println "--------------------"
// 写文件的时候需要进行序列化
def people = new People(name: "android",age: 18)

//saveObject(people,"../../../../people.bin")

def p = (People)readObject("../../../../people.bin")
println "the age is ${p.age}  -- the name is ${p.name}"
// 把对象保存到文件中
static def saveObject(Object object, String path) {
    try {
        def file = new File(path)
        if (!file.exists()) {
            file.createNewFile()
        }
        file.withObjectOutputStream { outStream ->
            outStream.writeObject(object)
        }
        return true
    } catch (Exception e) {
        e.printStackTrace()
    }
    return false
}

def readObject(String path) {
    def obj = null
    try {
        def file = new File(path)
        if (file == null || !file.exists()) {
            return null
        }
        file.withObjectInputStream { inStream ->
            obj = inStream.readObject()
        }
    } catch (Exception e) {
        e.printStackTrace()
    }
    return obj
}