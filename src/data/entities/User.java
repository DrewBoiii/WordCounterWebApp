package data.entities;

public class User {
    private static int id;
    private String nickname;
    private String password;

    public User(String nickname, String password){
        id++;
        this.nickname = nickname;
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static int getId() {
        return id;
    }
}
