package gr.seo.youthapp.model.enums;

/**
 * Represents the various access level related roles a user can have within the system. Each role
 * defines specific permissions:
 *
 * <ul>
 *   <li>USER: Regular user with basic access rights.
 *   <li>LEADER: A user with elevated permissions, in charge of a troop of users.
 *   <li>ADMIN: A user with administrative rights and broader access to manage resources.
 *   <li>SUPER_ADMIN: A developer-level users with the highest level of access and control over the
 *       system.
 * </ul>
 */
public enum UserRole {
  USER, LEADER, ADMIN, SUPER_ADMIN
}
