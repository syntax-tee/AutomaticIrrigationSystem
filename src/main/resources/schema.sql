DROP TABLE IF EXISTS plots;
CREATE TABLE plots
(
    id            INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    plot_name     VARCHAR(250)   NOT NULL,
    length        NUMERIC(20, 2) NOT NULL,
    width         NUMERIC(20, 2) NOT NULL,
    soil_type     VARCHAR(15),
    crop_type     VARCHAR(30),
    longitude     NUMERIC(20, 2),
    latitude      NUMERIC(20, 2),
    soil_moisture NUMERIC(20, 2)
);

DROP TABLE IF EXISTS time_slots;
CREATE TABLE time_slots
(
    id             INT            NOT NULL GENERATED BY DEFAULT AS IDENTITY,
    schedule_time  TIME           NOT NULL,
    duration       NUMERIC        NOT NULL,
    water_quantity NUMERIC(20, 2) NOT NULL,
    plot_id        INT            NOT NULL,
    status         VARCHAR(20),

    CONSTRAINT time_slots_pk PRIMARY KEY (id),
    CONSTRAINT plot_fk FOREIGN KEY (plot_id) REFERENCES plots (id)
);

DROP TABLE IF EXISTS sensor_devices;
CREATE TABLE sensor_devices
(
    id          INT NOT NULL GENERATED BY DEFAULT AS IDENTITY,
    device_id   VARCHAR(20),
    device_name VARCHAR(20),
    plot_id     INT,

    CONSTRAINT sensor_devices_pk PRIMARY KEY (id),
    CONSTRAINT plots_fk FOREIGN KEY (plot_id) REFERENCES plots (id)
);
