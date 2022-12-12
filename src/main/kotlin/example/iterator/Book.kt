package example.iterator

fun main() {
    val bookShelf = BookShelf(
        maxSize = 5
    )

    bookShelf.appendBook(Book("Around the World"))
    bookShelf.appendBook(Book("Bible"))
    bookShelf.appendBook(Book("Cinderella"))
    bookShelf.appendBook(Book("Show Me"))
    bookShelf.appendBook(Book("The Money"))

    val iterator = bookShelf.iterator()
    while (iterator.hasNext()) {
        println("iterator : ${(iterator.next() as Book).name}")
    }

}

data class Book(val name: String)

interface Aggregate {
    fun iterator(): Iterator<*>
}

class BookShelf(
    maxSize: Int
) : Aggregate {
    private var bookList: Array<Book> = Array(maxSize) { Book("") }
    private var lastIndex = 0

    override fun iterator(): Iterator<*> {
        return BookShelfIterator(this)
    }

    fun getBookByPosition(index: Int): Book {
        return bookList[index]
    }

    fun appendBook(book: Book) {
        bookList[lastIndex] = book
        lastIndex++
    }

    fun getLength(): Int {
        return lastIndex
    }
}

class BookShelfIterator(
    private val bookShelf: BookShelf,
    private var index: Int = 0
) : Iterator<Book> {

    override fun hasNext(): Boolean {
        return index < bookShelf.getLength()
    }

    override fun next(): Book {
        return bookShelf.getBookByPosition(index++)
    }
}