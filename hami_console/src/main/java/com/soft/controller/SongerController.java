package com.soft.controller;

import com.soft.model.Mtype;
import com.soft.model.Songer;
import com.soft.query.SongerQuery;
import com.soft.service.MtypeService;
import com.soft.service.SongerService;
import com.soft.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/songer")
public class SongerController {

    @Autowired
    private SongerService songerService;

    @Autowired
    private MtypeService mtypeService;

    @RequestMapping(value = "/list")
    public String list(SongerQuery songerQuery, Model model) {
        if (songerQuery.getPageNo() == null) {
            songerQuery.setPageNo(1);
        }
        Page<Songer> page = songerService.selectByConditionPage(songerQuery);
        model.addAttribute("page", page);
        List<Mtype> mtypes = mtypeService.selectAll();
        model.addAttribute("mtypes", mtypes);
        model.addAttribute("sq", songerQuery);
        return "songer";
    }

    @RequestMapping(value = "/toAdd")
    public String toAdd(Model model) {
        List<Mtype> mtypes = mtypeService.selectAll();
        model.addAttribute("mtypes", mtypes);
        return "addSonger";
    }

    @RequestMapping(value = "/add")
    public String add(Songer songer) {
        songerService.insert(songer);
        return "redirect:/songer/list";
    }

    @RequestMapping(value = "/deleteSonger")
    @ResponseBody
    public String deleteSonger(String srid) {
        songerService.deleteByPrimaryKey(Integer.parseInt(srid));
        return "success";
    }

    @RequestMapping(value = "/toSongerUpdate")
    public String toSongerUpdate(String srid, Model model) {
        Songer songer = songerService.selectByPrimaryKey(Integer.parseInt(srid));
        model.addAttribute("songer", songer);
        List<Mtype> mtypes = mtypeService.selectAll();
        model.addAttribute("mtypes", mtypes);
        return "updateSonger";
    }

    @RequestMapping(value = "/update")
    public String update(Songer songer) {
        System.out.println(songer);
        songerService.updateByPrimaryKey(songer);
        return "redirect:/songer/list";
    }

}
