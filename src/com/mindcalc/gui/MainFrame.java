package com.mindcalc.gui;

import com.mindcalc.calc.Signs;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainFrame extends JFrame {

    private JSlider slider = new JSlider(1, 5, 1);
    private JLabel lbl = new JLabel("...");
    private JCheckBox cbPlus = new JCheckBox("Сложение", true);
    private JCheckBox cbMinus = new JCheckBox("Вычитание", true);
    private JCheckBox cbMul = new JCheckBox("Умножение", true);
    private JCheckBox cbDiv = new JCheckBox("Деление", true);
    private SpinnerModel spinnerModel = new SpinnerNumberModel(10, 1, 40, 1);
    private JSpinner spinNTasks = new JSpinner(spinnerModel);


    public MainFrame() {
        initUI();
    }

    private void initUI() {
        ImageIcon webIcon = new ImageIcon("icon.png");
        setIconImage(webIcon.getImage());

        JButton makeBtn = new JButton("Make");
        makeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int numOfTasks = (int) spinNTasks.getValue();

                ArrayList<Signs> signs = new ArrayList<Signs>();
                if (cbPlus.isSelected()) signs.add(Signs.PLUS);
                if (cbMinus.isSelected()) signs.add(Signs.MINUS);
                if (cbMul.isSelected()) signs.add(Signs.MUL);
                if (cbDiv.isSelected()) signs.add(Signs.DIV);

                int difficulty = slider.getValue();

                EventQueue.invokeLater(() -> {
                    OutFrame frame = new OutFrame(numOfTasks, signs, difficulty);
                    frame.setVisible(true);
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                });
            }
        });

        slider.setMajorTickSpacing(1);
        slider.setPaintTicks(true);

        slider.addChangeListener((ChangeEvent event) -> {
            int value = slider.getValue();
            lbl.setText(Integer.toString(value));
        });

        createLayout(new JLabel("Выберите сложность: "),
                slider,
                lbl,
                makeBtn,
                cbPlus,
                cbMinus,
                cbMul,
                cbDiv,
                new JLabel("Выберите действия:"),
                spinNTasks,
                new JLabel("Выберите количество примеров:")
        );

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

        JPanel sep = new JPanel();

        gl.setHorizontalGroup(gl.createParallelGroup()
                .addGroup(gl.createSequentialGroup()
                        .addComponent(arg[10])
                        .addComponent(arg[9])
                        .addGap(100)
                )
                .addComponent(sep)
                .addComponent(arg[8])
                .addGroup(gl.createSequentialGroup()
                        .addComponent(arg[4])
                        .addComponent(arg[5])
                        .addComponent(arg[6])
                        .addComponent(arg[7])
                )
                .addComponent(sep)
                .addGroup(gl.createSequentialGroup()
                        .addComponent(arg[0])
                        .addComponent(arg[1])
                        .addComponent(arg[2])
                )
                .addComponent(arg[3])
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addGroup(gl.createParallelGroup()
                        .addComponent(arg[10])
                        .addComponent(arg[9])
                )
                .addComponent(sep)
                .addComponent(arg[8])
                .addGroup(gl.createParallelGroup()
                        .addComponent(arg[4])
                        .addComponent(arg[5])
                        .addComponent(arg[6])
                        .addComponent(arg[7])
                )
                .addComponent(sep)
                .addGroup(gl.createParallelGroup()
                        .addComponent(arg[0])
                        .addComponent(arg[1])
                        .addComponent(arg[2])
                )
                .addComponent(arg[3])
        );

        pack();
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
        });
    }
}
