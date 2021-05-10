package site.muzhi;

import com.google.gson.Gson;
import site.muzhi.result.Result;
import site.muzhi.result.ResultFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lichuang
 * @date 2021/05/10
 * @description
 */
public class MainTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        //Result<List<Integer>> r = ResultFactory.ok(list);

        Result<List<Integer>> result = ResultFactory.ok(list);

        Result<Object> ok = ResultFactory.ok();
        Gson gson = new Gson();
        System.out.println(gson.toJson(result));
        System.out.println(gson.toJson(ok));
    }
}
