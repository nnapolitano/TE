-- *************************************************************************************************
-- This script creates all of the database objects (tables, sequences, etc) for the database
-- *************************************************************************************************

BEGIN;


DROP TABLE IF EXISTS app_user;

CREATE TABLE app_user (
  id SERIAL PRIMARY KEY,
  user_name varchar(32) NOT NULL UNIQUE,
  password varchar(32) NOT NULL,
  first_name varchar(32) NOT NULL,
  last_name varchar(32) NOT NULL,
  role varchar(32) NOT NULL,
  salt varchar(255) NOT NULL
);
DROP TABLE IF EXISTS recipe;
DROP SEQUENCE IF EXISTS seq_recipe_id;

CREATE SEQUENCE seq_recipe_id;

CREATE TABLE recipe
(
        recipe_id INTEGER PRIMARY KEY DEFAULT NEXTVAL('seq_recipe_id'),
        meal_title VARCHAR(200) NOT NULL,
        ingredients VARCHAR(1000) NOT NULL,
	prepTime INTEGER NOT NULL,
        cookTime INTEGER NOT NULL,
	instructions VARCHAR(1000) NOT NULL
);

CREATE TABLE mealtype_recipe_id (
	meal_type integer NOT NULL,
	recipe_id integer NOT NULL,
	CONSTRAINT pk_mealtype_recipe PRIMARY KEY (meal_type, recipe_id)
);

ALTER TABLE mealtype_recipe_id ADD CONSTRAINT fk_recipe FOREIGN KEY (recipe_id) REFERENCES recipe(recipe_id);


