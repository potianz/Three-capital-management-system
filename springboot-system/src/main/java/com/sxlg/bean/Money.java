package com.sxlg.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "funds")
@Component
public class Money {
    private  long id;
    //村庄标识
    private String name;
    //村镇标记id
    private long countrySideId;

    //入账描述
    private String addDescribe;
    //入账金额
    private long addMoney;
    //入账时间
    private String addTime;

    //出账描述
    private String reduceDescribe;
    //出账金额
    private long reduceMoney;
    //出账时间
    private String reduceTime;

    //总额度
    private long totalMoney;

}
