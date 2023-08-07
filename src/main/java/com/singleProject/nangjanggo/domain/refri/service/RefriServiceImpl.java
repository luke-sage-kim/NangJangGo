package com.singleProject.nangjanggo.domain.refri.service;

import com.singleProject.nangjanggo.domain.item.model.Item;
import com.singleProject.nangjanggo.domain.refri.dao.RefriDao;
import com.singleProject.nangjanggo.domain.refri.model.Refri;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RefriServiceImpl implements RefriService {
    private final RefriDao rd;

    @Override
    public int seqRefri(Refri refri) {
        int result = 0;
        result = rd.seqRefri(refri);
        return result;
    }

    @Override
    public List<Refri> refriList(Refri refri) {
        List<Refri> refriList = rd.refriList(refri);
        return refriList;    }

    @Override
    public int addRefri(Refri refri) {
        int result = 0;
        result = rd.addRefri(refri);

        return result;
    }

    @Override
    public void deleteRefri(Integer refriId) {
        rd.deleteCascade(refriId);
        rd.deleteRefri(refriId);
    }


}
