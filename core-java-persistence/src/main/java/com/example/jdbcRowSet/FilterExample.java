package com.example.jdbcRowSet;

import javax.sql.RowSet;
import javax.sql.rowset.Predicate;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
    Create by Atiye Mousavi 
    Date: 5/31/2022
    Time: 10:40 AM
**/
public class FilterExample implements Predicate {
    private Pattern pattern;

    public FilterExample(String regexQuery) {
        if (regexQuery != null && !regexQuery.isEmpty()) {
            pattern = Pattern.compile(regexQuery);
        }
    }

    @Override
    public boolean evaluate(RowSet rs) {
        try {
            if (!rs.isAfterLast()) {
                String name = rs.getString("name");
                System.out.println(String.format(
                        "Searching for pattern '%s' in %s", pattern.toString(),
                        name));
                Matcher matcher = pattern.matcher(name);
                return matcher.matches();
            } else
                return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean evaluate(Object value, int column) throws SQLException {

        throw new UnsupportedOperationException("This operation is unsupported.");
    }

    @Override
    public boolean evaluate(Object value, String columnName) throws SQLException {
        throw new UnsupportedOperationException("This operation is unsupported.");
    }
}
