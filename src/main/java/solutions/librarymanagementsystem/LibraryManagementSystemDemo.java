package solutions.librarymanagementsystem;

import solutions.librarymanagementsystem.models.Book;
import solutions.librarymanagementsystem.models.BookItem;
import solutions.librarymanagementsystem.models.Member;

import java.util.List;

public class LibraryManagementSystemDemo {

    private static final String BOOK_TITLE_TO_SEARCH = "Title 0";

    public static void main(String[] args) {

        LibraryManager libraryManager = LibraryManager.getInstance();

        System.out.println("-----------------ADDING BOOK ITEMS TO THE LIBRARY----------------------");
        List<BookItem> bookItems = LibraryInitializer.addBookItems(libraryManager);

        System.out.println("-----------------ADDING MEMBERS TO THE LIBRARY--------------------------");
        List<Member> members = LibraryInitializer.addMembers(libraryManager);

        Member libraryMember = members.getFirst();

        System.out.println("-------------------SEARCHING BOOKS WITH BOOK TITLE: " + BOOK_TITLE_TO_SEARCH + "---------------------");

        List<Book> matchingBooks = libraryManager.searchBooksByTitle(BOOK_TITLE_TO_SEARCH);
        System.out.println("Found matching books: " + matchingBooks);

        Book matchingLibraryBook = matchingBooks.getFirst();

        System.out.println("---------------------FINDING BOOK ITEMS WITH BOOK TITLE: " + matchingLibraryBook.getTitle() + " ------------------------");

        List<BookItem> libraryBookItems = libraryManager.getAllBookItemsByBook(matchingLibraryBook);

        BookItem libraryBookItem = libraryBookItems.getFirst();

        System.out.println("Borrowing book item with id " + libraryBookItem.getBookItemId() + " for member id " + libraryMember.getMemberId());
        BookItem bookItem = libraryManager.borrowBook(libraryMember, libraryBookItem);

        List<BookItem> borrowedBookItems = libraryMember.getBorrowedBookItems();
        System.out.println("Borrowed book items by library members :" + borrowedBookItems);

        System.out.println("----------------------------RETURNING BOOK ITEM----------------------------------");

        System.out.println("Returning book item with id " + libraryBookItem.getBookItemId() + " for member id " + libraryMember.getMemberId());
        libraryManager.returnBook(libraryMember, libraryBookItem);

        borrowedBookItems = libraryMember.getBorrowedBookItems();
        System.out.println("Member book items " + borrowedBookItems);

    }

}
