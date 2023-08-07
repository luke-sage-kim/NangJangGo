package com.singleProject.nangjanggo.domain.item.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
import java.time.LocalDate;

@Getter
@Setter
@ToString
public class Item {
    private long			item_id;
    private long			refri_id;
    private String			i_name;
    private String			i_category;
    private String			i_loc;
    private Date            i_expiration;

    private int start; 		 	private int end;

    private String search;   	private String keyword;
}
