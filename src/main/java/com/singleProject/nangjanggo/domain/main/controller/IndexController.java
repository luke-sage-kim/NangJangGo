package com.singleProject.nangjanggo.domain.main.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
public class IndexController {


    @GetMapping(value = {"/","/index"})
    public  String Main(){

        return  "index";
    }


}
