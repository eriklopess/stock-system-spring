package eriklopess.stock.entities;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserEntityTest {

    @Test
    @DisplayName(value="Shoud return the User with all yours properties")
    public void ShoudReturnTheUserWithAllYoursProperties() {
        User user = new User(1, "Julio", "1234", 2);
        assertEquals(1, user.getId());
        assertEquals("Julio", user.getName());
        assertEquals(2, user.getRoleId());
    }
}
