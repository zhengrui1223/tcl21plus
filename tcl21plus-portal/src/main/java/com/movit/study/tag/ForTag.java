package com.movit.study.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * Created by admin on 2016/12/24.
 */
public class ForTag extends TagSupport{
    @Override
    public int doEndTag() throws JspException {

        return EVAL_PAGE;
    }

    @Override
    public int doAfterBody() throws JspException {
        return EVAL_PAGE;
    }
}
