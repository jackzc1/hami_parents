package com.soft.controller;

import com.soft.model.Mtype;
import com.soft.query.MtypeQuery;
import com.soft.service.MtypeService;
import com.soft.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/mtype")
public class MtypeController {

    @Autowired
    private MtypeService mtypeService;

    @RequestMapping(value = "/list")
    public String list(MtypeQuery mtypeQuery, Model model) {
        if (mtypeQuery.getPageNo() == null) {
            mtypeQuery.setPageNo(1);
        }
        Page<Mtype> page = mtypeService.selectByConditionPage(mtypeQuery);
        model.addAttribute("page", page);
        model.addAttribute("tname", mtypeQuery.getTname());
        return "mtype";
    }

    @ResponseBody
    @RequestMapping(value = "/addMtype")
    public String addMtype(Mtype mtype) {
        mtypeService.insert(mtype);
        return "success";
    }

    @ResponseBody
    @RequestMapping(value = "/toUpdate")
    public Mtype toUpdate(Integer tid) {
        Mtype mtype = mtypeService.selectByPrimaryKey(tid);
        return mtype;
    }

    @ResponseBody
    @RequestMapping(value = "/updateMtype")
    public String updateMtype(Mtype mtype) {
        System.out.println(mtype);
        mtypeService.updateByPrimaryKey(mtype);
        return "success";
    }

    @ResponseBody
    @RequestMapping(value = "/deleteMtype")
    public String deleteMtype(Integer tid) {
        mtypeService.deleteByPrimaryKey(tid);
        return "success";
    }

}
