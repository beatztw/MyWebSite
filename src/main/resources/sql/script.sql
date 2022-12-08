CREATE TABLE IF NOT EXISTS users_table
(
    id         bigserial primary key,
    login      varchar(30),
    role       varchar(25) default 'user',
    password   varchar(40)
);

CREATE TABLE IF NOT EXISTS posts_table
(
    id      bigserial primary key,
    title   varchar(760),
    text    varchar(760),
    imgName varchar(255),
    img     bytea,
    user_id bigint references users_table (id)
);

CREATE TABLE IF NOT EXISTS comments_table
(
    id      bigserial primary key,
    text    varchar(750),
    user_id bigint references users_table (id),
    post_id bigint references posts_table (id)
);

ALTER TABLE posts_table ALTER COLUMN imgName TYPE VARCHAR(255);