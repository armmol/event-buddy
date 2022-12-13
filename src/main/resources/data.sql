<<<<<<< HEAD
Insert into USER_TABLE (ID, PASSWORD, ROLE, USERNAME) Values (1, 'a', 1, 'a');
Insert into USER_TABLE (ID, PASSWORD, ROLE, USERNAME) Values (2, 'b', 1, 'b');
Insert into USER_TABLE (ID, PASSWORD, ROLE, USERNAME) Values (3, 'c', 1, 'c');
Insert into USER_TABLE (ID, PASSWORD, ROLE, USERNAME) Values (4, 'd', 1, 'd');
Insert into USER_TABLE (ID, PASSWORD, ROLE, USERNAME) Values (5, 'e', 1, 'e');
Insert into USER_TABLE (ID, PASSWORD, ROLE, USERNAME) Values (6, 'f', 2, 'f');
Insert into USER_TABLE (ID, PASSWORD, ROLE, USERNAME) Values (7, 'g', 2, 'g');
Insert into USER_TABLE (ID, PASSWORD, ROLE, USERNAME) Values (8, 'h', 2, 'h');

Insert into VISITOR (VISITOR_ID, DATE_OF_BIRTH, GENDER, VISITOR_DESCRIPTION, VISITOR_EMAIL, VISITOR_NAME, VISITOR_SURNAME, USER_ID) values (1, '1999-12-06', 0, 'Laceration without foreign body of nose, sequela', 'beastop0@tripadvisor.com', 'Estève', 'Eastop', 1);
Insert into VISITOR (VISITOR_ID, DATE_OF_BIRTH, GENDER, VISITOR_DESCRIPTION, VISITOR_EMAIL, VISITOR_NAME, VISITOR_SURNAME, USER_ID) values (2, '1999-04-19', 1, 'Drowning and submersion due to being washed overboard from (nonpowered) inflatable craft, initial encounter', 'mflicker1@boston.com', 'Adélaïde', 'Flicker', 2);
Insert into VISITOR (VISITOR_ID, DATE_OF_BIRTH, GENDER, VISITOR_DESCRIPTION, VISITOR_EMAIL, VISITOR_NAME, VISITOR_SURNAME, USER_ID) values (3, '1998-06-25', 2, 'Fracture of neck, unspecified', 'uvenditti2@linkedin.com', 'Frédérique', 'Venditti', 3);
Insert into VISITOR (VISITOR_ID, DATE_OF_BIRTH, GENDER, VISITOR_DESCRIPTION, VISITOR_EMAIL, VISITOR_NAME, VISITOR_SURNAME, USER_ID) values (4, '2010-01-28', 1, 'Burn of first degree of right toe(s) (nail), initial encounter', 'vyanov3@globo.com', 'Estée', 'Yanov', 4);
Insert into VISITOR (VISITOR_ID, DATE_OF_BIRTH, GENDER, VISITOR_DESCRIPTION, VISITOR_EMAIL, VISITOR_NAME, VISITOR_SURNAME, USER_ID) values (5, '2001-10-06', 0, 'Blister (nonthermal), unspecified lesser toe(s), initial encounter', 'roconnor4@drupal.org', 'Pénélope', 'O''Connor', 5);

Insert into ADDRESS (ADDRESS_ID, CITY, COUNTRY) Values (1, 'Kaunas', 'Lithuania');
Insert into ADDRESS (ADDRESS_ID, CITY, COUNTRY) Values (2, 'Vilnius', 'Lithuania');

insert into ORGANIZER (ORGANIZER_ID, ORGANIZER_EMAIL, ORGANIZER_NAME, PHONE_NUMBER, USER_ID) values (1, 'egrowden0@soup.io', 'Linkbuzz', '836-710-1765', 6);
insert into ORGANIZER (ORGANIZER_ID, ORGANIZER_EMAIL, ORGANIZER_NAME, PHONE_NUMBER, USER_ID) values (2, 'fbotterman1@unicef.org', 'Quatz', '635-636-8732', 6);
insert into ORGANIZER (ORGANIZER_ID, ORGANIZER_EMAIL, ORGANIZER_NAME, PHONE_NUMBER, USER_ID) values (3, 'vcastagne2@mapy.cz', 'Edgeify', '141-431-4124', 7);
insert into ORGANIZER (ORGANIZER_ID, ORGANIZER_EMAIL, ORGANIZER_NAME, PHONE_NUMBER, USER_ID) values (4, 'gdrache3@mtv.com', 'Youspan', '715-810-1953', 8);
insert into ORGANIZER (ORGANIZER_ID, ORGANIZER_EMAIL, ORGANIZER_NAME, PHONE_NUMBER, USER_ID) values (5, 'jledgister4@photobucket.com', 'Mudo', '367-805-7317', 7);

