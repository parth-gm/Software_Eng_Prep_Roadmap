package iterator;

public class Library {
    private Book[] books;
    private int count = 0;

    public Library(int size) {
        books = new Book[size];
    }

    public void addBook(Book book){
        books[count++] = book;
    }

    // 1️⃣ Forward iterator
    public Iterator<Book> createForwardIterator() {
        return new ForwardIterator(books, count);
    }

    // 2️⃣ Reverse iterator
    public Iterator<Book> createReverseIterator() {
        return new ReverseIterator(books, count);
    }
}
