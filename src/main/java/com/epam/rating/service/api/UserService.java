package com.epam.rating.service.api;

import com.epam.rating.entity.user.User;
import com.epam.rating.exception.ServiceException;

import java.util.Optional;

public interface UserService {
    Optional<User> login(String email, String password) throws ServiceException;
}
