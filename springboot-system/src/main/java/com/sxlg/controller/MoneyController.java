package com.sxlg.controller;

import com.sxlg.bean.Money;
import com.sxlg.service.MoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/money")
public class MoneyController {

    @Autowired
    private MoneyService moneyService;

    @RequestMapping("/toSelect")
    public ModelAndView toSelect(String name){
        ModelAndView mv = null;
        List<Money> countrySideList =moneyService.getcountrySideList(name);
        mv = new ModelAndView("money/index");
        mv.addObject("list",countrySideList);
        return mv;
    }

    @ResponseBody
    @RequestMapping("/toDelete")
    public ModelAndView toDelete(@RequestParam("id") int id,@RequestParam("res")int res,@RequestParam("mid")int mid,
                                 @RequestParam("addmoney")long addMoney , @RequestParam("reducemoney")long reduceMoney){
        ModelAndView mv = null;
        if (res==0) {
            moneyService.toDelete(id);
            mv = new ModelAndView("money/index");
            List<Money> countrySideList =moneyService.getcountrySideList("");
            mv.addObject("list",countrySideList);
            return mv;
        }
        else if (res==1){
            Money money= moneyService.selectTotalMoney(mid).get(0);
            money.setAddMoney(money.getAddMoney()-addMoney);
            money.setTotalMoney(money.getTotalMoney()-addMoney);
            moneyService.updateAddMoney(money);

            moneyService.toDeleteAdd(id);
            mv  = new ModelAndView("money/countrySide");
            Money money1= moneyService.selectTotalMoney(mid).get(0);
            List<Money> reduceMone=moneyService.selectReduceMoney(mid,0);
            List<Money>  addMone=moneyService.selectAddMoney(mid,0);
            mv.addObject("money",money1);
            mv.addObject("reduceMoney",reduceMone);
            mv.addObject("addMoney",addMone);
            return mv;
        }
        else {
            Money money= moneyService.selectTotalMoney(mid).get(0);
            money.setReduceMoney(money.getReduceMoney()-reduceMoney);
            money.setTotalMoney(money.getTotalMoney()+reduceMoney);
            moneyService.updateReduceMoney(money);

            moneyService.toDeleteReduce(id);
            mv  = new ModelAndView("money/countrySide");
            Money money1= moneyService.selectTotalMoney(mid).get(0);
            List<Money> reduceMone=moneyService.selectReduceMoney(mid,0);
            List<Money>  addMone=moneyService.selectAddMoney(mid,0);
            mv.addObject("money",money1);
            mv.addObject("reduceMoney",reduceMone);
            mv.addObject("addMoney",addMone);
            return mv;
        }

    }
    @RequestMapping("/toAdd")
    public ModelAndView toAdd(){
        ModelAndView mv =  new ModelAndView("money/addCountrySide");
        return mv;
    }

    @ResponseBody
    @RequestMapping("/toSaveCountryside")
    public ModelAndView toSaveCountryside(String name,String totalMoney){
        moneyService.toSaveCountryside(name,totalMoney);
        ModelAndView mv = null;
        List<Money> countrySideList =moneyService.getcountrySideList("");
        mv = new ModelAndView("money/index");
        mv.addObject("list",countrySideList);
        return mv;
    }

    @ResponseBody
    @RequestMapping("/toSelectCountrySide")
    public ModelAndView SelectCountrySide(int id){
        Money money= moneyService.selectTotalMoney(id).get(0);
        List<Money> reduceMoney=moneyService.selectReduceMoney(id,0);
        List<Money>  addMoney=moneyService.selectAddMoney(id,0);
        ModelAndView mv  = new ModelAndView("money/countrySide");
        mv.addObject("money",money);
        mv.addObject("reduceMoney",reduceMoney);
        mv.addObject("addMoney",addMoney);
        return mv;
    }

    @ResponseBody
    @RequestMapping("/toAddMoney")
    public ModelAndView toAddMoney(int cid){
        Money money= moneyService.selectTotalMoney(cid).get(0);
        ModelAndView mv  = new ModelAndView("money/addMoney");
        mv.addObject("money",money);
        return mv;
    }


    @ResponseBody
    @RequestMapping("/toReduceMoney")
    public ModelAndView toReduceMoney(int cid){
        Money money= moneyService.selectTotalMoney(cid).get(0);
        ModelAndView mv  = new ModelAndView("money/reduceMoney");
        mv.addObject("money",money);
        return mv;
    }

