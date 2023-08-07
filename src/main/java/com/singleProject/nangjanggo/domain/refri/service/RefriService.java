package com.singleProject.nangjanggo.domain.refri.service;

import com.singleProject.nangjanggo.domain.refri.model.Refri;

import java.util.List;

public interface RefriService {
    int seqRefri(Refri refri);

    List<Refri> refriList(Refri refri);

    int addRefri(Refri refri);

    void deleteRefri(Integer refriId);


}
