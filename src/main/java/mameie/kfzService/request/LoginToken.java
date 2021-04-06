package mameie.kfzService.request;

public class LoginToken {

    private String token, email;
    private boolean login;

    public LoginToken(String token, boolean login) {
        this.token = token;
        this.login = login;
    }

    public LoginToken(String token, boolean login, String email) {
        this.token = token;
        this.login = login;
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
