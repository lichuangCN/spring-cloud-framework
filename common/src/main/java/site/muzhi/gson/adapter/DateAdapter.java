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
public class DateAdapter extends TypeAdapter<Date> {

    /**
     * 日期个数
     */
    private String pattern;

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public void write(JsonWriter out, Date value) throws IOException {
        if (value != null) {
            if (pattern != null && !"".equals(pattern)) {
                out.value(DateUtil.format(value, pattern));
            } else {
                out.value(DateUtil.format(value, DateUtil.DEFAULT_DATE_PATTERN));
            }
        } else {
            out.value("");
        }
    }

    @Override
    public Date read(JsonReader in) throws IOException {
        String str = in.nextString();
        Date date = null;
        try {
            if (pattern != null && !"".equals(pattern)) {
                date = DateUtil.parse(str, pattern);
            } else {
                date = DateUtil.parse(str, DateUtil.DEFAULT_DATE_PATTERN);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
