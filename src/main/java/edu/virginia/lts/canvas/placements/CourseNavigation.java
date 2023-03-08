package edu.virginia.lts.canvas.placements;

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.virginia.lts.canvas.Placement;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CourseNavigation extends Placement {

  // TODO: can we automatically set the 'course_navigation' placement when this class is used.
  public static String COURSE_NAVIGATION_PLACEMENT = "course_navigation";

  @JsonProperty("default")
  private String defaultString;

  private String visibility;
}
