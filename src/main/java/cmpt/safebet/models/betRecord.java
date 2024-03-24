package cmpt.safebet.models;

import jakarta.persistence.*;

@Entity
@Table(name = "betRecord")
public class betRecord {
    
    @Id
    private int betID;
    private String username;
    private String winningTeam;
    private float betOdds;
    private int gainLoss;

    public betRecord(){

    }
    public betRecord(int betID, String username, String winningTeam, float betOdds, int gainLoss){
        this.betID = betID;
        this.username = username;
        this.winningTeam = winningTeam;
        this.betOdds = betOdds;
        this.gainLoss = gainLoss;
    }
    public int getBetId(){
        return betID;
    }
    public void setBetId(int betID){
        this.betID = betID;
    }
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getWinningTeam(){
        return winningTeam;
    }
    public void setWinningTeam(String winningTeam){
        this.winningTeam = winningTeam;
    }
    public float getBetOdds(){
        return betOdds;
    }
    public void setBetOdds(float betOdds){
        this.betOdds = betOdds;
    }
    public int getGainLoss(){
        return gainLoss;
    }
    public void setGainLoss(int gainLoss){
        this.gainLoss = gainLoss;
    }
}
