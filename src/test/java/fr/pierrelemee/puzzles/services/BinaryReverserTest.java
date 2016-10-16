package fr.pierrelemee.puzzles.services;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import fr.pierrelemee.puzzles.Main;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Main.class)
public class BinaryReverserTest {

    static {
        ((Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME)).setLevel(Level.OFF);
    }

    @Autowired
    protected BinaryReverser reverser;

    @Test
    public void testSample1() {
        assertEquals(11L, this.reverser.reverseBinary(13L).longValue());
    }

    @Test
    public void testSample2() {
        assertEquals(61L, this.reverser.reverseBinary(47L).longValue());
    }

    @Test
    public void testEdgeCases() {
        // Test on limits
        assertEquals(1L, this.reverser.reverseBinary(1L).longValue());
        assertEquals(1365623L, this.reverser.reverseBinary(1000000000L).longValue());
    }
}
