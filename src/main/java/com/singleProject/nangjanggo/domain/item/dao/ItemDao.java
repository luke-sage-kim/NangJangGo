package com.singleProject.nangjanggo.domain.item.dao;

import com.singleProject.nangjanggo.domain.item.model.Item;

import java.util.List;

public interface ItemDao {
    int totalItem();

    List<Item> ItemList(Item item);

    int seqItem(Item item);

    int addItem(Item item);

    int deleteItem(Integer  itemId);

    int searchCnt(Item item);

    List<Item> searchItem(Item item);
}
