package com.epam.rating.command;

import com.epam.rating.exception.ServiceException;
import com.epam.rating.exception.ValidationException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
    CommandResult execute (HttpServletRequest request, HttpServletResponse response) throws ServiceException, ValidationException;
}
