package fr.pierrelemee.puzzles.services;

import fr.pierrelemee.puzzles.model.Album;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ZipfSongCalculator {

    public List<String> top(int length, Album album) {
        List<String> top = new ArrayList<String>(length);
        for (Album.Song song: album.getSongs()) {
            if (top.size() >= length) {
                break;
            }
            top.add(song.getTitle());
        }
        return top;
    }

}
