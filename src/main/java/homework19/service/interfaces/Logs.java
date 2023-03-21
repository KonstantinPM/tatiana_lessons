package homework19.service.interfaces;

import java.io.File;

public interface Logs {
    void writeLog(File oldFile, File newFile);
}

