package extend

fun String.removeFormat(): String {
    return this.replace("R\$ ", "")
            .replace("$", "")
            .replace(",", "")
}

fun String.convertsStringFormatToDouble(): Double {
    return this.removeFormat().replace(".", "").toDouble() / 100
}

fun String.isUnknown() = this == "Unknown"

