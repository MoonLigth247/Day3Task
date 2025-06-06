/**
 * Системийн хэрэглэгчийн мэдээллийг хадгалах класс.
 */
public class User {
    private String email;
    private String name;
    private String password;

    /**
     * Хэрэглэгчийн шинэ обьектыг үүсгэнэ.
     *
     * @param email хэрэглэгчийн и-мэйл хаяг
     * @param name хэрэглэгчийн бүтэн нэр
     * @param password хэрэглэгчийн нууц үг
     */
    public User(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

    /**
     * @return хэрэглэгчийн и-мэйл хаяг
     */
    public String getEmail() { return email; }

    /**
     * @return хэрэглэгчийн бүтэн нэр
     */
    public String getName() { return name; }

    /**
     * @return хэрэглэгчийн нууц үг
     */
    public String getPassword() { return password; }
}
