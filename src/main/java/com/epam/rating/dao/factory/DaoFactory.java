package com.epam.rating.dao.factory;

import com.epam.rating.dao.api.FilmDao;
import com.epam.rating.dao.api.UserDao;

public interface DaoFactory {
    UserDao createUserDao();
}
