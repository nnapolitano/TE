DROP TABLE IF EXISTS mealtype_recipe_id;
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