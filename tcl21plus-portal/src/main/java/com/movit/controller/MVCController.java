package com.movit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by admin on 2016/12/30.
 */
@Controller()
public class MVCController {

    @RequestMapping("/MVCController")
    public String test1(){
        return "/index";
    }

    @RequestMapping("/downLoadTestFile")
    public void downLoad(HttpServletResponse response){

        try {
            File file = new File("F:/dom4j.xml");
            ServletOutputStream outputStream = response.getOutputStream();
            BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file));

            response.reset();
            // 先去掉文件名称中的空格,然后转换编码格式为utf-8,保证不出现乱码,这个文件名称用于浏览器的下载框中自动显示的文件名
            response.addHeader("Content-Disposition", "attachment;filename=" + new String("dom4j.xml".replaceAll(" ", "").getBytes("utf-8"), "iso8859-1"));
            //response.addHeader("Content-Length", "" + file.length());
            response.setContentType("application/octet-stream");

            byte [] b = new byte[1024];
            int len;
            while ( (len = inputStream.read(b)) != -1){
                outputStream.write(b, 0, len);
            }

            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
