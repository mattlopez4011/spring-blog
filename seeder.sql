USE spring_blog_db;

SHOW CREATE TABLE posts;

DROP database if exists spring_blog_db;

DROP TABLE IF EXISTS users;

DROP TABLE IF EXISTS posts_details;

describe dogs;
describe posts_details;

show tables;



USE spring_blog_db;

drop table if exists posts;

INSERT INTO posts(title, body, post_details_id, user_id) VALUE ('hello  world', 'Hello World body', 1, 1);
insert into posts (title, body, post_details_id, user_id) values ('Witty', 'Osmar', 2, 2);
insert into posts (title, body, post_details_id, user_id) values ('Hinda', 'Esposito', 3, 3);
insert into posts (title, body, post_details_id, user_id) values ('Yves', 'Masurel', 4, 4);
insert into posts (title, body, post_details_id, user_id) values ('Ayn', 'Lamblin', 5, 5);
insert into posts (title, body, post_details_id, user_id) values ('Rube', 'Strutton', 6, 6);
insert into posts (title, body, post_details_id) values ('Marrilee', 'Hawkings', 12);
insert into posts (title, body, post_details_id) values ('Eleni', 'Calverd', 9);
insert into posts (title, body, post_details_id) values ('Rourke', 'Citrine', 19);
insert into posts (title, body, post_details_id) values ('Kaila', 'Petegree', 19);
insert into posts (title, body, post_details_id) values ('Margit', 'Sculpher', 12);
insert into posts (title, body, post_details_id) values ('Augustine', 'Mara', 11);
insert into posts (title, body, post_details_id) values ('Fleurette', 'Groneway', 20);
insert into posts (title, body, post_details_id) values ('Ninnetta', 'Tribe', 11);
insert into posts (title, body, post_details_id) values ('Carree', 'Casterot', 7);
insert into posts (title, body, post_details_id) values ('Barbara-anne', 'Bugbird', 5);
insert into posts (title, body, post_details_id) values ('Karola', 'Spittal', 16);
insert into posts (title, body, post_details_id) values ('Delmore', 'Langer', 6);
insert into posts (title, body, post_details_id) values ('Lisha', 'Reck', 20);
insert into posts (title, body, post_details_id) values ('Joleen', 'Widdowes', 13);
insert into posts (title, body, post_details_id) values ('Yolane', 'Briscow', 16);


INSERT INTO posts_details(history_of_post, is_awesome, topic_description) value ('this post is old', 1,'this post was made old');
insert into posts_details (history_of_post, topic_description, is_awesome) values ('Chevrolet', 'Tracker', true);
insert into posts_details (history_of_post, topic_description, is_awesome) values ('Ford', 'Bronco', true);
insert into posts_details (history_of_post, topic_description, is_awesome) values ('GMC', '2500', true);
insert into posts_details (history_of_post, topic_description, is_awesome) values ('Buick', 'LeSabre', true);
insert into posts_details (history_of_post, topic_description, is_awesome) values ('Mitsubishi', 'Outlander', true);
insert into posts_details (history_of_post, topic_description, is_awesome) values ('Dodge', 'Colt', false);
insert into posts_details (history_of_post, topic_description, is_awesome) values ('Volvo', 'XC90', true);
insert into posts_details (history_of_post, topic_description, is_awesome) values ('Toyota', 'Echo', false);
insert into posts_details (history_of_post, topic_description, is_awesome) values ('Mazda', 'Familia', false);
insert into posts_details (history_of_post, topic_description, is_awesome) values ('Volkswagen', 'Eurovan', false);
insert into posts_details (history_of_post, topic_description, is_awesome) values ('Subaru', 'Legacy', false);
insert into posts_details (history_of_post, topic_description, is_awesome) values ('Dodge', 'Caliber', true);
insert into posts_details (history_of_post, topic_description, is_awesome) values ('Chevrolet', 'Cobalt', true);
insert into posts_details (history_of_post, topic_description, is_awesome) values ('Ford', 'LTD Crown Victoria', false);
insert into posts_details (history_of_post, topic_description, is_awesome) values ('Ford', 'Expedition', true);
insert into posts_details (history_of_post, topic_description, is_awesome) values ('Lincoln', 'Navigator L', true);
insert into posts_details (history_of_post, topic_description, is_awesome) values ('Ford', 'Thunderbird', false);
insert into posts_details (history_of_post, topic_description, is_awesome) values ('Ford', 'Thunderbird', false);
insert into posts_details (history_of_post, topic_description, is_awesome) values ('Plymouth', 'Breeze', true);
insert into posts_details (history_of_post, topic_description, is_awesome) values ('Mazda', '929', false);


insert into posts_images (image_title, url, post_id) values ('22 Bullets (L''immortel)', 'https://placekitten.com/g/200/300', 1);
insert into posts_images (image_title, url, post_id) values ('Peanuts - Die Bank zahlt alles', 'https://placekitten.com/g/200/300', 1);
insert into posts_images (image_title, url, post_id) values ('Street Mobster (a.k.a. Modern Yakuza: Outlaw Killer) (Gendai yakuza: hito-kiri yota)', 'https://placekitten.com/g/200/300', 1);


# 3. Seed the tags table with three tags named the following: "Silly", "Funny", and "Humor".
insert into tags (name)
    values ('Silly');
insert into tags (name)
values ('Funny');
insert into tags (name)
values ('Humor');

# 4. Seed the post_tag table with one post that has the "Silly" and "Funny" tags and another having the "Humor" and "Funny" tags. In total, you will need to insert four records.
insert into post_tag (tag_id, post_id)
                         VALUE ('1', '1');
insert into post_tag (tag_id, post_id)
    VALUE ('2', '1');
insert into post_tag (tag_id, post_id)
    VALUE ('1', '2');
insert into post_tag (tag_id, post_id)
    VALUE ('1', '3');
insert into post_tag (tag_id, post_id)
    VALUE ('2', '4');
insert into post_tag (tag_id, post_id)
    VALUE ('2', '5');
insert into post_tag (tag_id, post_id)
    VALUE ('3', '5');
insert into post_tag (tag_id, post_id)
    VALUE ('3', '6');

drop table users;
# Users seeder
insert into users (email, password, username) VALUE ('mock1@gmail.com', 'password1', 'mock1');
insert into users (email, password, username) VALUE ('mock2@gmail.com', 'password2', 'mock2');
insert into users (email, password, username) VALUE ('mock3@gmail.com', 'password3', 'mock3');
insert into users (email, password, username) VALUE ('mock4@gmail.com', 'password4', 'mock4');
insert into users (email, password, username) VALUE ('mock5@gmail.com', 'password5', 'mock5');
insert into users (email, password, username) VALUE ('mock6@gmail.com', 'password6', 'mock6');