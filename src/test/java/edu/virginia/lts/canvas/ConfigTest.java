package edu.virginia.lts.canvas;

import static org.junit.Assert.assertEquals;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Objects;
import org.junit.Test;

public class ConfigTest {

  @Test
  public void testConfig() throws Exception {
    // The test_config.json file was copy/pasted from
    // https://canvas.instructure.com/doc/api/file.lti_dev_key_config.html#configuring-the-tool-in-canvas
    // It was tweaked slightly to remove the public_jwk config in favor of public_jwk_url since we
    // will be using the url
    String testConfigJson =
        new String(
            Objects.requireNonNull(
                    getClass().getClassLoader().getResourceAsStream("test_config.json"))
                .readAllBytes());

    Placement userNavigation =
        Placement.builder()
            .text("User Navigation Placement")
            .iconUrl("https://some.icon.url/my_dashboard.png")
            .placement("user_navigation")
            .messageType(Placement.LTI_RESOURCE_LINK_REQUEST)
            .targetLinkUri("https://your.target_link_uri/my_dashboard")
            .canvasIconClass("icon-lti")
            .customField("foo", "$Canvas.user.id")
            .build();
    Placement editorButton =
        Placement.builder()
            .text("Editor Button Placement")
            .iconUrl("https://some.icon.url/editor_tool.png")
            .placement("editor_button")
            .messageType(Placement.LTI_DEEP_LINKING_REQUEST)
            .targetLinkUri("https://your.target_link_uri/content_selector")
            .selectionHeight(500)
            .selectionWidth(500)
            .build();
    Settings settings =
        Settings.builder()
            .text("Launch The Best Tool")
            .iconUrl("https://some.icon.url/tool-level.png")
            .selectionHeight(800)
            .selectionWidth(800)
            .placement(userNavigation)
            .placement(editorButton)
            .build();
    Extension extension =
        Extension.builder()
            .domain("thebesttool.com")
            .toolId("the-best-tool")
            .platform(Extension.CANVAS_PLATFORM)
            .privacyLevel(Extension.PUBLIC)
            .settings(settings)
            .build();
    Config config =
        Config.builder()
            .title("The Best Tool")
            .description("1.3 Test Tool used for documentation purposes.")
            .oidcInitiationUrl("https://your.oidc_initiation_url")
            .targetLinkUri("https://your.target_link_uri")
            .scope(Config.LINEITEM)
            .scope(Config.RESULT_READONLY)
            .extension(extension)
            .publicJwkUrl("https://your.public_jwk_url")
            .customField("bar", "$Canvas.user.sisid")
            .build();

    ObjectMapper mapper = new ObjectMapper();
    mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
    String configJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(config);

    assertEquals(mapper.readTree(testConfigJson), mapper.readTree(configJson));
  }
}
