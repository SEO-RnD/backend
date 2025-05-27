package gr.seo.youthapp.model.entity;

import gr.seo.youthapp.model.enums.BadgeLevel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents a badge entity that can be awarded to users as part of their achievements. A badge is
 * characterized by its name, level, description, and an activation status. Additionally, creation
 * and update timestamps are maintained for tracking purposes.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "badges")
public class Badge {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  @Enumerated(EnumType.ORDINAL)
  private BadgeLevel level;

  private String description;

  @Column(nullable = false)
  private Boolean isActive = true;

  private LocalDateTime createdAt = LocalDateTime.now();
  private LocalDateTime updatedAt = LocalDateTime.now();
}
