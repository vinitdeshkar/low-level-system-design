package solutions.librarymanagementsystem;

import solutions.librarymanagementsystem.models.Book;
import solutions.librarymanagementsystem.models.BookItem;
import solutions.librarymanagementsystem.models.Member;

import java.util.List;

public class LibraryManagementSystemDemo {

    public static void main(String[] args) {

        LibraryManager libraryManager = LibraryManager.getInstance();

        List<BookItem> bookItems = LibraryInitializer.addBookItems(libraryManager);
        List<Member> members = LibraryInitializer.addMembers(libraryManager);

        String memberId = members.getFirst().getMemberId();
        String bookItemId = bookItems.getFirst().getBookItemId();

        BookItem bookItem = libraryManager.borrowBook(memberId, bookItemId);

        System.out.println("Borrowed book with bookItem Id " + bookItem.getBookItemId());
        System.out.println("Borrowed book with title" + bookItem.getBook().getTitle());
        
        libraryManager.returnBook(memberId, bookItemId);

        List<Book> matchingBooks = libraryManager.searchBooksByTitle("Title");

        System.out.println(matchingBooks);
    }

}
