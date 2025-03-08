package com.api.Utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class dataProviders {

    @DataProvider(name = "Users")
    public String[][] getAlluserdata() throws IOException {

        String path = System.getProperty("user.dir")+"\\TestData\\TestData.xlsx";
        ExcelUtility xl = new ExcelUtility(path);

        int rownum = xl.getRowCount("users");
        int colcount = xl.getCellCount("users",1);

        String data[][] = new String[rownum][colcount];

        for(int i=1;i<=rownum;i++) {
            for (int j=0;j<colcount;j++) {
                data[i-1][j] = xl.getCellData("users",i,j);
            }
        }
        return data;

    }

    @DataProvider(name = "loginData")
    public String[][] getLoginData() throws IOException {

        String path = System.getProperty("user.dir")+"\\TestData\\TestData.xlsx";
        ExcelUtility xl = new ExcelUtility(path);

        int rownum = xl.getRowCount("users");
        int colcount = 2;

        String[][] data = new String[rownum][colcount];
        for (int i = 1; i <= rownum; i++) {
            // Get username and password for each row and store them in the array.
            data[i - 1][0] = xl.getCellDataOfSpecificColumn("users", "username", i);
            data[i - 1][1] = xl.getCellDataOfSpecificColumn("users", "password", i);
        }

        return data;
    }
}
