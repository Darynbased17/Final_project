INSERT INTO airlines (name, country) VALUES ('Air Astana', 'Kazakhstan');
INSERT INTO airlines (name, country) VALUES ('SCAT Airlines', 'Kazakhstan');
INSERT INTO airlines (name, country) VALUES ('Lufthansa', 'Germany');
INSERT INTO airlines (name, country) VALUES ('Turkish Airlines', 'Turkey');
INSERT INTO airlines (name, country) VALUES ('FlyDubai', 'UAE');

INSERT INTO airports (code, name, city, country) VALUES ('ALA', 'Almaty International', 'Almaty', 'Kazakhstan');
INSERT INTO airports (code, name, city, country) VALUES ('NQZ', 'Nursultan Nazarbayev', 'Astana', 'Kazakhstan');
INSERT INTO airports (code, name, city, country) VALUES ('FRA', 'Frankfurt Airport', 'Frankfurt', 'Germany');
INSERT INTO airports (code, name, city, country) VALUES ('IST', 'Istanbul Airport', 'Istanbul', 'Turkey');
INSERT INTO airports (code, name, city, country) VALUES ('DXB', 'Dubai International', 'Dubai', 'UAE');
INSERT INTO airports (code, name, city, country) VALUES ('CIT', 'Shymkent International', 'Shymkent', 'Kazakhstan');

INSERT INTO flights (flight_number, status, departure_airport_code, arrival_airport_code, airline_id)
VALUES ('KC-881', 'SCHEDULED', 'ALA', 'NQZ', 1);
INSERT INTO flights_airports (flight_id, airports_id) VALUES (1, 1), (1, 2);

INSERT INTO flights (flight_number, status, departure_airport_code, arrival_airport_code, airline_id)
VALUES ('LH-649', 'DELAYED', 'NQZ', 'FRA', 3);
INSERT INTO flights_airports (flight_id, airports_id) VALUES (2, 2), (2, 3);

INSERT INTO flights (flight_number, status, departure_airport_code, arrival_airport_code, airline_id)
VALUES ('TK-351', 'DEPARTED', 'ALA', 'IST', 4);
INSERT INTO flights_airports (flight_id, airports_id) VALUES (3, 1), (3, 4);

INSERT INTO flights (flight_number, status, departure_airport_code, arrival_airport_code, airline_id)
VALUES ('DV-706', 'ARRIVED', 'CIT', 'ALA', 2);
INSERT INTO flights_airports (flight_id, airports_id) VALUES (4, 6), (4, 1);

INSERT INTO flights (flight_number, status, departure_airport_code, arrival_airport_code, airline_id)
VALUES ('FZ-735', 'SCHEDULED', 'DXB', 'ALA', 5);
INSERT INTO flights_airports (flight_id, airports_id) VALUES (5, 5), (5, 1);