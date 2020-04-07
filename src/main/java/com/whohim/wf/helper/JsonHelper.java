package com.whohim.wf.helper;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.whohim.wf.exception.JsonException;

import java.io.IOException;

/**
 * Json帮助类
 */
public final class JsonHelper {

    public static final ObjectMapper MAPPER;

    static {
        MAPPER = new ObjectMapper();

        // SerializationFeature for changing how JSON is written

        // to allow serialization of "empty" POJOs (no properties to serialize)
        // (without this setting, an exception is thrown in those cases)
        MAPPER.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        // to write java.util.Date, Calendar as number (timestamp):
        MAPPER.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        // DeserializationFeature for changing how JSON is read as POJOs:

        // to prevent exception when encountering unknown property:
        MAPPER.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        // to allow coercion of JSON empty String ("") to null Object value:
        MAPPER.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);

        MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    private JsonHelper() {
        throw new UnsupportedOperationException("This is a helper class and cannot be instantiated");
    }

    /**
     * POJO -> Json String
     *
     * @param data pojo
     * @param <T> pojo type
     * @return json string
     */
    public static <T> String toJson(T data) {
        try {
            return MAPPER.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            throw new JsonException("toJson failed.", e);
        }
    }

    /**
     * Json String -> POJO
     *
     * @param json json string
     * @param tClass pojo class
     * @param <T> pojo type
     * @return pojo
     */
    public static <T> T fromJson(String json, Class<T> tClass) {
        try {
            return MAPPER.readValue(json, tClass);
        } catch (IOException e) {
            throw new JsonException("fromJson failed.", e);
        }
    }

}
