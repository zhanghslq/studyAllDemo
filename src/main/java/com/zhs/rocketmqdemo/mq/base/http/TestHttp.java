package com.zhs.rocketmqdemo.mq.base.http;

import com.alibaba.fastjson.JSON;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: zhs
 * @date: 2020/6/5 21:14
 */
public class TestHttp {
    public static void main(String[] args) throws IOException {


        String s = encodeFile("E://test.doc");

        String url = "http://test.cvhr.cn/cvparse_base64_v20200601";
        Map<String, String> params = new HashMap<String, String>();
        params.put("cv_text", s);
        params.put("file_name", "test.doc");
        params.put("is_return_txt", "1");

        String res = EntityUtils.toString(Request.Post(url).addHeader("user-id","test20200605")
                .addHeader("user-password","test20200605").bodyString(JSON.toJSONString(params), ContentType.APPLICATION_JSON).execute().returnResponse().getEntity());
        System.out.println(res);

    }
    public static String encodeFile(File file) throws IOException {
        byte[] readFileToByteArray = FileUtils.readFileToByteArray(file);
        return Base64.encodeBase64String(readFileToByteArray);
    }

    public static String encodeFile(String filePath) throws IOException {
        return encodeFile(new File(filePath));
    }
}
