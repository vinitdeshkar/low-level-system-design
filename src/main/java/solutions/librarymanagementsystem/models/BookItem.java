package solutions.librarymanagementsystem.models;

// This class represents copy of the book.
public class BookItem {

    private final String bookItemId;
    private final BookFormat bookFormat;
    private final double price;
    private final Book book; // Reference to book object

    public BookItem(String bookItemId, BookFormat bookFormat, Book book, double price) {
        this.bookItemId = bookItemId;
        this.bookFormat = bookFormat;
        this.book = book;
        this.price = price;
    }

    public String getBookItemId() {
        return bookItemId;
    }

    public Book getBook() {
        return book;
    }

    public BookFormat getBookFormat() {
        return bookFormat;
    }

    public double getPrice() {
        return price;
    }

    public static BookItemBuilder newBuilder() {
        return new BookItemBuilder();
    }

    public static class BookItemBuilder {

        private String bookItemId;
        private BookFormat bookFormat;
        private double price;
        private Book book; // Reference to book object

        public BookItemBuilder setBookItemId(String bookItemId) {
            this.bookItemId = bookItemId;
            return this;
        }

        public BookItemBuilder setBookFormat(BookFormat bookFormat) {
            this.bookFormat = bookFormat;
            return this;
        }

        public BookItemBuilder setPrice(double price) {
            this.price = price;
            return this;
        }

        public BookItemBuilder setBook(Book book) {
            this.book = book;
            return this;
        }

        public BookItem build() {
            return new BookItem(this.bookItemId, this.bookFormat, this.book, this.price);
        }

    }

}
