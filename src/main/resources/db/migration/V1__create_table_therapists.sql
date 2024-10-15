CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE THERAPISTS (
    ID UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    NAME CHARACTER VARYING NOT NULL,
    LAST_NAME CHARACTER VARYING NOT NULL,
    VOCATIONAL_TRAINING CHARACTER VARYING NOT NULL,
    YEARS_OF_EXPERIENCE INTEGER NOT NULL
);