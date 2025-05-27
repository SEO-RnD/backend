package gr.seo.youthapp.repository;

import gr.seo.youthapp.model.entity.Troop;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * TroopRepository acts as the data access layer for the Troop entity. It extends JpaRepository,
 * providing CRUD operations and query method support for Troop objects.
 */
public interface TroopRepository extends JpaRepository<Troop, Integer> {
}
