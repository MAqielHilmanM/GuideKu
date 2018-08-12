package guideku.bisfor.guideku.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Tools {
    public static String dateTimeToTimeFormat(Date date){
        String format = "HH:mm";
        DateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date);
    }

}
