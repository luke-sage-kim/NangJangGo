package com.singleProject.nangjanggo.domain.refri.controller;

import com.singleProject.nangjanggo.domain.refri.model.Refri;
import com.singleProject.nangjanggo.domain.refri.service.RefriService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@Slf4j
public class RefriController {
    private final RefriService rs;

    @PostMapping(value = "refri")
    public String addRefri(Refri refri, Model model
    , HttpSession session){
        Long memberId = (Long) session.getAttribute("loginId");
        refri.setMember_id(memberId);
        int refriSeq = rs.seqRefri(refri);
        System.out.println("refriSeq = " + refriSeq);
        refri.setRefri_id(refriSeq);
        int addResult = rs.addRefri(refri);


        return "redirect:/mypage";
    }
    //냉장고삭제
    @DeleteMapping(value = "/refri/{refri_id}")
    @ResponseBody
    public String refriDelete(@PathVariable("refri_id") Integer  refri_id){
        rs.deleteRefri(refri_id);
        return "redirect:/mypage";
    }

}
