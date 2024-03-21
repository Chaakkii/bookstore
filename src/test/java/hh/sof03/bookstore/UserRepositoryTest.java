package hh.sof03.bookstore;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import hh.sof03.bookstore.domain.User;
import hh.sof03.bookstore.domain.UserRepository;


@DataJpaTest

public class UserRepositoryTest {

    @Autowired

    private UserRepository userRepository;

    @Test
    public void testFindUserByUsername() {
        User testUser = new User("testuser", "password", "USER");
        userRepository.save(testUser);

        User foundUser = userRepository.findByUsername("testuser");
        assertThat(foundUser).isNotNull();
    }

    @Test
    public void testSaveUser() {
        User testUser = new User("testuser", "password", "USER");
        userRepository.save(testUser);

        userRepository.findById(testUser.getUserid());

        assertThat(userRepository.findById(testUser.getUserid())).isNotNull();

    }

    @Test
    public void testDeleteUserById() {
        User testUser = new User("testuser", "password", "USER");
        userRepository.save(testUser);

        userRepository.deleteById(testUser.getUserid());

        assertThat(userRepository.findById(testUser.getUserid())).isEmpty();
    }
    
 
}
