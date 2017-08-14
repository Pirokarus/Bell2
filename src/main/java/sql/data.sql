select add_user('user1','user1');
select add_user('user2','user2');

select add_group('u1_people',1);
select add_group('u1_companies',1);
select add_group('u2_people',2);

select add_contact('Petr','Petrov','89999',1);
select add_contact('Ivan','Ivanov','88888',1);
select add_contact('Pavel','Pavlov','77777',1);
select add_contact('Sergey','Sergeev','66666',1);
select add_contact('Lev','Lvov','111111',1);
select add_contact('Andrey','Andreev','22222',1);
select add_contact('Petr','Ivanov','33333',1);
select add_contact('Ivan','Petrov','44444',1);
select add_contact('Pavel','Petrov','555555',1);
select add_contact('Sergey','Petrov','89664999',1);
select add_contact('Lev','Petrov','8965865999',1);

select add_contact_to_group(1,1);
select add_contact_to_group(2,1);
select add_contact_to_group(3,1);
select add_contact_to_group(4,1);
select add_contact_to_group(5,1);
select add_contact_to_group(6,1);
select add_contact_to_group(7,1);
select add_contact_to_group(8,1);
select add_contact_to_group(9,1);
select add_contact_to_group(10,1);
select add_contact_to_group(11,1);

select add_contact('BELL',NULL,'121212',1);
select add_contact('INTEL',NULL,'787678',1);
select add_contact('AMD',NULL,'545454',1);

select add_contact_to_group(12,2);
select add_contact_to_group(13,2);
select add_contact_to_group(14,2);

select add_contact('Petr','Petrov','89999',2);
select add_contact('Ivan','Ivanov','88888',2);
select add_contact('Pavel','Pavlov','77777',2);
select add_contact('Sergey','Sergeev','66666',2);
select add_contact('Lev','Lvov','111111',2);

select add_contact_to_group(15,3);
select add_contact_to_group(16,3);
select add_contact_to_group(17,3);
select add_contact_to_group(18,3);
select add_contact_to_group(19,3);