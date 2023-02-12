package example.proxy

/*
*
**/
class Printer : PrinterInterface {
    private var name: String

    constructor() {
        this.name = ""
        println("Printer의 인스턴스를 생성 중")
    }

    constructor(name: String) {
        this.name = name
        println("Printer의 인스턴스 (${name})을 생성 중")
    }

    private fun dpHeavyJob(name: String) {
        print("$name")
        for (i in 0 until 5) {
            try {
                Thread.sleep(1000)
            } catch (e: Exception) {
            }
            print(".")
        }
        println("완료.")
    }

    override fun setPrinterName(name: String) {
        this.name = name
    }

    override fun getPrinterName(): String {
        return name
    }

    override fun print(name: String) {
        println("===name===")
        println(name)
    }
}