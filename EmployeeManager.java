import java.io.*;
import java.util.*;

public class EmployeeManager {
    
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        
        if (args.length == 0) {
        System.err.println("Error: Please provide a command argument.");
        System.err.println("Usage: java EmployeeManager <command>");
        System.err.println("Commands: l, s, +<n>, ?<n>, c, u<n>, d<n>");
        System.exit(1);
    }


        // Check arguments
        if (args[0].equals("l")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader r = new BufferedReader(
                    new InputStreamReader(
                        new FileInputStream("employees.txt")));
                String l = r.readLine();
                String e[] = l.split(",");
                for (String emp : e) {
                    System.out.println(emp);
                }
            } catch (IOException e) {
                // Handle exception silently
            }
            System.out.println("Data Loaded.");
            
        } else if (args[0].equals("s")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader r = new BufferedReader(
                    new InputStreamReader(
                        new FileInputStream("employees.txt")));
                String l = r.readLine();
                System.out.println(l);
                String e[] = l.split(",");
                Random rand = new Random();
                int idx = rand.nextInt(e.length);
                System.out.println(e[idx]);
            } catch (IOException e) {
                // Handle exception silently
            }
            System.out.println("Data Loaded.");
            
        } else if (args[0].contains("+")) {
            System.out.println("Loading data ...");
            try {
                try (BufferedWriter w = new BufferedWriter(
                        new FileWriter("employees.txt", true))) {
                    String n = args[0].substring(1);
                    w.write(", " + n);
                }
            } catch (IOException e) {
                // Handle exception silently
            }
            System.out.println("Data Loaded.");
            
        } else if (args[0].contains("?")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader r = new BufferedReader(
                    new InputStreamReader(
                        new FileInputStream("employees.txt")));
                String l = r.readLine();
                String e[] = l.split(",");
                boolean found = false;
                String s = args[0].substring(1);
                for (int i = 0; i < e.length && !found; i++) {
                    if (e[i].equals(s)) {
                        System.out.println("Employee found!");
                        found = true;
                    }
                }
            } catch (IOException e) {
                // Handle exception silently
            }
            System.out.println("Data Loaded.");
            
        } else if (args[0].contains("c")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader r = new BufferedReader(
                    new InputStreamReader(
                        new FileInputStream("employees.txt")));
                String l = r.readLine();
                char[] chars = l.toCharArray();
                boolean inWord = false;
                int count = 0;
                for (char c : chars) {
                    if (c == ' ') {
                        if (!inWord) {
                            count++;
                            inWord = true;
                        } else {
                            inWord = false;
                        }
                    }
                }
                System.out.println(count + " word(s) found " + chars.length);
            } catch (IOException e) {
                // Handle exception silently
            }
            System.out.println("Data Loaded.");
            
        } else if (args[0].contains("u")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader r = new BufferedReader(
                    new InputStreamReader(
                        new FileInputStream("employees.txt")));
                String l = r.readLine();
                String e[] = l.split(",");
                String n = args[0].substring(1);
                for (int i = 0; i < e.length; i++) {
                    if (e[i].equals(n)) {
                        e[i] = "Updated";
                    }
                }
                try (BufferedWriter w = new BufferedWriter(
                        new FileWriter("employees.txt"))) {
                    w.write(String.join(",", e));
                }
            } catch (IOException e) {
                // Handle exception silently
            }
            System.out.println("Data Updated.");
            
        } else if (args[0].contains("d")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader r = new BufferedReader(
                    new InputStreamReader(
                        new FileInputStream("employees.txt")));
                String l = r.readLine();
                String e[] = l.split(",");
                String n = args[0].substring(1);
                List<String> list = new ArrayList<>(Arrays.asList(e));
                list.remove(n);
                try (BufferedWriter w = new BufferedWriter(
                        new FileWriter("employees.txt"))) {
                    w.write(String.join(",", list));
                }
            } catch (IOException e) {
                // Handle exception silently
            }
            System.out.println("Data Deleted.");
        }
    }
}