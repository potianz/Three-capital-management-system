package com.sxlg.service;

import com.sxlg.bean.ZYGL;
import com.sxlg.mapper.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    @Autowired
    private TestDao testDao;
    public List<ZYGL> testS(){
        List<ZYGL> list = testDao.test();
        return list;
    }
    public Boolean isDel(int rid){
        return testDao.isDelete(rid);
    }
    public ZYGL testOne(int rid){
        return testDao.selectOne(rid);
    }
    public boolean update(ZYGL zygl){
        return testDao.update(zygl);
    }
    public boolean add(ZYGL zygl){
        return testDao.add(zygl);
    }
}
