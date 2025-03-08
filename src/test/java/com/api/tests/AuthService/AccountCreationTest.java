package com.api.tests.AuthService;

import com.api.models.request.SignupRequest;
import com.api.services.AuthService;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountCreationTest {

    @Test
    public void createAccountTest(){

        SignupRequest signupRequest = new SignupRequest.Builder()
                .userName("lahiru")
                .email("lahiru@gmail.com")
                .password("lahiru123")
                .mobileNumber("0715556669")
                .firstName("lahiru")
                .lastName("lahiru1")
                .build();
        AuthService authService = new AuthService();
        Response response = authService.signup(signupRequest);
        Assert.assertEquals(response.getStatusCode(),200);
        System.out.println(response.asPrettyString());
    }
}
