package com.lrving.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
* @Description: 字符流和字节流之间转换
* @Author: luolang
* @Date: 2019/2/23
*/
public class ByteToInputStream {  
  
    public static final InputStream byte2Input(byte[] buf) {  
        return new ByteArrayInputStream(buf);  
    }  
  
    public static final byte[] input2byte(InputStream inStream)  
            throws IOException {  
        ByteArrayOutputStream swapStream = new ByteArrayOutputStream();  
        byte[] buff = new byte[100];  
        int rc = 0;  
        while ((rc = inStream.read(buff, 0, 100)) > 0) {  
            swapStream.write(buff, 0, rc);  
        }  
        byte[] in2b = swapStream.toByteArray();  
        return in2b;  
    }  
  
} 