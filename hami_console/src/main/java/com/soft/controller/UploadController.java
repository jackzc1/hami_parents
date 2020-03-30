package com.soft.controller;

import com.alibaba.fastjson.JSONObject;
import com.soft.util.PropReader;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

@Controller
@RequestMapping(value = "/upload")
public class UploadController {

    /*文件上传*/
    @RequestMapping(value = "/uploadFile")
    public void uploadFile(HttpServletRequest request, HttpServletResponse response,
                           String lastImage, String type) throws IOException {

        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
        Map<String, MultipartFile> fileMap = multipartHttpServletRequest.getFileMap();
        /*Set<String> keySet = fileMap.keySet();
        Iterator<String> iterator = keySet.iterator();
        String key = iterator.next();*/
        MultipartFile multipartFile = fileMap.get("picFile");
        byte[] bytes = multipartFile.getBytes();

        String originalFilename = multipartFile.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        String fileName = UUID.randomUUID().toString();
        fileName = fileName + suffix;

        Client client = Client.create();

        if (StringUtils.isNotBlank(lastImage)) {
            WebResource resource = client.resource(lastImage);
            resource.delete();
        }

        WebResource resource1 = client.resource(PropReader.sysReader("filePath") + "/" + type + "/" + fileName);
        resource1.put(bytes);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("realPath", PropReader.sysReader("filePath") + "/" + type + "/" + fileName);
        jsonObject.put("relativePath", "/" + type + "/" + fileName);
        response.getWriter().write(jsonObject.toString());

    }

    /*窗口关闭删除上传的图片*/
    @RequestMapping(value = "/deletePic")
    public void deletePic(HttpServletRequest request, HttpServletResponse response,
                           String lastImage, String type) throws IOException {

        Client client = Client.create();

        if (StringUtils.isNotBlank(lastImage)) {
            WebResource resource = client.resource(lastImage);
            resource.delete();
        }

    }

    /*Mp3上传*/
    @RequestMapping(value = "/uploadFileMp3")
    public void uploadFileMp3(HttpServletRequest request, HttpServletResponse response,
                           String lastMp3, String type) throws IOException {

        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
        Map<String, MultipartFile> fileMap = multipartHttpServletRequest.getFileMap();
        MultipartFile multipartFile = fileMap.get("mp3File");
        byte[] bytes = multipartFile.getBytes();

        String originalFilename = multipartFile.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        String fileName = UUID.randomUUID().toString();
        fileName = fileName + suffix;

        Client client = Client.create();

        if (StringUtils.isNotBlank(lastMp3)) {
            WebResource resource = client.resource(lastMp3);
            resource.delete();
        }

        WebResource resource1 = client.resource(PropReader.sysReader("filePath") + "/" + type + "/" + fileName);
        resource1.put(bytes);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("realPath", PropReader.sysReader("filePath") + "/" + type + "/" + fileName);
        jsonObject.put("relativePath", "/" + type + "/" + fileName);
        response.getWriter().write(jsonObject.toString());

    }

}
