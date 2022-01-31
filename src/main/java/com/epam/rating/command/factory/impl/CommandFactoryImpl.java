package com.epam.rating.command.factory.impl;

import com.epam.rating.command.Command;
import com.epam.rating.command.factory.CommandFactory;
import com.epam.rating.command.impl.user.LoginCommand;
import com.epam.rating.dao.factory.DaoFactory;
import com.epam.rating.service.impl.UserServiceImpl;

public class CommandFactoryImpl implements CommandFactory {

    private static final String LOGIN_COMMAND = "login";
    private static final String LOG_OUT_COMMAND = "logOut";
    private static final String SHOW_HOME_PAGE_COMMAND = "showHomePage";

    private DaoFactory factory;

    public CommandFactoryImpl(DaoFactory factory){
        this.factory = factory;
    }

    @Override
    public Command create(String commandValue) {

        Command command;
        switch (commandValue) {
            case LOGIN_COMMAND:
                command = new LoginCommand(
                        new UserServiceImpl(factory)
                );
                break;
            default:
                throw new IllegalArgumentException("Illegal command: " + commandValue);
        }
        return command;
    }
}
