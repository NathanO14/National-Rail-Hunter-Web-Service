package com.nathanodong.nationaltrainhunterws;

import org.apache.cxf.helpers.IOUtils;

import java.io.IOException;

public class NTHFileResources {
    private ClassLoader classLoader = getClass().getClassLoader();

    public NTHFileResources() {
    }

    public String getFileWithUtil(String relativePath) {
        String result = "";


        try {
            result = IOUtils.toString(classLoader.getResourceAsStream(relativePath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
