package gr.seo.youthapp.model.entity.keys;

import jakarta.persistence.Embeddable;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

/**
 * Represents the composite primary key for the UserEarnedBadge entity. This class contains the
 * identifiers for a user and a badge, allowing the mapping of a many-to-many relationship between
 * users and badges.
 *
 * <p>It is marked as {@link Embeddable}, enabling it to be used as the composite key in a JPA
 * entity.</p>
 *
 * <p>Overrides {@code equals} and {@code hashCode} to ensure correct behavior in collections and
 * Hibernate relationships.</p>
 */
@Embeddable
public class UserBadgeId implements Serializable {
  @Serial
  private static final long serialVersionUID = -7557867935675462773L;

  private Integer userId;
  private Integer badgeId;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof UserBadgeId that)) {
      return false;
    }
    return Objects.equals(userId, that.userId) && Objects.equals(badgeId, that.badgeId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, badgeId);
  }
}
