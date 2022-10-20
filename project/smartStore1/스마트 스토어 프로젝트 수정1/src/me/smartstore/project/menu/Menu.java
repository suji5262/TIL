package me.smartstore.project.menu;

import me.smartstore.project.exception.InputRangeException;
import me.smartstore.project.util.ErrorMessage;

import javax.annotation.processing.Messager;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Menu {

    public static Scanner sc = new Scanner(System.in);

    private static Menu menu;

    public static Menu getInstance() {
        if (menu == null) {
            menu = new Menu();
        }
        return menu;
    }

    public int dishMainMenu() {
        while (true) {
            try {
                System.out.println();
                System.out.println("==============================");
                System.out.println("1. Parameter");
                System.out.println("2. Customer Data");
                System.out.println("3. Classification");
                System.out.println("4. Quit");
                System.out.println("==============================");
                System.out.println("choose One: ");
                int choice = Integer.parseInt(sc.next());
                if (1 <= choice && choice <= 4) {
                    return choice;
                }
                throw new InputRangeException();
            } catch (NumberFormatException e) {
                System.out.println(ErrorMessage.ERR_MSG_INVALID_INPUT_FORMAT);
            } catch (InputRangeException e) {
                System.out.println(ErrorMessage.ERR_MSG_INVALID_INPUT_RANGE);
            }
        }
    }
}