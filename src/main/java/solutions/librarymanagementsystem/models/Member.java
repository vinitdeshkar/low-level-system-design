package solutions.librarymanagementsystem.models;

import java.util.ArrayList;
import java.util.List;

public class Member {

    private final String memberId;

    private final MemberProfile memberProfile;

    private final List<BookItem> borrowedBookItems;

    public Member(String memberId, MemberProfile memberProfile) {
        this.memberId = memberId;
        this.memberProfile = memberProfile;
        this.borrowedBookItems = new ArrayList<>();
    }

    public void borrowBookItem(BookItem bookItem) {
        this.borrowedBookItems.add(bookItem);
    }

    public void returnBook(BookItem bookItem) {
        this.borrowedBookItems.remove(bookItem);
    }

    public String getMemberId() {
        return memberId;
    }

    public MemberProfile getMemberProfile() {
        return memberProfile;
    }

    public List<BookItem> getBorrowedBookItems() {
        return borrowedBookItems;
    }
}
