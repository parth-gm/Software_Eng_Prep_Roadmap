package iterator;

public class ForwardIterator implements Iterator<Book>{
    Book[] books;
    int size;
    int pos;
    ForwardIterator(Book[] books, int count){
        this.books =books;
        this.size = count;

    }

    @Override
    public boolean hasNext() {
        return this.pos<this.size;
    }

    @Override
    public Book next() {
        return books[this.pos++];
    }
}
