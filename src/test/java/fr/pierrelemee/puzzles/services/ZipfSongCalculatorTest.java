package fr.pierrelemee.puzzles.services;

import fr.pierrelemee.puzzles.Main;
import fr.pierrelemee.puzzles.model.Album;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Main.class)
public class ZipfSongCalculatorTest {

    @Autowired
    protected ZipfSongCalculator calculator;

    @Test
    public void testSample1() {
        assertEquals(
            Arrays.asList("four", "two"),
            this.calculator.top(
                2,
                Album.builder()
                    .addSong("one", 30)
                    .addSong("two", 30)
                    .addSong("three", 15)
                    .addSong("four", 25)
                    .build()
            )
        );
    }

    @Test
    public void testSample2() {
        assertEquals(
            Arrays.asList("19_2000", "clint_eastwood", "tomorrow_comes_today"),
            this.calculator.top(
                3,
                Album.builder()
                    .addSong("re_hash", 197812)
                    .addSong("5_4", 78906)
                    .addSong("tomorrow_comes_today", 189518)
                    .addSong("new_genious", 39453)
                    .addSong("clint_eastwood", 210492)
                    .addSong("new_genious", 39453)
                    .addSong("man_research", 26302)
                    .addSong("22544 punk", 39453)
                    .addSong("sound_check", 19727)
                    .addSong("double_bass", 17535)
                    .addSong("rock_the_house", 18782)
                    .addSong("19_2000", 198189)
                    .addSong("latin_simone", 13151)
                    .addSong("starshine", 12139)
                    .addSong("slow_country", 11272)
                    .addSong("m1_a1", 10521)
                    .build()
            )
        );
    }
}