INSERT INTO recipe (meal_title, ingredients, prepTime, cookTime, instructions) VALUES ('edamame', ' 300 grams edamame, 2 cups water, 2 tablespoons salt', 4, 6, 'Bring a pot of salted water big enough to easily hold your edamame to a boil,
Cut the stem end of the edamame pods off with clean scissors, Scrub the edamame in salt and then rinse thoroughly to remove the fine hairs on the pods, Boil the soybeans for 6-9 minutes, depending on how big they are. You can start testing the edamame at around 6 minutes for doneness. They should easily pop out of the pods, without having the pods disintegrate, Drain the edamame and serve with an extra sprinkle of sea salt if needed.');

INSERT INTO mealtype_recipe_id (meal_type, recipe_id) VALUES (0, 1);
INSERT INTO mealtype_recipe_id (meal_type, recipe_id) VALUES (2, 1);


INSERT INTO recipe (meal_title, ingredients, prepTime, cookTime, instructions) VALUES ('Buddha Bowl','1 ¼ cups short-grain brown rice or long-grain brown rice rinsed,
1 ½ cups frozen shelled edamame preferably organic,
1 ½ cups trimmed and roughly chopped snap peas or snow peas or thinly sliced broccoli florets,
1 to 2 tablespoons reduced-sodium tamari or soy sauce to taste,
4 cups chopped red cabbage or spinach or romaine lettuce or kale (ribs removed),
2 ripe avocados halved pitted and thinly sliced into long strips.',30, 30,'
Bring a large pot of water to boil (ideally about 4 quarts water), Once the water is boiling add the rice and continue boiling for 25 minutes, Add the edamame and cook for 3 more minutes (it’s ok if the water doesn’t reach a rapid boil again),Then add the snap peas and cook for 2 more minutes,
Drain well and return the rice and veggies to the pot, Season to taste with 1 to 2 tablespoons of tamari or soy sauce and stir to combine,
Divide the rice/veggie mixture and raw veggies into 4 bowls, Arrange cucumber slices along the edge of the bowl (see photos), Drizzle lightly with carrot ginger dressing and top with sliced green onion, Place a lime wedge or 2 in each bowl,
When you’re ready to serve divide the avocado into the bowls, Lightly drizzle sesame oil over the avocado followed by a generous sprinkle of sesame seeds and flaky sea salt, Serve promptly.');

INSERT INTO recipe (meal_title, ingredients, prepTime, cookTime, instructions) VALUES ('Keto Cheese Balls', '1⁄3 cup mayonnaise,
    ¼ cup pimientos or pickled jalapeños,
    1 tsp paprika powder or chili powder,
    1 tbsp Dijon mustard,
    1 pinch cayenne pepper,
    4 oz. cheddar cheese grated.',
15, 20,'Start by mixing all ingredients for the pimiento cheese in a large bowl, Add ground beef and the egg to the cheese mixture. Use a wooden spoon or clean hands to combine. Salt and pepper to taste, Form large meatballs and fry them in butter or oil in a skillet on medium heat until they are thoroughly cooked, Serve with a side dish of your choice of green salad and perhaps a homemade mayonnaise.' );


INSERT INTO recipe (meal_title, ingredients, prepTime, cookTime, instructions) VALUES ('Gluten Free Pancakes', '1 1/4 cups (185g) gluten free flour blend, 1 tablespoon granulated sugar, 1 teaspoon gluten-free baking powder, 1/2 teaspoon baking soda, 1/4 teaspoon salt, 1/4 teaspoon cinnamon (you can leave this out if you want), Wet ingredients:1 egg, 1 cup buttermilk (or 1 cup flaxmilk or dairy-free milk of choice + 1 teaspoon white vinegar), 1/4 cup oil of choice (I use avocado oil)',
10, 10, 'Mix dry ingredients in a large mixing bowl,
    Add the wet ingredients to your mixing bowl and stir just until combined,
    Ladle 1/4 cup of pancake batter onto your hot griddle or pan,
    Cook for 2-3 minutes or until bubbles form around the edges,
    Flip and continue to cook until cooked through,
    Serve hot,
    This recipe can be doubled, or tripled');


ALTER TABLE recipe ADD COLUMN user_id INTEGER;



ALTER TABLE recipe
ADD CONSTRAINT fk_constraint_user FOREIGN KEY (user_id) REFERENCES app_user(id);

UPDATE recipe
SET user_id = 2
WHERE recipe_id >0







DROP TABLE IF EXISTS meal_plan;
DROP SEQUENCE IF EXISTS seq_meal_plan_id;

CREATE SEQUENCE seq_meal_plan_id;

CREATE TABLE meal_plan (
meal_plan_id INTEGER PRIMARY KEY DEFAULT NEXTVAL('seq_meal_plan_id'),
user_id INTEGER NOT NULL,
mealplan_description varchar(500),
meal_date varchar(80) NOT NULL
);

INSERT INTO meal_plan (user_id, mealplan_description, meal_date) VALUES (1,'The Ultimate meal plan','2020-03-15');
INSERT INTO meal_plan (user_id, mealplan_description, meal_date) VALUES (1,'Enjoy the meal of your life for today, the best dished you like','2020-03-16');
INSERT INTO meal_plan (user_id, mealplan_description, meal_date) VALUES (1,'Hot spot of all dished today ','2020-03-17');
INSERT INTO meal_plan (user_id, mealplan_description, meal_date) VALUES (1,'kings and queens meals to enjoy ','2020-03-18');
INSERT INTO meal_plan (user_id, mealplan_description, meal_date) VALUES (1,'Enjoy your favorites meals today','2020-03-19');
INSERT INTO meal_plan (user_id, mealplan_description, meal_date) VALUES (1,'Special offer comes with the weekend','2020-03-20');
INSERT INTO meal_plan (user_id, mealplan_description, meal_date) VALUES (1,'Another special offer comes with the SuNnyDay!','2020-03-21');




DROP TABLE IF EXISTS app_user;
DROP SEQUENCE IF EXISTS seq_app_user_id;

CREATE SEQUENCE seq_app_user_id;

CREATE TABLE app_user (
id INTEGER PRIMARY KEY DEFAULT NEXTVAL('seq_app_user_id'),
user_name varchar(32),
password varchar(32),
first_name varchar(32),
last_name varchar(32),
role varchar(32),
salt varchar(255)
);


DROP TABLE IF EXISTS meal;
DROP SEQUENCE IF EXISTS seq_meal_id;

CREATE SEQUENCE seq_meal_id;

CREATE TABLE meal (
meal_id INTEGER PRIMARY KEY DEFAULT NEXTVAL('seq_meal_id'),
meal_description varchar(300),
user_id INTEGER NOT NULL
);

ALTER TABLE meal ADD COLUMN user_id INTEGER;



ALTER TABLE meal
ADD CONSTRAINT fk_constraint_user FOREIGN KEY (user_id) REFERENCES app_user(id);

UPDATE meal
SET user_id = 21
WHERE meal_id >5;



DROP TABLE IF EXISTS meal_meal_plan;

CREATE TABLE meal_meal_plan (
meal_plan_id INTEGER NOT NULL,
meal_id INTEGER NOT NULL
);

ALTER TABLE meal_meal_plan
ADD FOREIGN KEY (meal_plan_id)
REFERENCES meal_plan(meal_plan_id);
ADD FOREIGN KEY (meal_id)
REFERENCES meal(meal_id);

ALTER TABLE meal ADD CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES app_user(id);

DROP TABLE IF EXISTS recipe_meal;

CREATE TABLE recipe_meal (
recipe_id INTEGER NOT NULL,
meal_id INTEGER NOT NULL
);

ALTER TABLE recipe_meal
ADD FOREIGN KEY (recipe_id)
REFERENCES recipe(recipe_id);
ADD FOREIGN KEY (meal_id)
REFERENCES meal(meal_id);




--INSERT tests

INSERT INTO app_user (user_name, password, role, first_name, last_name) VALUES ('test','test1', 'meal planner', 'Kelly', 'Asha');
INSERT INTO app_user (user_name, password, role, first_name, last_name) VALUES ('test','test1', 'meal planner', 'Akinyi', 'Manga');
INSERT INTO app_user (user_name, password, role, first_name, last_name) VALUES ('test','test1', 'meal planner', 'Otaigo', 'Shiro');
INSERT INTO app_user (user_name, password, role, first_name, last_name) VALUES ('test','test1', 'meal planner', 'Kip', 'Asha');
INSERT INTO app_user (user_name, password, role, first_name, last_name) VALUES ('test','test1', 'meal planner', 'Ndegwa', 'Asha');




COMMIT;