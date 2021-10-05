package util;

import java.awt.*;

public class Message {

    public void displayTray(MessageType s) throws AWTException{
        SystemTray tray = SystemTray.getSystemTray();
        Image image = Toolkit.getDefaultToolkit().createImage(getClass().getResource("/icon.png"));
        TrayIcon trayIcon = new TrayIcon(image, "MESSAGE");
        trayIcon.setImageAutoSize(true);
        trayIcon.setToolTip("校园网连接状态");
        tray.add(trayIcon);
        if (SystemTray.getSystemTray() != null) {
            trayIcon.displayMessage("校园网连接状态", s.toString(), TrayIcon.MessageType.INFO);
        }
    }
}
