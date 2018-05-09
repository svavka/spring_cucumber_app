package ru.sbt.atbi.services;

import java.io.IOException;

public interface IWindowsShellService {
    String execCommand(String command) throws IOException;
    public boolean checkShell();
}
