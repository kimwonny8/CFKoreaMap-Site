CREATE TABLE IF NOT EXISTS authority
(
    authority_name VARCHAR(50) NOT NULL,
    PRIMARY KEY (authority_name)
);

CREATE TABLE IF NOT EXISTS member
(
    member_id     BIGINT AUTO_INCREMENT PRIMARY KEY,
    email         VARCHAR(50)  NOT NULL UNIQUE,
    password      VARCHAR(100) NOT NULL,
    name          VARCHAR(50),
    gym           VARCHAR(100),
    activated     BOOLEAN,
    refresh_token VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS member_authority
(
    member_id      BIGINT,
    authority_name VARCHAR(50),
    FOREIGN KEY (member_id) REFERENCES member (member_id),
    FOREIGN KEY (authority_name) REFERENCES authority (authority_name),
    PRIMARY KEY (member_id, authority_name)
);

CREATE TABLE IF NOT EXISTS gym
(
    gym_id    BIGINT AUTO_INCREMENT PRIMARY KEY,
    name      VARCHAR(255) NOT NULL UNIQUE,
    location  VARCHAR(255) NOT NULL,
    member_id BIGINT,
    FOREIGN KEY (member_id) REFERENCES member (member_id)
);



CREATE TABLE IF NOT EXISTS board
(
    board_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    type     VARCHAR(30) NOT NULL,
    gym_id   BIGINT,
    FOREIGN KEY (gym_id) REFERENCES gym (gym_id)
);

CREATE TABLE IF NOT EXISTS post
(
    post_id   BIGINT AUTO_INCREMENT PRIMARY KEY,
    title     VARCHAR(50),
    content   TEXT,
    is_notice BOOLEAN,
    board_id  BIGINT,
    member_id BIGINT,
    FOREIGN KEY (board_id) REFERENCES board (board_id),
    FOREIGN KEY (member_id) REFERENCES member (member_id)
);

CREATE TABLE IF NOT EXISTS reply
(
    reply_id  BIGINT AUTO_INCREMENT PRIMARY KEY,
    content   TEXT,
    post_id   BIGINT,
    member_id BIGINT,
    FOREIGN KEY (post_id) REFERENCES post (post_id),
    FOREIGN KEY (member_id) REFERENCES member (member_id)
);
