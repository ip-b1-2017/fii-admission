package com.ip_b1.fii.admission.Controllers;

public class Login {

    public static int checkCredentials(String username, String password){
        if(!checkUsername(username)){
            return 0; // username invalid
        } else if(!checkPassword(username, password)){
            return 1; // pass invalid
        } else return 2; // valid

    }

    private static boolean checkUsername(String username){
        //TODO verifica existenta in baza de date
        return false;
    }

    private static boolean checkPassword(String username, String password){
        //TODO verifica daca parola pentru user e corecta
        return false;
    }

}
