package com.movit.study.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * Created by admin on 2016/12/24.
 * 自定义标签类
 *
 */
public class HelloTag extends TagSupport {
    private String key = null;

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public int doEndTag() throws JspException {
        try {
            pageContext.getOut().write("hello " + this.key);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return EVAL_PAGE;
    }
}
