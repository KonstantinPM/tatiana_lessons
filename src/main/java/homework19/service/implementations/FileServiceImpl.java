package homework19.service.implementations;

import homework19.service.interfaces.FileService;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileServiceImpl implements FileService {

    public static List<Path> supportedFilesList = new ArrayList<>();

    @Override
    public List<Path> supportedFiles(Path path) {
        List<String> supportedExtensions = List.of("json", "yaml");

        for (String s : supportedExtensions) {
            try (Stream<Path> searchSupportedFiles = Files.walk(Paths.get(path.toUri()), 1)) {
                searchSupportedFiles
                        .filter(Files::isRegularFile)
                        .filter(p -> p.getFileName().toString().endsWith(s))
                        .map(supportedFilesList::add)
                        .collect(Collectors.toList());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return supportedFilesList;
    }
    @Override
    public String readFromFile(Path path) {
        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines(path, StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }

    @Override
    public File createNewDirectory(Path path) {
        File directory = new File(path.toFile(), "/converted/");
        if (!directory.exists()) {
            directory.mkdir();
            System.out.println("New directory was created: " + directory.getAbsolutePath());
        }
        return directory;
    }

    @Override
    public File saveToFile(Path path, boolean append, String data, String ext) throws IOException {
        File directory = createNewDirectory(path.getParent());
        File file = new File(directory.getPath(), path.toFile().getName().split("\\.")[0] + "_new" + ext);
        if (!file.exists()) {
            file.createNewFile();
        }

        OutputStream os = new FileOutputStream(file, append);
        os.write(data.getBytes(StandardCharsets.UTF_8));
        os.close();
        return file;
    }
}
