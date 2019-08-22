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
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.client.model.Setting;
import java.io.IOException;

/**
 * BaseSettingInfo
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-08-22T08:56:31.682Z")
public class BaseSettingInfo {
  @SerializedName("setting")
  private Setting setting = null;

  @SerializedName("editable")
  private Boolean editable = null;

  public BaseSettingInfo setting(Setting setting) {
    this.setting = setting;
    return this;
  }

   /**
   * Get setting
   * @return setting
  **/
  @ApiModelProperty(required = true, value = "")
  public Setting getSetting() {
    return setting;
  }

  public void setSetting(Setting setting) {
    this.setting = setting;
  }

  public BaseSettingInfo editable(Boolean editable) {
    this.editable = editable;
    return this;
  }

   /**
   * Specifies whether the value of the setting can be edited.
   * @return editable
  **/
  @ApiModelProperty(required = true, value = "Specifies whether the value of the setting can be edited.")
  public Boolean isEditable() {
    return editable;
  }

  public void setEditable(Boolean editable) {
    this.editable = editable;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BaseSettingInfo baseSettingInfo = (BaseSettingInfo) o;
    return Objects.equals(this.setting, baseSettingInfo.setting) &&
        Objects.equals(this.editable, baseSettingInfo.editable);
  }

  @Override
  public int hashCode() {
    return Objects.hash(setting, editable);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BaseSettingInfo {\n");
    
    sb.append("    setting: ").append(toIndentedString(setting)).append("\n");
    sb.append("    editable: ").append(toIndentedString(editable)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

