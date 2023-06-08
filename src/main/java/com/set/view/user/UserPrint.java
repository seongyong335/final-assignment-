package com.set.view.user;

public class UserPrint {
    public void printSuccessMessage(String successMessage) {
        switch (successMessage){
            case "register" : System.out.println("userId 생성 성공"); break;
            case "select" : System.out.println("로그인 성공"); break;
        }
    }

    public void printErrorMessage(String errorMessage) {
        switch (errorMessage){
            case "register" : System.out.println("userId 생성 실패"); break;
            case "select" : System.out.println("로그인 실패"); break;
        }
    }
}
