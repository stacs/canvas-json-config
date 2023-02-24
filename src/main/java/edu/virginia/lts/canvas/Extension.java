package edu.virginia.lts.canvas;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Extension {

  public static final String PUBLIC = "public";
  public static final String ANONYMOUS = "anonymous";

  public static final String CANVAS_PLATFORM = "canvas.instructure.com";

  private String domain;

  @JsonProperty("tool_id")
  private String toolId;

  private String platform;

  @JsonProperty(value = "privacy_level", required = true)
  private String privacyLevel;

  private Settings settings;
}
