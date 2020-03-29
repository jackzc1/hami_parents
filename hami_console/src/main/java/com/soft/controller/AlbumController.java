package com.soft.controller;

import com.soft.model.Album;
import com.soft.query.AlbumQuery;
import com.soft.service.AlbumService;
import com.soft.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/album")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    //列表显示
    @RequestMapping(value = "/list")
    public String list(AlbumQuery albumQuery, Model model) {
        System.out.println(albumQuery);
        if (albumQuery.getPageNo() == null) {
            albumQuery.setPageNo(1);
        }
        Page<Album> page = albumService.selectByConditionPage(albumQuery);
        model.addAttribute("mq", albumQuery);
        model.addAttribute("page", page);
        return "album";
    }

    //新增
    @RequestMapping(value = "/addAlbum")
    @ResponseBody
    public String addAlbum(Album album) {
        albumService.insert(album);
        return "success";
    }

    //表单校验
    @RequestMapping(value = "/isSame")
    @ResponseBody
    public String isSame(AlbumQuery albumQuery) {
        List<Album> albums = albumService.selectByCondition(albumQuery);
        if (albums != null && albums.size() > 0) {
            return "true";
        } else {
            return "false";
        }
    }

    //删除功能
    @RequestMapping(value = "/deleteAlbum")
    @ResponseBody
    public String deleteAlbum(String aid) {
        String flag = "fail";
        if (aid != null && !aid.equals("")) {
            albumService.deleteByPrimaryKey(Integer.parseInt(aid));
            flag = "success";
        }

        return flag;
    }

    //修改回显
    @RequestMapping(value = "/toUpdate")
    @ResponseBody
    public Album toUpdate(String aid) {
        Album album = new Album();
        if (aid != null && !aid.equals("")) {
            album = albumService.selectByPrimaryKey(Integer.parseInt(aid));
        }
        return album;
    }

    //修改
    @RequestMapping(value = "/updateAlbum")
    @ResponseBody
    public String updateAlbum(Album album) {
        albumService.updateByPrimaryKey(album);
        return "success";
    }

}
