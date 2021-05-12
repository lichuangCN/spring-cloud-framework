## 毕业版本依赖
|Spring Cloud Version | Spring Cloud Alibaba Version |  Spring Boot Version  |
|:----    |:---|:----- |   
|Hoxton.SR8 | 2.2.5.RELEASE | 2.3.2.RELEASE |

## 组件版本依赖					
|Spring Cloud Alibaba Version| Sentinel Version |  Nacos Version  | RocketMQ Version | Dubbo Version | Seata Version |
|:---- |:--- |:--- |:---   |:---|:----- |   
|2.2.5.RELEASE | 1.8.0 | 1.4.1 | 4.4.0 | 2.7.8 | 1.3.0 |

## 版本问题

### 1.rocketmq-spring-boot-starter版本

rocketmq-spring-boot在 2.1.0版本中对`@RocketMQTransactionListener`注解有重大调整，暂以RocketMQ4.4.0版本为基准。

参考：【1】https://blog.csdn.net/z69183787/article/details/109958380
```xml
<dependency>
    <groupId>org.apache.rocketmq</groupId>
    <artifactId>rocketmq-spring-boot-starter</artifactId>
    <version>${rocketmq.version}</version>
    <!--
        2.0.2对应rocketmq 4.4.0
        2.0.4对应rocketmq 4.5.2
        2.1.0对应rocketmq 4.6.0
     -->
</dependency>
```


