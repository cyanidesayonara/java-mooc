
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class TiedostonLukija {

    public ArrayList<String> lueTiedosto(String tiedosto) {
        try {
            return Files.lines(Paths.get(tiedosto)).collect(Collectors.toCollection(ArrayList::new));
        } catch (IOException ex) {
        }

        System.out.println("Tiedoston " + tiedosto + " lukeminen epäonnistui!");
        return new ArrayList<>();
    }

}
