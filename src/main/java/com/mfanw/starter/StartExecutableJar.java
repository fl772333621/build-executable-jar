package com.mfanw.starter;

import com.alee.laf.WebLookAndFeel;
import com.mfanw.starter.form.DemoForm;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.util.Enumeration;
import java.util.Objects;

/**
 * <b>可执行Jar启动器</b>
 * 第一步：替换ContentPane为目标Form <br />
 * 第二步：clean package 出可执行jar<br />
 *
 * @author mengwei18
 */
public class StartExecutableJar {

    public static void main(String[] args) {
        initGlobalFont();
        SwingUtilities.invokeLater(() -> {
            WebLookAndFeel.install();
            JFrame frame = new JFrame("可执行Jar样例V1.0");
            // 替换ContentPane即可完成Form启动
            frame.setContentPane(new DemoForm().getMainPanel());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setIconImage(new ImageIcon(Objects.requireNonNull(StartExecutableJar.class.getResource("/images/icon_image.png"))).getImage());
            frame.pack();
            frame.setBounds(100, 100, 800, 600);
            frame.setVisible(true);
        });
    }

    private static void initGlobalFont() {
        FontUIResource fontResource = new FontUIResource(new Font("微软雅黑", Font.PLAIN, 12));
        for (Enumeration<Object> keys = UIManager.getDefaults().keys(); keys.hasMoreElements(); ) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof FontUIResource) {
                UIManager.put(key, fontResource);
            }
        }
    }

}
