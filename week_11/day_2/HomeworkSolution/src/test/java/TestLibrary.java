import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestLibrary {

    Book book1;
    Book book2;

    Library library;

    Borrower borrower;

    @Before
    public void setUp() throws Exception {
        book1 = new Book("The Wild Sheep Chase", "Haruki Murakami", "mystery");
        book2 = new Book("The Crow Road", "Ian Banks", "Mystery");

        borrower = new Borrower("John");

        library = new Library(1);
    }

    @Test
    public void canReportCapacity() {
        assertEquals(true, library.hasCapacity());
    }

    @Test
    public void canAddBook__whenThereIsRoom() {
        library.addBook(book1);
        assertEquals(1, library.bookCount());
    }

    @Test
    public void cantAddBook__whenNoRoom() {
        library.addBook(book1);
        library.addBook(book2);

        assertEquals(1, library.bookCount());
    }

    @Test
    public void checkBookAvailable() {
        assertEquals(false, library.checkInStock(book1));
    }

    @Test
    public void checkBookAvailable__true() {
        library.addBook(book1);
        assertEquals(true, library.checkInStock(book1));
    }

    @Test
    public void testCanLendBook() {
        // arrange
        library.addBook(book1);

        // act
        library.loanBook(book1, borrower);

        // assert
        assertEquals(1, borrower.bookCount());
        assertEquals(0, library.bookCount());
        assertEquals(false, library.checkInStock(book1));
    }
}
