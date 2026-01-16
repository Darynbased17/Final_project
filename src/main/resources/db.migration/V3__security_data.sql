ALTER TABLE permissions ADD CONSTRAINT permissions_name_key UNIQUE (name);

INSERT INTO permissions (name) VALUES ('ROLE_ADMIN') ON CONFLICT (name) DO NOTHING;
INSERT INTO permissions (name) VALUES ('ROLE_USER') ON CONFLICT (name) DO NOTHING;

INSERT INTO users (username, email, password)
VALUES ('admin', 'admin@mail.ru', '$2a$12$X58qAN3p7hKy4jP2JHj6euvsdD/vLWIn7k2H6xg62fkhSct9FUYT2')
ON CONFLICT (username) DO NOTHING;

INSERT INTO users (username, email, password)
VALUES ('user1', 'user1@mail.ru', '$2a$12$X58qAN3p7hKy4jP2JHj6euvsdD/vLWIn7k2H6xg62fkhSct9FUYT2')
ON CONFLICT (username) DO NOTHING;

INSERT INTO user_permissions (user_id, permission_id)
SELECT u.id, p.id FROM users u, permissions p
WHERE u.username = 'admin' AND p.name = 'ROLE_ADMIN'
ON CONFLICT DO NOTHING;

INSERT INTO user_permissions (user_id, permission_id)
SELECT u.id, p.id FROM users u, permissions p
WHERE u.username = 'user1' AND p.name = 'ROLE_USER'
ON CONFLICT DO NOTHING;