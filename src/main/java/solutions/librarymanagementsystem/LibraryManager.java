package solutions.librarymanagementsystem;

import solutions.librarymanagementsystem.exception.LMSException;
import solutions.librarymanagementsystem.models.Book;
import solutions.librarymanagementsystem.models.BookItem;
import solutions.librarymanagementsystem.models.Member;
import solutions.librarymanagementsystem.services.BookService;
import solutions.librarymanagementsystem.services.MemberService;

import java.util.List;
import java.util.Optional;

public class LibraryManager {

    private static LibraryManager instance;
    private static final int MAX_BOOKS_PER_MEMBER = 5;
    private final BookService bookService;
    private final MemberService memberService;

    private LibraryManager() {
        this.bookService = new BookService();
        this.memberService = new MemberService();
    }

    public static synchronized LibraryManager getInstance() {
        if (instance == null) {
            instance = new LibraryManager();
            return instance;
        }
        return instance;
    }

    public void addBookItem(BookItem bookItem) {
        this.bookService.addBookItem(bookItem);
    }

    public void removeBookItem(BookItem bookItem) {
        this.bookService.removeBookItem(bookItem);
    }

    public synchronized BookItem borrowBook(Member member, BookItem bookItem) {

        Optional<Member> memberOptional = Optional.ofNullable(this.memberService.getMember(member.getMemberId()));
        Optional<BookItem> bookItemOptional = Optional.ofNullable(this.bookService.getBookItem(bookItem.getBookItemId()));

        if (memberOptional.isPresent() && bookItemOptional.isPresent()) {
            if (member.getBorrowedBookItems().size() < MAX_BOOKS_PER_MEMBER) {
                this.bookService.removeBookItem(bookItem);
                member.borrowBookItem(bookItem);
                return bookItem;
            } else {
                throw new LMSException("Member " + member.getMemberProfile().getName() + " has already borrowed max no of allowed books.");
            }
        }

        return bookItem;
    }

    public synchronized void returnBook(Member member, BookItem bookItem) {

        Optional<Member> memberOptional = Optional.ofNullable(this.memberService.getMember(member.getMemberId()));

        if (memberOptional.isPresent()) {
            member.returnBook(bookItem);
            this.bookService.addBookItem(bookItem);
        } else {
            throw new LMSException("Either member/book is not found OR book is not available.");
        }
    }

    public List<Book> searchBooksByTitle(String keyword) {
        return this.bookService.searchBooksByTitle(keyword);
    }

    public boolean registerMember(Member member) {
        this.memberService.addMember(member);
        return true;
    }

    public List<BookItem> getAllBookItemsByBook(Book book) {
        return this.bookService.getAllBookItemsByBook(book);
    }

    public void unregisterMember(String memberId) {
        this.memberService.removeMember(memberId);
    }

    public Member getMember(String memberId) {
        return this.memberService.getMember(memberId);
    }


}
