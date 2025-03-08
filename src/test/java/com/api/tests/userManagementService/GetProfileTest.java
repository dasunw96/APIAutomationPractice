package com.api.tests.userManagementService;

import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;
import com.api.services.AuthService;
import com.api.services.UserManagementService;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetProfileTest {

    @Test
    public void getProfileTest(){

        AuthService authService = new AuthService();
        Response response = authService.login(new LoginRequest("dasun123","dasun123"));
        LoginResponse loginResponse = response.as(LoginResponse.class);
        String token = loginResponse.getToken();

        UserManagementService userManagementService = new UserManagementService();
        response = userManagementService.getProfile(token);
        UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
        Assert.assertEquals(response.getStatusCode(),200);
    }
}
