package com.singleProject.nangjanggo.domain.refri.dao;

import com.singleProject.nangjanggo.domain.refri.model.Refri;

import java.util.List;

public interface RefriDao {
    int seqRefri(Refri refri);

    List<Refri> refriList(Refri refri);

    int addRefri(Refri refri);

    void deleteRefri(Integer refriId);

    void deleteCascade(Integer refriId);
}
