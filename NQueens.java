package ajedrez;

/**
 *
 * @author abeta
 */
public class NQueens {
    static int N = 8;
    static int[] board = new int[N];
    static int tablero = 0;
    /**
 * Imprime el tablero actual de las reinas y muestra el número de intento.
 * Cada posición del tablero se representa con 'Q' para la reina y '.' para un espacio vacío.
 * Incrementa automáticamente el contador de intentos.
 */
    static void printBoard() {
        tablero++;
        System.out.println();
        System.out.println("Intento " + tablero + ":"); 
   
    for (int i = 0; i < N; i++) {
           for (int j = 0; j < N; j++) {
               if (board[i] == j) {
                   System.out.print("Q ");
               } else {
                   System.out.print(". ");
               }
           }
           System.out.println();
       }
       System.out.println();
   }

    public static void solve(int row) {
        
        if (row==N)
        {
            printBoard();
            return;
        }
        
        for (int col = 0; col < N; col++) {
            if (isSafe(row, col)) {
                board[row] = col; 
                solve(row + 1);
            }
        }
    }

    /** Verifica si no colisiona con otra reina
    *@param row fila
    *@param col columna
    *@return regresas True si no colisiona
    **/ 
    public static boolean isSafe(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i] == col 
                    || Math.abs(board[i] - col) == row - i) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
       solve(0);
    }
}