insert into EVENT (EVENT_ID, DESCRIPTION, END_DATE, GENRE, NAME, START_DATE, ADDRESS_ADDRESS_ID, ORGANIZER_ORGANIZER_ID) values (1, 'nulla tellus in sagittis dui vel nisl duis ac nibh fusce lacus purus aliquet at feugiat non pretium quis lectus suspendisse potenti in eleifend quam', '2022-11-16 22:44:26', 0, 'Cupflower', '2022-07-24 08:26:31', 2, 3);
insert into EVENT (EVENT_ID, DESCRIPTION, END_DATE, GENRE, NAME, START_DATE, ADDRESS_ADDRESS_ID, ORGANIZER_ORGANIZER_ID) values (2, 'nulla ultrices aliquet maecenas leo odio condimentum id luctus nec molestie sed justo pellentesque viverra pede ac', '2022-05-30 21:42:17', 0, 'Nylon Hedgehog Cactus', '2022-08-13 01:11:37', 2, 5);
insert into EVENT (EVENT_ID, DESCRIPTION, END_DATE, GENRE, NAME, START_DATE, ADDRESS_ADDRESS_ID, ORGANIZER_ORGANIZER_ID) values (3, 'egestas metus aenean fermentum donec ut mauris eget massa tempor convallis nulla neque libero convallis eget eleifend luctus ultricies eu nibh quisque id justo', '2022-05-16 12:34:50', 0, 'Sedge', '2022-10-15 18:31:40', 2, 1);
insert into EVENT (EVENT_ID, DESCRIPTION, END_DATE, GENRE, NAME, START_DATE, ADDRESS_ADDRESS_ID, ORGANIZER_ORGANIZER_ID) values (4, 'a suscipit nulla elit ac nulla sed vel enim sit amet nunc viverra dapibus nulla suscipit ligula in lacus curabitur at ipsum ac tellus semper interdum mauris ullamcorper purus', '2022-01-09 12:36:24', 0, 'Mottled Spurge', '2022-01-20 18:44:49', 2, 4);
insert into EVENT (EVENT_ID, DESCRIPTION, END_DATE, GENRE, NAME, START_DATE, ADDRESS_ADDRESS_ID, ORGANIZER_ORGANIZER_ID) values (5, 'vulputate nonummy maecenas tincidunt lacus at velit vivamus vel nulla eget eros elementum pellentesque quisque porta volutpat erat quisque erat eros', '2022-01-15 13:36:09', 0, 'Partridgeberry', '2022-06-18 22:27:22', 1, 4);
insert into EVENT (EVENT_ID, DESCRIPTION, END_DATE, GENRE, NAME, START_DATE, ADDRESS_ADDRESS_ID, ORGANIZER_ORGANIZER_ID) values (6, 'sem fusce consequat nulla nisl nunc nisl duis bibendum felis sed', '2022-09-19 18:02:47', 0, 'Mazus', '2022-01-17 19:09:38', 2, 5);
insert into EVENT (EVENT_ID, DESCRIPTION, END_DATE, GENRE, NAME, START_DATE, ADDRESS_ADDRESS_ID, ORGANIZER_ORGANIZER_ID) values (7, 'vel sem sed sagittis nam congue risus semper porta volutpat quam pede lobortis ligula sit amet eleifend pede libero quis', '2022-05-09 18:11:26', 0, 'Blue Orchid', '2022-02-27 10:09:56', 2, 2);
insert into EVENT (EVENT_ID, DESCRIPTION, END_DATE, GENRE, NAME, START_DATE, ADDRESS_ADDRESS_ID, ORGANIZER_ORGANIZER_ID) values (8, 'aliquam erat volutpat in congue etiam justo etiam pretium iaculis justo in hac habitasse platea dictumst etiam faucibus cursus urna ut tellus', '2022-09-25 10:40:40', 0, 'Brandegee''s Onion', '2022-09-21 07:53:26', 2, 3);
insert into EVENT (EVENT_ID, DESCRIPTION, END_DATE, GENRE, NAME, START_DATE, ADDRESS_ADDRESS_ID, ORGANIZER_ORGANIZER_ID) values (9, 'libero non mattis pulvinar nulla pede ullamcorper augue a suscipit nulla elit ac nulla sed vel enim sit amet', '2022-06-15 10:51:18', 0, 'Oval-leaf Clustervine', '2022-09-05 01:05:49', 1, 1);
insert into EVENT (EVENT_ID, DESCRIPTION, END_DATE, GENRE, NAME, START_DATE, ADDRESS_ADDRESS_ID, ORGANIZER_ORGANIZER_ID) values (10, 'ornare imperdiet sapien urna pretium nisl ut volutpat sapien arcu sed augue aliquam erat volutpat in congue etiam justo etiam pretium', '2022-07-28 15:35:41', 0, 'Idaho Esslingeriana Lichen', '2022-08-16 14:46:42', 2, 1);
=======
INSERT INTO user_table (id, username, password, role) VALUES (1, 'visitor1', '1', 'VISITOR')
INSERT INTO user_table (id, username, password, role) VALUES (2, 'visitor3', '1', 'VISITOR')
INSERT INTO user_table (id, username, password, role) VALUES (3, 'visitor2', '1', 'VISITOR')


