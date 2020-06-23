package com.techelevator.dao;//package com.techelevator.model;

import com.techelevator.entity.User;


public interface UserDAO {

    void saveUser(User user);

    boolean searchForUsernameAndPassword(String userName, String password);

    void updatePassword(String userName, String password);

    User getUserByUserName(String userName);

}
