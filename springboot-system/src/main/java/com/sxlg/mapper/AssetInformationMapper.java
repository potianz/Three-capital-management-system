package com.sxlg.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sxlg.bean.AssetInformation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface AssetInformationMapper  extends BaseMapper<AssetInformation> {

    @Select("select name from user where id = #{id}")
    String  selectReviewer(@Param("id") Long id);

}
