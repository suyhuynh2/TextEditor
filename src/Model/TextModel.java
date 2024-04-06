package Model;

import java.io.*;
import java.util.*;

public class TextModel {
    private List<String> lines;

    public TextModel() {
        lines = new ArrayList<>();
    }

    public void addLine(String line) {
        lines.add(line);
    }

    public List<String> getLines() {
        return lines;
    }

    public void load(File file) throws IOException {
        lines.clear(); // Xóa dữ liệu cũ trước khi thêm dữ liệu mới từ tệp
        if (file.isDirectory()) {
            loadDirectory(file);
        } else {
            loadFile(file);
        }
    }

    private void loadDirectory(File directory) throws IOException {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    loadDirectory(file);
                } else {
                    if (file.getName().endsWith(".txt")) {
                        loadFile(file);
                    }
                }
            }
        }
    }

    public void save(File file, String text) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write(text); // Ghi nội dung vào tệp
        }
    }

    private void loadFile(File file) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        }
    }
}

