package gr.seo.youthapp.model.entity.keys;

import jakarta.persistence.Embeddable;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

/**
 * Represents the composite primary key for the UserCompletedPin entity. This class contains the
 * identifiers for a user and a pin, allowing the mapping of a many-to-many relationship between
 * users and badges.
 *
 * <p>It is marked as {@link Embeddable}, enabling it to be used as the composite key in a JPA
 * entity.</p>
 *
 * <p>Overrides {@code equals} and {@code hashCode} to ensure correct behavior in collections and
 * Hibernate relationships.</p>
 */
@Embeddable
public class UserPinId implements Serializable {
  @Serial
  private static final long serialVersionUID = 4669987818685943585L;

  private Integer userId;
  private Integer pinId;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof UserPinId that)) {
      return false;
    }
    return Objects.equals(userId, that.userId) && Objects.equals(pinId, that.pinId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, pinId);
  }
}
