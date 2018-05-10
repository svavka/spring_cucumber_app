package ru.sbt.atbi.services;


import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Scanner;

@Service
public class WindowsShellServiceImpl implements IWindowsShellService {
    private static final String CMD_SHELL_INIT = "cmd /c";

    public String execCommand(String command) {
        Scanner s;
        try {
            s = new Scanner(Runtime.getRuntime().exec(String.format("%s %s", CMD_SHELL_INIT, command)).getInputStream()).useDelimiter("\\A");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return s.hasNext() ? s.next() : "";
    }

    public boolean checkShell() {
        try {
            new Scanner(Runtime.getRuntime().exec(CMD_SHELL_INIT).getInputStream()).useDelimiter("\\A");
        } catch (IOException e) {
            return false;
        }
        return true;
    }
}
