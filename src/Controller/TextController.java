package Controller;

import Model.TextModel;
import View.TextView;

import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class TextController {
    private TextModel model;
    private TextView view;

    public TextController(TextModel model, TextView view) {
        this.model = model;
        this.view = view;
        this.view.addOpenListener(e -> openFile());
        this.view.addSaveListener(e -> saveFile());
        this.view.addExitListener(e -> System.exit(0));
    }

    private void openFile() {
        int returnVal = view.getFileChooser().showOpenDialog(view);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = view.getFileChooser().getSelectedFile();
            try {
                model.load(file);
                view.getTextArea().setText(String.join("\n", model.getLines()));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void saveFile() {
        int returnVal = view.getFileChooser().showSaveDialog(view);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = view.getFileChooser().getSelectedFile();
            try {
                String text = view.getTextArea().getText(); // Lấy nội dung từ JTextArea
                model.save(file, text); // Gọi phương thức save với nội dung để lưu
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        TextModel model = new TextModel();
        TextView view = new TextView();
        new TextController(model, view);
    }
}

