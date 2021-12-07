package com.epam.rating.dao.factory.impl;

import com.epam.rating.dao.api.FilmDao;
import com.epam.rating.dao.api.UserDao;
import com.epam.rating.dao.factory.DaoFactory;

public class DaoFactoryImpl implements DaoFactory {


    @Override
    public UserDao createUserDao() {
        return null;
    }

    @Override
    public FilmDao createFilmDao() {
        return null;
    }
}
