package com.java.bdaldemo;



import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.java.bdaldemo.bean.FaceDetectBean;
import com.java.bdaldemo.bean.ResultClass;
import com.java.bdaldemo.bean.face_list_bean;
import com.java.bdaldemo.bean.landmark72bean;
import com.java.bdaldemo.bean.landmarkbean;


import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * 人脸检测与属性分析
 */
public class FaceDetect {
    public double left_x;
    public double left_y;
    public double right_x;
    public double right_y;
    public double distance;


    public  String faceDetect() {

        String Filepath = "E:\\test01.jpg";
        ImageCompressUtil.ChangeImageSize(Filepath);
        /* String Filepath = file.getOriginalFilename();*/
        byte[] imageU = new byte[0];
        try {
            imageU = FileUtil.readFileByBytes(Filepath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String image = Base64Util.encode(imageU);
        System.out.println("image===>"+image);



        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/detect";
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("image", image);
            map.put("face_field", "age,beauty,landmark");
            map.put("image_type", "BASE64");
            String param = GsonUtils.toJson(map);

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = "填自己的access_token";
            String result = HttpUtil.post(url, accessToken, param);
            //解析JSON格式数据
            JSON json = JSON.parseObject(result);
            FaceDetectBean faceDetectBean = JSON.toJavaObject(json,FaceDetectBean.class);
            ResultClass resultClass =faceDetectBean.getResult();
            List<face_list_bean> face_list = resultClass.getFace_list();
            for(int i=0;i<face_list.size();i++){
                face_list_bean myface = face_list.get(i);
                List<landmark72bean> landmark72beanList = myface.getLandmark72();
                    landmark72bean landmark72_left = landmark72beanList.get(17);
                    landmark72bean landmark72_right = landmark72beanList.get(30);
                   System.out.println("x="+landmark72_left.getX()+",  y="+landmark72_left.getY());
                   System.out.println("x="+landmark72_right.getX()+",  y="+landmark72_right.getY());
                   left_x = landmark72_left.getX();
                   left_y = landmark72_left.getY();
                   right_x = landmark72_right.getX();
                   right_y = landmark72_right.getY();
                   double dx = (left_x - right_x);
                   double dy = (left_y - right_y);
                   distance = Math.sqrt(dx*dx + dy*dy );
                System.out.println("distance===>"+distance);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        FaceDetect fd = new FaceDetect();
        fd.faceDetect();
    }


}