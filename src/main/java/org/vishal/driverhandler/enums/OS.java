package org.vishal.driverhandler.enums;

public enum OS {
    LINUX,WINDOWS,MAC;

    public static OS getOS(){
        var OS = System.getProperty("os.name").toLowerCase();
        if(OS.contains("windows")){
            return WINDOWS;
        } else if (OS.contains("linux")) {
            return LINUX;
        } else if (OS.contains("mac")) {
            return MAC;
        }else {
            throw new RuntimeException("Unable to find appropriate Operating System");
        }
    }
}
