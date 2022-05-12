package org.vishal.utils.seleniumUtils;

import org.clipboardHealth.driverhandler.enums.Browser;
import org.clipboardHealth.driverhandler.enums.OS;

import java.io.File;

public class DriverUtils {

    public static String resolveDriverPath(){
        var os = System.getProperty("os.name").toLowerCase();
        var basePath = "drivers";
        var browserName = Browser.getBrowser().toString().toLowerCase();
        switch (OS.getOS()){
            case LINUX:
                return basePath+File.separator+"linux"+File.separator+browserName;
            case WINDOWS:
                return basePath+File.separator+"windows"+File.separator+browserName;
            case MAC:
                return basePath+File.separator+"macOS"+File.separator+browserName;
            default:
                throw new RuntimeException(String.format("Unable to find drivers for OS - %s", os));
        }
    }
}
