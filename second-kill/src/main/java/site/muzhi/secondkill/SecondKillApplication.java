package site.muzhi.secondkill;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan("site.muzhi.secondkill.mapper")
public class SecondKillApplication {

    @Bean
    public Snowflake snowflake() {
        Snowflake snowflake = IdUtil.getSnowflake(1, 1);
        return snowflake;
    }

    public static void main(String[] args) {
        SpringApplication.run(SecondKillApplication.class, args);
    }

}
