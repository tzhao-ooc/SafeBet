package cmpt.safebet.models;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface currentBetRepository extends JpaRepository<currentBet, Integer> {
    List<currentBet> findByUsername(String username);
    
}