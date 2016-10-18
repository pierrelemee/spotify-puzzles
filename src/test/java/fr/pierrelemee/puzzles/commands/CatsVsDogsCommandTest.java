package fr.pierrelemee.puzzles.commands;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CatsVsDogsCommandTest extends AbstractCommandTest {

    @Autowired
    protected CatsVsDogsCommand command;

    @Override
    protected String getName() {
        return "catsvsdogs";
    }

    @Test
    public void testSample1() throws Exception {
        this.command.run(this.getTestInput("sample1"), this.output);
        List<String> output = this.getOutputLines();
        assertEquals("1", output.get(0));
        assertEquals("3", output.get(1));
    }

}
