package com.how2java.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
public class UploadController {


    @RequestMapping("/uploadPage")
    public String uploadPage() {
        return "uploadPage";
    }

    /**
     *  5号处打印 D:\\IDEA_project\\springboot\\src\\main\\webapp\\uploaded\\1531928676483githubLearn.JPG
     *
     * value	请求参数名
     * required	是否必须包含该参数，默认为true
     * defaultValue	方法入参默认值
     *
     * @RequestParam("file")  使用@RequestParam可以将URL中的请求参数，绑定到方法的入参上，并通过@RequestParam的3个参数进行配置
     * 因为springmvc是根据 表单的那个name与 这边方法参数名  要相同才会 对应起来
     */

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(HttpServletRequest req,  @RequestParam("file") MultipartFile file, Model m) {
        try {

            String fileName = System.currentTimeMillis() + file.getOriginalFilename();
            String destFileName = req.getServletContext().getRealPath("") + "uploaded" + File.separator + fileName;

            System.out.println(req.getServletContext().getRealPath(""));//D:\IDEA_project\springboot\src\main\webapp\

            System.out.println(destFileName); //5号

            File destFIle = new File(destFileName);
            destFIle.getParentFile().mkdir();


            file.transferTo(destFIle); //将MultipartFile的文件 转放我们硬盘上
            m.addAttribute("fileName", fileName);
        } catch (IOException e) {
            e.printStackTrace();
            return "上传失败," + e.getMessage();
        }
        return "showImg";


    }
}

