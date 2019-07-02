package data.entities;

import java.util.Date;

public class ExtendedUser extends User{
    private String firstName;
    private String secondName;
    private String email;
    private String country;
    private Date birth;

    public ExtendedUser(String nickname, String password) {
        super(nickname, password);
    }
}
