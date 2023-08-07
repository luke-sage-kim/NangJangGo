package com.singleProject.nangjanggo.domain.refri.dao;

import com.singleProject.nangjanggo.domain.refri.model.Refri;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class RefriDaoImpl implements  RefriDao{
    private final SqlSession session;

    @Override
    public int seqRefri(Refri refri) {
        int result = 0;

        try {
            result = session.selectOne("seqRefri",refri);
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        return result;
    }

    @Override
    public List<Refri> refriList(Refri refri) {
        List<Refri> refriList = new ArrayList<>();
        try {
            refriList = session.selectList("refriList", refri);
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        return refriList;
    }

    @Override
    public int addRefri(Refri refri) {
        int result = 0;
        try {
            result = session.insert("addRefri",refri);
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        return result;
    }

    @Override
    public void deleteRefri(Integer refriId) {
        try {
            session.delete("deleteRefri",refriId);
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }

    @Override
    public void deleteCascade(Integer refriId) {
        try {
            session.delete("deleteCascade",refriId);
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }
}
