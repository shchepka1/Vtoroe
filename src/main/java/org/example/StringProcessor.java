package org.example;

import java.util.Scanner;

public class StringProcessor {
    public static void main(String[] args) {
        reverseWords();
    }

    public static void reverseWords() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите строку:");
            String s = scanner.nextLine();
            if (s == null || s.trim().isEmpty()) {
                System.err.println("Введена пустая строка");
                return;
            }
            String[] words = s.split("\\s+");
            StringBuilder reversed = new StringBuilder();
            for (int i = words.length - 1; i >= 0; i--) {
                reversed.append(words[i]); // добавляет слово в конец
                if (i > 0) { //Добавляет пробел после каждого слова
                    reversed.append(" ");
                }
            }
            System.out.println(reversed);
        } catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
            System.err.println("Ошибка обработки строки: " + e.getMessage());
        }
    }
}

