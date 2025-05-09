package tictactoe;
import java.util.Scanner;
public class Main {

    static int runde=0;
    static char winner= ' ';

    public static void gameState(char[][] tic) {

        //waagrecht
        int zähler = 0;
        int anzahl = 0;
        char saved = ' ';
        for (int i = 0; i < 3; ++i) {
            for (int j = 1; j < 3; ++j) {
                //System.out.println(tic[i][j]);
                if ((tic[i][j] != ' ') && tic[i][j] == tic[i][0]) {
                    zähler += 1;
                } else {
                    zähler = 0;
                    break;
                }
                if (zähler == 2) {
                    winner = tic[i][j];
                    return;
                }
            }
        }

        //senkrecht
        zähler = 0;
        anzahl = 0;
        saved = ' ';

        for (int i = 0; i < 3; ++i) {
            for (int j = 1; j < 3; ++j) {
                if ((tic[j][i] == tic[0][i]) && tic[j][i] != ' ') {
                    zähler += 1;
                } else {
                    zähler = 0;
                    break;
                }
                if (zähler == 2) {
                    winner= tic[j][i];
                    //System.out.println(saved + " wins");
                    //System.exit(1);
                }
            }
        }

        //diagonal

        if ((tic[0][0] == tic[1][1] && tic[0][0] == tic[2][2] || (tic[2][0] == tic[1][1] && tic[2][0] == tic[0][2])&& tic[1][1]!=' ')) {
            winner=tic[1][1];
            return;
        }

    }


    public static void analyseGame(char [][] tic) {
        Scanner scanner= new Scanner(System.in);
        int x,y;
        while(true) {
            try {
                x = scanner.nextInt();
                y = scanner.nextInt();
                //System.out.println("Im Bereich eins-3");
                if(x>3||x<1||y>3||y<1){
                    System.out.println("Coordinates should be from 1 to 3!");
                    scanner.nextLine();
                    continue;
                }
                if((tic[x-1][y-1]=='X')||(tic[x-1][y-1]=='O')){
                    System.out.println("This cell is occupied! Choose another one!");
                    scanner.nextLine();
                    continue;
                }
                if(runde%2==0) {
                    tic[x - 1][y - 1] = 'X';
                }
                else{
                    tic[x-1][y-1]='O';
                }
                ++runde;
                break;
            } catch (Exception e) {
                System.out.println("You should enter numbers!");
                scanner.nextLine();
            }
        }





        /*
        boolean isValid=true;
        if((x<0||x>3||y<0||y>3)){
            System.out.println("Print Coordinates should be from 1 to 3!" );
            isValid=false;
        }
        if(tic[x-1][y-1]=='X'||tic[x-1][y-1]=='O'){
            System.out.println("This cell is occupied! Choose another one!");
            return;
        }

*/


    }
    public static void main(String[] args) {
        // write your code here
        //Scanner scanner = new Scanner(System.in);

        //String eingabe = scanner.nextLine();

        //System.out.println("---------");

        //Ausgabe
        String firstLine = "| ";

        char[][] tic = new char[3][3];


        int counter = 0;

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                tic[i][j] = ' ';
            }
        }


        for(int start=0;start<=9;++start){



            System.out.println("---------");
            for (int i = 0; i < 3; ++i) {
                System.out.print(firstLine);
                for (int j = 0; j < 3; ++j) {
                    System.out.print(tic[i][j]);
                    System.out.print(" ");
                }
                System.out.println("|");
            }

            System.out.println("---------");

            gameState(tic);

            if(winner=='X'||winner=='O') {
                System.out.println(winner + " wins");
                System.exit(1);
            }


            analyseGame(tic);




            //notpossible(tic);
            //waagrecht(tic);
            //senkrecht(tic);
           // diagonal(tic);
            //draw(tic);

           // System.out.println("---------");

        }
/*
        for (int i = 0; i < 3; ++i) {
            System.out.print(firstLine);
            for (int j = 0; j < 3; ++j) {
                System.out.print(tic[i][j]);
                System.out.print(" ");
            }
            System.out.println("|");
        }

        System.out.println("---------");

*/




        /*


        notpossible(tic);
        waagrecht(tic);
        senkrecht(tic);
        diagonal(tic);
        draw(tic);
        System.out.println("Draw");

        //Berechnen



        //Waagrecht


        //Senkrecht

        //Diagonal


        //Draw berechen
        //for(int i=)
        //System.out.println("Draw");



         */
    }





}