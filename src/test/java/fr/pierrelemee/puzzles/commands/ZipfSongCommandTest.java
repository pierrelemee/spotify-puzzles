package fr.pierrelemee.puzzles.commands;

import fr.pierrelemee.puzzles.Main;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ZipfSongCommandTest extends AbstractCommandTest {

    @Autowired
    protected ZipfSongCommand command;

    @Override
    protected String getName() {
        return "zipfsong";
    }

    @Test
    public void testSample1() throws Exception {
        this.command.run(this.getTestInput("sample1"), this.output);
        List<String> output = this.getOutputLines();
        assertEquals("four", output.get(0));
        assertEquals("two", output.get(1));
    }

    @Test
    public void testSample2() throws Exception {
        this.command.run(this.getTestInput("sample2"), this.output);
        List<String> output = this.getOutputLines();
        assertEquals("19_2000", output.get(0));
        assertEquals("clint_eastwood", output.get(1));
        assertEquals("tomorrow_comes_today", output.get(2));
    }
}
