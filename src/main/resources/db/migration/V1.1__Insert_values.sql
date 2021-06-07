insert into classifications (deleted, appointment)
values (false, 'Passenger cars');
insert into classifications (deleted, appointment)
values (false, 'Trucks');

insert into ads (deleted, car_name, price, year, description, classification_id)
values (false, 'Volkswagen Polo', 12000, '2017', 'Good car.', 1);
insert into ads (deleted, car_name, price, year, description, classification_id)
values (false, 'Skoda Rapid', 15000, '2015', 'In operation for six years.', 1);
insert into ads (deleted, car_name, price, year, description, classification_id)
values (true, 'Ford Focus', 8000, '2009', 'The car is operational.', 1);
insert into ads (deleted, car_name, price, year, description, classification_id)
values (false, 'Volkswagen Passat B6', 7000, '2009', 'TO valid until 2022.', 1);
insert into ads (deleted, car_name, price, year, description, classification_id)
values (false, 'Mitsubishi Carisma', 1900, '2001', 'For work without problems.', 1);

insert into ads (deleted, car_name, price, year, description, classification_id)
values (false, 'Zil 130', 20000, '1985', 'Good truck car', 2);
insert into ads (deleted, car_name, price, year, description, classification_id)
values (false, 'Maz 555103', 35000, '2006', 'Owned by one user', 2);
insert into ads (deleted, car_name, price, year, description, classification_id)
values (true, 'Mercedes Atego 702', 25000, '1996', 'All spare parts are original', 2);
insert into ads (deleted, car_name, price, year, description, classification_id)
values (false, 'Mercedes Sprinter', 10000, '2008', 'Did not participate in accidents', 2);
insert into ads (deleted, car_name, price, year, description, classification_id)
values (false, 'Volkswagen 5 tons', 10000, '1985', 'Mileage 200000 km', 2);
