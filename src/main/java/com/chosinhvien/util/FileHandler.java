package com.chosinhvien.util;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

@Component
public class FileHandler {
    public String upload(MultipartFile file, HttpServletRequest req) throws Exception {
        String resourcesFolderPath = "src/main/webapp/template/images";

        byte[] bytes = file.getBytes();
        if (file.getSize() > (10 * 1024 * 1024)) {
            throw new CustomException("Vui lòng chọn file dung lượng nhỏ", HttpStatus.BAD_REQUEST);
        }
        if (file.getSize() == 0 || file == null) {
            throw new CustomException("Bạn chưa chọn file", HttpStatus.BAD_REQUEST);
        }
        String uploadRootPath = req.getServletContext().getRealPath("template/images");
        File dir = new File(uploadRootPath);
        if (!dir.exists())
            dir.mkdirs();

        File serverFile = new File(dir.getAbsolutePath() + File.separator
                + UUID.randomUUID() + file.getOriginalFilename());
        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
        stream.write(bytes);
        stream.close();
        return serverFile.getName();
    }
}
