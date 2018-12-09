package FileSystem;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileWriter;
import java.util.IllegalFormatException;
import java.util.Scanner;

public class FileSystem {
    private String fileName, pathToDir, pathToFile;

    public void setPathToDir(String pathToDir) {
        this.pathToDir = pathToDir;
        System.out.println("path to directory:" + pathToDir);
    }

    public void setPathToFile(String pathToFile) throws Exception {
        this.pathToFile = pathToFile;
        System.out.println("path to file:" + pathToFile);
        if (pathToFile.charAt(0) == '.') {
            this.pathToFile = getAbsolutePath(pathToDir, this.pathToFile.replace('/', '\\')) + fileName;
        }
        System.out.println("absolute path to file:" + this.pathToFile);
    }

    private File dir, file;

    public boolean createFileAtDir() {
        if(file.exists()){
            file.delete();
        }else{
        try {
            if (!file.createNewFile()) {
                System.out.println("Can't create file");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }}
        return true;
    }

    public void writeToFile() {
        StringBuilder stringBuilder = new StringBuilder();
        String[] contents = dir.list();
        if (contents != null) {
            for (String content : contents) {
                stringBuilder.append(content).append("\n\r\n\r");
            }
        }
        try (FileWriter newFile = new FileWriter(pathToFile, false)) {
            newFile.write(stringBuilder.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initFileDir() {
        dir = new File(pathToDir);
        file = new File(pathToFile);
        if (!dir.isDirectory()) {
            throw new IllegalArgumentException("Wrong path or directory");
        }
    }

    private void updateStringBuilder(@NotNull String token, String delimeter, StringBuilder stringBuilder,
                                     String startDir, String absolutePath) throws Exception {
        switch (token) {
            case "..":
                if (stringBuilder.lastIndexOf(delimeter) < 0) {
                    throw new Exception("\nWrong related path of file");
                }
                stringBuilder.setLength(stringBuilder.lastIndexOf(delimeter));
                //System.out.println(stringBuilder.toString());
                break;
            case ".":
                stringBuilder.append(delimeter).append(startDir);
                if (!absolutePath.equals(stringBuilder.toString())) {
                    throw new Exception("\nWrong related path of file");
                }
                break;
            default:
                stringBuilder.append(delimeter).append(token);
                break;
        }
    }

    public String getAbsolutePath(String absolutePath, String relatedPath) throws Exception {
        StringBuilder stringBuilder = new StringBuilder(absolutePath);
        String delimeter = "\\\\";

        boolean flag = true;
        if (relatedPath.contains("/")) {
            delimeter = "/";
            flag = false;
        }
        String startDir = absolutePath.substring(absolutePath.lastIndexOf(delimeter.charAt(0)) + 1);
        String[] tokens = relatedPath.split(delimeter);
        if (flag) {
            delimeter = delimeter.substring(0, 1);
        }
        int startIndex = 0;
        if (tokens.length != 0 && tokens[0].equals(".")) {
            ++startIndex;
        }

        File dir;
        for (int i = startIndex; i < tokens.length - 1; ++i) {
            updateStringBuilder(tokens[i], delimeter, stringBuilder, startDir, absolutePath);
            dir = new File(stringBuilder.toString());
            if (!dir.exists()) {
                throw new Exception("Wrong related path of file");
            }
        }
        fileName = delimeter + tokens[tokens.length - 1];
        return stringBuilder.toString();
    }

    public static void main(@NotNull String[] args) {
        FileSystem converter = new FileSystem();
        converter.setPathToDir(args[0]);
        try {
            converter.setPathToFile(args[1]);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        converter.initFileDir();
        if (converter.createFileAtDir()) {
            converter.writeToFile();
        }
    }
}
