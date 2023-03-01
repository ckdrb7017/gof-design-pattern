package example.dynamicproxy

import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.util.*

class HttpProxyHandler(
    private val target: Any? // 특정 구체화된 클래스
) : InvocationHandler {

    // Method 발생시 트리거 되는 함수
    override fun invoke(proxy: Any?, method: Method?, args: Array<out Any>?): Any? {
        println("-----------------------------------")
        HttpMethodInterface::class.members.forEach {
            if (method?.name?.contains(it.name) == true) {
                println("${it.name.uppercase(Locale.getDefault())} Method Called")
            }
        }
        println("Argument ${args?.get(0).toString()}")
        return method?.invoke(target, *args.orEmpty())
    }
}