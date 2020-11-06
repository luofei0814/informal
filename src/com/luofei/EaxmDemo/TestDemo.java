package com.luofei.EaxmDemo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestDemo {
    private JPanel jPanel;
    private JTextField textId;
    private JTextField textName;
    private JTextField textBalance;
    private JTextField textMileage;
    private JButton Button;
    private JButton Button1;
    private User user;


    public TestDemo(User user) {
        this.user=user;
        Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(jPanel,"取消修改");
            }
        });
        Button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id= Integer.parseInt(textId.getText());
                String name=textName.getText();
                float balance= Float.parseFloat(textBalance.getText());
                float mileage= Float.parseFloat(textMileage.getText());
                if (Dao.updateUser(id, name, balance, mileage)) {
                    JOptionPane.showMessageDialog(jPanel,"修改成功");
                }else {
                    JOptionPane.showMessageDialog(jPanel,"修改失败");
                }


            }
        });
        textId.setText(String.valueOf(user.getId()));
        textName.setText(String.valueOf(user.getName()));
        textBalance.setText(String.valueOf(user.getBalance()));
        textMileage.setText(String.valueOf(user.getMileage()));
    }

    public void creatView() {

        JFrame frame = new JFrame("TestDemo");
        frame.setContentPane(jPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

