package com.food.machine.service;

import com.food.machine.entity.UserDataEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {

    UserDataEntity savePersons(UserDataEntity userdataEntity);

    UserDataEntity getByUserId(String id);

    List<UserDataEntity> getAllData();

    Optional<UserDataEntity> updateItem(String id, UserDataEntity userDataEntity);

    boolean deleteUser(String id);

}
