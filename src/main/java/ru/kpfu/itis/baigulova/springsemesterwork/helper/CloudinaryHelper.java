package ru.kpfu.itis.baigulova.springsemesterwork.helper;

import com.cloudinary.Cloudinary;

import java.util.HashMap;
import java.util.Map;

public class CloudinaryHelper {

    private static Cloudinary cloudinary;

    public static Cloudinary getInstance() {
        if (cloudinary == null){
            Map configMap = new HashMap();

            configMap.put("cloud_name", "dnvbc2mwj");
            configMap.put("api_key", "315114872352397");
            configMap.put("api_secret", "kR9yIL18xQjYd1RjL04zYLn0wHM");
            cloudinary = new Cloudinary(configMap);
        }

        return cloudinary;
    }
}
