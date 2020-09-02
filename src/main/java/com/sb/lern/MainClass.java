package com.sb.lern;
import java.util.Scanner;

public class MainClass {
    public static int command;
        //Реализация взаимодействия с пользователем
        public static  void interacWithUser(Application app, Scanner sc) {
        System.out.println("Выберите действия:\n 1 -> выбор пользоватля \n 2 -> создание пользоватля\n 20 -> завершить приложение");
        command = sc.nextInt();

        switch (command) {
            case 1:
                System.out.println("Выберите пользователя: ");
                for (int i=0; i < app.getListOfUsers().size(); i++) {
                    System.out.println(i + ": " + app.getListOfUsers().get(i).getUserName());
                }
                    command = sc.nextInt();
                    System.out.println("Выбран пользователь: " + app.getListOfUsers().get(command).getUserName());
                    System.out.println("Выбрите действие:\n 1 -> Оплатить за телефон \n 2 -> добавить номер телефона \n 3-> добавить дополнительный счет \n 20 -> завершить приложение\"");
                return;
            case 2:
                System.out.println("Введите имя пользователя: ");
                String user = sc.nextLine();
                user = sc.nextLine();
                System.out.println("Введите номер телефона: ");
                String number = sc.nextLine();

                System.out.println("Введите остаток на счете: ");
                float balans = sc.nextFloat();

                app.addUser(new User(user, number, balans));
                System.out.println("Пользователь успешно создан:");
                return;


        }

    }

    public static void main(String[] args) {

        Application app = new Application(new User("Default", "923-222-56-77", 10000.0f));
        Scanner sc = new Scanner(System.in);
        while (command != 20) {
            interacWithUser(app, sc);
        }

        System.out.println("Программа завершена. Приходите еще");
    }
}
