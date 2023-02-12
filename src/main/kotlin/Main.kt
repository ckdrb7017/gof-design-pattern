import example.dynamicproxy.HttpMethodInterface
import example.dynamicproxy.HttpProxyHandler
import java.lang.reflect.Proxy


fun main() {
    val httpMethodInterface: HttpMethodInterface = Proxy.newProxyInstance(
        HttpMethodInterface::class.java.classLoader,
        arrayOf<Class<*>>(HttpMethodInterface::class.java),
        HttpProxyHandler(target = null) // method 발생시 이벤트를 처리할 핸들러
    ) as HttpMethodInterface

    httpMethodInterface.get()
    httpMethodInterface.post()
    httpMethodInterface.put()
    httpMethodInterface.delete()
}