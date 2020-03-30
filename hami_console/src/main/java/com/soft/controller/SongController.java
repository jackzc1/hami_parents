package com.soft.controller;

import com.soft.model.Album;
import com.soft.model.Mtype;
import com.soft.model.Song;
import com.soft.model.Songer;
import com.soft.query.SongQuery;
import com.soft.service.AlbumService;
import com.soft.service.MtypeService;
import com.soft.service.SongService;
import com.soft.service.SongerService;
import com.soft.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/song")
public class SongController {

    @Autowired
    private SongService songService;

    @Autowired
    private MtypeService mtypeService;

    @Autowired
    private SongerService songerService;

    @Autowired
    private AlbumService albumService;

    //条件查询
    @RequestMapping(value = "/list")
    public String list(SongQuery songQuery, Model model) {
        if (songQuery.getPageNo() == null) {
            songQuery.setPageNo(1);
        }
        System.out.println(songQuery);
        Page<Song> songPage = songService.selectByConditionPage(songQuery);
        model.addAttribute("page", songPage);
        List<Mtype> mtypes = mtypeService.selectAll();
        model.addAttribute("mtypes", mtypes);
        model.addAttribute("sq", songQuery);
        return "song";
    }

    //跳转到添加
    @RequestMapping(value = "/toAdd")
    public String toAdd(Model model) {
        List<Mtype> mtypes = mtypeService.selectAll();
        model.addAttribute("mtypes", mtypes);
        List<Songer> songers = songerService.selectAll();
        model.addAttribute("songers", songers);
        List<Album> albums = albumService.selectAll();
        model.addAttribute("albums", albums);
        return "addSong";
    }

    //添加
    @RequestMapping(value = "/add")
    public String add(Song song) {
        songService.insert(song);
        return "redirect:/song/list";
    }

    //删除
    @RequestMapping(value = "/deleteSong")
    @ResponseBody
    public String deleteSong(String sid) {
        songService.deleteByPrimaryKey(Integer.parseInt(sid));
        return "success";
    }
}
