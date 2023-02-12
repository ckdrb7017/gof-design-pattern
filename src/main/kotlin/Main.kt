import example.proxy.PrinterInterface
import example.proxy.PrinterProxy

fun main() {
    val printer: PrinterInterface = PrinterProxy(name = "ChangGyu")
    println("현재 이름은 ${printer.getPrinterName()} 입니다.")
    printer.setPrinterName("Charles Lee")
    println("현재 이름은 ${printer.getPrinterName()} 입니다.")
    println("완료.")
}