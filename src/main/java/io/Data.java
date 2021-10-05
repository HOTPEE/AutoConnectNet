package io;

import user.UserInfo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Data {
    private UserInfo userInfo;
    public Data(UserInfo userInfo) throws IOException {
        this.userInfo = userInfo;
        File dumpFile = new File("D:\\userinfo.txt");
        if (!dumpFile.exists()){
            dumpFile.createNewFile();
        }
        String content = userInfo.getId() + "|" + userInfo.getPassword();
        FileOutputStream fos = null;
        fos = new FileOutputStream(dumpFile);
        fos.write(content.getBytes(StandardCharsets.UTF_8));
        fos.close();

    }

}
