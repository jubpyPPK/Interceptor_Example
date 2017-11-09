package com.example.test2.feature.ppk.service;

import org.springframework.stereotype.Service;

/**
 * Created by napat on 11/9/2017 AD.
 */
@Service
public class PpkService {

    public String getProfile() throws Exception {
        String a = "c";
        String b = "1";

        int sum = Integer.decode(a) + Integer.decode(b);

        return String.valueOf(sum);
    }

}
