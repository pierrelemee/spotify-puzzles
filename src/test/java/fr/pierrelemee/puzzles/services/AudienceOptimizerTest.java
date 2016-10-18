package fr.pierrelemee.puzzles.services;

import fr.pierrelemee.puzzles.Main;
import fr.pierrelemee.puzzles.model.Pet;
import fr.pierrelemee.puzzles.model.Vote;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Main.class)
public class AudienceOptimizerTest {

    @Autowired
    protected AudienceOptimizer picker;

    @Before
    public void before() {
        this.picker.clear();
    }

    @Test
    public void testSample() {
        this.picker.optimizeViewers(1, 1, Arrays.asList(
            new Vote(Pet.fromString("C1"), Pet.fromString("D1")),
            new Vote(Pet.fromString("D1"), Pet.fromString("C1"))
        ));
        this.picker.optimizeViewers(1, 2, Arrays.asList(
            new Vote(Pet.fromString("C1"), Pet.fromString("D1")),
            new Vote(Pet.fromString("C1"), Pet.fromString("D1")),
            new Vote(Pet.fromString("C1"), Pet.fromString("D2")),
            new Vote(Pet.fromString("D2"), Pet.fromString("C1"))

        ));
        assertEquals(Arrays.asList(1, 3), this.picker.getAggregatedViewers());
    }

    @Test
    public void testUnpickedPet() {
        this.picker.optimizeViewers(1, 2, Arrays.asList(
                new Vote(Pet.fromString("C1"), Pet.fromString("D1")),
                new Vote(Pet.fromString("D1"), Pet.fromString("C1"))
        ));
        this.picker.optimizeViewers(2, 2, Arrays.asList(
            new Vote(Pet.fromString("C1"), Pet.fromString("D1")),
            new Vote(Pet.fromString("C1"), Pet.fromString("D2")),
            new Vote(Pet.fromString("D2"), Pet.fromString("C1")),
            new Vote(Pet.fromString("C1"), Pet.fromString("D1"))
        ));
        assertEquals(Arrays.asList(1, 3), this.picker.getAggregatedViewers());
    }

    @Test
    public void testWorstCase() {
        this.picker.optimizeViewers(2, 2, Arrays.asList(
            new Vote(Pet.fromString("C1"), Pet.fromString("D1")),
            new Vote(Pet.fromString("D1"), Pet.fromString("C2")),
            new Vote(Pet.fromString("C2"), Pet.fromString("D2")),
            new Vote(Pet.fromString("D2"), Pet.fromString("C1"))
        ));
        this.picker.optimizeViewers(1, 1, Arrays.asList(
            new Vote(Pet.fromString("C1"), Pet.fromString("D1")),
            new Vote(Pet.fromString("D1"), Pet.fromString("C1"))
        ));
        assertEquals(Arrays.asList(1, 2), this.picker.getAggregatedViewers());
    }
}
