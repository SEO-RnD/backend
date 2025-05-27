package gr.seo.youthapp.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity representing a session associated with a user. This class is used to store details about
 * authentication tokens, session duration and status.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "user_sessions")
public class UserSession {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  private String authToken;
  private LocalDateTime issuedAt;
  private LocalDateTime expiresAt;
  private Boolean isActive = true;
}
