package com.sxlg.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 用来定义资产信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssetInformation implements Serializable {
    //主键约束，定义一个唯一的信息

    private Long id;
//    资产的情况说明
    private String assets;
//    资产的价值
    private Long assetvalue;
// 资产的数量
    private Integer assetnumber;
//   资产的使用情况
    private String usages;
//   资产的使用单位
    private String usageuser;
//    资产的收益
    private Integer profit;
//    资产审核人
    private Long reviewer;

    private String name;
}
