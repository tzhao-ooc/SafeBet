package cmpt.safebet.models;

public class Users {
    private String username;
    private String password;
    private String email;
    private int rolls;

    public Users() {
    }

    public Users(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    
}
