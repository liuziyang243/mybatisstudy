# create db table t_file
CREATE TABLE t_file (
  id   INT NOT NULL AUTO_INCREMENT,
  file BLOB,
  PRIMARY KEY (id)
);

# create procedure
CREATE PROCEDURE count_user(IN p_user_name VARCHAR(20), OUT count_total INTEGER, OUT exec_date DATE)
  BEGIN
    SELECT count(*)
    INTO count_total
    FROM t_user
    WHERE user_name LIKE '%' || p_user_name || '%';
    SELECT sysdate()
    INTO exec_date
    FROM dual;
  END;