package com.how2java.springboot.web;

import javafx.scene.input.DataFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.util.Date;

/**
 * @RestController 是spring4里的新注解，是@ResponseBody和@Controller的缩写。
 */

/**
 *：ctrl+F9 自动编译，不用修改一次代码老是重新运行一次main函数
 */
//@RestController
    @Controller
public class HelloController {
    @RequestMapping("/hello")
    public String hello(Model m ) throws Exception {
        m.addAttribute("now", DateFormat.getDateTimeInstance().format(new Date()));
//        if(true){
//            throw new Exception("some exception");
//        }
        m.addAttribute("name", "thymeleaf");
        System.out.println("hahahaha ctrl+K");
        System.out.println("ctrl+t 是更新,更新是指把文件从git下载到本地呢");
        // 我是更新后的
        return "hello";
    }


}
