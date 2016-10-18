package fr.pierrelemee.puzzles.commands;

import fr.pierrelemee.puzzles.model.Album;
import fr.pierrelemee.puzzles.services.ZipfSongCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ZipfSongCommand extends AbstractCommand {

    @Autowired
    protected ZipfSongCalculator calculator;

    @Override
    public String getName() {
        return "zipfsong";
    }

    @Override
    public void execute() throws Exception {
        Album.Builder builder = Album.builder();
        List<Integer> parameters = this.nextIntegers();
        for (int i = 0; i < parameters.get(0); i++) {
            String[] elements = this.nextLine().split(" ");
            builder.addSong(elements[1], Integer.parseInt(elements[0]));
        }
        for (String title: this.calculator.top(parameters.get(1), builder.build())) {
            this.out.println(title);
        }
    }
}
