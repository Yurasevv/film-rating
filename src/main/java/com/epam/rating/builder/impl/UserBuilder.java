package com.epam.rating.builder.impl;

import com.epam.rating.builder.Builder;
import com.epam.rating.entity.user.User;
import com.epam.rating.entity.user.UserRole;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserBuilder implements Builder<User> {
    private static final String EMAIL_COLUMN = "email";
    private static final String PASSWORD_COLUMN = "password";
    private static final String ROLE_COLUMN = "role";
    private static final String ID_COLUMN = "id";
    private static final String FIRST_NAME_COLUMN = "first_name";
    private static final String SECOND_NAME_COLUMN = "second_name";
    private static final String NICKNAME_COLUMN = "second_name";


    @Override
    public User build(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(ID_COLUMN);
        String email = resultSet.getString(EMAIL_COLUMN);
        String password = resultSet.getString(PASSWORD_COLUMN);
        String roleValue = resultSet.getString(ROLE_COLUMN);
        UserRole role = UserRole.valueOf(roleValue.toUpperCase());
        String firstName = resultSet.getString(FIRST_NAME_COLUMN);
        String secondName = resultSet.getString(SECOND_NAME_COLUMN);
        String nickname = resultSet.getString(NICKNAME_COLUMN);
        return new User(email, password, firstName, secondName, nickname, role);
    }
}
