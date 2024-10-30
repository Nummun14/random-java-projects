package bagrutpracticequestions;

import java.util.Scanner;

public class Question1 {
    Scanner input = new Scanner(System.in);
    int[]
            a = {2, 8, 8, 8, 12, 24, 7, 7, 6},
            b = {0, 0, 0, 0, 0, 0, 0, 0};
    int count = 0;
    for (int i = 0; i < (a.length - 1); i++){
        if(a[i] == a[i+1]) {
            b[count] = a[i];
            count++;
        }
    }
}
