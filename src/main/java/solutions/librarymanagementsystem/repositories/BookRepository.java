package solutions.librarymanagementsystem.repositories;

import solutions.librarymanagementsystem.models.Book;
import solutions.librarymanagementsystem.models.BookItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BookRepository {
    private final Map<String, Book> booksMap;
    private final Map<String, BookItem> bookItemsMap;

    public BookRepository() {
        this.booksMap = new HashMap<>();
        this.bookItemsMap = new HashMap<>();
    }

    public void addBookItem(BookItem bookItem) {
        Book book = bookItem.getBook();
        String bookId = book.getId();
        String bookItemId = bookItem.getBookItemId();
        booksMap.put(bookId, book);
        bookItemsMap.put(bookItemId, bookItem);
    }

    public void removeBookItem(BookItem bookItem) {
        String bookItemId = bookItem.getBookItemId();
        bookItemsMap.remove(bookItemId);
    }

    public BookItem getBookItem(String bookItemId) {
        return bookItemsMap.get(bookItemId);
    }

    public Book getBook(String bookId) {
        return booksMap.get(bookId);
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(this.booksMap.values());
    }

    public List<BookItem> getAllBookItemsByBook(Book book) {

        String bookId = book.getId();
        return this.bookItemsMap
                .values()
                .stream()
                .filter(bookItem -> bookItem.getBook().getId().equals(bookId))
                .collect(Collectors.toList());
    }

}
