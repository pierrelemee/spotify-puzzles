package fr.pierrelemee.puzzles.services;

import fr.pierrelemee.puzzles.model.Vote;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Service aimed to optimize the number of viewers of the "Cats vs. Dogs" TV show.
 *
 * Its objective is to select the
 */
@Service
public class AudienceOptimizer {

    /**
     * List of aggregated optimized counts of viewers after the nth episode
     */
    protected List<Integer> aggregated;

    public AudienceOptimizer() {
        this.aggregated = new LinkedList<>();
    }

    public List<Integer> getAggregatedViewers() {
        return aggregated;
    }

    /**
     *
     *
     * @param cats number of cats in the show
     * @param dogs number of dogs in the show
     * @param votes list of all the votes emitted during the show
     */
    public void optimizeViewers(int cats, int dogs, List<Vote> votes) {
        // Marking map (only to avoid evaluating identical vote
        Map<Vote, Boolean> marks = new HashMap<>();
        // Worst case scenario: only one viewer top can be satisfied
        int optimized = 1;
        for (Vote vote: votes) {
            if (!marks.containsKey(vote)) {
                optimized = Math.max(optimized, votes.size() - votes.stream().filter(v -> v.isOpposedTo(vote)).collect(Collectors.toList()).size());
                marks.put(vote, true);
            }
        }
        this.aggregated.add(optimized + this.aggregated.stream().reduce((i1, i2) -> i1 + i2).orElse(0));
    }

    public void clear() {
        this.aggregated.clear();
    }
}
