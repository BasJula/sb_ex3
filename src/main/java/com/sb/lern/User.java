package com.sb.lern;

import java.util.ArrayList;
import java.util.HashMap;

public class User {
    private final String nameOfUser;
    private final ArrayList<String> telNumber = new ArrayList<String>(); //пользователь может меть нескольео номеров
    private final HashMap<String, String> valuta = new HashMap<String, String>();     //несколько доступных валют для платежа
    private final ArrayList <String> usersAccountNumber = new ArrayList();//несколько доступных счетов
    private final ArrayList <Float> usersAccountBalans = new ArrayList(); //баланс на каждом счете

    private float moneyForPayment;
    //у вновь создаваемого пользователя должен быть основной номер телефона
    //и счет, скоторого будет производится оплата
    public User(String nameOfUser, String telNumber, Float summa) {
        this.nameOfUser = nameOfUser;
        this.telNumber.add(telNumber);
        this.usersAccountNumber.add("mainAccount");
        this.usersAccountBalans.add(summa);
        this.valuta.put("rub", "Рубль");
        this.valuta.put("dollar", "Доллар");
    }
    //пользователь может иметь/добавлять дополнительные счета
    public boolean addAccount (String numberOfAccount, Float summa) {
        if (this.usersAccountNumber==null) {
            usersAccountNumber.add(numberOfAccount);
            usersAccountBalans.add(summa);
            return true;
        }
        return false;
    }

    //пользователь может иметь/добавлять дополнительные номера телефонов
    public void addTelNumber(String telNumber){
        this.telNumber.add(telNumber);
    }
    //получаем остаток на счете
    public float getBalans(int indexOfAccName) {
        return usersAccountBalans.get(indexOfAccName);
    }

    //получаем название счета
    public String getUsersAccountNumber(int indexOfAccName) {
        return this.usersAccountNumber.get(indexOfAccName);
    }
    //получаем номер телефона из списка
    public String getTelNumber (int indexTel) {
        return telNumber.get(indexTel);
    }
    //изменение остатка неа счету пользователя
    public boolean changeSumAccount (int indexOfAccName, Float newValue) {
        if (usersAccountBalans.get(indexOfAccName)!= null) {
            usersAccountBalans.set(indexOfAccName, newValue);
            return true;
        }
    return false;
    }
    //получение имени пользователя
    public String getUserName() {
        return nameOfUser;
    }




    }
