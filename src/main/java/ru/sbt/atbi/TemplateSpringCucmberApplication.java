package ru.sbt.atbi;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = {"@all"}, // фильтр запускаемых тестов по тегам, если надо исключмть пишем ~@all
        glue = "ru.sbt.atbi.steps", // пакет с реализацией шагов
        features = "src/java/resources/features", //папка со сценариями
        format = {"pretty", "json:target/cucumber.json", "html:target/cucumber.html"} //куда и как генерим отчеты
        //name = ^успешный  - фильтрует запускаемых тестов по названиям, которые соответствуют регулярке
)
@SpringBootApplication
@EnableAutoConfiguration
public class TemplateSpringCucmberApplication {

    public static void main(String[] args) {
        SpringApplication.run(TemplateSpringCucmberApplication.class, args);
    }
}
