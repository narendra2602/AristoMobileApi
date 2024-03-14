package com.aristomobileapi.service;
public interface TokenBlacklist {
    void addToBlacklist(String token);
    boolean isBlacklisted(String token);
}

