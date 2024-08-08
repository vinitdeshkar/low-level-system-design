package solutions.librarymanagementsystem.repositories;

import solutions.librarymanagementsystem.exception.LMSException;
import solutions.librarymanagementsystem.models.Member;

import java.util.HashMap;
import java.util.Map;

public class MemberRepository {

    private final Map<String, Member> memberMap;

    public MemberRepository() {
        this.memberMap = new HashMap<>();
    }

    public void addMember(Member member) {
        memberMap.putIfAbsent(member.getMemberId(), member);
    }

    public void removeMember(String memberId) {
        memberMap.remove(memberId);
    }

    public Member getMember(String memberId) {
        return memberMap.get(memberId);
    }
}
