package ii_dsl

sealed class Element

class TextElement(private val text: String) : Element() {
    override fun toString() = text
}

class Tag(private val name: String, var children: MutableList<Element> = mutableListOf(), val attributes: MutableMap<String, String> = mutableMapOf()) : Element() {
    private fun renderChildren() = children.joinToString(separator = "") { it.toString() }

    override fun toString(): String {
        return "<$name${hasAttributes()}${renderAttributes()}>" +
                renderChildren() +
                "</$name>"
    }

    private fun renderAttributes() =
            attributes.entries.joinToString(separator = " ") { "${it.key}=\"${it.value.replace("\"", "\\\"")}\"" }

    private fun hasAttributes() = when {
        attributes.isEmpty() -> ""
        else -> " "
    }

    fun text(s: String) {
        children.add(TextElement(s))
    }

    operator fun String.unaryPlus() {
        text(this)
    }
}



fun Tag.div(body: Tag.() -> Unit) {
    createTag(body, "div")
}

private fun Tag.createTag(body: Tag.() -> Unit, name: String) {
    val element = Tag(name)
    body(element)
    this.children.add(element)
}

fun Tag.span(body: Tag.() -> Unit) {
    createTag(body, "span")
}

fun Tag.h1(body: Tag.() -> Unit) {
    createTag(body, "h1")
}

fun createHTML(bodyOfHtml: Tag.() -> Unit): Tag {
    val tag = Tag("body")
    bodyOfHtml(tag)
    return tag
}

fun main(args: Array<String>) {
    buildString {
        val createHTML = createHTML() {
            span {
                div {
                    +"text\n"
                    +"text2"
                    div {
                        +"Text inside tag after text"
                    }
                    div {
                        h1 {
                            span {
                                attributes["style"] = "color: #FFF;"
                                text("ya text")
                            }
                        }
                    }
                }
            }
        }
        append(createHTML.toString())
    }.let { println(it) }
}