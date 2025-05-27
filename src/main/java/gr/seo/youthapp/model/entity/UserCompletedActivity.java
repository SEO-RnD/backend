package gr.seo.youthapp.model.entity;

import gr.seo.youthapp.model.entity.keys.UserActivityId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * Represents an entity for tracking activities completed by users. This entity uses a composite key
 * to uniquely identify the relationship between a user and a completed activity. It also includes a
 * timestamp indicating when the activity was completed.
 *
 * <p>The composite key is modeled using {@code UserActivityId}, which ensures the uniqueness of the
 * user-activity relationship.</p>
 *
 * <p>An instance of this class is initialized with the current timestamp for the
 * {@code completedAt} field by default.</p>
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "user_completed_activities")
public class UserCompletedActivity {
  @EmbeddedId
  private UserActivityId userActivityId;

  private LocalDateTime completedAt = LocalDateTime.now();
}
