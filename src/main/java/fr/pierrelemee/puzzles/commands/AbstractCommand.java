package fr.pierrelemee.puzzles.commands;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

public abstract class AbstractCommand {

    protected BufferedReader in;
    protected PrintStream out;

    public AbstractCommand() {
        this(System.in, System.out);
    }

    public AbstractCommand(InputStream in, PrintStream out) {
        this.in = new BufferedReader(new InputStreamReader(in));
        this.out = out;
    }

    public abstract String getName();

    public abstract void run() throws Exception;
}
