package fr.pierrelemee.puzzles.services;

import fr.pierrelemee.puzzles.model.Top;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ZipfSongCalculator {

    /**
     * Calculates the rank of nth first
     *
     * @param length
     * @param album
     * @return
     */
    public List<String> top(int length, Top album) {
        return album.getSongs().subList(0, length).stream().map(song -> song.getTitle()).collect(Collectors.toList());
    }

}
