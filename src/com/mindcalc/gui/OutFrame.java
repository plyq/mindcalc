package com.mindcalc.gui;

import com.mindcalc.calc.Signs;
import com.mindcalc.calc.UserQuery;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Mashkovsky on 18.10.2016.
 */
public class OutFrame extends JFrame {

    JLabel theLabel;


    public OutFrame(int numOfTasks, ArrayList<Signs> signs, int difficulty) {
        theLabel = new JLabel(new UserQuery(numOfTasks, signs, difficulty).make());
        initUI();
    }

    private void initUI() {
        ImageIcon webIcon = new ImageIcon("icon.png");
        setIconImage(webIcon.getImage());

        createLayout(theLabel);

        setTitle("Устный счет");
        setSize(400, 220);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    private void createLayout(JComponent... arg) {

        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setAutoCreateContainerGaps(true);
        gl.setAutoCreateGaps(true);


        gl.setHorizontalGroup(gl.createParallelGroup()
                .addComponent(arg[0])
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
        );

        pack();
    }

}
