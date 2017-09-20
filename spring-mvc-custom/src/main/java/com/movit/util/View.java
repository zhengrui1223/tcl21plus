package com.movit.util;

import java.util.HashMap;
import java.util.Map;

/************************************************************
 * @author jerry.zheng
 * @Description
 * @date 2017-09-20 13:46
 ************************************************************/
public class View {

    private String path;

    private Map<String, Object> model;

    public View(String path) {
        this.path = path;
    }

    public View(String path, Map<String, Object> model) {
        this.path = path;
        if (model == null) {
            this.model = new HashMap<String, Object>();
        }
        this.model = model;
    }

    public View addModel(String key, Object value) {
        model.put(key, value);
        return this;
    }

    public String getPath() {
        return path;
    }

    public Map<String, Object> getModel() {
        return model;
    }
}
