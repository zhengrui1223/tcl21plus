package com.movit.study.servlet;

import com.movit.study.servlet.base.AbstractHttpServlet;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by admin on 2016/12/21.
 */
public class UpLoadServlet extends AbstractHttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setCharacterEncoding("gbk");
            resp.setContentType("text/html");
            PrintWriter writer = resp.getWriter();

            DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);

            List<FileItem> fileItems = servletFileUpload.parseRequest(req);
            for (FileItem fileItem: fileItems){
                if(!fileItem.isFormField()){
                    writer.write(fileItem.getName());
                    long size = fileItem.getSize();
                    byte [] fileContent = new byte[1024];

                    InputStream inputStream = fileItem.getInputStream();
                    while (inputStream.read(fileContent) != -1){
                        String str = new String(fileContent);
                        writer.write("\r\n" + str);
                    }
                }else {
                    writer.write(fileItem.getFieldName());
                }
            }

            writer.flush();
            writer.close();
        } catch (Exception e) {
            log(e.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
