package com.singleProject.nangjanggo.config;

import com.singleProject.nangjanggo.domain.member.model.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SessionUser implements Serializable {
    private long			member_id;
    private String			m_id;
    private String			m_pass;
    private String			m_name;
    private String			m_email;
    private Date            m_create;
    private Date            m_update;



    public SessionUser(Member member) {
        this.member_id = member_id;
        this.m_id = m_id;
        this.m_pass = m_pass;
        this.m_name = m_name;
        this.m_email = m_email;
        this.m_create = m_create;
        this.m_update = m_update;

    }
}
