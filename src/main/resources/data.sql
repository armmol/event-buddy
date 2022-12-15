--Insert into USER_TABLE (PASSWORD, ROLE, USERNAME) Values ('a', 'VISITOR', 'a');
--Insert into USER_TABLE (PASSWORD, ROLE, USERNAME) Values ('b', 'ORGANIZER', 'b');
--Insert into USER_TABLE (PASSWORD, ROLE, USERNAME) Values ('c', 'ORGANIZER', 'c');
--Insert into USER_TABLE (PASSWORD, ROLE, USERNAME) Values ('d', 'ORGANIZER', 'd');
--Insert into USER_TABLE (PASSWORD, ROLE, USERNAME) Values ('e', 'ORGANIZER', 'e');
--Insert into USER_TABLE (PASSWORD, ROLE, USERNAME) Values ('f', 'VISITOR', 'f');
--Insert into USER_TABLE (PASSWORD, ROLE, USERNAME) Values ('g', 'VISITOR', 'g');
--Insert into USER_TABLE (PASSWORD, ROLE, USERNAME) Values ('h', 'VISITOR', 'h');
--Insert into USER_TABLE (PASSWORD, ROLE, USERNAME) Values ('testingpassword', 'VISITOR', 'HannaRa');
--Insert into USER_TABLE (PASSWORD, ROLE, USERNAME) Values ('Nothing', 'ORGANIZER', 'nonono');

Insert into USER_TABLE (PHONE_NUMBER, PASSWORD, ROLE, USERNAME, DATE_OF_BIRTH, GENDER, DESCRIPTION, EMAIL, LANGUAGES, NAME, SURNAME) values ('', 'a', 'VISITOR', 'a', '1974-12-06', 'MAN', 'Im very creative, communicative, and flexible', 'beastop0@tripadvisor.com', 'EN','Steve', 'Eastop');
Insert into USER_TABLE (PHONE_NUMBER, PASSWORD, ROLE, USERNAME, DATE_OF_BIRTH, GENDER, DESCRIPTION, EMAIL, LANGUAGES, NAME, SURNAME) values ('', 'f', 'VISITOR', 'f', '1999-04-19', 'MAN', 'My hobbies are reading books and working out', 'mflicker1@boston.com', 'EN', 'Andrew', 'Flicker');
Insert into USER_TABLE (PHONE_NUMBER, PASSWORD, ROLE, USERNAME, DATE_OF_BIRTH, GENDER, DESCRIPTION, EMAIL, LANGUAGES, NAME, SURNAME) values ('', 'g', 'VISITOR', 'g', '1998-06-25', 'WOMAN', 'My favourite hobby is travelling because I love discovering new cities and places around the world. ', 'uvenditti2@linkedin.com', 'LV', 'Anna', 'Venditti');
Insert into USER_TABLE (PHONE_NUMBER, PASSWORD, ROLE, USERNAME, DATE_OF_BIRTH, GENDER, DESCRIPTION, EMAIL, LANGUAGES, NAME, SURNAME) values ('', 'h', 'VISITOR', 'h', '2010-01-28', 'OTHER', 'I like spending time in nature and capture all the wonderful moments of beauty with my camera', 'vyanov3@globo.com', 'LT', 'Eve', 'Yanov');
Insert into USER_TABLE (PHONE_NUMBER, PASSWORD, ROLE, USERNAME, DATE_OF_BIRTH, GENDER, DESCRIPTION, EMAIL, LANGUAGES, NAME, SURNAME) values ('', 'testingpassword', 'VISITOR', 'HannaRa', '2001-10-06', 'WOMAN', 'I love trying new cuisine. As soon as a new restaurant opens, I would like to find a new friend to join in on the experience.', 'roconnor4@drupal.org', 'EN', 'Penelope', 'Connor');
Insert into USER_TABLE (PHONE_NUMBER, PASSWORD, ROLE, USERNAME, DATE_OF_BIRTH, GENDER, DESCRIPTION, EMAIL, LANGUAGES, NAME, SURNAME) values ('836-710-1765', 'b', 'ORGANIZER', 'b', '2001-10-06', 'WOMAN', 'I love trying new cuisine. As soon as a new restaurant opens, I would like to find a new friend to join in on the experience.', 'roconnor4@drupal.org', 'EN', 'Penelope', 'Connor');
Insert into USER_TABLE (PHONE_NUMBER, PASSWORD, ROLE, USERNAME, DATE_OF_BIRTH, GENDER, DESCRIPTION, EMAIL, LANGUAGES, NAME, SURNAME) values ('635-636-8732', 'c', 'ORGANIZER', 'c', '2001-10-06', 'WOMAN', 'I love trying new cuisine. As soon as a new restaurant opens, I would like to find a new friend to join in on the experience.', 'roconnor4@drupal.org', 'EN', 'Penelope', 'Connor');
Insert into USER_TABLE (PHONE_NUMBER, PASSWORD, ROLE, USERNAME, DATE_OF_BIRTH, GENDER, DESCRIPTION, EMAIL, LANGUAGES, NAME, SURNAME) values ('141-431-4124', 'd', 'ORGANIZER', 'd', '2001-10-06', 'WOMAN', 'I love trying new cuisine. As soon as a new restaurant opens, I would like to find a new friend to join in on the experience.', 'roconnor4@drupal.org', 'EN', 'Penelope', 'Connor');
Insert into USER_TABLE (PHONE_NUMBER, PASSWORD, ROLE, USERNAME, DATE_OF_BIRTH, GENDER, DESCRIPTION, EMAIL, LANGUAGES, NAME, SURNAME) values ('715-810-1953', 'e', 'ORGANIZER', 'e', '2001-10-06', 'WOMAN', 'I love trying new cuisine. As soon as a new restaurant opens, I would like to find a new friend to join in on the experience.', 'roconnor4@drupal.org', 'EN', 'Penelope', 'Connor');
Insert into USER_TABLE (PHONE_NUMBER, PASSWORD, ROLE, USERNAME, DATE_OF_BIRTH, GENDER, DESCRIPTION, EMAIL, LANGUAGES, NAME, SURNAME) values ('367-805-7317', 'Nothing', 'ORGANIZER', 'nonono', '2001-10-06', 'WOMAN', 'I love trying new cuisine. As soon as a new restaurant opens, I would like to find a new friend to join in on the experience.', 'roconnor4@drupal.org', 'EN', 'Penelope', 'Connor');

