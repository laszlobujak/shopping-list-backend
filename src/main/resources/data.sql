insert into users (username, password, role) values ('user1', 'user1', 'ADMIN');
insert into users (username, password, role) values ('user2', 'user2', 'USER');
insert into users (username, password, role) values ('user3', 'user3', 'USER');

insert into shoppinglists(title, owner_id, created_at, updated_at) values ('title1', 1, CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());
insert into shoppinglists(title, owner_id, created_at, updated_at) values ('title2', 2, CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());
insert into shoppinglists(title, owner_id, created_at, updated_at) values ('title3', 2, CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());
insert into shoppinglists(title, owner_id, created_at, updated_at) values ('title4', 3, CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());


insert into items(shoppinglist_id, item_name, quantaty, unit, purchased, created_at, updated_at) values (1, 'name1', 1, 'unit1', false, CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());
insert into items(shoppinglist_id, item_name, quantaty, unit, purchased, created_at, updated_at) values (1, 'name2', 2, 'unit2', false, CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());
insert into items(shoppinglist_id, item_name, quantaty, unit, purchased, created_at, updated_at) values (2, 'name3', 3, 'unit3', false, CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());
insert into items(shoppinglist_id, item_name, quantaty, unit, purchased, created_at, updated_at) values (2, 'name4', 4, 'unit4', false, CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());

insert into messages(item_id, text, created_at, updated_at) values (2, 'text1', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());
insert into messages(item_id, text, created_at, updated_at) values (2, 'text2', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());
insert into messages(item_id, text, created_at, updated_at) values (2, 'text3', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());
insert into messages(item_id, text, created_at, updated_at) values (1, 'text4', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());
