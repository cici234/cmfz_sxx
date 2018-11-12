package com.baizhi.controller;

import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import com.baizhi.util.FileUtil;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/chapter")
public class ChapterController {
    @Autowired
    private ChapterService chapterService;

    @RequestMapping("/save")
    @ResponseBody
    public Map<String, Object> save(Chapter chapter,HttpServletRequest request, MultipartFile multipartFile) {
        Map<String, Object> results = new HashMap<String, Object>();

        try {

            //上传路径
            /*String realPath = request.getSession().getServletContext().getRealPath("/chapter.mp3");
            multipartFile.transferTo(new File(realPath,multipartFile.getOriginalFilename()));
            System.out.println(multipartFile.getOriginalFilename());
            chapter.setDownPath("/chapter.mp3/"+multipartFile.getOriginalFilename());*/

            //获取时长
            /*MP3File f = (MP3File) AudioFileIO.read(mp3File);
            MP3AudioHeader audioHeader = (MP3AudioHeader)f.getAudioHeader();
            String trackLength = audioHeader.getTrackLength()/360+":"+audioHeader.getTrackLength()/60+":"+audioHeader.getTrackLength()%60;
            chapter.setDuration(trackLength);*/

            //获取音频大小
            //File file = new File(realPath);

            //chapter.setSize(partfile.getSize()/1024.00/1024.00+"M");


            //上传
            String s = FileUtil.saveFile(multipartFile, "/chaptermp3/", request);
            chapter.setDownPath(s);
            //获取时长
            String s1 = FileUtil.AudioLength(s, request);
            chapter.setDuration(s1);
            //获取音频大小
            Double size = FileUtil.AudioSize(s, request);
            chapter.setSize(size + "M");

            chapterService.add(chapter);
            results.put("success", true);

        } catch (Exception e) {
            e.printStackTrace();
            results.put("success", false);
            results.put("message", e.getMessage());
        }
        return results;
    }

    @RequestMapping("/download")
    @ResponseBody
    public void download(String fileName,String openStyle,HttpServletRequest request, HttpServletResponse response) throws Exception {
        //根据接收的文件名获取文件
        String realPath = request.getSession().getServletContext().getRealPath("/");
        //以文件输入流读取文件
        FileInputStream is = new FileInputStream(new File(realPath, fileName));
        //设置响应头
        response.addHeader("content-disposition",openStyle+";fileName="+URLEncoder.encode(fileName, "UTF-8"));
        //获取响应输出流
        ServletOutputStream os = response.getOutputStream();
        //使用IOUtils工具类
        IOUtils.copy(is,os);
        //关闭流
        IOUtils.closeQuietly(is);
        IOUtils.closeQuietly(os);
    }


}





