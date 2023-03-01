import example.dynamicproxy.HttpMethodImpl
import example.dynamicproxy.HttpMethodInterface
import example.dynamicproxy.HttpProxyHandler
import java.lang.reflect.Proxy


fun main() {
    val httpMethodProxy: HttpMethodInterface = Proxy.newProxyInstance(
        HttpMethodInterface::class.java.classLoader,
        arrayOf<Class<*>>(HttpMethodInterface::class.java),
        HttpProxyHandler(target = HttpMethodImpl()) // method 발생시 이벤트를 처리할 핸들러
    ) as HttpMethodInterface

    httpMethodProxy.get("GET arg")
    httpMethodProxy.post()
    httpMethodProxy.put()
    httpMethodProxy.delete()
}