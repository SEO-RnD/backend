# YouthApp Database Schema Overview

**GitHub Issue:** #1 - Describe Database Schema

This document outlines the initial version of the YouthApp relational database schema, which is implemented using
PostgreSQL. The system is designed to support a program where users complete educational activities organized into
paths, pins, and badges. All primary keys are sequential `INTEGER` IDs. Enums are handled in the application layer (
Java) rather than in the database.

> 🔒 All sensitive information (like credentials) is injected via environment variables.

---

## Schema Summary

The system supports:

- Multiple users with different roles (`USER`, `LEADER`, `ADMIN`, `SUPER_ADMIN`)
- Users belonging to a troop
- Two types of activities: standalone "paths" (Μονοπατια) and grouped "pin activities" (Δραστηριότητες Πτυχίου)
- Two types of pins: "normal" (Πτυχία) and "special" (Πτυχία Οδηγισμού) (mandatory for badges)
- Three progressive badges (Κορυφές): Bronze, Silver, and Gold
- Full tracking of user progress through activities, pins, and badges
- Session management using external authentication tokens

---

## Tables Overview

### 1. **Troops**

Represents an organizational group (e.g., local unit or region).

| Column       | Type      | Description                         |
|--------------|-----------|-------------------------------------|
| `id`         | INTEGER   | Primary key                         |
| `name`       | VARCHAR   | Name of the troop                   |
| `is_active`  | BOOLEAN   | Whether the troop is currently used |
| `created_at` | TIMESTAMP | Timestamp of creation               |
| `updated_at` | TIMESTAMP | Timestamp of last update            |

---

### 2. **Users**

Stores user data. Each user belongs to one troop.

| Column       | Type      | Description                                  |
|--------------|-----------|----------------------------------------------|
| `id`         | INTEGER   | Primary key                                  |
| `member_id`  | VARCHAR   | External login system ID                     |
| `username`   | VARCHAR   | Optional username                            |
| `name`       | VARCHAR   | Display name                                 |
| `role`       | VARCHAR   | User role (USER, LEADER, ADMIN, SUPER_ADMIN) |
| `is_active`  | BOOLEAN   | For soft-deletion support                    |
| `troop_id`   | INTEGER   | FK to `troops.id`                            |
| `created_at` | TIMESTAMP | Timestamp of creation                        |
| `updated_at` | TIMESTAMP | Timestamp of last update                     |

---

### 3. **Pins**

Represents a group of activities. Can be `NORMAL` or `SPECIAL`.

| Column        | Type      | Description                 |
|---------------|-----------|-----------------------------|
| `id`          | INTEGER   | Primary key                 |
| `name`        | VARCHAR   | Name of the pin             |
| `type`        | VARCHAR   | Pin type: SPECIAL or NORMAL |
| `description` | TEXT      | Pin description             |
| `is_active`   | BOOLEAN   | Whether the pin is active   |
| `created_at`  | TIMESTAMP | Timestamp of creation       |
| `updated_at`  | TIMESTAMP | Timestamp of last update    |

---

### 4. **Activities**

A unified table for both paths and pin activities.

| Column        | Type      | Description                                    |
|---------------|-----------|------------------------------------------------|
| `id`          | INTEGER   | Primary key                                    |
| `number`      | VARCHAR   | Activity number (used for display and sorting) |
| `title`       | VARCHAR   | Name of the activity                           |
| `description` | TEXT      | Detailed description                           |
| `type`        | VARCHAR   | `PATH` or `PIN_ACTIVITY`                       |
| `chapter`     | VARCHAR   | Chapter info (only used for paths)             |
| `pin_id`      | INTEGER   | FK to `pins.id` (only used for pin activities) |
| `is_active`   | BOOLEAN   | Whether the activity is active                 |
| `created_at`  | TIMESTAMP | Timestamp of creation                          |
| `updated_at`  | TIMESTAMP | Timestamp of last update                       |

---

### 5. **Badges**

Represents milestone awards earned by users.

| Column        | Type      | Description                              |
|---------------|-----------|------------------------------------------|
| `id`          | INTEGER   | Primary key                              |
| `name`        | VARCHAR   | Badge title                              |
| `level`       | INTEGER   | Level: 1 = Bronze, 2 = Silver, 3 = Gold  |
| `description` | TEXT      | Description of what the badge represents |
| `is_active`   | BOOLEAN   | Whether the badge is active              |
| `created_at`  | TIMESTAMP | Timestamp of creation                    |
| `updated_at`  | TIMESTAMP | Timestamp of last update                 |

Preloaded entries:

- Bronze Badge
- Silver Badge
- Gold Badge

---

## User Progress Tracking Tables

### 6. **User Completed Activities**

Tracks completed activities for each user.

| Column         | Type      | Description                          |
|----------------|-----------|--------------------------------------|
| `user_id`      | INTEGER   | FK to `users.id`                     |
| `activity_id`  | INTEGER   | FK to `activities.id`                |
| `completed_at` | TIMESTAMP | When the user completed the activity |

---

### 7. **User Completed Pins**

Tracks fully completed pins per user.

| Column         | Type      | Description                          |
|----------------|-----------|--------------------------------------|
| `user_id`      | INTEGER   | FK to `users.id`                     |
| `pin_id`       | INTEGER   | FK to `pins.id`                      |
| `completed_at` | TIMESTAMP | When the pin was marked as completed |

---

### 8. **User Earned Badges**

Tracks badges earned by each user.

| Column      | Type      | Description                      |
|-------------|-----------|----------------------------------|
| `user_id`   | INTEGER   | FK to `users.id`                 |
| `badge_id`  | INTEGER   | FK to `badges.id`                |
| `earned_at` | TIMESTAMP | Timestamp when badge was awarded |

---

### 9. **User Sessions**

Manages tokens returned from external login system.

| Column       | Type      | Description                        |
|--------------|-----------|------------------------------------|
| `id`         | INTEGER   | Primary key                        |
| `user_id`    | INTEGER   | FK to `users.id`                   |
| `auth_token` | VARCHAR   | Authentication token               |
| `issued_at`  | TIMESTAMP | When the token was issued          |
| `expires_at` | TIMESTAMP | Optional expiration date           |
| `is_active`  | BOOLEAN   | Whether the session is still valid |

---
