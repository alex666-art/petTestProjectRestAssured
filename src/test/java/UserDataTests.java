import Data.UserData;
import Data.pojo.Permissions;
import Data.pojo.Teams;
import SetUp.SetUp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserDataTests extends SetUp {

    @Test
    public void authorizationTest() {

        String actualName = UserData.getUserName(UserData.getUserToken());
        String expectedName = "TestovichTestov";
        String expectedStatus = "200";
        //assert
        Assertions.assertAll(
                () -> assertEquals(expectedStatus, UserData.getStatus(UserData.getUserToken()), "Bad gateway!"),
                () -> assertEquals(expectedName, actualName, "The name is wrong!")
        );
    }

    @Test
    public void checkUserDataTeamsTest() {
        String expectedStatus = "200";
        List<Teams> data = UserData.getUserTeamsJSON(UserData.getUserToken());

        Assertions.assertAll(
                () -> assertEquals(expectedStatus, UserData.getStatus(UserData.getUserToken()), "Bad gateway!"),
                () -> data.forEach(x -> assertEquals(x.getId(), 7)),
                () -> data.forEach(x -> assertEquals(x.getName(), "Test teamm"))
        );
    }

    @Test
    public void checkUserPermissionsTest() {
        String expectedStatus = "200";
        List<Permissions> data = UserData.getUserPermissionJSON(UserData.getUserToken(), 7);

        assertEquals(expectedStatus, UserData.getStatus(UserData.getUserToken()), "Bad gateway!");
    }
}