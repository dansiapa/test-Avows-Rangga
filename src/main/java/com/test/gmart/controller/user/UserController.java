package com.test.gmart.controller.user;

import com.test.gmart.dto.user.UserDTO;
import com.test.gmart.model.user.UserModel;
import com.test.gmart.response.DataResponse;
import com.test.gmart.response.HandlerResponse;
import com.test.gmart.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@RestController
@RequestMapping(value = "/api/v1/user", produces = {"application/json"})
public class UserController {
    @Autowired
    private UserService userService;

    //LOGIN
    @PostMapping("/login")
    public void loginUser(HttpServletRequest request, HttpServletResponse response,
                          @RequestBody UserModel loginRequest) throws Exception{

        UserDTO userDTO = userService.loginUser(loginRequest);

        if (userDTO != null) {
            DataResponse<UserDTO> data = new DataResponse<>();
            data.setData(userDTO);

            HandlerResponse.responseSuccessWithData(response,data);
        }else {
            HandlerResponse.responseBadRequest(response, "01","Something wrong");
        }

    }

    //Create User
    @PostMapping("/register")
    public void createUser(HttpServletRequest request, HttpServletResponse response,
                           @RequestParam("username") String userName,
                           @RequestParam("namaLengkap") String namaLengkap,
                           @RequestParam("userPassword") String userPassword,
                           @RequestParam("jenis_kelamin") String jenisKelamin,
                           @RequestParam("no_telepon") String noTelepon,
                           @RequestParam("alamat") String alamat) throws Exception {


        UserDTO userDTO = userService.createUser(userName,namaLengkap, userPassword, jenisKelamin, noTelepon, alamat);

        if (Objects.nonNull(userDTO)) {
            DataResponse<UserDTO> dataResponse = new DataResponse<>();
            dataResponse.setData(userDTO);
            HandlerResponse.responseSuccessWithData(response, dataResponse);
        } else {
            HandlerResponse.responseBadRequest(response, "08", "User already registered");
        }
    }
}
