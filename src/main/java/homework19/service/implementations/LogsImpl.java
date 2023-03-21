package homework19.service.implementations;

import homework19.service.interfaces.Logs;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class LogsImpl implements Logs {
    @Override
    public void writeLog(File oldFile, File newFile) {
        double currentTime = System.currentTimeMillis();
        DateTimeFormatter timeStampPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd\tHH:mm:ss");
        String timeNow = timeStampPattern.format(java.time.LocalDateTime.now());
        System.out.println("New convert finished at \t" + timeNow);

        FileWriter fileWriter = null;
        File log = new File(newFile.getParent(), "Result.log");
        if (!log.exists()) {
            try {
                log.createNewFile();
                System.out.println("Log created: " + log.getCanonicalPath());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            long oldSize = oldFile.length() / 1024L;
            long newSize = newFile.length() / 1024L;
            double finalTime = System.currentTimeMillis() - currentTime;
            fileWriter = new FileWriter(log, true);
            fileWriter.write("\n\n" + timeNow + "\n"
                    + oldFile.getName() + " -> " + newFile.getName()
                    + "\nConvertation time: " + finalTime + "ms"
                    + "\nOld Size: " + oldSize + "Kb " + "\nNew size: " + newSize + "Kb ");

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                assert fileWriter != null;
                fileWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
