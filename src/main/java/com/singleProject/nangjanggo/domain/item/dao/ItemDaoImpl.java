package com.singleProject.nangjanggo.domain.item.dao;

import com.singleProject.nangjanggo.domain.item.model.Item;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ItemDaoImpl implements ItemDao{
    private final SqlSession session;
    @Override
    public int totalItem() {
        int totalCount = 0;

        try {
            totalCount = session.selectOne("itemTotal");

        } catch (Exception e) {
            log.info(e.getMessage());
        }

        return totalCount;
    }

    @Override
    public List<Item> ItemList(Item item) {
        List<Item> itemList = new ArrayList<>();


        try {
            itemList = session.selectList("itemList",item);
            System.out.println("ItemDaoImpl.ItemList");
            System.out.println("이건가itemList.size() = " + itemList.size());
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        return itemList;
    }

    @Override
    public int seqItem(Item item) {
        int result = 0;

        try {
            result = session.selectOne("seqItem",item);
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        return result;
    }

    @Override
    public int addItem(Item item) {
        int result = 0;

        try {
            result = session.insert("addItem",item);
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        return result;
    }

    @Override
    public int deleteItem(Integer  itemId) {
        int result = 0;

        try {
            result = session.delete("deleteItem",itemId);
        } catch (Exception e) {
            log.info(e.getMessage());
        }

        return result;
    }

    @Override
    public int searchCnt(Item item) {
        int totalsearchCnt = 0;
        try {

            System.out.println("검색 종류는?"+item.getSearch());
            System.out.println("키워드는?"+item.getKeyword());
            totalsearchCnt = session.selectOne("searchCnt",item);
            System.out.println("정상적으로 작동해야됨");
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        return totalsearchCnt;
    }

    @Override
    public List<Item> searchItem(Item item) {
        List<Item> searchItemList = null;
        try {
            searchItemList = session.selectList("itemSearchList",item);
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        return searchItemList;
    }
}
