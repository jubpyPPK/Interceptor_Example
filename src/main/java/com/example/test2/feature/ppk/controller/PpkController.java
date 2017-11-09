package com.example.test2.feature.ppk.controller;

import com.example.test2.common.constans.ResultCode;
import com.example.test2.common.domain.GenericResponse;
import com.example.test2.common.domain.GenericStatus;
import com.example.test2.feature.ppk.controller.domain.SaveBankAccountData;
import com.example.test2.feature.ppk.service.PpkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by napat on 11/8/2017 AD.
 */
@RestController
@RequestMapping(value = "/ppk")
public class PpkController {

    @Autowired
    private PpkService ppkService;

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public HttpEntity<Object> init(@RequestParam String name) throws Exception{

        SaveBankAccountData data = new SaveBankAccountData();
        data.setName(name);
        data.setAge(ppkService.getProfile());

        return new ResponseEntity<>(new GenericResponse(ResultCode.SUCCESS.get(),data),HttpStatus.OK);
    }

    @RequestMapping(value = "/void", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public void initVoid(@RequestParam String name) throws Exception{

        SaveBankAccountData data = new SaveBankAccountData();
        data.setName(name);
        data.setAge("14");

        GenericResponse response = new GenericResponse(ResultCode.SUCCESS.get(),data);
        System.out.print("Response Body :: " + response);

    }

}
