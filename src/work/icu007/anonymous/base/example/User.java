package work.icu007.anonymous.base.example;

/**
 * @Author {xiheya}
 * @Date: 2024/04/08/ 23:00
 * @Description
 */
public class User {
    private String userName;
    private String phoneNumber;
    private String password;
    private String confirmPassword;
    private String email;
    private String sex;
    private String birthday;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public User() {
    }

    public User(String name, String phoneNumber, String password, String confirmPassword, String email, String sex, String birthday) {
        this.userName = name;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.email = email;
        this.sex = sex;
        this.birthday = birthday;
    }
}
