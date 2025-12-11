package iterator;

public class IteratorDemo {

    static void main() {

        Library lib = new Library(10);
        lib.addBook(new Book("Clean Code"));
        lib.addBook(new Book("Design Patterns"));
        lib.addBook(new Book("Refactoring"));
        lib.addBook(new Book("Effective Java"));

        System.out.println("Forward:");
        Iterator<Book> fwd = lib.createForwardIterator();
        while (fwd.hasNext()) {
            System.out.println(fwd.next().getTitle());
        }

        System.out.println("Backward:");
        Iterator<Book> rev = lib.createReverseIterator();
        while (rev.hasNext()) {
            System.out.println(rev.next().getTitle());
        }

    }
}
