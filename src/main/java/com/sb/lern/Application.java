package com.sb.lern;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;

public class Application {
    private final ArrayList<User> listOfUsers = new ArrayList<User>();

    public Application(User user) {
        listOfUsers.add(user);
    }
    //можно добавить любое количество пользователей
    public void addUser(User user) {
        listOfUsers.add(user);

    }

    //получить пользователя
    public User getUserByIndex(int index) {
        return listOfUsers.get(index);
    }
    //получить список доступнеых пользователей
    public ArrayList<User> getListOfUsers() {
        return listOfUsers;
    }

    //производим платеж выбранного телефона с выбранного Юзера на выбранную сумму
    public String doPayment (int indexOfUser, int indexOfTel, int indexOfAccName, float coastOfPayment) {
        float summaOnAccaunt = listOfUsers.get(indexOfUser).getBalans(indexOfAccName); //сумма на выбраннм счете
        String telefonNumber = listOfUsers.get(indexOfUser).getTelNumber(indexOfTel);
        if (summaOnAccaunt<coastOfPayment) {return "На счету нет денег!";}
        if (telefonNumber == null) { return "Нет такого номера";}
        listOfUsers.get(indexOfUser).changeSumAccount(indexOfAccName, (summaOnAccaunt-coastOfPayment));
    return "Платеж выполнен успешно. Остаток на счете " + listOfUsers.get(indexOfUser).getBalans(indexOfAccName);
    }

}
