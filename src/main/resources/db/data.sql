INSERT INTO USER (id, avatar, email, last_name, name, password, phone, username) VALUES
(1,'', 'user@email.com', 'useris','useriukas', '{bcrypt}$2y$12$y8uY.LDwuib2e.CFpoEF7.lWcG2P.n33o0jXBBUCc4pykroZn0RvS', '+37060090000', 'user'),
(2,'', 'admin@email.com', 'adminas', 'adminukas', '{bcrypt}$2y$12$6C5T4j7HlR8CaokuYbtvMuKU5GAHJxVmq7v9oQonieq5jTAtEiRuG', '+37069099999', 'admin');

INSERT INTO ROLE (id, role_name) VALUES
(1, 'USER'),
(2, 'ADMIN');

INSERT INTO USER_ROLES (user_id, role_id) VALUES
(1, 1),
(2, 2),
(2, 1);

INSERT INTO RECIPE (id, recipe_description, cook_time, difficulty, directions, prep_time, servings, source, url, notes_id) VALUES
(1, 'Best pasta',  1, 'HARD', 'jjj', 2, 2, 'qqqqq', 'hahha', 1);

INSERT INTO NOTES (id, recipe_notes, recipe_id) VALUES
(1, 'Do with love', 1);

INSERT INTO CATEGORY (id, category_description) VALUES
(1, 'Italian'),
(2, 'Lithuania');

INSERT INTO RECIPE_CATEGORY (recipe_id, category_id) VALUES
(1, 1),
(1, 2);

INSERT INTO INGREDIENT (id, amount, ingredient_description, mu_id, recipe_id) VALUES
(1, 1, 'Water', 1, 1),
(2, 0.5, 'Pasta', 3, 1);

INSERT INTO MEASURE_UNIT (id, mu_description) VALUES
( 1, 'l.'   ),
( 2, 'ml.'   ),
( 3, 'kg.'   ),
( 4, 'g.'   ),
( 5, 'spoon'   ),
( 6, 'tea spoon'   );