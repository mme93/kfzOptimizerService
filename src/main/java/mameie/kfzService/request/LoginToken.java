package mameie.kfzService.request;

public class LoginToken {

    private String token;
    private boolean login;

    public LoginToken(String token, boolean login) {
        this.token = token;
        this.login = login;
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
}
