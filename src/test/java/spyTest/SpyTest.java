package spyTest;

import spy.UserRepository;
import spy.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;


import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class SpyTest {

    @Spy
    private UserRepository userRepository = new UserRepository();

    @InjectMocks
    private UserService userService;

    @Test
    void withPartialMock() {
        doReturn("Mocked User").when(userRepository).findUserNameById(1);

        String name = userService.getGreeting(1);

        assertEquals("Hello Mocked User", name);

        verify(userRepository).exists(1); // реальный вызов
        verify(userRepository).findUserNameById(1); //подмененный вызов
    }

    @Test
    void realUser() {
        String result = userService.getGreeting(-1);

        assertEquals("User not found", result);
        verify(userRepository).exists(-1);
    }
}