INSERT INTO visitors_table (visitor_id, visitor_name, visitor_surname, visitor_email, gender, date_of_birth, visitor_description, visitor_language, user_col) VALUES (1, 'Visitor', 'One', 'visitor1@email.com', 'MAN', '1990-01-01', 'aaaa', 'LV', 1)
INSERT INTO visitors_table (visitor_id, visitor_name, visitor_surname, visitor_email, gender, date_of_birth, visitor_description, visitor_language, user_col) VALUES (2, 'Visitor', 'Two', 'visitor2@email.com', 'WOMAN', '2000-01-01', 'aaaa', 'RU', 2)
INSERT INTO visitors_table (visitor_id, visitor_name, visitor_surname, visitor_email, gender, date_of_birth, visitor_description, visitor_language, user_col) VALUES (3, 'Visitor', 'Three', 'visitor3@email.com', 'OTHER', '1995-01-01', 'aaaa', 'EN', 3)

INSERT INTO user_table (id, username, password, role) VALUES (4, 'organizer1', '1', 'ORGANIZER')
INSERT INTO user_table (id, username, password, role) VALUES (5, 'organizer2', '1', 'ORGANIZER')
INSERT INTO user_table (id, username, password, role) VALUES (6, 'organizer3', '1', 'ORGANIZER')

INSERT INTO organizers_table (organizer_id, organizer_name, organizer_email, phone_number, user_col) VALUES (1, 'TestOrganizer1', 'organizer1@email.com', '22121212', 4)
INSERT INTO organizers_table (organizer_id, organizer_name, organizer_email, phone_number, user_col) VALUES (2, 'TestOrganizer2', 'organizer2@email.com', '22121213', 5)
INSERT INTO organizers_table (organizer_id, organizer_name, organizer_email, phone_number, user_col) VALUES (3, 'TestOrganizer3', 'organizer3@email.com', '22121214', 6)


INSERT INTO address_table (address_id, country, city) VALUES (1, 'Latvia', 'Riga')
INSERT INTO address_table (address_id, country, city) VALUES (2, 'Lithuania', 'Kaunas')
INSERT INTO address_table (address_id, country, city) VALUES (3, 'Germany', 'Bremen')


INSERT INTO event_table (event_id, name, start_date, end_date, description, genre, address_col, org_col) VALUES (1, 'event1', '2022-12-23', '2022-12-25', 'aa', 'FESTIVAL', 1, 1)
INSERT INTO event_table (event_id, name, start_date, end_date, description, genre, address_col, org_col) VALUES (2, 'event2', '2023-01-01', '2023-01-10', 'aa', 'FESTIVAL', 2, 2)
INSERT INTO event_table (event_id, name, start_date, end_date, description, genre, address_col, org_col) VALUES (3, 'event3', '2023-03-01', '2023-05-31', 'aa', 'EXHIBITION', 3, 3)


INSERT INTO attendance_table (attendance_id, event_col, visit_col) VALUES (1, 1, 1)
INSERT INTO attendance_table (attendance_id, event_col, visit_col) VALUES (2, 2, 2)
>>>>>>> main
