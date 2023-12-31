package cmpt.safebet.models;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByNameAndPassword(String name, String password);
    List<User> findByName(String name);
    List<User> findByUid(int uid);
    
}
