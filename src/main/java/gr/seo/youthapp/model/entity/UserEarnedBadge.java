package gr.seo.youthapp.model.entity;

import gr.seo.youthapp.model.entity.keys.UserBadgeId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents the relationship between a user and a badge that the user has earned. This entity
 * models the many-to-many association between users and badges with an associated composite primary
 * key.
 *
 * <p>The {@code UserEarnedBadge} entity contains:
 * - A composite primary key represented by {@code UserBadgeId}, which includes the unique
 * identifiers for the user and badge. - The date and time when the badge was earned, stored as
 * {@code earnedAt}.</p>
 *
 * <p>An instance of this entity is automatically associated with the timestamp for when the badge
 * was earned, defaulting to the current time if not explicitly set.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "user_earned_badges")
public class UserEarnedBadge {
  @EmbeddedId
  private UserBadgeId userBadgeId;

  private LocalDateTime earnedAt = LocalDateTime.now();
}
