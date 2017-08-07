DROP TABLE contacts;
DROP TABLE groups;
DROP TABLE users;


CREATE TABLE users
(
  id         		serial         		PRIMARY KEY,
  login    		VARCHAR(255)         	UNIQUE NOT NULL,
  pussword              VARCHAR(255)  		UNIQUE NOT NULL
);

CREATE TABLE groups
(
  id         		serial         		PRIMARY KEY,
  name    		VARCHAR(255)         	NOT NULL,
  user_id              	INTEGER	  		NOT NULL REFERENCES users(id) ON DELETE CASCADE 
);

CREATE TABLE contacts
(
  id         		serial         		PRIMARY KEY,
  firstName    		VARCHAR(255)         	NOT NULL,
  lastName    		VARCHAR(255)         	,
  number    		VARCHAR(255)         	NOT NULL,
  groupId    		INTEGER         	REFERENCES groups(id)  ON DELETE SET NULL,
  user_id              	INTEGER	  		NOT NULL REFERENCES users(id) ON DELETE CASCADE 
);