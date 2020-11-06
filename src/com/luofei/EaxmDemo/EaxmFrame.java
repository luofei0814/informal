package com.luofei.EaxmDemo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EaxmFrame {
    private  static JFrame frame;
    private JButton Button;
    private JTable table1;
    private JPanel eaxm;
    private ArrayList<User> userDemos;

    public EaxmFrame() {
        Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int position=table1.getSelectedRow();
                User user=userDemos.get(position);
                TestDemo testDemo=new TestDemo(user);
                testDemo.creatView();

            }
        });
    }

    public static void main(String[] args) {
        frame = new JFrame("EaxmFrame");
        frame.setContentPane(new EaxmFrame().eaxm);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(0,0,500,500);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        String[] headers={"序号","姓名","账户余额","骑行里程"};
        userDemos=Dao.selectUser();

        Object[][] data = new Object[userDemos.size()][4];
        for (int i = 0; i <userDemos.size() ; i++) {
            data[i][0]=userDemos.get(i).getId();
            data[i][1]=userDemos.get(i).getName();
            data[i][2]=userDemos.get(i).getBalance();
            data[i][3]=userDemos.get(i).getMileage();
        }
        table1 = new JTable(data,headers);
    }
}
