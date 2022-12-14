Insert into USER_TABLE (ID, PASSWORD, ROLE, USERNAME) Values (1, 'a', 'VISITOR', 'a');
Insert into USER_TABLE (ID, PASSWORD, ROLE, USERNAME) Values (2, 'b', 'ORGANIZER', 'b');
Insert into USER_TABLE (ID, PASSWORD, ROLE, USERNAME) Values (3, 'c', 'ORGANIZER', 'c');
Insert into USER_TABLE (ID, PASSWORD, ROLE, USERNAME) Values (4, 'd', 'ORGANIZER', 'd');
Insert into USER_TABLE (ID, PASSWORD, ROLE, USERNAME) Values (5, 'e', 'ORGANIZER', 'e');
Insert into USER_TABLE (ID, PASSWORD, ROLE, USERNAME) Values (6, 'f', 'VISITOR', 'f');
Insert into USER_TABLE (ID, PASSWORD, ROLE, USERNAME) Values (7, 'g', 'VISITOR', 'g');
Insert into USER_TABLE (ID, PASSWORD, ROLE, USERNAME) Values (8, 'h', 'VISITOR', 'h');

Insert into VISITORS_TABLE (DATE_OF_BIRTH, GENDER, VISITOR_DESCRIPTION, VISITOR_EMAIL, VISITOR_LANGUAGE, VISITOR_NAME, VISITOR_SURNAME, USER_COL) values ('1999-12-06', 'MAN', 'Laceration without foreign body of nose, sequela', 'beastop0@tripadvisor.com', 'EN','Estève', 'Eastop', 1);
Insert into VISITORS_TABLE (DATE_OF_BIRTH, GENDER, VISITOR_DESCRIPTION, VISITOR_EMAIL, VISITOR_LANGUAGE, VISITOR_NAME, VISITOR_SURNAME, USER_COL) values ('1999-04-19', 'MAN', 'Drowning and submersion due to being washed overboard from (nonpowered) inflatable craft, initial encounter', 'mflicker1@boston.com', 'EN', 'Adélaïde', 'Flicker', 2);
Insert into VISITORS_TABLE (DATE_OF_BIRTH, GENDER, VISITOR_DESCRIPTION, VISITOR_EMAIL, VISITOR_LANGUAGE, VISITOR_NAME, VISITOR_SURNAME, USER_COL) values ('1998-06-25', 'MAN', 'Fracture of neck, unspecified', 'uvenditti2@linkedin.com', 'LV', 'Frédérique', 'Venditti', 3);
Insert into VISITORS_TABLE (DATE_OF_BIRTH, GENDER, VISITOR_DESCRIPTION, VISITOR_EMAIL, VISITOR_LANGUAGE, VISITOR_NAME, VISITOR_SURNAME, USER_COL) values ('2010-01-28', 'MAN', 'Burn of first degree of right toe(s) (nail), initial encounter', 'vyanov3@globo.com', 'LV', 'Estée', 'Yanov', 4);
Insert into VISITORS_TABLE (DATE_OF_BIRTH, GENDER, VISITOR_DESCRIPTION, VISITOR_EMAIL, VISITOR_LANGUAGE, VISITOR_NAME, VISITOR_SURNAME, USER_COL) values ('2001-10-06', 'MAN', 'Blister (nonthermal), unspecified lesser toe(s), initial encounter', 'roconnor4@drupal.org', 'EN', 'Pénélope', 'O''Connor', 5);

Insert into ADDRESS_TABLE (ADDRESS_ID, CITY, COUNTRY) Values (1, 'Kaunas', 'Lithuania');
Insert into ADDRESS_TABLE (ADDRESS_ID, CITY, COUNTRY) Values (2, 'Vilnius', 'Lithuania');

insert into ORGANIZERS_TABLE (ORGANIZER_ID, ORGANIZER_EMAIL, ORGANIZER_NAME, PHONE_NUMBER, USER_COL) values (1, 'egrowden0@soup.io', 'Linkbuzz', '836-710-1765', 6);
insert into ORGANIZERS_TABLE (ORGANIZER_ID, ORGANIZER_EMAIL, ORGANIZER_NAME, PHONE_NUMBER, USER_COL) values (2, 'fbotterman1@unicef.org', 'Quatz', '635-636-8732', 6);
insert into ORGANIZERS_TABLE (ORGANIZER_ID, ORGANIZER_EMAIL, ORGANIZER_NAME, PHONE_NUMBER, USER_COL) values (3, 'vcastagne2@mapy.cz', 'Edgeify', '141-431-4124', 7);
insert into ORGANIZERS_TABLE (ORGANIZER_ID, ORGANIZER_EMAIL, ORGANIZER_NAME, PHONE_NUMBER, USER_COL) values (4, 'gdrache3@mtv.com', 'Youspan', '715-810-1953', 8);
insert into ORGANIZERS_TABLE (ORGANIZER_ID, ORGANIZER_EMAIL, ORGANIZER_NAME, PHONE_NUMBER, USER_COL) values (5, 'jledgister4@photobucket.com', 'Mudo', '367-805-7317', 7);

