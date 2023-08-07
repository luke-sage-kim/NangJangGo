package com.singleProject.nangjanggo.domain.member.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Getter
@Setter
@ToString
public class Member {
    private long			member_id;
    private String			m_id;
    private String			m_pass;
    private String			m_name;
    private String			m_email;
    private Date            m_create;
    private Date            m_update;

}
//    MEMBER_ID
//    M_ID
//    M_PASS
//    M_NAME
//    M_EMAIL
//    M_CREATE
//    M_UPDATE