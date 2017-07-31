package LaiOffer.ReadFile;

import java.io.*;
import java.util.Scanner;

/**
 * Created by matinaju on 6/20/17.
 */
public class Impl {
    void StandReadMethod() throws IOException {
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            in = new FileInputStream("/Users/matinaju/IdeaProjects/HelloWorld/src/LaiOffer/ReadFile/input.txt");
            byte[] bytes = new byte[10];
            int n = in.read(bytes);
            System.out.println("n = " + n);
            for (byte b : bytes) {
                System.out.print((char) b);
            }
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }

    void CommonReadMethod() throws IOException {
        FileInputStream fis = new
                FileInputStream("/Users/matinaju/IdeaProjects/HelloWorld/src/LaiOffer/ReadFile/input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }

    void StandardOut() throws IOException {
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            in = new FileInputStream("/Users/matinaju/IdeaProjects/HelloWorld/src/LaiOffer/ReadFile/input.txt");
            out = new FileOutputStream("/Users/matinaju/IdeaProjects/HelloWorld/src/LaiOffer/ReadFile/output.txt");
            int c;
            while ((c = in.read()) != -1) {
                System.out.print((char) c);
                out.write(c);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }

    void chineseInput() throws IOException {
        FileReader in = null;
        FileWriter out = null;
        try {
            in = new FileReader("/Users/matinaju/IdeaProjects/HelloWorld/src/LaiOffer/ReadFile/chineseInput.txt");
            out = new FileWriter("/Users/matinaju/IdeaProjects/HelloWorld/src/LaiOffer/ReadFile/chineseOutput.txt");
            int c;
            while ((c = in.read()) != -1) {
                System.out.print((char) c);
                out.write(c);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }

    void keyboardOutput() throws IOException {
        InputStreamReader cin = null;
        try {
            cin = new InputStreamReader(System.in);
            System.out.println("Enter Characters, 'q' to quit");
            StringBuffer userInput = new StringBuffer();
            while (true) {
                char c = (char) cin.read();
                if (c == 'q') {
                    break;
                }
                userInput.append(c);
            }
            System.out.println(userInput);
        } finally {
            if (cin != null) {
                cin.close();
            }
        }
    }

    void scannerInputLineByLine() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please type: ");
        while (true) {
            String line = scanner.nextLine();
            if (line.toLowerCase().equals("exit")) {
                break;
            }
            System.out.println("input text: " + line);
        }
    }
}
