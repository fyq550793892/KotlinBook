package com.kotlin.book

import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    var c: Int? = null

    @Test
    fun addition_isCorrect() {
//        defaultTest()
//        inTest()
//        println("这里的值是 ${whenTest(3L)}")
        withAndRunAndApplyUse()
    }

    fun sum(a: Int, b: Int): Int {
        println("调用这里${a + b}")
        return a + b
    }

    fun whenTest(obj: Any): String {

        val mObj = when (obj) {
            1 -> "One"
            "two" -> "Two"
            is Long -> "Long"
            !is String -> "NotString"
            else -> "Un"
        }
        return mObj

    }

    private fun inTest() {
        for (i in 1..10) {
            println("i的值是$i")
        }

        // 列表定义
        val listIn = listOf<String>("a", "b", "c")

        // map定义
        val mapIn = mapOf("a" to 1, "b" to 2, "c" to "a")
        for (i in listIn) {
            println("list的值是$i")
        }

        // 过滤
        val postive = listIn.filter { it != "a" }

        for (i in postive) {
            println("过滤后的值是$i")
        }


        var mBool: Boolean = "10" !in listIn
    }

    fun defaultTest(numOne: Int = 0, b: String = "我是默认") {
        println("我的参数是${numOne} ${b}")
    }

    // let函数的使用 let用于辅助判空,而不用一直用?.来判空
    fun letUse(str: String?) {
        // 未使用let前
        str?.length
        str?.get(0)
        str?.reader()

        // 使用let后
        str?.let {
            it.length
            it[0]
            it.reader()
        }
    }

    // with/run/apply 标准函数的使用 其用于连续调用,可以返回用户规定的类型
    fun withAndRunAndApplyUse() {
        // 不用with
        val builder: StringBuilder = StringBuilder()
        builder.append("f")
        builder.toString()

        // 使用with,这里可以返回String
        with(StringBuilder()) {
            append("f")
            toString()
        }

        // 使用run,这里result类型是最后的一个方法返回的类型 即int
        val result = StringBuilder().run {
            append("a")
            toString()
            capacity()
        }
        println("这里的值是run $result")

        // 使用apply,这里resultApply类型只能是StringBuilder
        val resultApply = StringBuilder().apply {
            append("a")
            toString()
            capacity()
        }

        println("这里的值是apply $resultApply")

    }

}

