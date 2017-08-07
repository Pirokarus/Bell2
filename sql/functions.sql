CREATE OR REPLACE FUNCTION add_user(
_login VARCHAR(255),
_pussword VARCHAR(255)
)
RETURNS void AS
$BODY$
BEGIN
INSERT INTO users(
login,
pussword
) VALUES (
_login,
_pussword
);
END
$BODY$
LANGUAGE 'plpgsql';


CREATE OR REPLACE FUNCTION add_group(
_name VARCHAR(255),
_userId INTEGER
)
RETURNS void AS
$BODY$
BEGIN
INSERT INTO groups(
name,
user_id
) VALUES (
_name,
_userId
);
END
$BODY$
LANGUAGE 'plpgsql';


CREATE OR REPLACE FUNCTION add_contact(
_firstName VARCHAR(255),
_lustName VARCHAR(255),
_number VARCHAR(255),
_groupId INTEGER,
_userId INTEGER
)
RETURNS void AS
$BODY$
BEGIN
INSERT INTO contacts(
firstName,
lastName,
number,
groupId,
user_id
) VALUES (
_firstName,
_lustName,
_number,
_groupId,
_userId
);
END
$BODY$
LANGUAGE 'plpgsql'

CREATE OR REPLACE FUNCTION add_contact_without_group(
_firstName VARCHAR(255),
_lustName VARCHAR(255),
_number VARCHAR(255),
_userId INTEGER
)
RETURNS void AS
$BODY$
BEGIN
INSERT INTO contacts(
firstName,
lastName,
number,
user_id
) VALUES (
_firstName,
_lustName,
_number,
_userId
);
END
$BODY$
LANGUAGE 'plpgsql'


CREATE OR REPLACE FUNCTION delete_user(
_id INTEGER
)
RETURNS void AS
$BODY$
BEGIN
DELETE FROM users
WHERE id = _id;
END
$BODY$
LANGUAGE 'plpgsql'


CREATE OR REPLACE FUNCTION delete_group(
_id INTEGER
)
RETURNS void AS
$BODY$
BEGIN
DELETE FROM groups
WHERE id = _id;
END
$BODY$
LANGUAGE 'plpgsql'


CREATE OR REPLACE FUNCTION delete_contact(
_id INTEGER
)
RETURNS void AS
$BODY$
BEGIN
DELETE FROM contacts
WHERE id = _id;
END
$BODY$
LANGUAGE 'plpgsql'


CREATE OR REPLACE FUNCTION update_user(
_id INTEGER,
_login VARCHAR(255),
_pussword VARCHAR(255)
)
RETURNS void AS
$BODY$
BEGIN
UPDATE users
SET
login = _login,
pussword = _pussword
WHERE id = _id;
END
$BODY$
LANGUAGE 'plpgsql'


CREATE OR REPLACE FUNCTION update_group(
_id INTEGER,
_name VARCHAR(255)
)
RETURNS void AS
$BODY$
BEGIN
UPDATE users
SET
name = _name
WHERE id = _id;
END
$BODY$
LANGUAGE 'plpgsql'


CREATE OR REPLACE FUNCTION update_contact(
_id INTEGER,
_firstName VARCHAR(255),
_lustName VARCHAR(255),
_number VARCHAR(255),
_groupId INTEGER
)
RETURNS void AS
$BODY$
BEGIN
UPDATE users
SET
firstName = _firstName,
lastName = _lustName,
number = _number,
groupId = _groupId
WHERE id = _id;
END
$BODY$
LANGUAGE 'plpgsql'


CREATE OR REPLACE FUNCTION add_group_to_contact(
_id INTEGER,
_groupId INTEGER
)
RETURNS void AS
$BODY$
BEGIN
UPDATE users
SET
groupId = _groupId
WHERE id = _id;
END
$BODY$
LANGUAGE 'plpgsql'


CREATE OR REPLACE FUNCTION user_count()
RETURNS BIGINT
    AS 'select count(*) from users;'
    LANGUAGE SQL
    IMMUTABLE
    RETURNS NULL ON NULL INPUT;


CREATE OR REPLACE FUNCTION contacts_count()
RETURNS SETOF BIGINT
    AS 'select count(*) from contacts group by user_id;'
    LANGUAGE SQL
    IMMUTABLE
    RETURNS NULL ON NULL INPUT;


CREATE OR REPLACE FUNCTION avg_count_contacts()
RETURNS numeric 
    AS 'select avg(foo) from(select count(*) as foo from contacts group by user_id) as t;'
    LANGUAGE SQL
    IMMUTABLE
    RETURNS NULL ON NULL INPUT;


CREATE OR REPLACE FUNCTION avg_count_groups()
RETURNS numeric 
    AS 'select avg(foo) from(select count(*) as foo from contacts group by groupId) as t;'
    LANGUAGE SQL
    IMMUTABLE
    RETURNS NULL ON NULL INPUT;


CREATE OR REPLACE FUNCTION dream_users()
RETURNS SETOF VARCHAR
    AS 'select u.login from users u join(select user_id from contacts group by user_id having count(*)<10) c on u.id=c.user_id;'
    LANGUAGE SQL
    IMMUTABLE
    RETURNS NULL ON NULL INPUT;


