package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class TextView extends JFrame {
    private JTextArea textArea;
    private JFileChooser fileChooser;

    public TextView() {
        setTitle("Text Editor");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem exitItem = new JMenuItem("Exit");

        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);

        setJMenuBar(menuBar);

        fileChooser = new JFileChooser();

        setVisible(true);
        setLocationRelativeTo(null);
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public JFileChooser getFileChooser() {
        return fileChooser;
    }

    public void addOpenListener(ActionListener listener) {
        JMenu fileMenu = getJMenuBar().getMenu(0);
        JMenuItem openItem = fileMenu.getItem(0);
        openItem.addActionListener(listener);
    }

    public void addSaveListener(ActionListener listener) {
        JMenu fileMenu = getJMenuBar().getMenu(0);
        JMenuItem saveItem = fileMenu.getItem(1); // Sử dụng index 1 cho menu item "Save"
        saveItem.addActionListener(listener);
    }

    public void addExitListener(ActionListener listener) {
        JMenu fileMenu = getJMenuBar().getMenu(0);
        JMenuItem exitItem = fileMenu.getItem(2);
        exitItem.addActionListener(listener);
    }
}

