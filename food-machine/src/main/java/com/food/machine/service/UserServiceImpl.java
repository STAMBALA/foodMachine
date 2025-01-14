package com.food.machine.service;

import com.food.machine.Repository.UserRepository;
import com.food.machine.entity.UserDataEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
//@Slf4j
@SuppressWarnings("All")
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public UserDataEntity savePersons(UserDataEntity userdataEntity) {
        log.info("Data saved with new id");
        return userRepository.save(userdataEntity);

    }

    @Override
    public UserDataEntity getByUserId(Integer id) {
        Optional<UserDataEntity> optional = userRepository.findById(id);
        if (optional.isPresent()) {
            log.info("Data found with id {}", id);
            return optional.get();
        } else {
            log.info("Data not found with id {}", id);
            return optional.orElseThrow();
        }
    }

    @Override
    public List<UserDataEntity> getAllData() {
        log.info("Data found successfully");
        return userRepository.findAll();
    }

    @Override
    public Optional<UserDataEntity> updateItem(Integer id, UserDataEntity userDataEntity) {
        Optional<UserDataEntity> optionalItem = userRepository.findById(id);
        if (optionalItem.isPresent()) {
            UserDataEntity existingItem = optionalItem.get();
            existingItem.setFoodItems(userDataEntity.getFoodItems());
            existingItem.setFoodQuantity(userDataEntity.getFoodQuantity());
            existingItem.setUserBiometric(userDataEntity.isUserBiometric());
            existingItem.setFoodDamageOrNot(userDataEntity.getFoodDamageOrNot());
            existingItem.setId(userDataEntity.getId());
            userRepository.save(existingItem);
            return Optional.of(existingItem);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public boolean deleteUser(Integer id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}