
-- Insert a user
INSERT INTO users (username, email, password, role, created_at)
VALUES ('user1', 'john@example.com', '$2a$10$V0gOCTkfaUdfhOEDTnYv4O0lacmfdVGDn0K9ErR9t8DU2zfNjLJ5S', 1, CURRENT_TIMESTAMP);

-- Insert an item
INSERT INTO item (users_id, title, description, start_price, current_price, start_time, end_time, status)
VALUES (1, 'Vintage Watch', 'A classic vintage wristwatch.', 100.0, 120.0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP + INTERVAL '7' DAY, 0);