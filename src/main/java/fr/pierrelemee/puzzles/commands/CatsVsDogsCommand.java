package fr.pierrelemee.puzzles.commands;

import fr.pierrelemee.puzzles.model.Album;
import fr.pierrelemee.puzzles.model.Pet;
import fr.pierrelemee.puzzles.model.Vote;
import fr.pierrelemee.puzzles.services.AudienceOptimizer;
import fr.pierrelemee.puzzles.services.ZipfSongCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Service
public class CatsVsDogsCommand extends AbstractCommand {

    @Autowired
    protected AudienceOptimizer optimizer;

    @Override
    public String getName() {
        return "catsvsdogs";
    }

    @Override
    public void execute() throws Exception {
        Integer nbEpisodes = this.nextInteger();
        for (int i = 0; i < nbEpisodes; i ++) {
            List<Integer> parameters = this.nextIntegers();
            // The vote list for the related episode
            List<Vote> votes = new ArrayList<>(parameters.get(2));
            for (int j = 0; j < parameters.get(2); j++) {
                votes.add(Vote.fromString(this.nextLine()));
            }
            this.optimizer.optimizeViewers(parameters.get(0), parameters.get(1), votes);
        }
        // Let's output the result:
        for (Integer viewers: this.optimizer.getAggregatedViewers()) {
            this.out.println(viewers);
        }
    }
}
