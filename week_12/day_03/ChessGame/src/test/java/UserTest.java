import org.junit.Before;
import org.junit.Test;

import players.User;

import static org.junit.Assert.assertEquals;

public class UserTest {
    User user;

    @Before
    public void setUp() throws Exception {
        user = new User("John");
    }

    @Test
    public void canGetName() {
        assertEquals("John", user.getName());
    }
}
