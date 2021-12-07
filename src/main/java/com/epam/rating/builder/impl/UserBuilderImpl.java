package com.epam.rating.builder.impl;

import com.epam.rating.builder.Builder;
import com.epam.rating.entity.user.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserBuilderImpl implements Builder<User> {
    @Override
    public User build(ResultSet resultSet) throws SQLException {
        return null;
    }
}
