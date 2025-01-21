package com.axisbank.limit.Utility;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

import static java.lang.String.format;

@Slf4j
public class JsonTransformer {

  private JsonTransformer() {}

  private static final ObjectMapper MAPPER =
      new ObjectMapper()
          .setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY)
          .registerModule(new JavaTimeModule())
          .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
          .setSerializationInclusion(JsonInclude.Include.NON_NULL);

  public static String transformToJson(Object object) {
    try {
      return MAPPER.writeValueAsString(object);
    } catch (JsonProcessingException ex) {
      String message =
          String.format(
              "Failed to serialize object of class: %s. Exception: %s",
              Optional.ofNullable(object).map(o -> o.getClass().getName()).orElse("NULL"),
              ex.getMessage());
      log.error(String.format("{\"message\": %s}", message), ex);
      throw new RuntimeException(message, ex);
    }
  }

  public static <T> T transformToObject(String jsonString, Class<T> classType) {
    try {
      return MAPPER.readValue(jsonString, classType);
    } catch (JsonProcessingException exp) {
      log.error(format("unable to parse json %s", jsonString), exp);
      throw new RuntimeException(exp.getMessage(), exp);
    }
  }
}
