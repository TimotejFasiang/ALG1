import java.util.Scanner;

/* 
 * 28. This program checks whether a matrix is orthonormal by testing vector magnitude and dot multiplication 
 * @author Timotej Fašiang
 * @version 1.1, January 11 2022
 */ 

class SemestralniPrace {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        //Good luck Tim!
        while (true) {
            System.out.println("Ulohu zadanou na hodine nebo vánoční úlohu? ");
            String zadani = sc.nextLine();
            if (zadani.contains("vano") || zadani.contains("Vano") || zadani.contains("váno") || zadani.contains("Váno")) {
                //VANOCNI ULOHU
                VanocniUloha.main();
            }
            else {
                //ULOHU ZADANOU NA HODINE
                Uloha.uloha28();
            }
        }
    }
} // Semestralni prace class close

class Uloha {
    private static Scanner sc = new Scanner(System.in);
    public static void uloha28() {
        while (true) { // Main loop
            System.out.println("Počet vektoru: ");
            int pocet = sc.nextInt();
            if (pocet <= 0) { // Condition to break from main loop
                break;
            }
            Double[][] matrix = new Double[pocet][pocet];
            System.out.println("Zadej vektory");
            for (int i = 0; i < pocet; i++) { // Creates matrix from input
                for (int j = 0; j < pocet; j++) {
                    Double vectInput = sc.nextDouble();
                    matrix[i][j] = vectInput;
                }
            }
            if (magnitudeTest(matrix, pocet) && dotProductTest(matrix, pocet)) {
                System.out.println("System vektoru je ortonormalni");
            } else {
                System.out.println("System vektoru neni ortonormalni");
            }
            //System.out.println(Arrays.deepToString(matrix).replace("], ", "]\n"));
        }
    }
    public static boolean magnitudeTest(Double[][] matrix, int pocet) { // Checks whether the vectors from the matrix input are of magnitude(Delka vektoru) 1 
        int False = 0;
        Double[] vector;
        for (int i = 0; i < pocet; i++) { 
            double magnitude = 0.0;
            vector = new Double[pocet];
            for (int j = 0; j < pocet; j++) { // Creates vectors from the matrix input
                vector[j] = matrix[i][j];
            }
            for (int j = 0; j < vector.length; j++) { // Sum of all the elements squared
                magnitude += Math.pow(vector[j], 2);
            }
            if (Math.sqrt(magnitude) != 1) { // Final magnitude calculation 
                False = 1;
            }
        }
        return (False != 1);
    }
    public static boolean dotProductTest(Double[][] matrix, int pocet) { // Checks whether the dot-product(Skalární součin) of all the vectors are equal to 0 
        Double sum = 0.0;
        Double[] vector1 = new Double[pocet];
        Double[] vector2 = new Double[pocet];
        for (int i = 0; i < pocet; i++) { // Cycles through all the vectors in the matrix
            for (int j = 0; j < pocet; j++) { // Creates vector1 from the matrix
                vector1[j] = matrix[i][j];
            }
            for (int j = i+1; j < pocet; j++) { // "j = i+1" is to make sure vector2 is after vector1 in the order from the input matrix.  
                for (int k = 0; k < pocet; k++) { // Creates vector2 from the matrix
                    vector2[k] = matrix[j][k];
                }
                for (int k = 0; k < pocet; k++) { // Does the actual vector dot/scalar multiplication
                    sum += vector1[k] * vector2[k];
                }
            }   
        }
        return (sum == 0);
    }
} // Uloha class close

class VanocniUloha {
    public static void main() {
        // Good luck Tim!
        display_tree();
        System.out.println("");
        System.out.println("");
    }

    public static final String TEXT_RESET = "\u001B[0m";   // Changes 
    public static final String TEXT_RED = "\u001B[31m";    // color 
    public static final String TEXT_GREEN = "\u001B[32m";  // for
    public static final String TEXT_YELLOW = "\u001B[33m"; // text
    public static final String TEXT_BLUE = "\u001B[34m";   // output
    
    static void empty(int sizeb) { // Prints empty space before the tree
        System.out.println("");
        for (int i=0; i<sizeb; i++) {
            System.out.print(" ");
        }
    }

    static void full(int s, String ornament) { // Prints the tree part
        for (int i=0; i<s; i++) {
            double ran = Math.random()*100;
            double rando = Math.random()*3;
            if (ran < 85 ) {
                System.out.print(TEXT_GREEN + "*" + TEXT_RESET);
            }
            else { // Randomly selects color for the ornament
                if (rando<1) {
                    System.out.print(TEXT_RED + ornament + TEXT_RESET);
                }
                else if (rando<2) {
                    System.out.print(TEXT_YELLOW + ornament + TEXT_RESET);
                }
                else {
                    System.out.print(TEXT_BLUE + ornament + TEXT_RESET);
                }
            }
        }
    }
    
    static void display_tree() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Výška vánočního stromku: ");
        int size = sc.nextInt(); 
        System.out.println("Typ ornamentu(znak): ");
        String ornament = sc.next();
        for (int r=1; r <= size; r++) { 
            int s = 2*r-1; // Calculates how much of the tree is visible on the printed line
            empty((2*size-2*r)/2); // Caluclates how much space before the tree should appear on the printed line
            full(s, ornament); 
        }
    }
} // Vanocni Uloha class close