    @ResponseBody
    @RequestMapping("/toSaveAdd")
    public ModelAndView SaveAdd(@RequestParam("mid")int mid,@RequestParam("addDescribe") String addDescribe,@RequestParam("addMoney")long addMoney){
        Money money= moneyService.selectTotalMoney(mid).get(0);
        moneyService.toSaveAdd(mid,addDescribe,addMoney);
        money.setAddMoney(money.getAddMoney()+addMoney);
        money.setTotalMoney(money.getTotalMoney()+addMoney);
        moneyService.updateAddMoney(money);

        Money money1= moneyService.selectTotalMoney(mid).get(0);
        List<Money> reduceMoney=moneyService.selectReduceMoney(mid,0);
        List<Money>  addMone=moneyService.selectAddMoney(mid,0);
        ModelAndView mv  = new ModelAndView("money/countrySide");
        mv.addObject("money",money1);
        mv.addObject("reduceMoney",reduceMoney);
        mv.addObject("addMoney",addMone);
        return mv;
    }

    @ResponseBody
    @RequestMapping("/toSaveReduce")
    public ModelAndView toSaveReduce(@RequestParam("mid")int mid,@RequestParam("reduceDescribe") String reduceDescribe,@RequestParam("reduceMoney")long reduceMoney){
        Money money= moneyService.selectTotalMoney(mid).get(0);
        moneyService.toSaveReduce(mid,reduceDescribe,reduceMoney);
        money.setReduceMoney(money.getReduceMoney()+reduceMoney);
        money.setTotalMoney(money.getTotalMoney()-reduceMoney);
        moneyService.updateReduceMoney(money);

        Money money1= moneyService.selectTotalMoney(mid).get(0);
        List<Money> reduceMone=moneyService.selectReduceMoney(mid,0);
        List<Money>  addMone=moneyService.selectAddMoney(mid,0);
        ModelAndView mv  = new ModelAndView("money/countrySide");
        mv.addObject("money",money1);
        mv.addObject("reduceMoney",reduceMone);
        mv.addObject("addMoney",addMone);
        return mv;
    }

    @ResponseBody
    @RequestMapping("/toUpdateMoney")
    public ModelAndView UpdateMoney(@RequestParam("id")int id,@RequestParam("res") int res){

        if(res ==1) {
            Money money= moneyService.selectAddMoney(0,id).get(0);
            ModelAndView mv = new ModelAndView("money/updateAdd");
            mv.addObject("money", money);
            return mv;
        }else {
            Money money= moneyService.selectReduceMoney(0,id).get(0);
            ModelAndView mv = new ModelAndView("money/updateReduce");
            mv.addObject("money", money);
            return mv;
        }
    }

    @ResponseBody
    @RequestMapping("/toSaveUpdateAdd")
    public ModelAndView SaveUpdateAdd(@RequestParam("mid")int mid,@RequestParam("addDescribe") String addDescribe
            ,@RequestParam("addMoney")long addMoney,@RequestParam("addTime")String addTime,@RequestParam("id")int id){
        Money money= moneyService.selectTotalMoney(mid).get(0);
        Money addMon= moneyService.selectAddMoney(0,id).get(0);
        money.setAddMoney(money.getAddMoney()+(addMoney-addMon.getAddMoney()));
        money.setTotalMoney(money.getTotalMoney()+(addMoney-addMon.getAddMoney()));
        moneyService.updateAddMoney(money);
        moneyService.saveUpdateAdd(id,addDescribe,addMoney,addTime);

        Money money1= moneyService.selectTotalMoney(mid).get(0);
        List<Money> reduceMoney=moneyService.selectReduceMoney(mid,0);
        List<Money>  addMone=moneyService.selectAddMoney(mid,0);
        ModelAndView mv  = new ModelAndView("money/countrySide");
        mv.addObject("money",money1);
        mv.addObject("reduceMoney",reduceMoney);
        mv.addObject("addMoney",addMone);
        return mv;
    }

    @ResponseBody
    @RequestMapping("/toSaveUpdateReduce")
    public ModelAndView SaveUpdateReduce(@RequestParam("mid")int mid,@RequestParam("reduceDescribe") String reduceDescribe
            ,@RequestParam("reduceMoney")long reduceMoney,@RequestParam("reduceTime")String reduceTime,@RequestParam("id")int id){
        Money money= moneyService.selectTotalMoney(mid).get(0);
        Money reduceMon= moneyService.selectReduceMoney(0,id).get(0);
        money.setReduceMoney(money.getReduceMoney()+(reduceMoney-reduceMon.getReduceMoney()));
        money.setTotalMoney(money.getTotalMoney()-(reduceMoney-reduceMon.getReduceMoney()));
        moneyService.updateReduceMoney(money);
        moneyService.saveUpdateReduce(id,reduceDescribe,reduceMoney,reduceTime);

        Money money1= moneyService.selectTotalMoney(mid).get(0);
        List<Money> reduceMone=moneyService.selectReduceMoney(mid,0);
        List<Money>  addMone=moneyService.selectAddMoney(mid,0);
        ModelAndView mv  = new ModelAndView("money/countrySide");
        mv.addObject("money",money1);
        mv.addObject("reduceMoney",reduceMone);
        mv.addObject("addMoney",addMone);
        return mv;
    }

}
