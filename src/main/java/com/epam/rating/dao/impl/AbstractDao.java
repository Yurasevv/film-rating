package com.epam.rating.dao.impl;

import com.epam.rating.dao.api.Dao;
import com.epam.rating.entity.Identifiable;

public abstract class AbstractDao<T extends Identifiable> implements Dao<T> {
}
