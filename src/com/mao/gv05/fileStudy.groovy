package com.mao.gv05


def file = new File("../../../../whiteList.txt")

def lines = file.readLines()

def whiteList = [
        "R.drawable.ic_maoyan",
        "R.raw.webview_javascript_bridge",
        "R.string.movie_keep*" ,       //防止混淆拿不到资源名称，这里配置一下白名单
        "R.drawable.qiju_*",
        // 以下是防止 android.support.constraint.Group 其所包含的 ids
        "R.id.view_module_container"
]

println whiteList.toListString()

whiteList.addAll(file.readLines())

println whiteList.toListString()

println lines.toListString()

