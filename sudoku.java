import java.util.Scanner;
public class sudoku {
    public static boolean isSafe(int[][] grid, int row, int col, int i){
        for(int idx=0;idx<9;idx++){
            if(grid[row][idx]==i){
                return false;
            }else if(grid[idx][col]==i){
                return false;
            }
        }
        int blRow = (row/3)*3;
        int blCol = (col/3)*3;
        for(int rdx=0;rdx<3;rdx++){
            for(int cdx=0;cdx<3;cdx++){
                if (grid[blRow+rdx][blCol+cdx]==i){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean solver(int[][] grid, int row, int col){
        if (row==9){
            return true;
        }
        int nrow,ncol;
        if(col!=8){
            nrow=row;
            ncol=col+1;
        }else{
            nrow=row+1;
            ncol=0;
        }
        if (grid[row][col]!=0){
            if (solver(grid,nrow,ncol)){
                return true;
            }
        }else{
            for (int i=1; i<=9;i++){
                if (isSafe(grid,row,col,i)){
                    grid[row][col]=i;
                    if(solver(grid,nrow,ncol)){
                        return true;
                    }else{
                        grid[row][col]=0;
                    }
                }
            }
        }
        return false;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int[][] grid = new int[9][9];
        for (int i=0; i<9;i++){
            for(int j=0;j<9;j++){
                grid[i][j]=sc.nextInt();
            }
        }
        sc.close();
        solver(grid,0,0);
        System.out.println();
        for(int i=0;i<9;i++){
            for (int j=0;j<9;j++){
                System.out.print(grid[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
