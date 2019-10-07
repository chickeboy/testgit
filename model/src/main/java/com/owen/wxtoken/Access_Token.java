package com.owen.wxtoken;

public class Access_Token {
    private Integer id;

    private String accessToken;

    private int expireIn;

    private long expireOut;

    public Access_Token(String accessToken, int expireIn) {
        this.accessToken = accessToken;
        this.expireIn = expireIn;
        this.expireOut  = System.currentTimeMillis()+expireIn*1000;
    }

    public Access_Token() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public int getExpireIn() {
        return expireIn;
    }

    public void setExpireIn(int expireIn) {
        this.expireIn = expireIn;
    }

    public long getExpireOut() {
        return expireOut;
    }

    public void setExpireOut(long expireOut) {
        this.expireOut = expireOut;
    }
}