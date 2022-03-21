import java.util.Scanner;

public class ex2 {

    public static void main(String[] args) {

        int l = 3, c = 3;
        int[][] matrice1 = new int[l][c];
        int[][] matrice2 = new int[l][c];
        int[][] matrice3 = new int[l][c];
        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < c; j++) {

                matrice1[i][j] = scan.nextInt();

            }
        }
/*
        for(int i=0;i<l;i++){
            for(int j=0;j<c;j++){

                matrice2[i][j] = scan.nextInt();

            }
        }
        scan.close();


        for(int i=0;i<l;i++) {
            for (int j = i; j < c; j++) {
                int suma =0;


                for (int r = 0; r< c; j++) {
          suma+=matrice1[i][]*matrice2[][];
                }
                matrice3[i][j]=suma;
            }
        }


    }

*/

    }
}
