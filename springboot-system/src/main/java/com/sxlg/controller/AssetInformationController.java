package com.sxlg.controller;

import com.sxlg.bean.AssetInformation;
import com.sxlg.service.AssetInformationService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/countryside/asse")
public class AssetInformationController {
    @Autowired
    private AssetInformationService service;

    @GetMapping("/selectAll")
    @ResponseBody
    public List<AssetInformation> selectAll(){
       return service.selectAll();
    }

    @GetMapping
    public String list(){
        return "asset";
    }

    @PostMapping("/delete")
    @ResponseBody
    public  int delete(Long id){
        int a = service.delete(id);
        return a;
    }

    @PostMapping("/insert")
    @ResponseBody
    public int  insert(AssetInformation assetInformation){
        int a = service.insert(assetInformation);
        return a;
    }

    @PostMapping("/update")
    @ResponseBody
    public void update(AssetInformation assetInformation){
        if(assetInformation.getId()!=null){
            service.update(assetInformation);
        }
    }
}
