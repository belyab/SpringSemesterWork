package ru.kpfu.itis.baigulova.springsemesterwork.helper;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Objects;

public class ImageHelper {
    public static File makeFile(MultipartFile part) throws IOException {
        String fileName = Paths.get(Objects.requireNonNull(part.getOriginalFilename())).getFileName().toString();
        InputStream content = part.getInputStream();
        File file = new File(fileName);
        FileOutputStream outputStream = new FileOutputStream(file);
        byte[] buffer = new byte[content.available()];
        content.read(buffer);
        outputStream.write(buffer);

        return file;
    }
}
