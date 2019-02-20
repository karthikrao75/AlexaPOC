CREATE TABLE IF NOT EXISTS users (
  user_id INT NOT NULL,
  user_name VARCHAR(45) NOT NULL,
  PRIMARY KEY (user_id),
  UNIQUE INDEX user_name_UNIQUE (user_name ASC));
  

  
  CREATE TABLE IF NOT EXISTS leaves (
  leave_id INT NOT NULL,
  start_date DATETIME NULL,
  end_date DATETIME NULL,
  leave_reason VARCHAR(200) NOT NULL,
  user_id INT NOT NULL,
  PRIMARY KEY (leave_id),
  INDEX user_id_idx (user_id ASC),
  CONSTRAINT user_id
    FOREIGN KEY (user_id)
    REFERENCES alexa.users (user_id));