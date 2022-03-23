package com.java.bdaldemo.bean;

import java.util.List;

public class face_list_bean{
    /*
    "face_token":"8ad51d2c97a022efa8ffb5f789fc9658",
    "location":{
        "left":99.57,
        "top":112.13,
        "width":258,
        "height":230,
        "rotation":-4   },
    "face_probability":1,
    "angle":{
        "yaw":-4.94,
        "pitch":22.63,
        "roll":-6.86  },
    "age":22,
    "beauty":78.24,
    "landmark":[
        {"x":172.24,"y":148.64},
        {"x":280.38,"y":140.28},
        {"x":229.78,"y":222.21},
        {"x":235.31,"y":264.27}  ],
    "landmark72":[{....}]
     */
    private String face_token;
    private locationbean location;
    private int face_probability;
    private  anglebean angle;
    private  int age;
    private double beauty;
    private List<landmarkbean> landmark;
    private List<landmark72bean> landmark72;

    public String getFace_token() {
        return face_token;
    }

    public void setFace_token(String face_token) {
        this.face_token = face_token;
    }

    public locationbean getLocation() {
        return location;
    }

    public void setLocation(locationbean location) {
        this.location = location;
    }

    public int getFace_probability() {
        return face_probability;
    }

    public void setFace_probability(int face_probability) {
        this.face_probability = face_probability;
    }

    public anglebean getAngle() {
        return angle;
    }

    public void setAngle(anglebean angle) {
        this.angle = angle;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getBeauty() {
        return beauty;
    }

    public void setBeauty(double beauty) {
        this.beauty = beauty;
    }

    public List<landmarkbean> getLandmark() {
        return landmark;
    }

    public void setLandmark(List<landmarkbean> landmark) {
        this.landmark = landmark;
    }

    public List<landmark72bean> getLandmark72() {
        return landmark72;
    }

    public void setLandmark72(List<landmark72bean> landmark72) {
        this.landmark72 = landmark72;
    }

}
