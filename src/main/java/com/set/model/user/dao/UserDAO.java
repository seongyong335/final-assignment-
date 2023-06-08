package com.set.model.user.dao;

import com.set.model.user.dto.UserDTO;

import java.util.List;
import java.util.Map;

public interface UserDAO {

    int insertUser(Map<String, String> userInfo);


    List<UserDTO> selectUser(Map<String, String> userInfo);

    int updateUser(Map<String, String> userInfo);

    int deleteUser(Map<String, String> userInfo);
}
