package org.example.utils;

import org.example.model.Flat;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static java.lang.String.format;

public class FileUtils {


    static void saveToFile(String filename, List<Flat> flats) {
        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(filename))) {
            for (Flat flat : flats) {
                bw.append(format("Nr mieszkania: %d, liczba pokoi: %d, pietro: %s, powierzchnia: %f",
                        flat.getFlatNumber(), flat.getRooms(), flat.getFloor(), flat.getSpace()));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
