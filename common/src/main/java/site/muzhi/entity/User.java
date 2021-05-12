package site.muzhi.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author lichuang
 * @date 2021/05/10
 * @description
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private Integer age;

    private Date date;

    private List<User> children;

    public User() {
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public User(String name, Integer age, Date date) {
        this.name = name;
        this.age = age;
        this.date = date;
    }
}
