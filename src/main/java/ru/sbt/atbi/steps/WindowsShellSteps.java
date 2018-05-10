package ru.sbt.atbi.steps;

import cucumber.api.java.ru.Допустим;
import cucumber.api.java.ru.Если;
import cucumber.api.java.ru.То;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sbt.atbi.TemplateSpringCucmberApplication;
import ru.sbt.atbi.config.MainConfiguration;
import ru.sbt.atbi.services.IWindowsShellService;

@ContextConfiguration(classes = MainConfiguration.class)
@RunWith(SpringRunner.class)
public class WindowsShellSteps extends Step {

    @Autowired
    IWindowsShellService windowsShellService;

    @Autowired
    World world;

    @Допустим("^в системе существует комнандный интерпритатор CMD$")
    public void checkShellService() {
        Assert.assertTrue(windowsShellService.checkShell());
    }

    @Если("^введена команда (\\w.*)$")
    public void setShellCommand(String shellCommand) {
        world.setExpression(shellCommand);
        world.setExpressionResult(windowsShellService.execCommand(shellCommand));
    }


    @То("^ответом будет (\\w.*)$")
    public void checkExpressionResult(String availResult) {
        Assert.assertEquals(String.format(
                "Ответов выражения %s должен быть %s, по факту ответ %s",
                world.getExpression(), availResult, world.getExpressionResult()),
                world.getExpressionResult(), availResult);

    }
}
