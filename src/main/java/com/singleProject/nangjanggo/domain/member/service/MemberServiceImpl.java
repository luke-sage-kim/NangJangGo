package com.singleProject.nangjanggo.domain.member.service;

import com.singleProject.nangjanggo.config.SessionUser;
import com.singleProject.nangjanggo.domain.member.dao.MemberDao;
import com.singleProject.nangjanggo.domain.member.model.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberServiceImpl implements MemberService {
    private final MemberDao md;
   // private final HttpSession session;

    @Override
    public int seqMember(Member member) {
        int result = 0;
        result = md.seqMember(member);
        return result;
    }

    @Override
    public int memberJoin(Member member) {
        int result = 0;
        result = md.memberJoin(member);
        return result;
    }

    @Override
    public Member memberLogin(Member member) {
        String inputPass = member.getM_pass();
        String pass = md.memberPass(member);
        if (pass ==null){
            System.out.println("아이디가 존재 하지 않습니다");
            member = null;
            return member;
        }

        if (pass.equals( inputPass)){
            member = md.memberInfo(member);
            System.out.println("서비스임name은?->"+member.getM_name());

        }
        else {
            System.out.println("비밀번호가다른듯");
            member = null;
        }
        return member;
    }

    @Override
    public void memberDelete(Member member) {
       md.memberDelete(member);

    }

    @Override
    public int memberUpdate(Member member) {
        int result = md.memberUpdate(member);
        return result;
    }
}
