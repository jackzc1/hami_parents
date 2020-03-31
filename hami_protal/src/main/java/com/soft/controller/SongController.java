package com.soft.controller;

import com.soft.model.Mtype;
import com.soft.model.Song;
import com.soft.query.SongQuery;
import com.soft.service.MtypeService;
import com.soft.service.SongService;
import com.soft.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/song")
public class SongController {

    @Autowired
    private SongService songService;

    @Autowired
    private MtypeService mtypeService;

    //条件查询
    @RequestMapping(value = "/list")
    public String list(SongQuery songQuery, Model model) {
        System.out.println(songQuery);
        if (songQuery.getPageNo() == null) {
            songQuery.setPageNo(1);
        }
        Page<Song> songPage = songService.selectByConditionPage(songQuery);
        model.addAttribute("page", songPage);
        List<Mtype> mtypes = mtypeService.selectAll();
        model.addAttribute("mtypes", mtypes);
        model.addAttribute("sq", songQuery);
        return "search";
    }

}
