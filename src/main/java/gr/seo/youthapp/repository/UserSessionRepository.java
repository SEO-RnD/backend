package gr.seo.youthapp.repository;

import gr.seo.youthapp.model.entity.UserSession;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserSessionRepository provides the data access layer for managing UserSession entities. It
 * extends JpaRepository, offering a set of standard methods for CRUD operations and enabling the
 * definition of custom query methods.
 */
public interface UserSessionRepository extends JpaRepository<UserSession, Integer> {
  /**
   * Retrieves a UserSession entity wrapped in an Optional based on the provided authentication
   * token.
   *
   * @param authToken the authentication token to search for
   * @return an Optional containing the UserSession entity if found, otherwise an empty Optional
   */
  Optional<UserSession> findByAuthToken(String authToken);

  /**
   * Retrieves a UserSession entity wrapped in an Optional based on the provided user ID.
   *
   * @param id the ID of the user whose session is being retrieved
   * @return an Optional containing the UserSession entity if found, otherwise an empty Optional
   */
  Optional<UserSession> findByUserId(Integer id);
}
