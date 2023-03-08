package edu.virginia.lts.canvas;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class Placement {

  public static final String LTI_RESOURCE_LINK_REQUEST = "LtiResourceLinkRequest";
  public static final String LTI_DEEP_LINKING_REQUEST = "LtiDeepLinkingRequest";

  private String text;

  private String placement;

  @JsonProperty("message_type")
  private String messageType;

  @JsonProperty("icon_url")
  private String iconUrl;

  @JsonProperty("target_link_uri")
  private String targetLinkUri;

  @JsonProperty("canvas_icon_class")
  private String canvasIconClass;

  @JsonProperty("selection_height")
  private Integer selectionHeight;

  @JsonProperty("selection_width")
  private Integer selectionWidth;

  @JsonProperty("custom_fields")
  @Singular
  private Map<String, String> customFields;
}
