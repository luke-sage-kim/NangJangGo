package com.singleProject.nangjanggo.domain.member.dao;

import com.singleProject.nangjanggo.domain.member.model.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class MemberDaoImpl implements MemberDao{
    private final SqlSession session;

    @Override
    public int seqMember(Member member) {
        int result = 0;
        try {
            result = session.selectOne("seqMember",member);
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        return result;
    }

    @Override
    public int memberJoin(Member member) {
        int result = 0;
        try {
            System.out.println("아이디는? "+member.getM_id());
            result = session.insert("joinMember",member);
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        return result;
    }

    @Override
    public String memberPass(Member member) {
        String result = null;
        try {
            result = session.selectOne("passMember",member);
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        return result;

    }

    @Override
    public Member memberInfo(Member member) {
        try {
            member = session.selectOne("infoMember",member);
            System.out.println("name은?->"+member.getM_name());
        } catch (Exception e) {
            log.info(e.getMessage());
        }

        return member;
    }



    @Override
    public int memberUpdate(Member member) {

        try {
            int result = session.update("updateMember",member);
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        return 0;
    }

    @Override
    public void memberDelete(Member member) {
        session.delete("deleteMember",member);

    }


}
