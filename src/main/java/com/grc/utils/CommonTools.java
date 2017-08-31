package com.grc.utils;

import java.sql.Timestamp;

public class CommonTools {
    public static Timestamp getCurrentTime(){
        return new Timestamp(System.currentTimeMillis());
    }
}
