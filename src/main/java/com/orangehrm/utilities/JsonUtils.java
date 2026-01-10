package com.orangehrm.utilities;

import com.google.gson.Gson;
import lombok.experimental.UtilityClass;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@UtilityClass
public class JsonUtils {

    private static final Gson GSON = new Gson();
    private static final String JSON_DESERIALIZE_ERROR_MSG = "Could not deserialize JSON file at '%s'. Cause: %s";

    public <T> T deserializeJson(String classpathLocation, Class<T> tClass) {
        try {
            InputStream is = JsonUtils.class.getClassLoader().getResourceAsStream(classpathLocation);
            if (is == null) {
                throw new RuntimeException("JSON file not found: " + classpathLocation);
            }
            return GSON.fromJson(new InputStreamReader(is, StandardCharsets.UTF_8), tClass);
        } catch (Exception e) {
            // TODO: add logger here (Log4j)
            // logger.error(JSON_DESERIALIZE_ERROR_MSG.formatted(classpathLocation, e));
            throw new RuntimeException(JSON_DESERIALIZE_ERROR_MSG.formatted(classpathLocation, e), e);
        }
    }
}