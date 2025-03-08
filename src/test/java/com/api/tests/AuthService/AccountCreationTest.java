package com.api.tests.AuthService;

import com.api.Utilities.dataProviders;
import com.api.models.request.SignupRequest;
import com.api.services.AuthService;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountCreationTest {

    @Test(dataProvider = "Users", dataProviderClass = dataProviders.class)
    public void createAccountTest(String userName, String email,String password, String mobileNo, String fName, String lName){

        SignupRequest signupRequest = new SignupRequest.Builder()
                .userName(userName)
                .email(email)
                .password(password)
                .mobileNumber(mobileNo)
                .firstName(fName)
                .lastName(lName)
                .build();
        AuthService authService = new AuthService();
        Response response = authService.signup(signupRequest);
        Assert.assertEquals(response.getStatusCode(),200);
    }
}
