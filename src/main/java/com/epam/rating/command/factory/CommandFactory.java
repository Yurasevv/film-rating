package com.epam.rating.command.factory;

import com.epam.rating.command.Command;

public interface CommandFactory {
    Command create(String commandValue);
}
