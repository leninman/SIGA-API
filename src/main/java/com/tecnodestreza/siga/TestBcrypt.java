import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
public class TestBcrypt {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String raw = "director";
        String hash = "$2a$10$jhhc/FL4CzvRkn365duK4.QO4OiT0UE8aNNSSYl1ZT0hQtsIhASRS";
        System.out.println("Matches: " + encoder.matches(raw, hash));
    }
}
