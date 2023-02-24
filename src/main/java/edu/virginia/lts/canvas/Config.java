package edu.virginia.lts.canvas;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;

@Data
@Builder
public class Config {

  public static final String LINEITEM = "https://purl.imsglobal.org/spec/lti-ags/scope/lineitem";
  public static final String RESULT_READONLY =
      "https://purl.imsglobal.org/spec/lti-ags/scope/result.readonly";
  public static final String SCORE = "https://purl.imsglobal.org/spec/lti-ags/scope/score";
  public static final String CONTEXTMEMBERSHIP_READONLY =
      "https://purl.imsglobal.org/spec/lti-nrps/scope/contextmembership.readonly";
  public static final String LINEITEM_READONLY =
      "https://purl.imsglobal.org/spec/lti-ags/scope/lineitem.readonly";
  public static final String UPDATE = "https://canvas.instructure.com/lti/public_jwk/scope/update";

  @JsonProperty(required = true)
  private String title;

  @JsonProperty(required = true)
  private String description;

  @JsonProperty(value = "oidc_initiation_url", required = true)
  private String oidcInitiationUrl;

  @JsonProperty(value = "target_link_uri", required = true)
  private String targetLinkUri;

  @Singular private List<String> scopes;

  @Singular private List<Extension> extensions;

  @JsonProperty(value = "public_jwk_url", required = true)
  private String publicJwkUrl;

  @JsonProperty("custom_fields")
  @Singular
  private Map<String, String> customFields;
}
