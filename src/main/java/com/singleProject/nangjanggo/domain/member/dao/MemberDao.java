package com.singleProject.nangjanggo.domain.member.dao;

import com.singleProject.nangjanggo.domain.member.model.Member;

public interface MemberDao {
    int seqMember(Member member);

    int memberJoin(Member member);

    String memberPass(Member member);

    Member memberInfo(Member member);

    void memberDelete(Member member);

    int memberUpdate(Member member);

}
