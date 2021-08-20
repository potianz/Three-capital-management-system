package com.sxlg.service;

import com.sxlg.bean.Money;
import com.sxlg.mapper.MoneyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MoneyService {
    @Autowired
    MoneyMapper moneyMapper;

    public List<Money> getcountrySideList(String name) {
        return moneyMapper.getcountrySideList(name,0);
    }

    public void toDelete(int id) {
        moneyMapper.deleteById(id);
    }

    public void toSaveCountryside(String name, String totalMoney) {
        moneyMapper.SaveCountryside(name,totalMoney);
    }

    public List<Money> selectTotalMoney(int id) {
        return  moneyMapper.getcountrySideList(null,id);
    }

    public List<Money> selectReduceMoney(int id, int mid) {
        return moneyMapper.selectReduceMoney(id,mid);
    }

    public List<Money> selectAddMoney(int id, int mid) {
        return  moneyMapper.selectAddMoney(id,mid);
    }

    public void toDeleteReduce(int id) {
        moneyMapper.deleteReduce(id);
    }

    public void toDeleteAdd(int id) {
        moneyMapper.deleteAdd(id);
    }

    public void toSaveAdd(int mid, String addDescribe, long addMoney) {
        moneyMapper.saveAdd(mid,addDescribe,addMoney);
    }

    public void updateAddMoney(Money money) {
        moneyMapper.updateAdd(money);
    }

    public void toSaveReduce(int mid, String reduceDescribe, long reduceMoney) {
        moneyMapper.saveReduce(mid,reduceDescribe,reduceMoney);
    }

    public void updateReduceMoney(Money money) {
        moneyMapper.updateReduce(money);
    }

    public void saveUpdateAdd(int id, String addDescribe, long addMoney, String addTime) {
        moneyMapper.saveUpdateAdd(id,addDescribe,addMoney,addTime);
    }

    public void saveUpdateReduce(int id, String reduceDescribe, long reduceMoney, String reduceTime) {
        moneyMapper.saveUpdateReduce(id,reduceDescribe,reduceMoney,reduceTime);
    }
}
