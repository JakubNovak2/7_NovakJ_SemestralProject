package NovakJ_SemestralProject;

import java.util.Scanner;

public class SemestralniPraceMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do{
        System.out.println("Co chcete spustit? \n 1 - Semestralni uloha \n 2 - Vanocni uloha \n 3 - Konec");
        choice = sc.nextInt();
        if (choice == 1){
            SemestralniPraceUloha7.main(args);
        } else if (choice == 2){
            ChristmasNovakJakub.main(args);
        }
        System.out.println("");
        }while (choice ==1 || choice ==2);
        sc.close();
    }
}
