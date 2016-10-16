package fr.pierrelemee.puzzles.commands;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

public abstract class AbstractCommand {

    protected BufferedReader in;
    protected PrintStream out;

    public abstract String getName();

    public void run() throws Exception {
        this.run(System.in, System.out);
    }

    public void run(InputStream in, PrintStream out) throws Exception {
        this.in = new BufferedReader(new InputStreamReader(in));
        this.out = out;
        this.execute();
    }

    protected abstract void execute() throws Exception;
}
