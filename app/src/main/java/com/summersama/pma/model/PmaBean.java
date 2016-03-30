package com.summersama.pma.model;

/**
 * Created by woshi on 2016/3/30.
 */

public class PmaBean {
    private int pmaId;
    private String userName;
    private String password;
    private String other;

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public int getPmaId() {
        return pmaId;
    }

    public void setPmaId(int pmarId) {
        this.pmaId = pmaId;
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
    public PmaBean(int pmaId,String userName,String password,String other){
        super();
        this.pmaId=pmaId;
        this.userName=userName;
        this.password =password;}
    @Override
    public String toString(){
        return "PmaBeam [pmarId="+pmaId+",userName="+userName+"," +
                "password="+password+"]";

    }
}
