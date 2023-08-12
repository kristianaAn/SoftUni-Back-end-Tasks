package com.example.softuni_game_store.constants;

public enum Constants {
    ;
    public final static String REGISTER_USER = "RegisterUser";
    public final static String LOGIN = "LoginUser";
    public final static String LOGOUT = "Logout";
    public final static String CLOSE = "Close";
    public final static String EMAIL_REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

    public final static String PASSWORD_REGEX = "(?=^.{6,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$";

    public final static String DUPLICATE_EMAIL = "Email already exists";

    public final static String SUCCESSFUL_REGISTRATION = "%s was registered";
}
