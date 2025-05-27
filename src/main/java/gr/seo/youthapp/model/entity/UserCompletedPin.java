package gr.seo.youthapp.model.entity;

import gr.seo.youthapp.model.entity.keys.UserPinId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents the mapping between a user and a completed pin in the system. This entity captures the
 * association when a user completes a specific pin, along with the timestamp indicating when the
 * completion occurred.
 *
 * <p>The {@code userPinId} field acts as a composite primary key consisting of references to
 * a user and a pin. The {@code completedAt} field stores the timestamp when the pin was marked as
 * completed.</p>
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "user_completed_pins")
public class UserCompletedPin {
  @EmbeddedId
  private UserPinId userPinId;

  private LocalDateTime completedAt = LocalDateTime.now();
}
