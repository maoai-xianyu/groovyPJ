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

copy("../../../../groovyPJ.iml","../../../../groovyPJ2.iml")

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
                lines.each {line ->
                    writer.append(line +"\r\n")
                }
            }
            return true
        }

    } catch (Exception e) {
        e.printStackTrace()
    }
    return false
}
