package com.grc.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class CommonTools {
    public static Timestamp getCurrentTime(){
        return new Timestamp(System.currentTimeMillis());
    }
    public static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
}
