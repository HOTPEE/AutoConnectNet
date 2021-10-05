/*
 * Created by JFormDesigner on Thu Sep 16 22:30:41 CST 2021
 */

package windows;

import io.Data;
import io.Download;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import user.UserInfo;
import util.Message;
import util.MessageType;
import util.Tool;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import javax.swing.*;
import javax.swing.border.*;

/**
 * 自动连接校园网窗口类
 * @author HOTPEE
 * @TIME 2021-9-13-18:26:01
 */
public class MainWindow extends JFrame {
    private final Tool tool;
    private final UserInfo userInfo;
    public MainWindow(Tool tool, UserInfo userInfo) throws IOException, AWTException, InterruptedException {
        initComponents();
        this.tool = tool;
        this.userInfo = userInfo;
        File dumpFile = new File("D:\\userinfo.txt");
        if (!dumpFile.exists()){
            return;
        }
        FileInputStream fis = null;
        fis = new FileInputStream(dumpFile);
        int len;
        byte[] bytes = new byte[200];
        while ((len = fis.read(bytes)) != -1) {
            String str = new String(bytes, 0, len);
            String[] s = str.split("\\|");
            textField3.setText(s[0]);
            textField4.setText(s[1]);
            checkText();
        }
    }
    public void checkText() throws AWTException, InterruptedException, IOException {
        if (textField3.getText() != null && textField3.getText() != null){
            userInfo.setId(textField3.getText());
            userInfo.setPassword(textField4.getText());

            Message message = new Message();
            EdgeDriver driver = new EdgeDriver();
            new Data(userInfo);

            driver.get("http://210.26.0.56/");
            Thread.sleep(400);
            if (driver.getCurrentUrl().equalsIgnoreCase("http://210.26.0.56/srun_portal_success?ac_id=1&theme=basic")){
                message.displayTray(MessageType.FAILED);

                driver.close();
                Thread.sleep(3000);
                System.exit(0);
                return;
            }

            WebElement user = driver.findElement(By.id("username"));
            user.sendKeys(userInfo.getId());

            WebElement password = driver.findElement(By.id("password"));
            password.sendKeys(userInfo.getPassword());

            WebElement click = driver.findElement(By.id("login"));
            click.click();

            Thread.sleep(400);

            message.displayTray(MessageType.SUCCESS);
            this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            driver.close();
            Thread.sleep(3000);
            System.exit(0);

        }
    }

    private void button1ActionPerformed(ActionEvent e) throws AWTException, InterruptedException, IOException {
        if (!(tool.isSystem())){
            return;
        }
        userInfo.setId(textField3.getText());
        userInfo.setPassword(textField4.getText());

        Message message = new Message();
        EdgeDriver driver = new EdgeDriver();
        new Data(userInfo);

        driver.get("http://210.26.0.56/");
        Thread.sleep(400);
        if (driver.getCurrentUrl().equalsIgnoreCase("http://210.26.0.56/srun_portal_success?ac_id=1&theme=basic")){
            message.displayTray(MessageType.FAILED);
            driver.close();
            return;
        }

        WebElement user = driver.findElement(By.id("username"));
        user.sendKeys(userInfo.getId());

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys(userInfo.getPassword());

        WebElement click = driver.findElement(By.id("login"));
        click.click();

        Thread.sleep(400);

        message.displayTray(MessageType.SUCCESS);
        driver.close();
        Thread.sleep(3000);
        System.exit(0);
    }

    private void button2ActionPerformed(ActionEvent e) throws IOException {
        new Download();
    }

    private void initComponents() throws AWTException, InterruptedException,IOException {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - HOTPEE
        layeredPane1 = new JLayeredPane();
        textField3 = new JTextField();
        textField4 = new JTextField();
        label1 = new JLabel();
        label2 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();

        //======== this ========
        setTitle("AutoConnect");
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== layeredPane1 ========
        {
            layeredPane1.add(textField3, JLayeredPane.DEFAULT_LAYER);
            textField3.setBounds(150, 20, 215, 25);
            layeredPane1.add(textField4, JLayeredPane.DEFAULT_LAYER);
            textField4.setBounds(150, 60, 215, 25);

            //---- label1 ----
            label1.setText("\u767b\u5f55\u7528\u6237\u540d");
            layeredPane1.add(label1, JLayeredPane.DEFAULT_LAYER);
            label1.setBounds(70, 20, 70, 22);

            //---- label2 ----
            label2.setText("\u7528\u6237\u5bc6\u7801");
            layeredPane1.add(label2, JLayeredPane.DEFAULT_LAYER);
            label2.setBounds(80, 60, 70, 22);

            //---- button1 ----
            button1.setText("\u767b\u5f55");
            button1.addActionListener(e -> {
                try {
                    button1ActionPerformed(e);
                } catch (AWTException awtException) {
                    awtException.printStackTrace();
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            });
            layeredPane1.add(button1, JLayeredPane.DEFAULT_LAYER);
            button1.setBounds(40, 100, 385, 50);

            //---- button2 ----
            button2.setText("\u4e0b\u8f7d\u9a71\u52a8");
            button2.addActionListener(e -> {
                try {
                    button2ActionPerformed(e);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            });
            layeredPane1.add(button2, JLayeredPane.DEFAULT_LAYER);
            button2.setBounds(40, 160, 385, 25);

            //---- label3 ----
            label3.setText("\u5f00\u53d1\u8005: HOTPEE, Github: https://github.com/HOTPEE/");
            layeredPane1.add(label3, JLayeredPane.DEFAULT_LAYER);
            label3.setBounds(75, 185, 395, 35);

            //---- label4 ----
            label4.setText("\u672c\u8f6f\u4ef6\u4ec5\u9002\u7528\u4e8e\u897f\u5317\u6c11\u65cf\u5927\u5b66\u6821\u56ed\u7f51");
            layeredPane1.add(label4, JLayeredPane.DEFAULT_LAYER);
            label4.setBounds(125, 215, 395, 35);

            //---- label5 ----
            label5.setText("\u521d\u6b21\u4f7f\u7528\u8bf7\u5148\u4e0b\u8f7d\u9a71\u52a8\uff0c\u5f53C\u76d8 Edge,zip \u80fd\u591f\u65e0\u635f\u6253\u5f00\u540e\u8bf7\u628a\u91cc\u9762\u7684exe\u6587\u4ef6\u89e3\u538b");
            layeredPane1.add(label5, JLayeredPane.DEFAULT_LAYER);
            label5.setBounds(10, 250, 515, 35);
        }
        contentPane.add(layeredPane1, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - HOTPEE
    private JLayeredPane layeredPane1;
    private JTextField textField3;
    private JTextField textField4;
    private JLabel label1;
    private JLabel label2;
    private JButton button1;
    private JButton button2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
