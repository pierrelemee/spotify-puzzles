package fr.pierrelemee.puzzles.commands;

import fr.pierrelemee.puzzles.model.Album;
import fr.pierrelemee.puzzles.services.BinaryReverser;
import fr.pierrelemee.puzzles.services.ZipfSongCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.LinkedList;
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
        int[] parameters = Arrays.asList(this.nextLine().split(" ")).stream().mapToInt(s -> Integer.parseInt(s)).toArray();
        Album.Builder builder = Album.builder();
        for (int i = 0; i < parameters[0]; i++) {
            String[] elements = this.nextLine().split(" ");
            builder.addSong(elements[1], Integer.parseInt(elements[0]));
        }
        for (String title: this.calculator.top(parameters[1], builder.build())) {
            this.out.println(title);
        }
    }
}
