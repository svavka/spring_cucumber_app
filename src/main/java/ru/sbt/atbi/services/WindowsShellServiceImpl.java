package ru.sbt.atbi.services;


import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

@Service
public class WindowsShellServiceImpl implements IWindowsShellService {
    private static final String CMD_INTEPRITATOR_INIT = "cmd /c";

    public String execCommand(String command) throws IOException {
        Scanner s = null;
        s = new Scanner(Runtime.getRuntime().exec(String.format("%s %s", CMD_INTEPRITATOR_INIT, command)).getInputStream()).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }

    public boolean checkShell() {
        Scanner s = null;
        try {
            s = new Scanner(Runtime.getRuntime().exec(CMD_INTEPRITATOR_INIT).getInputStream()).useDelimiter("\\A");
        } catch (IOException e) {
            return false;
        }
        return true;
    }
}
