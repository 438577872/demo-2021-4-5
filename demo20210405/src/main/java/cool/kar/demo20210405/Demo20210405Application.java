package cool.kar.demo20210405;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cool.kar.demo20210405.mapper")
public class Demo20210405Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo20210405Application.class, args);
	}

}
