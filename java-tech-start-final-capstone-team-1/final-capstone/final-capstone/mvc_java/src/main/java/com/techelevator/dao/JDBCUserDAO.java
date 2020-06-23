package com.techelevator.dao;//package com.techelevator.model;

import com.techelevator.entity.User;
import com.techelevator.security.PasswordHasher;
import org.bouncycastle.util.encoders.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;


@Component
public class JDBCUserDAO implements UserDAO {

    private JdbcTemplate jdbcTemplate;
    private PasswordHasher hashMaster;

    @Autowired
    public JDBCUserDAO(DataSource dataSource, PasswordHasher hashMaster) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.hashMaster = hashMaster;
    }

    @Override
    public void saveUser(User user) {
        byte[] salt = hashMaster.generateRandomSalt();
        String hashedPassword = hashMaster.computeHash(user.getPassword(), salt);
        String saltString = new String(Base64.encode(salt));
        user.setId(getNextUserId());
        jdbcTemplate.update("INSERT INTO app_user(id, user_name, password, first_name, last_name, role, salt) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?)",
                user.getId(),
                user.getGetUserName(), hashedPassword, user.getFirstName(),
                user.getLastName(), user.getRole(), saltString);
    }

    @Override
    public boolean searchForUsernameAndPassword(String userName, String password) {
        String sqlSearchForUser = "SELECT * " +
                "FROM app_user " +
                "WHERE UPPER(user_name) = ? ";

        SqlRowSet user = jdbcTemplate.queryForRowSet(sqlSearchForUser, userName.toUpperCase());
        if (user.next()) {
            String dbSalt = user.getString("salt");
            String dbHashedPassword = user.getString("password");
            String givenPassword = hashMaster.computeHash(password, Base64.decode(dbSalt));
            return dbHashedPassword.equals(givenPassword);
        } else {
            return false;
        }
    }

    @Override
    public void updatePassword(String userName, String password) {
        /*
         * The updated password needs to be hashed before being inserted into the database.
         */
        jdbcTemplate.update("UPDATE app_user SET password = ? WHERE user_name = ?", password, userName);
    }

    @Override
    public User getUserByUserName(String userName) {
        String sqlSearchForUsername = "SELECT * " +
                "FROM app_user " +
                "WHERE UPPER(user_name) = ? ";

        SqlRowSet user = jdbcTemplate.queryForRowSet(sqlSearchForUsername, userName.toUpperCase());
        User thisUser = null;
        if (user.next()) {
            thisUser = new User();
            thisUser.setId(user.getLong("id"));
            thisUser.setGetUserName(user.getString("user_name"));
            thisUser.setPassword(user.getString("password"));
            thisUser.setFirstName(user.getString("first_name"));
            thisUser.setLastName(user.getString("last_name"));
            thisUser.setRole(user.getString("role"));
        }

        return thisUser;
    }

    private long getNextUserId() {
        SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('app_user_id_seq')");
        if (nextIdResult.next()) {
            return nextIdResult.getLong(1);
        }
        return 0L;
    }

}