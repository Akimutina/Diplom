package ru.iteco.fmhandroid.ui.activity;

import org.joda.time.DateTime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DataHelper {
    public User getValidUser() {
        return new User("login2", "password2");
    }

    public User getNotValidUser() {
        return new User("login", "password");
    }

    public class User {
        private final String login;
        private final String password;

        public User(String login, String password) {
            this.login = login;
            this.password = password;
        }

        public String getLogin() {
            return login;
        }

        public String getPassword() {
            return password;
        }
    }

}
