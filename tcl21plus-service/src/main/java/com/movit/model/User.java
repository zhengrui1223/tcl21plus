package com.movit.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.code.ssm.api.CacheKeyMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

public class User implements Serializable {
    private Logger logger = LoggerFactory.getLogger(User.class);
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private String password;

    @CacheKeyMethod
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    @Override
    public String toString() {
        ObjectMapper mapper = DaoObjectMapper.getSerializeMapper();
        String jsonString = null;
        try {
            jsonString = mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            logger.warn("fail to parse entity " + getClass().getName(), e);
        }
        return jsonString == null ? super.toString() : jsonString;
    }

    private static class DaoObjectMapper {
        private static ObjectMapper serializeMapper;

        public synchronized static ObjectMapper getSerializeMapper() {
            if (serializeMapper == null) {
                serializeMapper = new ObjectMapper();
                serializeMapper.configure(SerializationFeature.INDENT_OUTPUT, false);
                serializeMapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);
                serializeMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
                serializeMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
            }
            return serializeMapper;
        }
    }
}