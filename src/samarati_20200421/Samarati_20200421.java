package samarati_20200421;

import java.util.Scanner;

public class Samarati_20200421 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s, s1;
        char c;
        int nummer, ss = 0, sz = 0, sw = 0, count = 0;
        boolean main = true;
        int[][] sudoku = new int[9][9]; 
        int[][] lösung = new int[9][9];
        System.out.println("Sudoku - Ziffern duerfen nur einmal vorkommen!");
        nummer = random();
        sudoku = sudoku(nummer);
        lösung = lösung(nummer);
        while(main){
            ausgabe(sudoku);
            s = sc.next();
            c = (s.toLowerCase()).charAt(0);
            switch(c){
                case 'n':{
                    l(count, sudoku, lösung);
                    nummer = random();
                    sudoku = sudoku(nummer);
                    lösung = lösung(nummer);
                    break;
                }
                case 'l':{
                    l(count, sudoku, lösung);
                    sudoku = sudoku(nummer);
                    break;
                }
                case 'x':{System.out.println("Good Bye SUDOKU!"); main = false; break;}
                default:{
                    count++;
                    s = s.toLowerCase();
                    c = s.charAt(0);
                    switch(c){
                        case 'a': ss = 0; break;
                        case 'b': ss = 1; break;
                        case 'c': ss = 2; break;
                        case 'd': ss = 3; break;
                        case 'e': ss = 4; break;
                        case 'f': ss = 5; break;
                        case 'g': ss = 6; break;
                        case 'h': ss = 7; break;
                        case 'i': ss = 8; break; 
                    }
                    c = s.charAt(1); s1 = String.valueOf(c); sz = Integer.parseInt(s1)-1;
                    c = s.charAt(2); s1 = String.valueOf(c); sw = Integer.parseInt(s1);
                    if(sudoku[sz][ss]>=0){
                        sudoku[sz][ss] = sw;
                    }else{
                        System.out.println("Wertzuweisung nicht möglich! ");
                    }
                    break;}
            }
        }
    }
    
    public static int random(){
        int number = (int) (1 + Math.round( Math.random() * (4 - 1) ));
        return number;
    }
    
    public static int[][] sudoku(int number){
        int[][] sudokuABCD = new int[9][9];
        int[][] sudokuA = {{ 0, -6, -1, -3,  0,  0, -4,  0, -5},
                           { 0,  0,  0,  0,  0, -2,  0, -7, -8},
                           {-9,  0,  0, -1, -5, -4, -2,  0,  0},
                           { 0, -4, -7,  0, -9,  0,  0, -2,  0},
                           { 0,  0,  0, -2,  0, -5,  0,  0,  0},
                           { 0, -3,  0,  0, -1,  0, -6, -8,  0},
                           { 0,  0, -5, -7, -2, -3,  0,  0, -1},
                           {-7, -1,  0, -6,  0,  0,  0,  0,  0},
                           {-6,  0, -9,  0,  0, -1, -3, -4,  0}};

        int[][] sudokuB = {{-9,  0,  0, -1,  0,  0, -5,  0,  0},
                           { 0, -6,  0,  0, -2,  0, -4, -8,  0},
                           {-4,  0, -2, -6,  0, -7,  0,  0, -9},
                           { 0, -3, -9,  0, -7,  0,  0,  0,  0},
                           {-2, -8,  0, -5,  0, -1,  0, -9, -3},
                           { 0,  0,  0,  0, -9,  0, -6, -4,  0},
                           {-5,  0,  0, -4,  0, -8, -3,  0, -2},
                           { 0, -2, -3,  0, -5,  0,  0, -6,  0},
                           { 0,  0, -7,  0,  0, -6,  0,  0, -1}};
        
        int[][] sudokuC = {{-8,  0,  0, -6,  0, -2, -7,  0, -5},
                           { 0,  0, -7,  0, -8,  0, -9, -1,  0},
                           { 0, -2,  0, -3,  0, -9,  0,  0, -6},
                           {-1, -3, -4,  0,  0,  0,  0, -2,  0},
                           { 0,  0,  0, -5,  0, -1,  0,  0,  0},
                           { 0, -5,  0,  0,  0,  0, -1, -4, -8},
                           {-4,  0,  0, -2,  0, -6,  0, -9,  0},
                           { 0, -7, -5,  0, -9,  0, -3,  0,  0},
                           {-6,  0, -8, -7,  0, -4,  0,  0, -1}};
        
        int[][] sudokuD = {{ 0,  0, -9,  0, -2,  0, -7,  0,  0},
                           { 0, -5, -7, -8,  0,  0, -6, -9,  0},
                           {-3, -6,  0,  0,  0, -4,  0, -5, -2},
                           { 0,  0, -4,  0, -9,  0,  0, -6,  0},
                           {-1,  0,  0, -2, -3, -5,  0,  0, -8},
                           { 0, -3,  0,  0, -6,  0, -1,  0,  0},
                           {-9, -4,  0, -6,  0,  0,  0, -8, -7},
                           { 0, -1, -2,  0,  0, -9, -3, -4,  0},
                           { 0,  0, -5,  0, -4,  0, -9,  0,  0}};
        switch(number){
            case 1: sudokuABCD = sudokuA; break;
            case 2: sudokuABCD = sudokuB; break;
            case 3: sudokuABCD = sudokuC; break;
            case 4: sudokuABCD = sudokuD; break;
        }
        return sudokuABCD;
    }
    
    public static void ausgabe(int[][] sudoku){
            System.out.println("    | a | b | c | d | e | f | g | h | i ");
            System.out.println("----o---+---+---o---+---+---o---+---+---o");
            System.out.print("1   | ");for(int i = 0;i<9;i++){if(sudoku[0][i]==0){System.out.print("  | ");}else{System.out.print(Math.abs(sudoku[0][i])+" | ");}}System.out.println("");
            System.out.println("----+---+---+---+---+---+---+---+---+---+");
            System.out.print("2   | ");for(int i = 0;i<9;i++){if(sudoku[1][i]==0){System.out.print("  | ");}else{System.out.print(Math.abs(sudoku[1][i])+" | ");}}System.out.println("");
            System.out.println("----+---+---+---+---+---+---+---+---+---+");
            System.out.print("3   | ");for(int i = 0;i<9;i++){if(sudoku[2][i]==0){System.out.print("  | ");}else{System.out.print(Math.abs(sudoku[2][i])+" | ");}}System.out.println("");
            System.out.println("----o---+---+---o---+---+---o---+---+---o");
            System.out.print("4   | ");for(int i = 0;i<9;i++){if(sudoku[3][i]==0){System.out.print("  | ");}else{System.out.print(Math.abs(sudoku[3][i])+" | ");}}System.out.println("");
            System.out.println("----+---+---+---+---+---+---+---+---+---+");
            System.out.print("5   | ");for(int i = 0;i<9;i++){if(sudoku[4][i]==0){System.out.print("  | ");}else{System.out.print(Math.abs(sudoku[4][i])+" | ");}}System.out.println("");
            System.out.println("----+---+---+---+---+---+---+---+---+---+");
            System.out.print("6   | ");for(int i = 0;i<9;i++){if(sudoku[5][i]==0){System.out.print("  | ");}else{System.out.print(Math.abs(sudoku[5][i])+" | ");}}System.out.println("");
            System.out.println("----o---+---+---o---+---+---o---+---+---o");
            System.out.print("7   | ");for(int i = 0;i<9;i++){if(sudoku[6][i]==0){System.out.print("  | ");}else{System.out.print(Math.abs(sudoku[6][i])+" | ");}}System.out.println("");
            System.out.println("----+---+---+---+---+---+---+---+---+---+");
            System.out.print("8   | ");for(int i = 0;i<9;i++){if(sudoku[7][i]==0){System.out.print("  | ");}else{System.out.print(Math.abs(sudoku[7][i])+" | ");}}System.out.println("");
            System.out.println("----+---+---+---+---+---+---+---+---+---+");
            System.out.print("9   | ");for(int i = 0;i<9;i++){if(sudoku[8][i]==0){System.out.print("  | ");}else{System.out.print(Math.abs(sudoku[8][i])+" | ");}}System.out.println("");
            System.out.println("----o---+---+---o---+---+---o---+---+---o");
            System.out.println("(N)eues Feld, (L)oesung, E(x)it, SZW-Befehl (z.B. E54)?");
    }
    
    public static int[][] lösung(int number){
        int[][] lösungABCD = new int[9][9];
        int[][] lösungA = {{ 2, -6, -1, -3,  7,  8, -4,  9, -5},
                           { 3,  5,  4,  9,  6, -2,  1, -7, -8},
                           {-9,  7,  8, -1, -5, -4, -2,  3,  6},
                           { 1, -4, -7,  8, -9,  6,  5, -2,  3},
                           { 8,  9,  6, -2,  3, -5,  7,  1,  4},
                           { 5, -3,  2,  4, -1,  0, -6, -8,  9},
                           { 4,  8, -5, -7, -2, -3,  9,  6, -1},
                           {-7, -1,  3, -6,  4,  9,  8,  5,  2},
                           {-6,  2, -9,  5,  8, -1, -3, -4,  7}};

        int[][] lösungB = {{-9,  7,  8, -1,  4,  3, -5,  2,  6},
                           { 3, -6,  1,  9, -2,  5, -4, -8,  7},
                           {-4,  5, -2, -6,  8, -7,  1,  3, -9},
                           { 6, -3, -9,  8, -7,  4,  2,  1,  5},
                           {-2, -8,  4, -5,  6, -1,  7, -9, -3},
                           { 7,  1,  5,  3, -9,  2, -6, -4,  8},
                           {-5,  9,  6, -4,  1, -8, -3,  7, -2},
                           { 1, -2, -3,  7, -5,  9,  8, -6,  4},
                           { 8,  4, -7,  2,  3, -6,  9,  5, -1}};
        
        int[][] lösungC = {{-8,  4,  9, -6,  1, -2, -7,  3, -5},
                           { 3,  6, -7,  4, -8,  5, -9, -1,  2},
                           { 5, -2,  1, -3,  7, -9,  4,  8, -6},
                           {-1, -3, -4,  8,  6,  7,  5, -2,  9},
                           { 9,  8,  2, -5,  4, -1,  6,  7,  3},
                           { 7, -5,  6,  9,  2,  3, -1, -4, -8},
                           {-4,  1,  3, -2,  5, -6,  8, -9,  7},
                           { 9, -7, -5,  1, -9,  8, -3,  6,  4},
                           {-6,  9, -8, -7,  3, -4,  2,  5, -1}};
        
        int[][] lösungD = {{ 4,  8, -9,  5, -2,  6, -7,  3,  1},
                           { 2, -5, -7, -8,  1,  3, -6, -9,  4},
                           {-3, -6,  1,  9,  7, -4,  8, -5, -2},
                           { 7,  2, -4,  1, -9,  8,  5, -6,  3},
                           {-1,  9,  6, -2, -3, -5,  4,  7, -8},
                           { 5, -3,  8,  4, -6,  7, -1,  2,  9},
                           {-9, -4,  3, -6,  5,  1,  2, -8, -7},
                           { 6, -1, -2,  7,  8, -9, -3, -4,  5},
                           { 8,  7, -5,  3, -4,  2, -9,  1,  6}};
        switch(number){
            case 1: lösungABCD = lösungA; break;
            case 2: lösungABCD = lösungB; break;
            case 3: lösungABCD = lösungC; break;
            case 4: lösungABCD = lösungD; break;
        }
        return lösungABCD;
    }
    
    public static void l(int count, int[][] sudoku, int[][] lösung){
        int korrekt = 0, leer = 0;
        double k;
        for(int i = 0;i<9;i++){
            for(int j = 0;j<9;j++){
                if(lösung[i][j]<0){}else{
                if(sudoku[i][j]==0){leer++;}else{
                if(sudoku[i][j]==lösung[i][j]){korrekt++;}
                }}
            }
        }
        k = 100*(korrekt/leer);
        System.out.println("Nach "+count+" Rateversuchen haben Sie das SUDOKU-Raetsel zu "+k+"% geloest.");
    }
}