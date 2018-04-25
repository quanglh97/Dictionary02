package com.example.khaik.Model;

import java.io.Serializable;

public class Friend implements Serializable{
    public String MSSV;
    public String TENSV;

    public Friend(String MSSV, String TENSV) {
        this.MSSV = MSSV;
        this.TENSV = TENSV;
    }

    public Friend() {
    }

    public String getMSSV() {
        return MSSV;
    }

    public void setMSSV(String MSSV) {
        this.MSSV = MSSV;
    }

    public String getTENSV() {
        return TENSV;
    }

    public void setTENSV(String TENSV) {
        this.TENSV = TENSV;
    }
}
