package com.summersama.pma.model;

/**
 * Created by woshi on 2016/3/28.
 */
public class PmaBean {
    private int pmarId;
    private String userName;
    private String password;

    public int getPmarId() {
        return pmarId;
    }

    public void setPmarId(int pmarId) {
        this.pmarId = pmarId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public PmaBean(){

    }
    public PmaBean(int pmarId,String userName,String password){
        super();
        this.pmarId=pmarId;
        this.userName=userName;
        this.password =password;}
        @Override
                public String toString(){
                        return "PmaBeam [pmarId="+pmarId+",userName="+userName+"," +
                                "password="+password+"]";

    }
}
