package example.dynamicproxy

class HttpMethodImpl: HttpMethodInterface {
    override fun get(string: String){
        println("GET")
    }
    override fun post(){
        println("POST")
    }
    override fun put(){
        println("PUT")
    }
    override fun delete(){
        println("DELETE")
    }
}