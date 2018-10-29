package com.scottlogic.competitionEngine.user;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public interface UserService {
    String getCurrentUser(HttpServletRequest request) throws ServletException;
}
