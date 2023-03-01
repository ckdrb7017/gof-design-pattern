package example.dynamicproxy

interface HttpMethodInterface {
    fun get(string: String){}
    fun post(){}
    fun put(){}
    fun delete(){}
}