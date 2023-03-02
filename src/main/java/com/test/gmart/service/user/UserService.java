package com.test.gmart.service.user;

import com.test.gmart.dto.user.UserDTO;
import com.test.gmart.model.user.UserModel;
import com.test.gmart.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    //CREATE USER
    public UserDTO createUser(String userName, String namaLengkap, String userPassword, String jenisKelamin,
                              String noTelepon, String alamat){
        if (Objects.nonNull(userRepository.getUserModelByNoTeleponAndUserName(noTelepon,userName))){
            return null;
        }else {
            UserModel userModel = new UserModel();

            userModel.setUserName(userName);
            userModel.setNamaLengkap(namaLengkap);
            userModel.setUserPassword(passwordEncoder.encode(userPassword));
            userModel.setJenisKelamin(jenisKelamin);
            userModel.setNoTelepon(noTelepon);
            userModel.setAlamat(alamat);
            userModel.setCreatedAt(LocalDateTime.now());

            return convertDTO(userRepository.save(userModel));
        }
    }

    //LOGIN
    public UserDTO loginUser(UserModel loginRequest){
        Optional<UserModel> userModel= userRepository.getUserModelByUserName(loginRequest.getUserName());
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        if (userModel.isPresent()){
            boolean result = bCryptPasswordEncoder.matches(loginRequest.getUserPassword(), userModel.get().getUserPassword());
            if (result){
                return convertDTO(userModel.get());
            } else {
                return null;
            }
        }else {
            return null;
        }
    }


    //Convert DTO
    public UserDTO convertDTO(UserModel item){
        UserDTO userDTO = new UserDTO();
        userDTO.setIdUser(item.getUserId());
        userDTO.setUserName(item.getUserName());
        userDTO.setNamaLengkap(item.getNamaLengkap());
        userDTO.setJenisKelamin(item.getJenisKelamin());
        userDTO.setNoTelepon(item.getNoTelepon());
        userDTO.setAlamat(item.getAlamat());
        return userDTO;
    }
}