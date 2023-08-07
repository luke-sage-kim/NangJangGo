package com.singleProject.nangjanggo.domain.refri.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
@Getter
@Setter
@ToString
public class Refri {
    private  long 				refri_id;
    private  long 				member_id;
    private String	 				r_name;
    private LocalDate           create_date;
    private LocalDate	 		modified_date;
}

//    REFRI_ID
//    R_NAME
//     MEMBER_ID
