package com.food.machine.Repository;

import com.food.machine.entity.UserDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserDataEntity, String> {
    Optional<UserDataEntity> findById(int id);
}
