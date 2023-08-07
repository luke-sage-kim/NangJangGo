package com.singleProject.nangjanggo.domain.item.service;

import com.singleProject.nangjanggo.domain.item.model.Item;

import java.util.List;

public interface ItemService {
    int totalItem();

    List<Item> listItem(Item item);

    int seqItem(Item item);

    int addItem(Item item);

    int deleteItem(Integer  item_id);

    int searchCnt(Item item);

    List<Item> searchItem(Item item);

}
