public class PecanGrowing {
    public static void main(String[] args) {
        int[][] orchard = {
            {5, 0, 7},
            {2, 3, 8},
            { 9, 1, 6}
        };
        
        PecanGrowing pecangrowing = new PecanGrowing();
        pecangrowing.path(orchard);
    }

    public void path(int[][] orchard) {
        int rows = orchard.length;
        int columns = orchard[0].length;
        int[][] P = new int[rows][columns];
        char[][] path = new char[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                P[i][j] = orchard[i][j];
                if (i == 0 && j == 0) {
                    path[i][j] = 'X';
                } else if (i == 0) {
                    P[i][j] += P[i][j - 1];
                    path[i][j] = 'L';
                } else if (j == 0) {
                    P[i][j] += P[i - 1][j];
                    path[i][j] = 'U';
                } else {
                    if (P[i - 1][j] > P[i][j - 1]) {
                        P[i][j] += P[i - 1][j];
                        path[i][j] = 'U';
                    } else {
                        P[i][j] += P[i][j - 1];
                        path[i][j] = 'L';
                    }
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(path[i][j] + "|");
            }
            System.out.println();
        }
        
        System.out.println("Score: " + P[rows - 1][columns - 1]);
    }
}
