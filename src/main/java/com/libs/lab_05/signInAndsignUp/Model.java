package com.libs.lab_05.signInAndsignUp;

public class Model {

    private String userName;
    private String pass;
    private String confirmPass;
    
    public Model(){
        userName = null;
        pass = null;
        confirmPass = null;
    }
    
    public String getUserName(){
        return userName;
    }
    
    public void setUserName(String _userName){
        userName = _userName;
    }
    
    public String getConfirmPass() {
        return confirmPass;
    }

    public String getPass() {
        return pass;
    }

    public void setConfirmPass(String confirmPass) {
        this.confirmPass = confirmPass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
}
