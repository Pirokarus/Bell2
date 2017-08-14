-- Создание таблицы пользователей
CREATE TABLE public.users
(
  id SERIAL PRIMARY KEY NOT NULL,
  login VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL
);
CREATE UNIQUE INDEX users_login_uindex ON public.users (login);
CREATE UNIQUE INDEX users_password_uindex ON public.users (password);

-- Создание таблицы групп
CREATE TABLE public.groups
(
  id SERIAL PRIMARY KEY NOT NULL,
  name VARCHAR(255) NOT NULL,
  user_id INTEGER NOT NULL,
  CONSTRAINT groups_users_id_fk FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Создание таблицы контактов
CREATE TABLE public.contacts
(
  id SERIAL PRIMARY KEY NOT NULL,
  firstName VARCHAR(255) NOT NULL,
  lastName VARCHAR(255) ,
  number VARCHAR(255) NOT NULL,
  user_id INTEGER NOT NULL,
  CONSTRAINT contacts_users_id_fk FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Создание таблицы связей пользователей и групп
CREATE TABLE public.references_table
(
  contact_id INTEGER NOT NULL,
  group_id INTEGER NOT NULL,
  id SERIAL PRIMARY KEY NOT NULL,
  CONSTRAINT references_table_contact_id_fk FOREIGN KEY (contact_id) REFERENCES contacts (id) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT references_table_groups_id_fk FOREIGN KEY (group_id) REFERENCES groups (id) ON DELETE CASCADE ON UPDATE CASCADE
);