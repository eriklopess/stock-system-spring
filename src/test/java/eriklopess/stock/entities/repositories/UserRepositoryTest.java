package eriklopess.stock.entities.repositories;

import eriklopess.stock.entities.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    @DisplayName(value = "create: Should throws an exception if data is not valid")
    public void ShouldThrowsAnExceptionIfUserIsNotValid() throws Exception {
        userRepository.save(new User());
    }

    @Test
    @DisplayName(value = "create: Should return an user if data is valid")
    public void ShouldReturnAnUserIfDataIsValid() {
        User user = new User(1, "Julio", "1234", 2);

        User result = userRepository.save(user);

        assertNotNull(result);
    }

    @Test
    @DisplayName(value = "findById: Should return an exception if id not found")
    public void ShouldReturnAnExceptionIfIdNotFound() throws Exception{
        int id = 1;

        userRepository.findById(id);
    }

    @Test
    @DisplayName(value = "findById: Should return an user if id is valid")
    public void ShouldReturnAnUserIfIdIsValid() {
        User user = new User(1, "Julio", "1234", 2);
        int id = 1;

        userRepository.save(user);
        Optional<User> result = userRepository.findById(id);

        assertNotNull(result);
    }

    @Test
    @DisplayName(value = "findAll: Should return all users")
    public void ShouldReturnAllUsers() {
        User user = new User(1, "Julio", "1234", 2);

        userRepository.save(user);

        List<User> userList = userRepository.findAll();

        assertEquals(1, userList.size());
    }
}
