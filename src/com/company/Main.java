package com.company;

import java.util.Scanner;
import java.util.Random;
public class Main {

    public static Scanner sc = new Scanner(System.in);
    public static int min = 1;
    public static int max = 100;
    private static int current = 33;
    private static int last = 33;
    private static int l_ans = 2;
    private static int asks=1;
    private static int nasks=1;
    private static int srasks;
    public static void main(String[] args) {
        boolean playing = true;

        String []a= new String[6];
        Random ran= new Random();
        a[0]="Ваше число ";
        a[1]="Это ";
        a[2]="Вы загадали ";
        a[3]="Тогда может ";
        a[4]="А не загадали ли вы ";
        a[5]="Наверное ваше число ";
        while(playing){
            System.out.println("Загадайте число от 1 до 100, а я буду угадывать!");
            System.out.println("Это 33?");
            switch (getFirstCommand()){
                case 1: guessed(); break;
                case 2: notGuessed(); break;
                case 99: exit(); break;
            }
            while(playing){
                int random=ran. nextInt(6);
                System.out.println(""+min+" "+max+" "+last+" "+current);
                System.out.println(String.format(a[random]+"%d?", nextNumber()));
                asks++;
                switch (getSecondCommand()){
                    case 1: guessed(); break;
                    case 11: guessed(); break;
                    case 10: guessed(); break;
                    case 2: hotter(); break;
                    case 21: hotter(); break;
                    case 20: hotter(); break;
                    case 3: colder(); break;
                    case 31: colder(); break;
                    case 30: colder(); break;
                    case 4: equal(); break;
                    case 41: equal(); break;
                    case 40: equal(); break;
                    case 99: exit(); break;
                    case 991: exit(); break;
                    case 990: exit(); break;
                }
            }
        }
    }

    private static void equal() {
        min = (current+last)/2;
        max = (current+last)/2;
        l_ans = 4;
    }

    private static int nextNumber() {
        if(current>=min && current <=max)
            last = current;
        if(l_ans==4){
            current = min;
        }else if(Math.abs(last-min)<Math.abs(last-max)){
            current = (last+max)/2;
        }else{
            current = (last+min)/2;
        }
        return current;
    }

    private static void colder() {
        if(current>last){
            max = (last+current)/2;
        }else{
            min = (last+current)/2;
        }
        l_ans = 3;
    }

    private static void hotter() {
        if(current>last){
            min = (last+current)/2;
        }else{
            max = (last+current)/2;
        }
        l_ans = 2;
    }

    private static int getSecondCommand() {
        boolean recognized = false;
        int res = 0;
        while(!recognized){
            String command = sc.nextLine();
            if("да".startsWith(command)) {
                res = 1;
                recognized = true;
            }
            if("д".startsWith(command)) {
                res = 10;
                recognized = true;
            }
            if("горячее".startsWith(command)) {
                res = 2;
                recognized = true;
            }
            if("г".startsWith(command)) {
                res = 20;
                recognized = true;
            }
            if("гор".startsWith(command)) {
                res = 21;
                recognized = true;
            }
            if("холоднее".startsWith(command)) {
                res = 3;
                recognized = true;
            }
            if("хол".startsWith(command)) {
                res = 31;
                recognized = true;
            }
            if("х".startsWith(command)) {
                res = 30;
                recognized = true;
            }
            if("равно".startsWith(command)) {
                res = 4;
                recognized = true;
            }
            if("рав".startsWith(command)) {
                res = 41;
                recognized = true;
            }
            if("р".startsWith(command)) {
                res = 40;
                recognized = true;
            }
            if("выход".startsWith(command)){
                res = 99;
                recognized = true;
            }
            if("вых".startsWith(command)){
                res = 991;
                recognized = true;
            }
            if("в".startsWith(command)){
                res = 990;
                recognized = true;
            }
            if(!recognized){
                System.out.println("Не понял...");
            }
        }
        return res;
    }

    private static void notGuessed() {

    }

    private static void guessed() {
        System.out.println("Отличное число! Мне понравилось!");
        System.out.println("Мне понадобилось " + asks+ "попыток");
        nasks++;
        srasks=(srasks+asks)/nasks;
        System.exit(0);
    }

    private static void exit() {
        System.out.println("Спасибо за игру!");
        System.out.println("Мне понадобилось " + asks+ "попыток");
        nasks++;
        srasks=(srasks+asks)/nasks;
        System.exit(0);
    }

    private static int getFirstCommand() {
        boolean recognized = false;
        int res = 0;
        while(!recognized){
            String command = sc.nextLine();
            if("да".startsWith(command)) {
                res = 1;
                recognized = true;
            }
            if("нет".startsWith(command)) {
                res = 2;
                recognized = true;
            }
            if("выход".startsWith(command)){
                res = 99;
                recognized = true;
            }
            if(!recognized){
                System.out.println("Введите команду заново, пожалуйста...");
            }
        }
        return res;
    }
}
