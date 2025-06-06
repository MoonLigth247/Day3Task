import static org.junit.Assert.*;
import org.junit.Test;

public class UserTest {

    @Test
    public void testUserInitialization() {
        User user = new User("test@example.com", "Бат", "mypassword123");

        System.out.println("=== User тест ===");
        System.out.println("Email: " + user.getEmail());
        System.out.println("Нэр: " + user.getName());
        System.out.println("Нууц үг: " + user.getPassword());

        assertEquals("test@example.com", user.getEmail());
        assertEquals("Бат", user.getName());
        assertEquals("mypassword123", user.getPassword());
    }
}




