package gr.seo.youthapp.model.entity;

import gr.seo.youthapp.model.enums.UserRole;
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
 * Represents a User entity in the system. This entity contains information about users such as
 * their identifiers, roles, status, and association with a specific troop. It also tracks
 * timestamps for creation and updates.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable = false)
  private String memberId;

  private String username;

  @Column(name = "name")
  private String fullName;

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private UserRole role;

  @Column(nullable = false)
  private Boolean isActive = true;

  @ManyToOne
  @JoinColumn(name = "troop_id", referencedColumnName = "id")
  private Troop troop;

  private LocalDateTime createdAt = LocalDateTime.now();
  private LocalDateTime updatedAt = LocalDateTime.now();
}
