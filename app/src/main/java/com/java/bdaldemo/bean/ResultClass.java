package com.java.bdaldemo.bean;

import com.java.bdaldemo.bean.face_list_bean;

import java.util.List;

public class ResultClass {
    /*
    "face_num":1,
    "face_list":[]
     */
    private int face_num;
    private List<face_list_bean> face_list;

    public List<face_list_bean> getFace_list() {
        return face_list;
    }

    public void setFace_list(List<face_list_bean> face_list) {
        this.face_list = face_list;
    }

    public int getFace_num() {
        return face_num;
    }

    public void setFace_num(int face_num) {
        this.face_num = face_num;
    }

}