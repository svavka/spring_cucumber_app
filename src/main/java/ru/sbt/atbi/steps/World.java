package ru.sbt.atbi.steps;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("cucumber-glue")
@Data
public class World {
    private String expression;
    private String expressionResult;
}
