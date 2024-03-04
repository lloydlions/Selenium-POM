package e2e.test.ui;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.sauce_demo.LoginPage;
import utils.DataProviderUtil;

import java.io.IOException;

public class SampleTest {

    LoginPage loginPage = new LoginPage();

    @BeforeTest
    public void setup(){
        loginPage.navigate();
    }

    @AfterTest
    public void tearDown() {
        loginPage.quitDriver();
    }

    @Test(dataProvider = "data-provider")
    public void testLoginToSauceDemo(String data1, String data2) {
        loginPage.setLoginThenSubmit(data1,data2);
    }

    @DataProvider(name = "data-provider", parallel = true)
    public static Object[][] dataProvider_testLoginToSauceDemo() throws IOException {
        String csvFile = "ui/loginUserAccounts.csv";
        return DataProviderUtil.readTestData(csvFile);
    }


}
