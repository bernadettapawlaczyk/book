package com.example.book;

import com.example.book.model.User;
import com.example.book.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void Find_user_by_lastName(){
        String lastName = "Pawlaczyk";

        User user = new User();
        user.setLastName(lastName);

        Optional<User> foundUserOptional = userRepository.findByLastName(lastName);
        Assertions.assertThat(foundUserOptional.isEmpty()).isTrue();

        //when
        userRepository.save(user);
        foundUserOptional = userRepository.findByLastName(lastName);

        //then
        Assertions.assertThat(foundUserOptional.isPresent()).isTrue();
        User foundUser = foundUserOptional.get();
        Assertions.assertThat(foundUser.getLastName()).isEqualTo(user.getLastName());
    }
    @Test
    public void finds_customer_by_Email(){
        // given
        String email = "betaanna@gmail.com";

        User user1 = new User();
        user1.setEmail(email);

        // when
        Optional<User> foundUserOptional= userRepository.findByEmail(email);
        Assertions.assertThat(foundUserOptional.isEmpty()).isTrue();

        userRepository.save(user1);
        foundUserOptional = userRepository.findByEmail(email);

        //then
        Assertions.assertThat(foundUserOptional.isPresent()).isTrue();
        User foundUser1 = foundUserOptional.get();
        Assertions.assertThat(foundUser1.getEmail()).isEqualTo(user1.getEmail());
    }
}
