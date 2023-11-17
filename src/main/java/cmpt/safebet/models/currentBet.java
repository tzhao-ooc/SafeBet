package cmpt.safebet.models;

import jakarta.persistence.*;


// current bets is not yet able to create relationships with other
// entities. currentBets has no foreign key!

@Entity
@Table(name = "currentBets")
public class currentBet {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int betID;
    private String gameID;
    private int betAmount;
    private String username;
    private String betTeam;
    private String betMatchup;
    private float betOdds;

    public currentBet() {

    }
    public currentBet(String gameID, int betAmount, String username, String betTeam, String betMatchup, float betOdds) {
        this.gameID = gameID;
        this.betAmount = betAmount;
        this.username = username;
        this.betTeam = betTeam;
        this.betMatchup = betMatchup;
        this.betOdds = betOdds; 
    }
    public String getGameID() {
        return gameID;
    }
    public void setGameID(String gameID) {
        this.gameID = gameID;
    }
    public int getBetId() {
        return betID;
    }
    public void setBetId(int betID) {
        this.betID = betID;
    }
    public int getBetAmount() {
        return betAmount;
    }
    public void setBetAmount(int betAmount) {
        this.betAmount = betAmount;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getBetTeam() {
        return betTeam;
    }
    public void setBetTeam(String betTeam) {
        this.betTeam = betTeam;;
    }
    public String getBetMatchup() {
        return betMatchup;
    }
    public void setBetMatchup(String betMatchup) {
        this.betMatchup = betMatchup;
    }
    public float getBetOdds() {
        return betOdds;
    }
    public void setBetOdds(float betOdds) {
        this.betOdds = betOdds;
    }

}
    


