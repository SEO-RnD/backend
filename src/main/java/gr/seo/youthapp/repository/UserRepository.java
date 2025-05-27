package gr.seo.youthapp.repository;

import gr.seo.youthapp.model.entity.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserRepository is a data access layer interface for managing User entities. It extends
 * JpaRepository, providing standard methods for CRUD operations, as well as the ability to define
 * custom query methods.
 */
public interface UserRepository extends JpaRepository<User, Integer> {
  /**
   * Retrieves a User entity wrapped in an Optional based on the provided member ID.
   *
   * @param memberId the unique identifier of the member to look up
   * @return an Optional containing the User entity if found, otherwise an empty Optional
   */
  Optional<User> findByMemberId(String memberId);

  /**
   * Retrieves a User entity wrapped in an Optional based on the provided username.
   *
   * @param username the username of the User entity to look up
   * @return an Optional containing the User entity if found, otherwise an empty Optional
   */
  Optional<User> findByUsername(String username);

  /**
   * Retrieves a list of User entities associated with a specific troop ID.
   *
   * @param troopId the unique identifier of the troop
   * @return a list of User entities belonging to the specified troop
   */
  List<User> findByTroopId(Integer troopId);
}
