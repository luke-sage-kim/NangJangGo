package com.singleProject.nangjanggo.domain.item.service;

import com.singleProject.nangjanggo.domain.item.dao.ItemDao;
import com.singleProject.nangjanggo.domain.item.model.Item;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ItemServiceImpl implements ItemService{
    private final ItemDao id;
    @Override
    public int totalItem() {
        int totalItem = id.totalItem();

        return totalItem;
    }

    @Override
    public List<Item> listItem(Item item) {
        List<Item> itemList = id.ItemList(item);
        return itemList;
    }

    @Override
    public int seqItem(Item item) {
        int result = 0;
        result = id.seqItem(item);
        return result;
    }

    @Override
    public int addItem(Item item) {
        int result = 0;
        result = id.addItem(item);
        return result;
    }

    @Override
    public int deleteItem(Integer  item_id) {
        int result = 0;
        result = id.deleteItem(item_id);
        return result;
    }

    @Override
    public int searchCnt(Item item) {
        int totalItem =id.searchCnt(item);
        return totalItem;
    }

    @Override
    public List<Item> searchItem(Item item) {
        List<Item> searchItemList = null;
        searchItemList = id.searchItem(item);

        return searchItemList;
    }
}
