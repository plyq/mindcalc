package com.mindcalc.gui;

import com.mindcalc.calc.Signs;
import com.mindcalc.calc.UserQuery;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.util.ArrayList;

/**
 * Created by Mashkovsky on 18.10.2016.
 */
public class OutFrame extends JFrame {

    JEditorPane theLabel;
    int sizeX;
    int sizeY;
    private String text;
    private JButton printButton;
    private JButton swapAnswersButton;
    private String swapButtonText;

    public OutFrame(int numOfTasks, ArrayList<Signs> signs, int difficulty, int numOfVars) {
        theLabel = new JEditorPane();
        theLabel.setContentType("text/html");
        theLabel.setEditable(false);
        text = new UserQuery(numOfTasks, signs, difficulty, numOfVars).make();
        theLabel.setText(text);
        sizeX = signs.size() * 260;
        sizeY = numOfTasks * 45;
        swapButtonText = "Скрыть ответы";
        initUI();
    }

    private void initUI() {
        ImageIcon webIcon = new ImageIcon("icon.png");
        JScrollPane scrollPane = new JScrollPane(theLabel);

        printButton = new javax.swing.JButton();

        printButton.setText("Печать");
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                print(evt);
            }
        });

        swapAnswersButton = new JButton();

        swapAnswersButton.setText(swapButtonText);
        swapAnswersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (swapButtonText.equals("Показать ответы")){
                    text = text.replaceAll("color=white","color=black");
                    theLabel.setText(text);
                    swapButtonText = "Скрыть ответы";
                } else {
                    text = text.replaceAll("color=black","color=white");
                    theLabel.setText(text);
                    swapButtonText = "Показать ответы";
                }
                swapAnswersButton.setText(swapButtonText);
            }
        });
        createLayout(scrollPane, printButton, swapAnswersButton);

        setSize(sizeX, sizeY);
        setTitle("Устный счет");
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
                .addGroup(GroupLayout.Alignment.CENTER, gl.createSequentialGroup()
                        .addComponent(arg[1])
                        .addComponent(arg[2])
                )
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
                .addGroup(gl.createParallelGroup()
                        .addComponent(arg[1])
                        .addComponent(arg[2])
                )
        );

        pack();
    }

    private void print(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_print
        PrintingTask task = new PrintingTask();
        task.run();
    }

    private class PrintingTask extends SwingWorker<Object, Object> {

        private volatile boolean complete = false;
        private volatile String message;

        @Override
        protected Object doInBackground() {
            try {
                complete = theLabel.print();
                message = "Printing " + (complete ? "complete" : "canceled");
            } catch (PrinterException ex) {
                message = "Sorry, a printer error occurred";
            } catch (SecurityException ex) {
                message =
                        "Sorry, cannot access the printer due to security reasons";
            }
            return null;
        }

        @Override
        protected void done() {
            message(!complete, message);
        }
    }

    private void message(boolean error, String msg) {
        int type = (error ? JOptionPane.ERROR_MESSAGE :
                JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(this, msg, "Printing", type);
    }

}
