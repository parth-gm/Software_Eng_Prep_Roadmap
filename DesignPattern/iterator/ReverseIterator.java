package iterator;

public class ReverseIterator implements Iterator<Book> {
    private Book[] books;
    private int index;

    public ReverseIterator(Book[] books, int size) {
        this.books = books;
        this.index = size - 1;  // start at the last book
    }

    @Override
    public boolean hasNext() {
        return index >= 0;
    }

    @Override
    public Book next() {
        return books[index--];
    }
}
