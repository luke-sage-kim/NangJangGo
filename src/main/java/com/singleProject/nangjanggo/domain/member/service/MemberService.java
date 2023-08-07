package com.singleProject.nangjanggo.domain.member.service;

import com.singleProject.nangjanggo.domain.member.model.Member;

public interface MemberService {
    int seqMember(Member member);

    int memberJoin(Member member);

    Member memberLogin(Member member);

    void memberDelete(Member member);

    int memberUpdate(Member member);
}
