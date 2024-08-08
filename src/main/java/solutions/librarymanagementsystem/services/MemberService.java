package solutions.librarymanagementsystem.services;

import solutions.librarymanagementsystem.exception.LMSException;
import solutions.librarymanagementsystem.models.BookItem;
import solutions.librarymanagementsystem.models.Member;
import solutions.librarymanagementsystem.repositories.MemberRepository;

import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService() {
        this.memberRepository = new MemberRepository();
    }

    public void addMember(Member member) {

        String memberId = member.getMemberId();
        Optional<Member> memberOptional = Optional.ofNullable(this.memberRepository.getMember(memberId));

        if (memberOptional.isEmpty()) {
            this.memberRepository.addMember(member);
        } else {
            throw new LMSException("Member with id " + memberId + " already exists in the system");
        }
    }

    public void removeMember(String memberId) {

        Optional<Member> memberOptional = Optional.ofNullable(this.memberRepository.getMember(memberId));

        if (memberOptional.isPresent()) {
            this.memberRepository.removeMember(memberId);
        } else {
            throw new LMSException("Member doesn't exist in the library.");
        }
    }

    public Member getMember(String memberId) {
        return this.memberRepository.getMember(memberId);
    }

}
