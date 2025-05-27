package gr.seo.youthapp.model.entity;

import gr.seo.youthapp.model.enums.PinType;
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
 * Represents a pin entity in the system, used for defining different types of pins with associated
 * properties. Pins are identified by a unique ID and can have a name, type, description, and
 * activation state. Additionally, timestamps for creation and updates are tracked.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "pins")
public class Pin {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String name;

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private PinType type;

  @Column(nullable = false)
  private String description;

  @Column(nullable = false)
  private Boolean isActive = true;

  private LocalDateTime createdAt = LocalDateTime.now();
  private LocalDateTime updatedAt = LocalDateTime.now();
}
