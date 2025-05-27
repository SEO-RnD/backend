package gr.seo.youthapp.model.entity;

import gr.seo.youthapp.model.enums.ActivityType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
 * Represents an activity in the system, which may correspond to a PATH or a PIN ACTIVITY.
 * Activities are distinguished by a type, title, and chapter. Supports tracking creation and update
 * timestamps.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "activities")
public class Activity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable = false)
  private String number;

  @Column(nullable = false)
  private String title;

  private String description;

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private ActivityType type;

  private String chapter;

  @ManyToOne
  @JoinColumn(name = "pin_id")
  private Pin pin;

  @Column(nullable = false)
  private Boolean isActive = true;

  private LocalDateTime createdAt = LocalDateTime.now();
  private LocalDateTime updatedAt = LocalDateTime.now();
}
