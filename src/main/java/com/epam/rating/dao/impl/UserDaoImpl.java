package com.epam.rating.dao.impl;

import com.epam.rating.builder.Builder;
import com.epam.rating.dao.api.UserDao;
import com.epam.rating.entity.user.User;
import com.epam.rating.entity.user.UserRole;
import com.epam.rating.exception.DaoException;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl extends AbstractDao<User> implements UserDao {

    private static final String USER_TABLE = "fitness_user";
    private static final String FIND_USER_BY_EMAIL_AND_PASSWORD_QUERY =
            "SELECT * FROM rating_user WHERE email = ? AND password = ?";
    private static final String FIND_USERS_BY_REVIEW_ID_QUERY =
            "SELECT DISTINCT u.id, email, password, role, first_name, second_name " +
                    "FROM rating_user AS u " +
                    "JOIN review AS o ON u.id = o.client_id " +
                    "WHERE o.review_id = ?";
    private static final String SAVE_USER_QUERY = "INSERT INTO rating_user" +
            "(id, email, password, first_name, second_name, role) " +
            "VALUES(?, ?, ?, ?, ?, ?, ?) " +
            "ON DUPLICATE KEY UPDATE " +
            "id = VALUES(id)," +
            "email = VALUES(email)," +
            "password = VALUES(password)," +
            "first_name = VALUES(first_name)," +
            "second_name = VALUES(second_name)," +
            "role = VALUES(role)";
    private static final String GET_ALL_USERS = "" +
            "SELECT * FROM rating_user WHERE role = 'user'";

    public UserDaoImpl(Connection connection, Builder<User> builder){
        super(connection, builder);
    }

    @Override
    public Optional<User> findUserByEmailAndPassword(String email, String password) throws DaoException {
        return executeForSingleResult(FIND_USER_BY_EMAIL_AND_PASSWORD_QUERY, email, password);
    }

    @Override
    public List<User> getAllUsers() throws DaoException {
        return executeQuery(GET_ALL_USERS);
    }

    @Override
    public void save(User user) throws DaoException {
        UserRole role = user.getRole();
        Object[] fields = {
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                user.getName(),
                user.getSurname(),
                role.toString(),
        };
        executeUpdate(SAVE_USER_QUERY, fields);
    }

    @Override
    public List<User> findUsersByReviewId(long reviewId) throws DaoException {
        return null;
    }

    @Override
    protected String getTableName(){
        return USER_TABLE;
    }
}
