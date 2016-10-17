package fr.pierrelemee.puzzles.commands;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


import static org.junit.Assert.assertEquals;

public class ReverseBinaryCommandTest extends AbstractCommandTest{

    @Autowired
    protected ReverseBinaryCommand command;

    @Override
    protected String getName() {
        return "reversebinary";
    }

    @Test
    public void testSample1() throws Exception {
        this.command.run(this.getTestInput("sample1"), this.output);
        assertEquals(11L, Long.parseLong(this.getOutputLines().get(0)));
        this.output.close();
    }

    @Test
    public void testSample2() throws Exception {
        this.command.run(this.getTestInput("sample2"), this.output);
        assertEquals(61L, Long.parseLong(this.getOutputLines().get(0)));
        this.output.close();
    }
}
