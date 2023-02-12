package example.proxy

interface PrinterInterface {
    fun setPrinterName(name: String)
    fun getPrinterName(): String
    fun print(name: String)
}