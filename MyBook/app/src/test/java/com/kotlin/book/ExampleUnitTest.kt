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
        inTest()
//        println("这里的值是 ${whenTest(3L)}")
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
        val listIn = listOf<String>("a", "b", "c")
        for (i in listIn) {
            println("list的值是$i")
        }

        // 过滤
        val postive = listIn.filter { it != "a" }

        for (i in postive) {
            println("过滤后的值是$i")
        }


        var mBool: Boolean = 10 !in 0..listIn.lastIndex
    }

    fun defaultTest(numOne: Int = 0, b: String = "我是默认") {
        println("我的参数是${numOne} ${b}")
    }
}

