package com.hfad.myvolley;

public class DeveloperList {
    private String login, avatar_url, html_url;

    public DeveloperList(String login, String avatar_url, String html_url){
        this.login = login;
        this.avatar_url = avatar_url;
        this.html_url = html_url;
    }
    public String getLogin() {
        return login;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public String getHtml_url() {
        return html_url;
    }

}
