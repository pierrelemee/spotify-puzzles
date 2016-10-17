package fr.pierrelemee.puzzles.commands;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import fr.pierrelemee.puzzles.Main;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Main.class)
public abstract class AbstractCommandTest {

    protected ByteArrayOutputStream buffer;
    protected PrintStream output;

    public AbstractCommandTest() {
        this.buffer = new ByteArrayOutputStream();
        this.output = new PrintStream(this.buffer);
    }

    @Before
    public void before() {
        this.buffer.reset();
    }

    protected abstract String getName();

    protected InputStream getTestInput(String input) {
        return getClass().getResourceAsStream(String.format("/%s/%s", this.getName(), input));
    }

    protected List<String> getOutputLines() {
        return Arrays.asList((new String(this.buffer.toByteArray()).trim()).split(System.lineSeparator()));
    }
}
