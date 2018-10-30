package com.krhonos.auth.service;

public interface SecuriteService {

    String findLoggedInUsername();

    void autologin(String utilisateurnom, String password);
}
