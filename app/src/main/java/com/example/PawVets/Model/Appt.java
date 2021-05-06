package com.example.PawVets.Model;

public class Appt {
    private String vetName;
    private String petName;
    private String selectDate;
    private String selectTime;

public Appt() {

}

public Appt(String vetname, String petname, String selecttime, String selectdate) {
    vetName = vetname;
    petName = petname;
    selectDate = selectdate;
    selectTime = selecttime;
}

public String getVetName() {
    return vetName;
}

public void setVetName(String vetname) {
    vetName = vetname;
}

public String getPetName() {
    return petName;
}

public void setPetName(String petname) {
    petName = petname;
}

    public String getSelectDate() {
        return selectDate;
    }

    public void setSelectDate(String selectdate) {
        selectDate = selectdate;
    }

    public String getSelectTime() {
        return selectTime;
    }

    public void setSelectTime(String selecttime) {
        selectTime = selecttime;
    }

}

