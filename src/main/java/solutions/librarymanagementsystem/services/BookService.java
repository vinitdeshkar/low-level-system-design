package solutions.librarymanagementsystem.services;

import solutions.librarymanagementsystem.models.Book;
import solutions.librarymanagementsystem.models.BookItem;
import solutions.librarymanagementsystem.repositories.BookRepository;

import java.util.List;
import java.util.stream.Collectors;

public class BookService {

    private final BookRepository bookRepository;

    public BookService() {
        this.bookRepository = new BookRepository();
    }

    public void addBookItem(BookItem bookItem) {
        this.bookRepository.addBookItem(bookItem);
    }

    public void removeBookItem(BookItem bookItem) {
        this.bookRepository.removeBookItem(bookItem);
    }

    public BookItem getBookItem(String bookItemId) {
        return this.bookRepository.getBookItem(bookItemId);
    }

    public List<Book> searchBooksByTitle(String keyword) {
        return this.bookRepository.getAllBooks().stream().filter(book ->
                book.getTitle().contains(keyword)
        ).collect(Collectors.toList());
    }


}
