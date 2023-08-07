package com.singleProject.nangjanggo.domain.member.controller;

import com.singleProject.nangjanggo.domain.member.model.Member;
import com.singleProject.nangjanggo.domain.member.service.MemberService;
import com.singleProject.nangjanggo.domain.refri.model.Refri;
import com.singleProject.nangjanggo.domain.refri.service.RefriService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MemberController {
    private final MemberService ms;
    private final RefriService rs;
    //가입창이동
    @GetMapping(value = "join")
    public String memberGoJoin(){

        return "member/joinForm";
    }
    //가입
    @PostMapping(value = "join")
    public String memberJoin(Member member, Model model){
        int memberseq = ms.seqMember(member);
        member.setMember_id(memberseq);
        int joinMember = ms.memberJoin(member);

        return "index";
    }

    //로그인
    @PostMapping(value = "/login")
    public String memberLogin(Member member,Model model, HttpSession session){
        Member loginMember = ms.memberLogin(member);
        int loginYn =0;
        if (loginMember == null){
            model.addAttribute("loginYn",loginYn);
            return "/index";
        }


        if (!loginMember.getM_name().isEmpty()){
            System.out.println("세션의 이름은? = " + loginMember.getM_name());
            session.setAttribute("loginName", loginMember.getM_name());
            session.setAttribute("loginId",loginMember.getMember_id());
            session.setAttribute("loginM_ID",loginMember.getM_id());
            session.setAttribute("loginM_PASS",loginMember.getM_pass());
            session.setAttribute("loginM_EMAIL",loginMember.getM_email());
             loginYn =1;


        }
        System.out.println("로그인여부 1이면 성공->"+loginYn);
        model.addAttribute("loginYn",loginYn);
        return "/index";
    }
    //로그아웃
    @GetMapping("/logout")
    public String memberLogout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "/index";
    }
    //마이페이지
    @GetMapping("/mypage")
    public String memberPage( HttpSession session, Model model,Refri refri) {
        Long memberId = (Long) session.getAttribute("loginId");
        refri.setMember_id(memberId);
        List<Refri> refriList = rs.refriList(refri);
        System.out.println("사이즈는? "+refriList.size());
        model.addAttribute("listRefri",refriList);

        return "member/myPage";
    }
    //회원수정
    @PostMapping("member/update")
    public String memberUpdate(Member member,HttpSession session){
        Long memberId = (Long) session.getAttribute("loginId");
        member.setMember_id(memberId);
        System.out.println("memberId는? "+memberId);
        System.out.println("member이름은? "+member.getM_name());
        int updateMember = ms.memberUpdate(member);
        session.setAttribute("loginName", member.getM_name());
        return "redirect:/mypage";

    }
    //회원탈퇴
    @PostMapping("/member/delete")
    public String memberDelete(HttpSession session){
        Long memberId = (Long) session.getAttribute("loginId");
        Member member = new Member();
        member.setMember_id(memberId);
         ms.memberDelete(member);
        return "/index";
    }


}
