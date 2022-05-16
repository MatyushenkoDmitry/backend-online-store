
CREATE TABLE IF NOT EXISTS users(id serial PRIMARY KEY ,name VARCHAR(500),login VARCHAR(500), password VARCHAR(500));

CREATE TABLE IF NOT EXISTS categories(id serial PRIMARY KEY, name VARCHAR(500));

CREATE TABLE IF NOT EXISTS manufacturers(id serial PRIMARY KEY, name VARCHAR(500));

CREATE TABLE IF NOT EXISTS units(id serial PRIMARY KEY, name VARCHAR(500));



CREATE TABLE IF NOT EXISTS goods(

   id serial PRIMARY KEY,
   category_id serial NOT NULL,
   manufacturer_id serial NOT NULL,
   unit_id serial NOT NULL,
   name VARCHAR(500) NOT NULL,
   price decimal(13,2) NOT NULL,
   picture_url VARCHAR(3000)
                                );



CREATE TABLE IF NOT EXISTS shopping_carts(
                           id serial PRIMARY KEY,
                           user_id serial NOT NULL
                           );

CREATE TABLE IF NOT EXISTS shopping_cart_items(
                           id serial PRIMARY KEY,
                           cart_id serial NOT NULL,
                           goods_id serial NOT NULL,
                           quantity integer NOT NULL
                                              );



CREATE TABLE IF NOT EXISTS invoices(
                           id serial PRIMARY KEY,
                           user_id serial NOT NULL,
                           total decimal(13,2) NOT NULL,
                           issue_date timestamp NOT NULL,
                           due_date timestamp NOT NULL,
                           is_paid boolean
                                   );
