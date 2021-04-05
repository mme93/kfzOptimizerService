package mameie.kfzService.request;

public class UserLoginAnswer {
    String email,password;
    boolean isLogin;

    public UserLoginAnswer(String email, String password, boolean isLogin) {
        this.email = email;
        this.password = password;
        this.isLogin = isLogin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }
}
