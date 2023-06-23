package task2;

// 2) Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.

import java.io.IOException;
import java.util.logging.*;

public class task2 {
    public static void main(String[] args) throws IOException {

        Logger logger = Logger.getLogger(task2.class.getName());
        logger.setLevel(Level.INFO);
        //ConsoleHandler ch = new ConsoleHandler();
        FileHandler fh = new FileHandler("log.xml");
        logger.addHandler(fh);
        //SimpleFormatter sFormat = new SimpleFormatter ();
        XMLFormatter xml = new XMLFormatter();
        //ch.setFormatter(sFormat);
        fh.setFormatter(xml);
        logger.info("Тестовое логирование" );

        int arr[] = {9, 8, 7, 6, 5, 4, 3, 2, 1};

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("\n");
        bubbleSort(arr, logger);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void bubbleSort(int[] arr, Logger logger) {
        int n = arr.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                    logger.info("Итерация " + i + "-" + j);
                }
            }
        }
    }
}
