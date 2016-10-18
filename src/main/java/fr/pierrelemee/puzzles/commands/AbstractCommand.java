package fr.pierrelemee.puzzles.commands;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class AbstractCommand {

    private static final String DEFAULT_DELIMITER = " ";

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

    protected Integer nextInteger() throws Exception {
        return Integer.parseInt(this.nextLine());
    }

    protected Long nextLong() throws Exception {
        return Long.parseLong(this.nextLine());
    }

    protected String nextLine() throws Exception {
        return this.in.readLine().trim();
    }

    protected List<String> nextStrings() throws Exception {
        return this.nextStrings(DEFAULT_DELIMITER);
    }

    protected List<String> nextStrings(String delimiter) throws Exception {
        return Arrays.asList(this.nextLine().split(delimiter));
    }

    protected List<Integer> nextIntegers() throws Exception {
        return this.nextIntegers(DEFAULT_DELIMITER);
    }

    protected List<Integer> nextIntegers(String delimiter) throws Exception {
        return this.nextStrings().stream().mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
    }
}
