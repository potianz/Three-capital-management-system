package com.sxlg.controller;

import com.sxlg.bean.ZYGL;
import com.sxlg.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TestController {
    @Autowired
    private TestService testService;

    @RequestMapping("/test")
    public String select(Model model){
        List<ZYGL> list = testService.testS();
        model.addAttribute("list",list);
        return "main";
    }
    @RequestMapping("/isDelete")
    @ResponseBody
    public boolean isDelete(int rid){
        return testService.isDel(rid);
    }
    @RequestMapping("/add")
    public String add(){
        return "add";
    }
    @RequestMapping("/realAdd")
    @ResponseBody
    public boolean realAdd(ZYGL zygl){
        zygl.setDel(true);
        System.out.println(zygl);
         return testService.add(zygl);

    }
    @RequestMapping("/update")
    public String update(int rid, Model model){
        ZYGL zygl = this.selectOne(rid);
        model.addAttribute("zygl",zygl);
        return "update";
    }
    @RequestMapping("/update2")
    @ResponseBody
    public String update2(ZYGL zygl){
        testService.update(zygl);
        return "hello";
    }
    public ZYGL selectOne(int rid){
        ZYGL zygl = testService.testOne(rid);
        return zygl;
    }
}
