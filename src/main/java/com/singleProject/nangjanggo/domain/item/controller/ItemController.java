package com.singleProject.nangjanggo.domain.item.controller;

import com.singleProject.nangjanggo.domain.item.model.Item;
import com.singleProject.nangjanggo.domain.item.service.ItemService;
import com.singleProject.nangjanggo.domain.item.service.Paging;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class ItemController {
    private final ItemService is;

    @GetMapping(value = "item")
    public String item(@RequestParam(name = "refri_id") int refriId, Item item, Model model,  String currentPage){
        item.setRefri_id(refriId); // 요청 파라미터 refri_id를 item 객체에 설정
        System.out.println("현재 냉장고 아이디는? " + item.getRefri_id());

        int totalItem = is.totalItem();

        Paging paging = null;
        paging = new Paging(totalItem, currentPage);
        item.setStart(paging.getStart());
        item.setEnd(paging.getEnd());

        System.out.println("item.getStart()->"+item.getStart());
        System.out.println("item.getEnd()->"+item.getEnd());

        List<Item> itemList = is.listItem(item);

        log.info("itemList.size() -> " + itemList.size());



        model.addAttribute("page", paging);
        model.addAttribute("refri_id", refriId);
        model.addAttribute("totalItem", totalItem);
        model.addAttribute("listItem", itemList);
        return "item/itemList";
    }

    @PostMapping(value = "item")
    public String addItem(@DateTimeFormat(pattern = "yyyy/MM/dd") Item item, @RequestParam(name = "refri_id") int refriId) {
        int itemSeq = is.seqItem(item);
        item.setRefri_id(refriId);
        item.setItem_id(itemSeq);
        int addResult = is.addItem(item);
        return "redirect:/item?refri_id=" + refriId;
    }

    @DeleteMapping(value = "/item/{item_id}")
    @ResponseBody
    public String deleteItem(@PathVariable("item_id") Integer  item_id){

        int result = is.deleteItem(item_id);
        return "redirect:/item";
    }

    @GetMapping(value = "/search")
    public String searchItem(Item item, String currentPage, Model model){

        int totalItem = is.searchCnt(item);
        Paging paging = null;
        paging = new Paging(totalItem, currentPage);
        item.setStart(paging.getStart());
        item.setEnd(paging.getEnd());

        List<Item> searchItem = is.searchItem(item);

        model.addAttribute("page", paging);
        model.addAttribute("totalItem",totalItem);
        model.addAttribute("listItem",searchItem);

        return "item/itemList";

    }

}
