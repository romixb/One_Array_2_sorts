package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[0]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        ArrayList<String> list = new ArrayList<>();
        for (String s : array
        ) {
            if (!isNumber(s)) {
                list.add(s);
            }
        }

        Collections.sort(list);

        ArrayList<Integer> list2 = new ArrayList<>();
        for (String s : array
        ) {
            if (isNumber(s)) {
                list2.add(Integer.parseInt(s));
            }

        }

        list2.sort(Collections.reverseOrder());

        Iterator it = list.iterator();
        Iterator<Integer> it2 = list2.iterator();
        while (it.hasNext() && it2.hasNext()) {
            for (int i = 0; i < array.length; i++) {
                if (!isNumber(array[i])) {
                    array[i] = (String) it.next();
                } else array[i] = Integer.toString(it2.next());
            }
        }
        isGreaterThan("","");

    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-') // не цифра и не начинается с '-'
                    || (chars.length == 1 && c == '-')) // одиночный '-'
            {
                return false;
            }
        }
        return true;
    }
}
