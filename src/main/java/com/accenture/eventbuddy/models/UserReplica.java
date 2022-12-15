import com.accenture.eventbuddy.auth.UserRole;
import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "user_table")
@Data
public class UserReplica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String username;
    String password;
    @Enumerated(EnumType.STRING)
    UserRole role;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof com.accenture.eventbuddy.auth.UserReplica user)) return false;
        return username.equals(user.username) && password.equals(user.password) && role == user.role;
    }
}