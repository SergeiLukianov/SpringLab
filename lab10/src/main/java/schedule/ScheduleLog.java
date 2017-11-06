package schedule;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

public class ScheduleLog {
    private static StringBuffer value = new StringBuffer();

    public static void append(String str){
        value.append(str);
    }

    public static String getStringValue(){
        return value.toString();
    }

    public static void clear(){
        value = new StringBuffer();
    }

}