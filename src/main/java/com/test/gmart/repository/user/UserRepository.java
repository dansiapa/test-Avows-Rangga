package com.test.gmart.repository.user;

import com.test.gmart.model.user.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, Integer> {

    UserModel getUserModelByNoTeleponAndUserName(String noTelepon, String userName);

    Optional<UserModel> getUserModelByUserName(String userName);
}
