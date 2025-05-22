-- USERS
CREATE TABLE users
(
    id         INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    member_id  VARCHAR(255) NOT NULL,
    username   VARCHAR(255),
    name       VARCHAR(255),
    role       VARCHAR(50)  NOT NULL, -- USER, LEADER, ADMIN, SUPER_ADMIN
    is_active  BOOLEAN      NOT NULL DEFAULT TRUE,
    created_at TIMESTAMP             DEFAULT now(),
    updated_at TIMESTAMP             DEFAULT now()
);

-- TROOPS
CREATE TABLE troops
(
    id         INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name       VARCHAR(255) NOT NULL,
    is_active  BOOLEAN      NOT NULL DEFAULT TRUE,
    created_at TIMESTAMP             DEFAULT now(),
    updated_at TIMESTAMP             DEFAULT now()
);

-- USER-TROOP RELATIONSHIP (Many-to-Many)
CREATE TABLE user_troops
(
    user_id  INTEGER NOT NULL,
    troop_id INTEGER NOT NULL,
    PRIMARY KEY (user_id, troop_id),
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (troop_id) REFERENCES troops (id)
);

-- PINS
CREATE TABLE pins
(
    id          INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    type        VARCHAR(50)  NOT NULL, -- SPECIAL or NORMAL
    description TEXT,
    is_active   BOOLEAN      NOT NULL DEFAULT TRUE,
    created_at  TIMESTAMP             DEFAULT now(),
    updated_at  TIMESTAMP             DEFAULT now()
);

-- ACTIVITIES (shared for paths and pin activities)
CREATE TABLE activities
(
    id          INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    number      VARCHAR(20)  NOT NULL,
    title       VARCHAR(255) NOT NULL,
    description TEXT,
    type        VARCHAR(50)  NOT NULL, -- PATH or PIN_ACTIVITY
    chapter     VARCHAR(50),           -- only for paths
    pin_id      INTEGER,               -- only for pin activities
    is_active   BOOLEAN      NOT NULL DEFAULT TRUE,
    created_at  TIMESTAMP             DEFAULT now(),
    updated_at  TIMESTAMP             DEFAULT now(),
    CONSTRAINT fk_pin FOREIGN KEY (pin_id) REFERENCES pins (id)
);

-- BADGES
CREATE TABLE badges
(
    id          INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    level       INTEGER      NOT NULL, -- BRONZE - 1, SILVER - 2, GOLD - 3
    description TEXT,
    is_active   BOOLEAN      NOT NULL DEFAULT TRUE,
    created_at  TIMESTAMP             DEFAULT now(),
    updated_at  TIMESTAMP             DEFAULT now()
);

-- Insert 3 core badges
INSERT INTO badges (name, level, description)
VALUES ('Bronze Badge', 1, 'Awarded after completing 4 paths, 1 pin, and Special Pin A'),
       ('Silver Badge', 2, 'Awarded after completing 4 new paths, 1 new pin, and Special Pin B'),
       ('Gold Badge', 3, 'Awarded after completing 4 new paths, 2 new pins, and Special Pin C');

-- Paths completed by user
CREATE TABLE user_completed_activities
(
    user_id      INTEGER NOT NULL,
    activity_id  INTEGER NOT NULL,
    completed_at TIMESTAMP DEFAULT now(),
    PRIMARY KEY (user_id, activity_id),
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (activity_id) REFERENCES activities (id)
);

-- Pins completed by user
CREATE TABLE user_completed_pins
(
    user_id      INTEGER NOT NULL,
    pin_id       INTEGER NOT NULL,
    completed_at TIMESTAMP DEFAULT now(),
    PRIMARY KEY (user_id, pin_id),
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (pin_id) REFERENCES pins (id)
);

-- Badges earned by user
CREATE TABLE user_earned_badges
(
    user_id   INTEGER NOT NULL,
    badge_id  INTEGER NOT NULL,
    earned_at TIMESTAMP DEFAULT now(),
    PRIMARY KEY (user_id, badge_id),
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (badge_id) REFERENCES badges (id)
);

-- USER SESSION STORAGE (auth token management)
CREATE TABLE user_sessions
(
    id         INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    user_id    INTEGER      NOT NULL,
    auth_token VARCHAR(512) NOT NULL,
    issued_at  TIMESTAMP             DEFAULT now(),
    expires_at TIMESTAMP,
    is_active  BOOLEAN      NOT NULL DEFAULT TRUE,
    FOREIGN KEY (user_id) REFERENCES users (id)
);