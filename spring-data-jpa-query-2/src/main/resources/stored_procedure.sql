-- INSERT INTO foo(id,name) VALUES (1,'John');



    CREATE PROCEDURE GetFoosByName(IN fooName VARCHAR(255))
        LANGUAGE SQL
        DETERMINISTIC
        SQL SECURITY DEFINER
        BEGIN
            SELECT * FROM foo WHERE name = fooName;
        END

    CREATE PROCEDURE GetAllFoos()
        LANGUAGE SQL
        DETERMINISTIC
        SQL SECURITY DEFINER
        BEGIN
            SELECT * FROM foo;
        END
