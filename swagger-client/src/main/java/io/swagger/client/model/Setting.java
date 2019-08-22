/*
 * Camera API
 * No description
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

/**
 * Gets or Sets Setting
 */
@JsonAdapter(Setting.Adapter.class)
public enum Setting {
  
  ISO("ISO"),
  
  FOCUS_MODE("FOCUS_MODE"),
  
  AE_COMPENSATION("AE_COMPENSATION"),
  
  AE_LOCK("AE_LOCK");

  private String value;

  Setting(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static Setting fromValue(String text) {
    for (Setting b : Setting.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }

  public static class Adapter extends TypeAdapter<Setting> {
    @Override
    public void write(final JsonWriter jsonWriter, final Setting enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public Setting read(final JsonReader jsonReader) throws IOException {
      String value = jsonReader.nextString();
      return Setting.fromValue(String.valueOf(value));
    }
  }
}

