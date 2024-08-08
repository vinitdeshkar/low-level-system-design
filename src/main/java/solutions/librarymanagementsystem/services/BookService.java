package solutions.librarymanagementsystem.services;

import solutions.librarymanagementsystem.exception.LMSException;
import solutions.librarymanagementsystem.models.Book;
import solutions.librarymanagementsystem.models.BookItem;
import solutions.librarymanagementsystem.repositories.BookRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookService {

    private final BookRepository bookRepository;

    public BookService() {
        this.bookRepository = new BookRepository();
    }

    public void addBookItem(BookItem bookItem) {
        String bookItemId = bookItem.getBookItemId();
        Optional<BookItem> bookItemOptional = Optional.ofNullable(this.bookRepository.getBookItem(bookItemId));

        if (bookItemOptional.isEmpty()) {
            this.bookRepository.addBookItem(bookItem);
        } else {
            throw new LMSException("Book item already exists in the library.");
        }
    }

    public void removeBookItem(BookItem bookItem) {

        String bookItemId = bookItem.getBookItemId();
        Optional<BookItem> bookItemOptional = Optional.ofNullable(this.bookRepository.getBookItem(bookItemId));

        if (bookItemOptional.isPresent()) {
            this.bookRepository.removeBookItem(bookItem);
        } else {
            throw new LMSException("Book item doesnt exist in the library.");
        }

    }

    public BookItem getBookItem(String bookItemId) {
        return this.bookRepository.getBookItem(bookItemId);
    }

    public List<Book> searchBooksByTitle(String keyword) {
        return this.bookRepository
                .getAllBooks()
                .stream()
                .filter(book -> book.getTitle().contains(keyword))
                .collect(Collectors.toList());
    }

    public List<BookItem> getAllBookItemsByBook(Book book) {

        String bookId = book.getId();
        Optional<Book> bookOptional = Optional.ofNullable(this.bookRepository.getBook(bookId));

        if (bookOptional.isEmpty()) {
            throw new LMSException("Book doesnt exist in the library.");
        }
        return this.bookRepository.getAllBookItemsByBook(book);
    }


}
