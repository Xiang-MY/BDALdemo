package com.java.bdaldemo.bean;

/**
 * 人脸检测Javabean对象
 * 直接得到接口返回数据转成Java对象
 * @author 小帅丶
 */
public class FaceDetectBean {
    public FaceDetectBean(){

    }

    public FaceDetectBean(int error_code, String error_msg, int log_id, int timestamp, int cached, ResultClass result) {
        this.error_code = error_code;
        this.error_msg = error_msg;
        this.log_id = log_id;
        this.timestamp = timestamp;
        this.cached = cached;
        this.result = result;
    }

    /**
     "error_code":0,
     "error_msg":"SUCCESS",
     "log_id":2473751407,
     "timestamp":1646563273,
     "cached":0,
     "result":{
     */
    private int error_code;
    private String error_msg;
    private int log_id;
    private int timestamp;
    private int cached;
    private ResultClass result;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getError_msg() {
        return error_msg;
    }

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public int getLog_id() {
        return log_id;
    }

    public void setLog_id(int log_id) {
        this.log_id = log_id;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public int getCached() {
        return cached;
    }

    public void setCached(int cached) {
        this.cached = cached;
    }

    public ResultClass getResult() {
        return result;
    }

    public void setResult(ResultClass result) {
        this.result = result;
    }

}


