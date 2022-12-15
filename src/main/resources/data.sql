INSERT INTO plots (id, plot_name, length, width, soil_type, crop_type, longitude, latitude, soil_moisture)
VALUES (1, 'Plot 1', 56.74, 95.74, 'LOAMY', 'cereal', 34.5, 39.8, 13.8);
INSERT INTO plots (id, plot_name, length, width, soil_type, crop_type, longitude, latitude, soil_moisture)
VALUES (2, 'Plot 2', 76.78, 25.94, 'CLAY', 'vegetable', 34.5, 39.8, 13.8);
INSERT INTO plots (id, plot_name, length, width, soil_type, crop_type, longitude, latitude, soil_moisture)
VALUES (3, 'Plot 3', 46.75, 35.85, 'LOAMY', 'fruit', 34.5, 39.8, 13.8);
INSERT INTO plots (id, plot_name, length, width, soil_type, crop_type, longitude, latitude, soil_moisture)
VALUES (4, 'Plot 4', 86.72, 35.73, 'SANDY', 'seed', 34.5, 39.8, 13.8);

INSERT INTO time_slots (id, schedule_time, duration, water_quantity, plot_id, status)
VALUES (1, '14:06', 10, 35.4, 1, 'IRRIGATION_DONE');
INSERT INTO time_slots (id, schedule_time, duration, water_quantity, plot_id, status)
VALUES (5, '14:07', 10, 35.4, 1, 'SCHEDULED');
INSERT INTO time_slots (id, schedule_time, duration, water_quantity, plot_id, status)
VALUES (2, '14:08', 5, 45.4, 2, 'IRRIGATION_DONE');
INSERT INTO time_slots (id, schedule_time, duration, water_quantity, plot_id, status)
VALUES (3, '14:09', 6, 37.4, 3, 'SCHEDULED');
INSERT INTO time_slots (id, schedule_time, duration, water_quantity, plot_id, status)
VALUES (4, '14:10', 9, 75.4, 4, 'IRRIGATION_DONE');

INSERT INTO sensor_devices (id, device_id, device_name, plot_id)
VALUES (1, 'deviceOne', 'highImpactSensor1', 1);
INSERT INTO sensor_devices (id, device_id, device_name, plot_id)
VALUES (2, 'deviceTwo', 'highImpactSensor2', 2);
INSERT INTO sensor_devices (id, device_id, device_name, plot_id)
VALUES (3, 'deviceThree', 'highImpactSensor4', 3);
INSERT INTO sensor_devices (id, device_id, device_name, plot_id)
VALUES (4, 'deviceFour', 'highImpactSensor4', 4);