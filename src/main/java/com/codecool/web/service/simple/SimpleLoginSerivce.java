package com.codecool.web.service.simple;

import com.codecool.web.dao.UserDao;
import com.codecool.web.model.User;
import com.codecool.web.service.LoginService;
import com.codecool.web.service.exception.ServiceException;

import java.sql.SQLException;

public class SimpleLoginSerivce implements LoginService {

    private final UserDao userDao;

    public SimpleLoginSerivce(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User loginUser(String name, String password) throws SQLException, ServiceException {
        try{
            User user = userDao.findByName(name);
            if (user == null || !user.getPassword().equals(password)){
                throw new ServiceException("Login error");
            }
            return user;
        }catch (IllegalArgumentException e){
            throw new ServiceException(e.getMessage());
        }
    }
}
