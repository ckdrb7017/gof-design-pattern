package example.proxy

// Printer의 대리 클래스
class PrinterProxy : PrinterInterface {
    private var name: String = ""
    private lateinit var realPrinter: Printer // 실제 프린터

    constructor(name: String) {
        this.name = name
    }

    override fun setPrinterName(name: String) {
        if (this::realPrinter.isInitialized) {
            realPrinter.setPrinterName(name = name)
        }
        this.name = name
    }

    override fun getPrinterName(): String {
        return name
    }

    override fun print(name: String) {
        realize()
        realPrinter.print(name)
    }

    private fun realize() {
        if (this::realPrinter.isInitialized.not()) {
            realPrinter = Printer(name = name)
        }
    }
}