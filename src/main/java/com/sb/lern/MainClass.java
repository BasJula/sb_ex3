package com.sb.lern;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainClass {
    //public static int command;
        //Реализация взаимодействия с пользователем
        public static  void interacWithUser(Application app) {
            Scanner sc = new Scanner(System.in);
            try {
            while (true) {

                System.out.println("Выберите действия:\n 1 -> выбор пользоватля \n 2 -> создание пользоватля\n 20 -> завершить приложение");
                int command = sc.nextInt();

                switch (command) {
                    case 1:
                        System.out.println("Выберите пользователя: ");
                        for (int i = 0; i < app.getListOfUsers().size(); i++) {
                            System.out.println(i + ": " + app.getListOfUsers().get(i).getUserName());
                        }
                        command = sc.nextInt();
                        User selectedUser = app.getListOfUsers().get(command);
                        System.out.println("Выбран пользователь: " + selectedUser.getUserName());
                        System.out.println("Выберите действие:\n 1 -> Оплатить за телефон \n 2 -> добавить номер телефона \n 3-> добавить дополнительный счет \n 20 -> завершить приложение\"");
                        command = sc.nextInt();
                        switch (command) {
                            case 1:
                                System.out.println("Выберите номер телефона");
                                for (int i = 0; i < selectedUser.getTelNumberList().size(); i++) {
                                    System.out.println(i + ": " + selectedUser.getTelNumber(i));
                                }
                                int indexOfTel = sc.nextInt();
                                String telNum = selectedUser.getTelNumber(indexOfTel);
                                System.out.println("Выбран номер телефона: " + telNum);

                                System.out.println("Выберите свой счет");
                                for (int i = 0; i < selectedUser.getTelNumberList().size(); i++) {
                                    System.out.println(i + ": " + selectedUser.getUsersAccountNumber(i) + ", Баланс " + selectedUser.getBalans(i));
                                }
                                int indexOfAccount = sc.nextInt();

                                System.out.println("Введите сумму для оплаты: ");
                                float sumOfPayment = sc.nextFloat();
                                System.out.println(app.doPayment(selectedUser, indexOfTel, indexOfAccount, sumOfPayment));

                            case 2:
                            case 3:


                        }
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

            } } catch (InputMismatchException | IndexOutOfBoundsException | NumberFormatException e) {
                System.out.println("Неправильный ввод: " + e.getMessage());
                interacWithUser(app); //перезапускаем взаимодействие с пользователем в случае ошибки
    }


    }


    public static void main(String[] args) {

        Application app = new Application(new User("Default", "923-222-56-77", 10000.0f));


            interacWithUser(app);

        System.out.println("Программа завершена. Приходите еще");
    }
}
