CREATE TABLE users
(
    chat_id bigint PRIMARY KEY,
    state_index int DEFAULT 1,
    has_game_session boolean DEFAULT false
);

INSERT INTO users (chat_id, state_index, has_game_session) Values(1, 1, false);
INSERT INTO users (chat_id, state_index, has_game_session) Values(2, 1, false);
INSERT INTO users (chat_id, state_index, has_game_session) Values(3, 1, false);
INSERT INTO users (chat_id, state_index, has_game_session) Values(4, 1, false);
SELECT * FROM users
