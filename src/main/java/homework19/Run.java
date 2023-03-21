package homework19;

import homework19.service.implementations.FileServiceImpl;
import homework19.service.implementations.JsonConverterImpl;
import homework19.service.implementations.LogsImpl;
import homework19.service.implementations.YamlConverterImpl;
import homework19.service.interfaces.Converter;
import homework19.service.interfaces.FileService;
import homework19.service.interfaces.Logs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static homework19.service.implementations.FileServiceImpl.supportedFilesList;

public class Run {
    private static final String JSON = "json";
    private static final String YAML = "yaml";

    public static void main(String[] args) {

        Path path = Path.of(System.getProperty("user.dir"));
        FileService fs = new FileServiceImpl();
        Logs log = new LogsImpl();

        if (!(args.length == 0)) {
            String linkToFile = args[0].trim();
            path = Path.of(linkToFile);
        }
        if (Files.isDirectory(path) || (Files.isRegularFile(path))) {
            System.out.println("Supported files: " + fs.supportedFiles(path));

            for (Path p : supportedFilesList) {
                if (p.getFileName().toString().endsWith(YAML)) {
                    Converter yaml = new YamlConverterImpl();
                    String str = yaml.convert(fs.readFromFile(p));

                    try {
                        log.writeLog(p.toFile(), fs.saveToFile(p, false, str, ".json"));

                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                } else if (p.getFileName().toString().endsWith(JSON)) {
                    Converter json = new JsonConverterImpl();
                    String str = json.convert(fs.readFromFile(p));

                    try {
                        log.writeLog(p.toFile(), fs.saveToFile(p, false, str, ".yaml"));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
