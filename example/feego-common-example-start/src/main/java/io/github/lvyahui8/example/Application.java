package io.github.lvyahui8.example;

import io.github.lvyahui8.configuration.annotations.ModuleLoggerAutoGeneration;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

/**
 * @author lvyahui (lvyahui8@gmail.com,lvyahui8@126.com)
 * @since 2020/2/16 22:08
 */
@SpringBootApplication
@ModuleLoggerAutoGeneration({"campaign","status"})
@EnableDubbo(scanBasePackages = "io.github.lvyahui8.example")
@PropertySource("classpath:dubbo-provider.properties")
public class Application {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class,args);
    }
}
