INSERT INTO plots (id, plot_name, length, width, soil_type)
VALUES (1, 'Plot 1', 56.74, 95.74, 'LOAMY');
INSERT INTO plots (id, plot_name, length, width, soil_type)
VALUES (2, 'Plot 2', 76.78, 25.94, 'CLAY');
INSERT INTO plots (id, plot_name, length, width, soil_type)
VALUES (3, 'Plot 3', 46.75, 35.85, 'LOAMY');
INSERT INTO plots (id, plot_name, length, width, soil_type)
VALUES (4, 'Plot 4', 86.72, 35.73, 'SANDY');

INSERT INTO time_slots (id, start_time, duration, water_quantity, plot_id, current_status)
VALUES (1, '14:30', 10, 35.4, 1, 'IRRIGATION_DONE');
INSERT INTO time_slots (id, start_time, duration, water_quantity, plot_id, current_status)
VALUES (5, '18:30', 10, 35.4, 1, 'SCHEDULED');
INSERT INTO time_slots (id, start_time, duration, water_quantity, plot_id, current_status)
VALUES (2, '15:30', 5, 45.4, 2, 'IRRIGATION_DONE');
INSERT INTO time_slots (id, start_time, duration, water_quantity, plot_id, current_status)
VALUES (3, '16:30', 6, 37.4, 3, 'SCHEDULED');
INSERT INTO time_slots (id, start_time, duration, water_quantity, plot_id, current_status)
VALUES (4, '13:30', 9, 75.4, 4, 'IRRIGATION_DONE');
