INSERT INTO brs_user
(id, email, hash_password, state, role, surname, name)
  SELECT
    1,
    'admin@admin.com',
    '$2a$10$CVYX7vIc3a7nz7cWiGj0xeBUlAfcg7dVtWc2n5hQv7CNzTD4UGxeK',

    'CONFIRMED',
    'ADMIN',
    'admin',
    'admin'
  WHERE
    NOT EXISTS(
        SELECT id
        FROM brs_user
        WHERE id = 1
    );