package gr.seo.youthapp.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Enum representing various badge levels. Each level corresponds to the order of the badges,
 * represented by an integer value. The three badge levels available are:
 *
 * <ul>
 *   <li>BRONZE: First level of badge to reach (value: 1)</li>
 *   <li>SILVER: Second level of badge to reach (value: 2)</li>
 *   <li>GOLD: Last level of badge to reach (value: 3)</li>
 * </ul>
 */
@AllArgsConstructor
@Getter
public enum BadgeLevel {
  BRONZE(1), SILVER(2), GOLD(3);

  private final int level;
}
