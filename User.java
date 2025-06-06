/**
 * Системд нэвтрэх хэрэглэгчийн мэдээллийг хадгалах класс.
 * Хэрэглэгчийн үндсэн мэдээлэл болох и-мэйл, нэр, нууц үгийг агуулна.
 */
public class User {
    private String email;
    private String name;
    private String password;

    /**
     * Хэрэглэгчийн обьектыг и-мэйл, нэр, нууц үгээр үүсгэнэ.
     *
     * @param email хэрэглэгчийн и-мэйл хаяг (уникаль утга)
     * @param name хэрэглэгчийн бүтэн нэр
     * @param password хэрэглэгчийн нууц үг (6-аас дээш тэмдэгтээс бүрдсэн)
     * @throws IllegalArgumentException параметрүүд хоосон эсвэл null байвал
     */
    public User(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

    /**
     * Хэрэглэгчийн и-мэйл хаягийг буцаана.
     *
     * @return хэрэглэгчийн и-мэйл хаяг
     */
    public String getEmail() { return email; }

    /**
     * Хэрэглэгчийн бүтэн нэрийг буцаана.
     *
     * @return хэрэглэгчийн нэр
     */
    public String getName() { return name; }

    /**
     * Хэрэглэгчийн нууц үгийг буцаана.
     * Анхаар: Нууц үгийг шууд хэвлэх эсвэл лог хийхгүй байхыг зөвлөж байна.
     *
     * @return хэрэглэгчийн нууц үг
     */
    public String getPassword() { return password; }
}
