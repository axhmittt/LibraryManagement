package ui;

import java.util.Scanner;

public class InputHelper {
    Scanner sc = new Scanner(System.in);

    public String getString(String msg) {
        System.out.print(msg);
        return sc.nextLine();
    }

    public int getInt(String msg) {
        System.out.print(msg);
        return Integer.parseInt(sc.nextLine());
    }
}
