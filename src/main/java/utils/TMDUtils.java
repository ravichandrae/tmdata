package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by renaganti on 5/31/16.
 */
public class TMDUtils {
    public static String getCurrentDate() {
        Date updatedDate = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return simpleDateFormat.format(updatedDate);
    }
}
