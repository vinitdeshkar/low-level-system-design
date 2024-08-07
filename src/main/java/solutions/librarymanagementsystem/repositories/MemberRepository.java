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
        if (!memberMap.containsKey(member.getMemberId())) {
            memberMap.put(member.getMemberId(), member);
        } else {
            throw new LMSException("Member with id " + member.getMemberId() + " already exists in the system");
        }
    }

    public void removeMember(String memberId) {
        if (memberMap.containsKey(memberId)) {
            memberMap.remove(memberId);
        } else {
            throw new LMSException("Member with id " + memberId + " doesn't exist in the system");
        }
    }

    public Member getMember(String memberId) {
        if (memberMap.containsKey(memberId)) {
            return memberMap.get(memberId);
        } else {
            throw new LMSException("Member with id " + memberId + " doesn't exist in the system");
        }
    }
}
