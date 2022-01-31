package com.epam.rating.dao.factory.impl;

import com.epam.rating.builder.impl.UserBuilder;
import com.epam.rating.dao.api.FilmDao;
import com.epam.rating.dao.api.UserDao;
import com.epam.rating.dao.factory.DaoFactory;
import com.epam.rating.dao.impl.UserDaoImpl;

import java.sql.Connection;

public class DaoFactoryImpl implements DaoFactory {

    private Connection connection;

    public DaoFactoryImpl(Connection connection) {
        this.connection = connection;
    }

    public UserDao createUserDao() {
        return new UserDaoImpl(connection, new UserBuilder());
    }
}
