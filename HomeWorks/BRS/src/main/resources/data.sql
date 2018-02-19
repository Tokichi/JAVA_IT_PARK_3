INSERT INTO brs_user
(id, email, hash_password, state, role, name, surname, patronymic)
  SELECT
    1,
    'admin',
    '$2a$10$num6dkwy8/VuFNDTaR0N3u2rMq4jnZRCVTj1KBhO0.EZi2Kr1GmHS',
    'CONFIRMED',
    'ADMIN',
    'Админ',
    'Админов',
    'Админович'
  WHERE
    NOT EXISTS(
        SELECT id
        FROM brs_user
        WHERE id = 1
    );

CREATE TABLE IF NOT EXISTS persistent_logins (
  username VARCHAR(64) NOT NULL,
  series VARCHAR(64) PRIMARY KEY NOT NULL,
  token VARCHAR(64) NOT NULL,
  last_used TIMESTAMP NOT NULL
)