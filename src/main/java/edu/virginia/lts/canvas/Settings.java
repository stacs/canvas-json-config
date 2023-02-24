package edu.virginia.lts.canvas;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;

@Data
@Builder
public class Settings {

  private String text;

  @JsonProperty("icon_url")
  private String iconUrl;

  @JsonProperty("selection_height")
  private Integer selectionHeight;

  @JsonProperty("selection_width")
  private Integer selectionWidth;

  @Singular private List<Placement> placements;
}
