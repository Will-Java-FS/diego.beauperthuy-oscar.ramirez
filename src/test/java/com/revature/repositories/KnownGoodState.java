package com.revature.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class KnownGoodState {

    @Autowired
    JdbcTemplate jdbcTemplate;

    void set() {

        jdbcTemplate.update("""
                SET SEARCH_PATH TO pairedproject;
                
                DROP TABLE IF EXISTS car;
                
                DROP TABLE IF EXISTS dealership;
                
                create table dealership(
                	dealership_id SERIAL,
                	name varchar(50) UNIQUE NOT NULL,
                	city varchar(50),
                	state varchar(50),
                	PRIMARY KEY (dealership_id)
                );
                
                create table car(
                	car_id SERIAL,
                	make varchar(50) NOT NULL,
                	model varchar(50) NOT NULL,
                	year int,
                	dealership_id int,
                	PRIMARY KEY (car_id),
                	CONSTRAINT fk_dealership
                		FOREIGN KEY(dealership_id)
                		REFERENCES dealership(dealership_id)
                );
                
                INSERT INTO dealership VALUES
                    (DEFAULT, 'Carmax Inc.', 'Richmond', 'Virginia'),
                    (DEFAULT, 'Penske Automotive Group Inc.', 'Bloomfield Hills', 'Michigan'),
                    (DEFAULT, 'Green Fmaily Stores', 'Blasdell', 'New York'),
                    (DEFAULT, 'Auto Haven', 'Brooklyn', 'New York'),
                    (DEFAULT, 'Boucher Group', 'Greenfield', 'Wisconsin');

                INSERT INTO car VALUES
                	(DEFAULT, 'Acura', 'MDX', 2022, 1),
                    (DEFAULT, 'Acura', 'NSX', 2019, 2),
                    (DEFAULT, 'Acura', 'TL', 2013, 3),
                    (DEFAULT, 'Acura', 'TLX', 2020, 4),
                    (DEFAULT, 'Acura', 'TSX', 2011, 5),
                    (DEFAULT, 'Alfa Romeo', '4C', 2018, 1),
                    (DEFAULT, 'Alfa Romeo', 'Tonale', 2024, 2),
                    (DEFAULT, 'Alfa Romeo', 'Stelvio', 2023, 3),
                    (DEFAULT, 'Buick', 'Cascada', 2016, 4),
                    (DEFAULT, 'Buick', 'Verano', 2014, 5),
                    (DEFAULT, 'Cadillac', 'ELR', 2015, 1),
                    (DEFAULT, 'Cadillac', 'XTS', 2017, 2),
                    (DEFAULT, 'Chrysler', 'Sebring', 2007, 3),
                    (DEFAULT, 'Dodge', 'Nitro', 2008, 4),
                    (DEFAULT, 'Ford', 'Taurus', 2016, 5),
                    (DEFAULT, 'Honda', 'S2000', 2009, 1),
                    (DEFAULT, 'Hyundai', 'Santa Cruz', 2022, 2),
                    (DEFAULT, 'Hyundai', 'Veloster', 2019, 3),
                    (DEFAULT, 'Infiniti', 'QX55', 2022, 4),
                    (DEFAULT, 'Infiniti', 'QX60', 2022, 5),
                    (DEFAULT, 'Infiniti', 'QX70', 2017, 1),
                    (DEFAULT, 'Infiniti', 'QX80', 2021, 2),
                    (DEFAULT, 'Lexus', 'RC', 2023, 3),
                    (DEFAULT, 'Lexus', 'RX', 2023, 4),
                    (DEFAULT, 'Lexus', 'NX Hybrid', 2023, 5),
                    (DEFAULT, 'Mazda', 'CX-3', 2020, 1),
                    (DEFAULT, 'Mazda', 'CX-5', 2020, 2),
                    (DEFAULT, 'Mazda', 'MX-30', 2020, 3),
                    (DEFAULT, 'Nissan', 'Cube', 2011, 4),
                    (DEFAULT, 'Nissan', 'Frontier', 2020, 5),
                    (DEFAULT, 'Nissan', 'Juke', 2011, 1),
                    (DEFAULT, 'Nissan', 'GT-R', 2009, 2),
                    (DEFAULT, 'Saab', '9-4X', 2011, 3),
                    (DEFAULT, 'Saab', '9-5', 2011, 4),
                    (DEFAULT, 'Saab', '9-7X', 2009, 5),
                    (DEFAULT, 'Subaru', 'Solterra', 2023, 1),
                    (DEFAULT, 'Suzuki', 'SX4', 2010, 2),
                    (DEFAULT, 'Toyota', 'Avalon', 2019, 3),
                    (DEFAULT, 'Toyota', 'C-HR', 2019, 4),
                    (DEFAULT, 'Volkswagen', 'Atlas', 2023, 5),
                    (DEFAULT, 'Volkswagen', 'Beetle', 2019, 1),
                    (DEFAULT, 'Volkswagen', 'CC', 2014, 2),
                    (DEFAULT, 'Volvo', 'S40', 2011, 3),
                    (DEFAULT, 'Volvo', 'V90', 2020, 4),
                    (DEFAULT, 'Volvo', 'XC60', 2023, 5);
                """);
    }

}