insert into EVENT_TABLE (EVENT_ID, DESCRIPTION, END_DATE, GENRE, NAME, START_DATE, ADDRESS_COL, ORG_COL) values (1, 'nulla tellus in sagittis dui vel nisl duis ac nibh fusce lacus purus aliquet at feugiat non pretium quis lectus suspendisse potenti in eleifend quam', '2022-11-16 22:44:26', 'FESTIVAL', 'Cupflower', '2022-07-24 08:26:31', 2, 3);
insert into EVENT_TABLE (EVENT_ID, DESCRIPTION, END_DATE, GENRE, NAME, START_DATE, ADDRESS_COL, ORG_COL) values (2, 'nulla ultrices aliquet maecenas leo odio condimentum id luctus nec molestie sed justo pellentesque viverra pede ac', '2022-05-30 21:42:17', 'FESTIVAL', 'Nylon Hedgehog Cactus', '2022-08-13 01:11:37', 2, 5);
insert into EVENT_TABLE (EVENT_ID, DESCRIPTION, END_DATE, GENRE, NAME, START_DATE, ADDRESS_COL, ORG_COL) values (3, 'egestas metus aenean fermentum donec ut mauris eget massa tempor convallis nulla neque libero convallis eget eleifend luctus ultricies eu nibh quisque id justo', '2022-05-16 12:34:50', 'FESTIVAL', 'Sedge', '2022-10-15 18:31:40', 2, 1);
insert into EVENT_TABLE (EVENT_ID, DESCRIPTION, END_DATE, GENRE, NAME, START_DATE, ADDRESS_COL, ORG_COL) values (4, 'a suscipit nulla elit ac nulla sed vel enim sit amet nunc viverra dapibus nulla suscipit ligula in lacus curabitur at ipsum ac tellus semper interdum mauris ullamcorper purus', '2022-01-09 12:36:24', 'FESTIVAL', 'Mottled Spurge', '2022-01-20 18:44:49', 2, 4);
insert into EVENT_TABLE (EVENT_ID, DESCRIPTION, END_DATE, GENRE, NAME, START_DATE, ADDRESS_COL, ORG_COL) values (5, 'vulputate nonummy maecenas tincidunt lacus at velit vivamus vel nulla eget eros elementum pellentesque quisque porta volutpat erat quisque erat eros', '2022-01-15 13:36:09', 'FESTIVAL', 'Partridgeberry', '2022-06-18 22:27:22', 1, 4);
insert into EVENT_TABLE (EVENT_ID, DESCRIPTION, END_DATE, GENRE, NAME, START_DATE, ADDRESS_COL, ORG_COL) values (6, 'sem fusce consequat nulla nisl nunc nisl duis bibendum felis sed', '2022-09-19 18:02:47', 'FESTIVAL', 'Mazus', '2022-01-17 19:09:38', 2, 5);
insert into EVENT_TABLE (EVENT_ID, DESCRIPTION, END_DATE, GENRE, NAME, START_DATE, ADDRESS_COL, ORG_COL) values (7, 'vel sem sed sagittis nam congue risus semper porta volutpat quam pede lobortis ligula sit amet eleifend pede libero quis', '2022-05-09 18:11:26', 'FESTIVAL', 'Blue Orchid', '2022-02-27 10:09:56', 2, 2);
insert into EVENT_TABLE (EVENT_ID, DESCRIPTION, END_DATE, GENRE, NAME, START_DATE, ADDRESS_COL, ORG_COL) values (8, 'aliquam erat volutpat in congue etiam justo etiam pretium iaculis justo in hac habitasse platea dictumst etiam faucibus cursus urna ut tellus', '2022-09-25 10:40:40', 'FESTIVAL', 'Brandegee''s Onion', '2022-09-21 07:53:26', 2, 3);
insert into EVENT_TABLE (EVENT_ID, DESCRIPTION, END_DATE, GENRE, NAME, START_DATE, ADDRESS_COL, ORG_COL) values (9, 'libero non mattis pulvinar nulla pede ullamcorper augue a suscipit nulla elit ac nulla sed vel enim sit amet', '2022-06-15 10:51:18', 'FESTIVAL', 'Oval-leaf Clustervine', '2022-09-05 01:05:49', 1, 1);
insert into EVENT_TABLE (EVENT_ID, DESCRIPTION, END_DATE, GENRE, NAME, START_DATE, ADDRESS_COL, ORG_COL) values (10, 'ornare imperdiet sapien urna pretium nisl ut volutpat sapien arcu sed augue aliquam erat volutpat in congue etiam justo etiam pretium', '2022-07-28 15:35:41', 'FESTIVAL', 'Idaho Esslingeriana Lichen', '2022-08-16 14:46:42', 2, 1);