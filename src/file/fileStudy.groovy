package file


def f = new File("../../whiteList.txt")

def lines = ["w2www","2222"]

lines.addAll(f.readLines())

println lines.toListString()


def ff = new File("../../whiteList.txt").readLines()

def liness = ["w2www","2222"]

liness.addAll(ff)

println liness.toListString()