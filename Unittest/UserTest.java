import static org.junit.Assert.*;
import org.junit.Test;

public class UserTest {
    
    @Test
    public void testValidUserCreation() {
        
        String email = "user@gmail.com";
        String name = "Бат";
        String password = "password123";
        
        
        User user = new User(email, name, password);
        assertEquals(email, user.getEmail());
        assertEquals(name, user.getName());
        
        assertEquals(password, user.getPassword());
        
        System.out.println(" Хэрэглэгч амжилттай үүслээ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullEmail() {
        
        new User(null, "Бат", "password123");
        
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyEmail() {
        
        new User("", "Бат", "password123");
        
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShortPassword() {
        String shortPassword = "pass1";
        
        new User("user@gmail.com", "Бат", shortPassword);
        
    }

    @Test
    public void testMinimumLengthPassword() {
        String minPassword = "pass12";
        
        User user = new User("user@gmail.com", "Бат", minPassword);
        
        assertEquals(minPassword, user.getPassword());
    }
}
