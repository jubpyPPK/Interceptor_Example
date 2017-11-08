package com.example.test2.feature.ppk.controller;

import com.example.test2.common.domain.ResponseModel;
import com.example.test2.feature.ppk.controller.domain.SaveBankAccountData;
import com.example.test2.common.domain.Status;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by napat on 11/8/2017 AD.
 */
@RestController
@RequestMapping(value = "/ppk")
public class PpkController {

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ResponseEntity<Object> init(@RequestParam String name){

        SaveBankAccountData data = new SaveBankAccountData();
        data.setName("PPK");
        data.setAge("20");

        Status status = new Status();
        status.setCode("1002");
        status.setMessage("Fail");

        ResponseModel response = new ResponseModel();
        response.setData(data);
        response.setStatus(status);

        return new ResponseEntity<Object>(response,HttpStatus.OK);
    }

}
