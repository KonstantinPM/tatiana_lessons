package homework19.service.interfaces;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;


public interface FileService {

    List<Path> supportedFiles(Path path);

    String readFromFile(Path path);

    File createNewDirectory(Path path);

    File saveToFile(Path path, boolean append, String data, String ext) throws IOException;
}
