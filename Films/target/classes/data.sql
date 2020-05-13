DROP TABLE IF EXISTS films;

CREATE TABLE films (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  Producer VARCHAR(250) NOT NULL
);

INSERT INTO films (name, Producer) VALUES
  ('Film1', 'Producer1'),
  ('Film2', 'Producer2');