package com.sxlg.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sxlg.bean.Money;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MoneyMapper extends BaseMapper<Money> {

    List<Money> getcountrySideList(@Param("name") String name, @Param("id") int id);

    void SaveCountryside(@Param("name")String name, @Param("totalMoney")String totalMoney);

    List<Money> selectReduceMoney(@Param("id")int id, @Param("mid")int mid);

    List<Money> selectAddMoney(@Param("id")int id, @Param("mid")int mid);

    void deleteReduce(int id);

    void deleteAdd(int id);

    void saveAdd(@Param("mid")int mid,@Param("addDescribe") String addDescribe,@Param("addMoney") Long addMoney);

    void updateAdd(Money money);

    void saveReduce(@Param("mid")int mid,@Param("reduceDescribe") String reduceDescribe, @Param("reduceMoney")long reduceMoney);

    void updateReduce(Money money);

    void saveUpdateAdd(@Param("id")int id, @Param("addDescribe") String addDescribe, @Param("addMoney") long addMoney, @Param("addTime") String addTime);

    void saveUpdateReduce(@Param("id")int id,@Param("reduceDescribe") String reduceDescribe, @Param("reduceMoney")long reduceMoney , @Param("reduceTime")String reduceTime);
}
