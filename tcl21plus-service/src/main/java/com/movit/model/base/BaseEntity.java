package com.movit.model.base;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

public abstract class BaseEntity implements Serializable {
    private Logger logger = LoggerFactory.getLogger(getClass());

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        String jsonString = null;
        try {
            jsonString = new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            logger.warn("fail to parse entity " + getClass().getName(), e);
        }
        return jsonString == null ? super.toString() : jsonString;
    }

}
