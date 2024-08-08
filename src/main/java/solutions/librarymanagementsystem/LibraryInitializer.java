package solutions.librarymanagementsystem;

import solutions.librarymanagementsystem.models.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class LibraryInitializer {

    public static List<BookItem> addBookItems(LibraryManager libraryManager) {

        List<BookItem> bookItems = new ArrayList<>();
        // Create some books and book items
        for (int i = 0; i < 2; i++) {
            Book book = Book
                    .newBuilder()
                    .setId("BOOK-ID-" + i)
                    .setTitle("Title " + i)
                    .setAuthors(Collections.singletonList("Author " + i))
                    .setPublishers(Collections.singletonList("Publisher " + i))
                    .build();

            System.out.println("Created a book " + book);

            for (int j = 0; j < 3; j++) {
                BookItem bookItem = BookItem
                        .newBuilder()
                        .setBookItemId("BOOK-ITEM-" + i + j)
                        .setPrice(10.0)
                        .setBookFormat(BookFormat.PAPERBACK)
                        .setBook(book)
                        .build();

                System.out.println("Created a book item " + bookItem);
                libraryManager.addBookItem(bookItem);
                bookItems.add(bookItem);

            }

            System.out.println("------------------------------------------------------------------------");
        }

        return bookItems;
    }

    public static List<Member> addMembers(LibraryManager libraryManager) {

        List<Member> members = new ArrayList<>();
        // Create members
        for (int i = 0; i < 3; i++) {
            MemberProfile memberProfile = new MemberProfile("Name " + i, "emailId" + i + ".com", "32183791", "Pune - " + i);
            Member member = new Member("MEMBER-ID-" + i, memberProfile);
            libraryManager.registerMember(member);
            members.add(member);
            System.out.println("Created a member " + member);
        }

        System.out.println("------------------------------------------------------------------------");

        return members;
    }
}
