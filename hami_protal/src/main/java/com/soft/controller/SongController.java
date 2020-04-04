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
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
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

    @RequestMapping(value = "/play")
    public String play(String sids, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {

        String[] split = null;
        if (sids != null && !"".equals(sids)) {
            split = sids.split(",");
        }
        List<Integer> list = new ArrayList<>();
        //获得cookies
        Cookie[] cookies = request.getCookies();
        //从cookies中获得sids
        String value = "";
        //遍历cookies
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if ("sids".equals(name)) {
                    value = cookie.getValue();
                    value = URLDecoder.decode(value, "UTF-8");
                }
            }
        }

        //把String类型的sid转为Integer,并存放到list中
        if (split != null) {
            for (String s : split) {
                if (s != null && !"".equals(s)) {
                    list.add(Integer.parseInt(s));
                }
            }

            if (value != null && !"".equals(value)) {
                String[] split1 = value.split(",");
                for (String s1 : split1) {
                    if (!"".equals(s1)) {
                        boolean flag = true;
                        for (String s : split) {
                            if (s1.equals(s)) {
                                flag = false;
                                break;
                            }
                        }

                        if (flag) {
                            list.add(Integer.parseInt(s1));
                            sids = sids + value + ",";
                        }
                    }
                }

            }
        }

        //返回cookies
        sids = URLEncoder.encode(sids, "UTF-8");
        Cookie cookie = new Cookie("sids", sids);
        cookie.setPath("/");
        //测试时间3分钟
        cookie.setMaxAge(60*60*24*30);
        response.addCookie(cookie);

        if (list.size() == 0) {
            list.add(-1);
        }
        List<Song> songs = songService.selectByListsIds(list);
        request.setAttribute("songs", songs);
        return "player";
    }


    @RequestMapping(value = "/getSong")
    @ResponseBody
    public Song getSong(Integer sid) {
        Song song = songService.selectBysid1(sid);
        return song;
    }
}
