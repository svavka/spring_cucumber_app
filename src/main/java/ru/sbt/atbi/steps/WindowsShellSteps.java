package ru.sbt.atbi.steps;

import cucumber.api.java.ru.Допустим;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import ru.sbt.atbi.services.IWindowsShellService;

public class WindowsShellSteps extends Step {

    @Autowired
    IWindowsShellService windowsShellService;

    @Допустим("^в системе существует комнандный интерпритатор CMD$")
    public void checkShellService() {
        Assert.assertTrue(windowsShellService.checkShell());
    }
}
