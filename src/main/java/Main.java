
import user.UserInfo;
import util.Tool;
import windows.MainWindow;

import java.awt.*;
import java.io.*;

/**
 * 西北民族大学校园网自动连接系统主类
 * @author HotPee
 * @Time 2021-9-13-18:26:01
 */


public class Main {

    public static void main(String[] args) throws IOException, InterruptedException, AWTException {
        Tool tool = new Tool();
        tool.init();
        if (!tool.isSystem()){
            System.exit(0);
        }

        MainWindow window = new MainWindow(tool, new UserInfo());
        window.setBounds(100,100,500,350);
        window.setVisible(true);
    }
}
