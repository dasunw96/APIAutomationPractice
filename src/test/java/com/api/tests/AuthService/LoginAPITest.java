package com.api.tests.AuthService;

import com.api.Utilities.dataProviders;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.services.AuthService;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginAPITest {

    @Test(dataProvider = "loginData", dataProviderClass = dataProviders .class)
    public void loginTest(String uname, String pwd){

        LoginRequest loginRequest = new LoginRequest(uname,pwd);
        AuthService authService = new AuthService();
        Response response = authService.login(loginRequest);
        LoginResponse loginResponse = response.as(LoginResponse.class);
        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertEquals(loginResponse.getUsername(),uname);

    }
}
