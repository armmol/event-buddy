INSERT INTO user_table ( username, password, role) VALUES ( 'visitor1', '1', 'VISITOR')
INSERT INTO user_table ( username, password, role) VALUES ( 'visitor3', '1', 'VISITOR')
INSERT INTO user_table ( username, password, role) VALUES ( 'visitor2', '1', 'VISITOR')


INSERT INTO visitors_table ( visitor_name, visitor_surname, visitor_email, gender, date_of_birth, visitor_description, visitor_language, user_col) VALUES ( 'Visitor', 'One', 'visitor1@email.com', 'MAN', '1990-01-01', 'aaaa', 'LV', 1)
INSERT INTO visitors_table ( visitor_name, visitor_surname, visitor_email, gender, date_of_birth, visitor_description, visitor_language, user_col) VALUES ( 'Visitor', 'Two', 'visitor2@email.com', 'WOMAN', '2000-01-01', 'aaaa', 'RU', 2)
INSERT INTO visitors_table ( visitor_name, visitor_surname, visitor_email, gender, date_of_birth, visitor_description, visitor_language, user_col) VALUES ( 'Visitor', 'Three', 'visitor3@email.com', 'OTHER', '1995-01-01', 'aaaa', 'EN', 3)

INSERT INTO user_table ( username, password, role) VALUES ( 'organizer1', '1', 'ORGANIZER')
INSERT INTO user_table ( username, password, role) VALUES ( 'organizer2', '1', 'ORGANIZER')
INSERT INTO user_table ( username, password, role) VALUES ( 'organizer3', '1', 'ORGANIZER')

INSERT INTO organizers_table ( organizer_name, organizer_email, phone_number, user_col) VALUES ( 'TestOrganizer1', 'organizer1@email.com', '22121212', 4)
INSERT INTO organizers_table ( organizer_name, organizer_email, phone_number, user_col) VALUES ( 'TestOrganizer2', 'organizer2@email.com', '22121213', 5)
INSERT INTO organizers_table ( organizer_name, organizer_email, phone_number, user_col) VALUES ( 'TestOrganizer3', 'organizer3@email.com', '22121214', 6)


INSERT INTO address_table ( country, city) VALUES ( 'Latvia', 'Riga')
INSERT INTO address_table ( country, city) VALUES ( 'Lithuania', 'Kaunas')
INSERT INTO address_table ( country, city) VALUES ( 'Germany', 'Bremen')


INSERT INTO event_table ( name, start_date, end_date, description, genre, address_col, org_col) VALUES ( 'event1', '2022-12-23', '2022-12-25', 'aa', 'FESTIVAL', 1, 1)
INSERT INTO event_table ( name, start_date, end_date, description, genre, address_col, org_col) VALUES ( 'event2', '2023-01-01', '2023-01-10', 'aa', 'FESTIVAL', 2, 2)
INSERT INTO event_table ( name, start_date, end_date, description, genre, address_col, org_col) VALUES ( 'event3', '2023-03-01', '2023-05-31', 'aa', 'EXHIBITION', 3, 3)


INSERT INTO attendance_table ( event_col, visit_col) VALUES ( 1, 1)
INSERT INTO attendance_table ( event_col, visit_col) VALUES ( 1, 2)
INSERT INTO attendance_table ( event_col, visit_col) VALUES ( 1, 3)