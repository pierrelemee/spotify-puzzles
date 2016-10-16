package fr.pierrelemee.puzzles.commands;

import fr.pierrelemee.puzzles.Main;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.*;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Main.class)
public class ReverseBinaryCommandTest {

    @Autowired
    protected ReverseBinaryCommand command;
    protected ByteArrayOutputStream buffer;
    protected PrintStream output;

    public ReverseBinaryCommandTest() {
        this.buffer = new ByteArrayOutputStream();
        this.output = new PrintStream(this.buffer);
    }

    @Before
    public void before() {
        this.buffer.reset();
    }

    @Test
    public void testSample1() throws Exception {
        this.command.run(this.getTestInput("sample1"), this.output);
        assertEquals(11L, Long.parseLong(new String(this.buffer.toByteArray()).trim()));
        this.output.close();
    }

    @Test
    public void testSample2() throws Exception {
        this.command.run(this.getTestInput("sample2"), this.output);
        assertEquals(61L, Long.parseLong(new String(this.buffer.toByteArray()).trim()));
        this.output.close();
    }

    protected InputStream getTestInput(String name) {
        return getClass().getResourceAsStream(String.format("/reversebinary/%s", name));
    }
}
