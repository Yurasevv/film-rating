package com.epam.rating.dao.impl;

import com.epam.rating.builder.Builder;
import com.epam.rating.dao.api.Dao;
import com.epam.rating.entity.Identifiable;
import com.epam.rating.exception.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class AbstractDao<T extends Identifiable> implements Dao<T> {
    private static final String FIND_BY_ID_QUERY = "SELECT * FROM %s WHERE id = ?";
    private static final String GET_ALL_QUERY = "SELECT * FROM %s";

    private Connection connection;
    private Builder<T> builder;

    public AbstractDao(Connection connection, Builder<T> builder){
        this.connection = connection;
        this.builder = builder;
    }

    protected List<T> executeQuery(String query, Object... params) throws DaoException {
        try(PreparedStatement statement = connection.prepareStatement(query)){
            setStatementParameters(statement, params);
            ResultSet resultSet = statement.executeQuery();
            List<T> entities = new ArrayList<>();
            while(resultSet.next()){
                T entity = builder.build(resultSet);
                entities.add(entity);
            }
            return entities;
        } catch (SQLException ex){
            throw new DaoException(ex.getMessage(), ex);
        }
    }


    protected void executeUpdate(String query, Object... params) throws DaoException {
        try(PreparedStatement statement = connection.prepareStatement(query)){
            setStatementParameters(statement, params);
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new DaoException(ex.getMessage(), ex);
        }
    }


    @Override
    public Optional<T> findById(int id) throws DaoException{
        String formattedQuery = insertTableName(FIND_BY_ID_QUERY);
        return executeForSingleResult(formattedQuery, id);
    }


    protected Optional<T> executeForSingleResult(String query, Object... params) throws DaoException{
        List<T> items = executeQuery(query, params);
        if(items.size() > 0){
            T item = items.get(0);
            return Optional.of(item);
        } else{
            return Optional.empty();
        }
    }


    @Override
    public List<T> getAll() throws DaoException{
        String formattedQuery = insertTableName(GET_ALL_QUERY);
        return executeQuery(formattedQuery);
    }

    @Override
    public void deleteById(int id){
        throw new UnsupportedOperationException();
    }


    protected abstract String getTableName();


    private String insertTableName(String query){
        String tableName = getTableName();
        return String.format(query, tableName);
    }

    private void setStatementParameters(PreparedStatement statement, Object... params) throws SQLException{
        for(int i = 0; i < params.length; i++){
            statement.setObject(i + 1, params[i]);
        }
    }
}
