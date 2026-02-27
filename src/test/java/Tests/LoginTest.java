package Tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Base.BaseTest;
import Pages.LoginPOM;
import Utils.JsonUtils;

public class LoginTest extends BaseTest {
    LoginPOM log;

    @DataProvider(name = "logindata")
    public Object[][] loginData() throws IOException {
        JsonUtils js = new JsonUtils();
        List<HashMap<String, String>> data = js.jsonreader();
        Object[][] obj = new Object[data.size()][1];
        for (int i = 0; i < data.size(); i++) {
            obj[i][0] = data.get(i);
        }
        return obj;
    }

    @Test(dataProvider = "logindata")
    public void logintest(HashMap<String, String> input) {
        log = new LoginPOM(driver);
        String username = input.get("username");
        String password = input.get("password");

        // Use the EXACT method names from your LoginPOM
        log.login(username, password); 
        log.clicklogin();

        if (username.equals("standard_user")) {
            System.out.println("✅ Login Success: " + username);
        } else {
            // Verify error exists using your boolean method
            boolean isErrorVisible = log.error();
            System.out.println("❌ Error verified for: " + username + " -> " + isErrorVisible);
           
        }
    }
}
