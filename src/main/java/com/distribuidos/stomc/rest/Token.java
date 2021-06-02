package com.distribuidos.stomc.rest;

public class Token {

    private String account;
    private String token;

    public Token(String account, String token) {
        this.account = account;
        this.token = token;
    }

    public String getAccount(){
        return this.account;
    }

    public void setAccount(String account){
        this.account = account;
    }

    public String getToken(){
        return this.token;
    }

    public void setToken(String token){
        this.token = token;
    }
}
