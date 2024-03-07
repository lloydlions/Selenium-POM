package e2e.test.api;

import core.ApiClientTest;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class SampleTest {

    private final String URL = ConfigReader.getInstance().getProperty("catApi") + "/breeds";

    @Test
    public void ApiTest() {
        ApiClientTest apiClientTest = new ApiClientTest();
        JSONObject jsonResponse = apiClientTest.sendGetRequest(URL);

        System.out.println(jsonResponse);

    }
}
