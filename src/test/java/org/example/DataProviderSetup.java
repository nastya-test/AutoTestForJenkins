package org.example;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderSetup {

    @DataProvider(name="allPlatform")
    public Object[][] dataProviderMethod() {
        return new Object[][] { {"web"}, {"mobile"}};
    }

//    @Test(dataProvider = "allPlatform")
//    public void myTest (String val) {
//        System.out.println("Parameter Is : " + val);
//    }
}
