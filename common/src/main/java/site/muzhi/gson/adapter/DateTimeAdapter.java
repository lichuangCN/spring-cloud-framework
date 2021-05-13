package site.muzhi.gson.adapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import site.muzhi.util.DateUtil;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

/**
 * @author lichuang
 * @date 2021/05/13
 * @description
 */
public class DateTimeAdapter extends TypeAdapter<Date> {
    
    @Override
    public void write(JsonWriter out, Date value) throws IOException {
        if (value != null) {
            out.value(DateUtil.format(value));
        } else {
            out.value("");
        }
    }

    @Override
    public Date read(JsonReader in) throws IOException {
        String str = in.nextString();
        Date date = null;
        try {
            date = DateUtil.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
