package extend

fun String.removeFormat(): String {
    return this.replace("R\$ ", "")
            .replace("$", "")
            .replace(",", "")
}
//converts

fun String.convertsStringFormatToDouble(): Double{
    return this.removeFormat().replace(".", "").toDouble()
}