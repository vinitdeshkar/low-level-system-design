package solutions.librarymanagementsystem;

import solutions.librarymanagementsystem.models.Book;
import solutions.librarymanagementsystem.models.BookItem;
import solutions.librarymanagementsystem.models.Member;

import java.util.List;

public class LibraryManagementSystemDemo {

    public static void main(String[] args) {

        LibraryManager libraryManager = LibraryManager.getInstance();

        System.out.println("-----------ADDING BOOK ITEMS-------------");
        List<BookItem> bookItems = LibraryInitializer.addBookItems(libraryManager);

        System.out.println("-----------ADDING MEMBERS-------------");
        List<Member> members = LibraryInitializer.addMembers(libraryManager);

        String memberId = members.getFirst().getMemberId();
        String bookItemId = bookItems.getFirst().getBookItemId();


        System.out.println("Borrowing book item with id " + bookItemId + " for member id " + memberId);
        BookItem bookItem = libraryManager.borrowBook(memberId, bookItemId);

        List<BookItem> borrowedBookItems = members.getFirst().getBorrowedBookItems();
        System.out.println("Borrowed book items " + borrowedBookItems);

        System.out.println("-----------RETURN BOOK ITEM-------------");

        System.out.println("Returning book item with id " + bookItemId + " for member id " + memberId);
        libraryManager.returnBook(memberId, bookItemId);

        borrowedBookItems = members.getFirst().getBorrowedBookItems();
        System.out.println("Member book items " + borrowedBookItems);

        System.out.println("--------------SEARCHING BOOKS------------------------");

        List<Book> matchingBooks = libraryManager.searchBooksByTitle("Title");

        System.out.println(matchingBooks);
    }

}
