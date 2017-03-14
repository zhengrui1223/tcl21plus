package com.movit.study.servlet;

import com.movit.study.servlet.base.AbstractHttpServlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by admin on 2016/12/21.
 */
public class DownLoadServlet extends AbstractHttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 使用servletContext读取资源文件，相对于web项目的根路径

        /*resp.setContentType("image/jpeg");
        resp.setHeader("Content-Disposition","attachment;filename=test.jpeg");

        ServletOutputStream outputStream = resp.getOutputStream();

        ServletContext servletContext = getServletContext();
        InputStream inputStream = servletContext.getResourceAsStream("/WEB-INF/image/test.png");

        byte [] b = new byte[1024];
        while (inputStream.read(b) != -1){
            outputStream.write(b);
        }

        outputStream.flush();
        outputStream.close();*/

        //###########################################################################################//

        // 使用ClassLoader读取资源文件，相对于类目录(即classes)

        resp.setHeader("Content-Type","application/force-download");
        resp.setHeader("Content-Disposition","attachment;filename=config-common.properties");
        ServletOutputStream outputStream = resp.getOutputStream();

        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("config-common.properties");

        byte [] b = new byte[1024];
        int len;
        while ( (len = inputStream.read(b)) != -1){
            outputStream.write(b, 0, len);
        }

        outputStream.flush();
        outputStream.close();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