Insert into ADDRESS_TABLE ( CITY, COUNTRY) Values ( 'Kaunas', 'Lithuania');
Insert into ADDRESS_TABLE ( CITY, COUNTRY) Values ( 'Vilnius', 'Lithuania');

--insert into ORGANIZERS_TABLE ( ORGANIZER_EMAIL, ORGANIZER_NAME, PHONE_NUMBER, USER_COL) values ( 'eventagency@agency.io', 'Event Agency', '836-710-1765', 2);
--insert into ORGANIZERS_TABLE ( ORGANIZER_EMAIL, ORGANIZER_NAME, PHONE_NUMBER, USER_COL) values ( 'fbotterman1@unicef.org', 'Eight Event', '635-636-8732', 3);
--insert into ORGANIZERS_TABLE ( ORGANIZER_EMAIL, ORGANIZER_NAME, PHONE_NUMBER, USER_COL) values ( 'vcastagne2@mapy.cz', 'Laboratorium', '141-431-4124', 4);
--insert into ORGANIZERS_TABLE ( ORGANIZER_EMAIL, ORGANIZER_NAME, PHONE_NUMBER, USER_COL) values ( 'gdrache3@mtv.com', 'TMF Production', '715-810-1953', 5);
--insert into ORGANIZERS_TABLE ( ORGANIZER_EMAIL, ORGANIZER_NAME, PHONE_NUMBER, USER_COL) values ( 'jledgister4@photobucket.com', 'Bravo Events', '367-805-7317', 10);

