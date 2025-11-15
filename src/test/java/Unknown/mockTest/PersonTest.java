package Unknown.mockTest;
import Unknown.mocks.Computer;
import Unknown.mocks.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class PersonTest {

    @Mock
    private Computer computer; //создаем мок

    @InjectMocks
    private Person person; //внедряем мок

    @Test
    void  test() {
        when(computer.getModel()).thenReturn("MacBook Pro"); //настройка мок

        //проверка
        String result =  person.getComputer();
        assertEquals("MacBook Pro", result);

        //Убедиться, что метод вызывался
        verify(computer).getModel();
    }
}
