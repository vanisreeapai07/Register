package com.example.register;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class DataModel extends RealmObject {

    @PrimaryKey
    long id;
    String attendance1;
    String attendance2;

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    String name1;
    String name2;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAttendance1() {
        return attendance1;
    }

    public void setAttendance1(String attendance1) {
        this.attendance1 = attendance1;
    }

    public String getAttendance2() {
        return attendance2;
    }

    public void setAttendance2(String attendance2) {
        this.attendance2 = attendance2;
    }



}
