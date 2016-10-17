package com.mindcalc.gui;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.*;

public class MainFrame extends JFrame {

    private JSlider slider;
    private JLabel lbl;

    public MainFrame() {
        initUI();
    }

    private void initUI() {
        ImageIcon webIcon = new ImageIcon("icon.png");
        setIconImage(webIcon.getImage());

        JButton makeBtn = new JButton("Make");
        makeBtn.setHorizontalAlignment(JLabel.CENTER);
        makeBtn.setVerticalAlignment(JLabel.CENTER);

        slider = new JSlider(1, 5, 1);
        slider.setMajorTickSpacing(1);
        slider.setPaintTicks(true);

        slider.addChangeListener((ChangeEvent event) -> {
            int value = slider.getValue();
            lbl.setText(Integer.toString(value));
        });

        JCheckBox cbPlus = new JCheckBox("Сложение", true);
        JCheckBox cbMinus = new JCheckBox("Вычитание", true);
        JCheckBox cbMul = new JCheckBox("Умножение", true);
        JCheckBox cbDiv = new JCheckBox("Деление", true);

        SpinnerModel spinnerModel = new SpinnerNumberModel(10, 1, 40, 1);
        JSpinner spinNTasks = new JSpinner(spinnerModel);

        lbl = new JLabel("...");
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

        gl.linkSize(arg[0]);

        pack();
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
        });
    }
}