insert into EVENT_TABLE ( DESCRIPTION, END_DATE, GENRE, NAME, START_DATE, ADDRESS_COL, ORG_COL) values ( 'Christmas is approaching, and one of the signs testifying to this is the Old Town Christmas Fair with sweet-smelling mulled wine, roasted almonds, glittering glazed gingerbread and local handcraft.', '2022-11-27 22:44:26', 'MARKET', 'Old Town Christmas Fair', '2023-01-01 08:26:31', 2, 1);
insert into EVENT_TABLE ( DESCRIPTION, END_DATE, GENRE, NAME, START_DATE, ADDRESS_COL, ORG_COL) values ( 'Visit the park which has the largest exhibition of ice sculptures in the Baltics, and where musical shows, demonstrations of sculpture creation, and various activities for children will be organized..', '2022-12-30 21:42:17', 'FESTIVAL', 'International Ice Sculpture Festival', '2023-03-13 01:11:37', 2, 3);
insert into EVENT_TABLE ( DESCRIPTION, END_DATE, GENRE, NAME, START_DATE, ADDRESS_COL, ORG_COL) values ( 'Positivus is a music festival that gathers thousands of visitors every year and allows the performance of both world-famous artists and young and little-known musical talents.', '2022-05-16 12:34:50', 'FESTIVAL', 'Positivus', '2022-10-15 18:31:40', 2, 1);
insert into EVENT_TABLE ( DESCRIPTION, END_DATE, GENRE, NAME, START_DATE, ADDRESS_COL, ORG_COL) values ( 'International Biennial of Contemporary Art is one of the largest contemporary art events in Latvia and the Baltic States. It takes place every two years, and its creative management is each time entrusted to another international art curator.', '2022-01-09 12:36:24', 'EXHIBITION', 'International Biennial of Contemporary Art', '2022-01-20 18:44:49', 2, 2);
insert into EVENT_TABLE ( DESCRIPTION, END_DATE, GENRE, NAME, START_DATE, ADDRESS_COL, ORG_COL) values ( 'the 16th International Exhibition of Small Form Porcelain will be held in the museum, which in 2022, in response to the various upheavals the world has faced the past several years, is dedicated to the theme of Consolation.', '2022-01-15 13:36:09', 'EXHIBITION', '16th Exhibition of Small Form Porcelain', '2022-06-18 22:27:22', 1, 2);
insert into EVENT_TABLE ( DESCRIPTION, END_DATE, GENRE, NAME, START_DATE, ADDRESS_COL, ORG_COL) values ( 'A crazy party in a Riga bar, a gala dinner in an elegant restaurant, an unforgettable tango on the floor of the venue hall or a family celebration under the starry sky in the city.', '2022-12-31 18:02:47', 'FESTIVAL', 'New Year Eve Celebrations', '2023-01-01 19:09:38', 2, 1);
insert into EVENT_TABLE ( DESCRIPTION, END_DATE, GENRE, NAME, START_DATE, ADDRESS_COL, ORG_COL) values ( 'The Balttour international travel trade fair is the most important tourism event in the Baltics, which helps travellers to choose destinations and plan trips.', '2023-05-09 18:11:26', 'MARKET', 'Balttour 2023', '2023-02-27 10:09:56', 2, 2);
insert into EVENT_TABLE ( DESCRIPTION, END_DATE, GENRE, NAME, START_DATE, ADDRESS_COL, ORG_COL) values ( 'The Summer Sound 2023 festival will take place on August 4 and 5. Get ready and plan your visit to Latvia and the festival in advance. Summer Sound, which takes place in Liepaja.', '2022-09-25 10:40:40', 'FESTIVAL', 'Summer Sound', '2022-09-21 07:53:26', 2, 3);
insert into EVENT_TABLE ( DESCRIPTION, END_DATE, GENRE, NAME, START_DATE, ADDRESS_COL, ORG_COL) values ( 'The exposition displays everyday items – clothing and accessories, utensils and textiles, as well as religious and ritual objects from different regions of India.', '2022-06-15 10:51:18', 'EXHIBITION', 'Everyday Art of India', '2022-09-05 01:05:49', 1, 1);
insert into EVENT_TABLE ( DESCRIPTION, END_DATE, GENRE, NAME, START_DATE, ADDRESS_COL, ORG_COL) values ( 'The spectacular exhibits from the Fashion Museums collection showcase fashion as an exquisite cocktail of craftsmanship, art and business.', '2022-07-28 15:35:41', 'EXHIBITION', 'Masterpieces of Fashion', '2022-08-16 14:46:42', 2, 1);

Insert into ATTENDANCE_TABLE (EVENT_COL, VISIT_COL) values (1, 1);
Insert into ATTENDANCE_TABLE (EVENT_COL, VISIT_COL) values (2, 2);
Insert into ATTENDANCE_TABLE (EVENT_COL, VISIT_COL) values (2, 3);
Insert into ATTENDANCE_TABLE (EVENT_COL, VISIT_COL) values (2, 4);

Insert into MATCH_TABLE (ATT1_COL, ATT2_COL) values (2, 3);
Insert into MATCH_TABLE (ATT1_COL, ATT2_COL) values (2, 4);

