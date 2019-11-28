package cn.wtyoha.company_background_system.domain;

import java.util.HashSet;
import java.util.Set;

public class Traveller {
    // 旅客表
    String id;
    String name;
    String sex;
    String PhoneNum;
    int credentialsType; // 证件类型 0 身份证， 1 护照， 2 军官证
    String credentialsTypeStr;
    String credentialsNum;
    int travellerType; // 旅客类型 0 成人， 1 儿童
    String travellerTypeStr;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNum() {
        return PhoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        PhoneNum = phoneNum;
    }

    public int getCredentialsType() {
        return credentialsType;
    }

    public void setCredentialsType(int credentialsType) {
        this.credentialsType = credentialsType;
        switch (credentialsType) {
            case 0:
                credentialsTypeStr = "身份证";
                break;
            case 1:
                credentialsTypeStr = "护照";
                break;
            case 2:
                credentialsTypeStr = "军官证";
        }
    }

    public String getCredentialsTypeStr() {
        return credentialsTypeStr;
    }

    public void setCredentialsTypeStr(String credentialsTypeStr) {
        this.credentialsTypeStr = credentialsTypeStr;
        if ("身份证".equals(credentialsTypeStr)) {
            credentialsType = 0;
        }
        if ("护照".equals(credentialsTypeStr)) {
            credentialsType = 1;
        }
        if ("军官证".equals(credentialsTypeStr)) {
            credentialsType = 2;
        }
    }

    public String getCredentialsNum() {
        return credentialsNum;
    }

    public void setCredentialsNum(String credentialsNum) {
        this.credentialsNum = credentialsNum;
    }

    public int getTravellerType() {
        return travellerType;
    }

    public void setTravellerType(int travellerType) {
        this.travellerType = travellerType;
        switch (travellerType) {
            case 0:
                travellerTypeStr = "成人";
                break;
            case 1:
                travellerTypeStr = "儿童";
        }
    }

    public String getTravellerTypeStr() {
        return travellerTypeStr;
    }

    public void setTravellerTypeStr(String travellerTypeStr) {
        this.travellerTypeStr = travellerTypeStr;
        if ("成人".equals(travellerTypeStr)) {
            travellerType = 0;
        }
        if ("儿童".equals(travellerTypeStr)) {
            travellerType = 1;
        }
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return id == null ? (((Traveller) obj).getId() == null) : id.equals(((Traveller) obj).getId());
    }

    @Override
    public String toString() {
        return "Traveller{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", PhoneNum='" + PhoneNum + '\'' +
                ", credentialsType=" + credentialsType +
                ", credentialsTypeStr='" + credentialsTypeStr + '\'' +
                ", credentialsNum='" + credentialsNum + '\'' +
                ", travellerType=" + travellerType +
                ", travellerTypeStr='" + travellerTypeStr + '\'' +
                '}';
    }
}

