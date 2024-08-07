package solutions.librarymanagementsystem.services;

import solutions.librarymanagementsystem.models.Member;
import solutions.librarymanagementsystem.repositories.MemberRepository;

public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService() {
        this.memberRepository = new MemberRepository();
    }

    public void addMember(Member member) {
        this.memberRepository.addMember(member);
    }

    public void removeMember(String memberId) {
        this.memberRepository.removeMember(memberId);
    }

    public Member getMember(String memberId) {
        return this.memberRepository.getMember(memberId);
    }

}
