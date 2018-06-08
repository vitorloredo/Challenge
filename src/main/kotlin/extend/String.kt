package extend

fun String.removeFormat(): String {
    return this.replace("R\$ ", "")
            .replace("$", "")
            .replace(",", "")
}