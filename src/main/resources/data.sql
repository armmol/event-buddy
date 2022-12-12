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