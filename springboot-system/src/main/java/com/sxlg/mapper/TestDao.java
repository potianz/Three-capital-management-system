package com.sxlg.mapper;

import com.sxlg.bean.ZYGL;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface TestDao {
        @Select("select * from resourceman where del = 1")
        List<ZYGL> test();
        @Update("update resourceman set del = 0 where rid = #{rid}" )
        boolean isDelete(int rid);
        @Select("select * from resourceman where rid = #{rid}")
        ZYGL selectOne(int rid);
        @Update("update resourceman set " +
                        "rname=#{rname}," +
                        "area=#{area}," +
                        "located=#{located}," +
                        "rownership=#{rownership}," +
                        "development=#{development}" +
                " where rid = #{rid}")
        Boolean update(ZYGL zygl);
        @Insert("insert into resourceman values(" +
                "#{rid}," +
                "#{rname}," +
                "#{located}," +
                "#{area}," +
                "#{rownership}," +
                "#{development}," +
                "#{del})")
        Boolean add(ZYGL zygl);
}
