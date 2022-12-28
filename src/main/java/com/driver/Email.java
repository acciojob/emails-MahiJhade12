package com.driver;

import java.util.HashMap;
import java.util.HashSet;

public class Email {

    private String emailId;
    private String password;
    private boolean conditionCheck;

    public Email(String emailId) {
        this.emailId = emailId;
        this.password = "Accio@123";
        conditionCheck=false;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    private boolean conditionCheck(String newPassword) {
        int n = newPassword.length();
        String inputPassword = newPassword;
        int uppercase = 0;
        int lowercase = 0;
        int specialcharacters = 0;
        int digits = 0;
        char[] Password = inputPassword.toCharArray();
        for (int index = 0; index < inputPassword.length(); index++) {
            if (Character.isUpperCase(Password[index])) {
                uppercase = 1;
            }
            if (Character.isLowerCase(Password[index])) {
                lowercase = 1;
            }
            if (Character.isDigit(Password[index])) {
                digits = 1;
            }
        }
        if (inputPassword.contains("~") || inputPassword.contains("!") || inputPassword.contains("@")
                || inputPassword.contains("#") || inputPassword.contains("$") || inputPassword.contains("%")
                || inputPassword.contains("^") || inputPassword.contains("&") || inputPassword.contains("*")) ;
        {
            specialcharacters = 1;
        }

        if (inputPassword.length() >= 8 && (uppercase == 1) && (lowercase == 1) && (digits == 1) && (specialcharacters == 1)) {
            return true;
        }
        return false;
    }
    

    public void changePassword(String oldPassword, String newPassword) {
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
        String currPassword = getPassword();
        if (oldPassword != currPassword) {
            System.out.println("Old password incorrect");
            return;
        }
        else {
            if(conditionCheck(newPassword)){
                System.out.println("New Password set successfully");
                setPassword(newPassword);
            }
        }
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

   


}
