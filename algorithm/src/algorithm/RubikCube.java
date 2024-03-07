package algorithm;
import java.util.*;
public class RubikCube {
	public static void print(char[][][] cube) {
		for (int face = 0; face < 6; face++) {
            System.out.println("Face " + face + ":");
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    System.out.print(cube[face][row][col]);
                }
                System.out.println();
            }
        }
	}
	public static void TopLayer(char[][][] cube) {
        char[][] temp = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                temp[i][j] = cube[0][i][j];
            }
        }
        cube[0][0][0] = temp[2][0];
        cube[0][0][1] = temp[1][0];
        cube[0][0][2] = temp[0][0];
        cube[0][1][0] = temp[2][1];
        cube[0][1][1] = temp[1][1];
        cube[0][1][2] = temp[0][1];
        cube[0][2][0] = temp[2][2]; 
        cube[0][2][1] = temp[1][2];
        cube[0][2][2] = temp[0][2];
	}    
	public void FaceClockwise(int face,char[][][]cube) {
		int n = cube[0].length; 
        int[][] temp = new int[n][n];
 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = cube[face][i][j];
            }
        }
 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cube[face][i][j] = (char) temp[n - 1 - j][i];
            }
        }
    }

    public void FaceAntiClockwise(int face) {
    	
    }

    public void LeftClock(int face,char[][][]cube) {
    	int n = cube.length;
        int[][][] newCube = new int[n][n][n];
 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    newCube[i][j][k] = cube[i][j][k];
                }
            }
        }
 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (k == 0) {
                        cube[i][j][k] = (char) newCube[i][j][n - 1];
                    } else {
                        cube[i][j][k] = (char) newCube[i][j][k - 1];
                    }
                }
            }
        }
        
    }

    public void RightClock(int col,char[][][] cube) {
    	char[][] temp = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                temp[i][j] = cube[2][i][j];
            }
        }
        
        for (int i = 0; i < 3; i++) {
            cube[2][i][0] = cube[5][i][2];
            cube[2][i][2] = cube[4][2 - i][0];
            cube[5][i][2] = cube[0][2 - i][2];
            cube[4][i][0] = temp[i][0];
        }
    }
    
//    	int[][][] temp = new int[6][3][3];
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                for (int k = 0; k < 3; k++) {
//                    if (i == 3 - 1) {
//                        temp[i][j][k] = cube[i][j][k];
//                        cube[i][j][k] = cube[i][j][3 - k - 1];
//                    }
//                }
//            }
//        }
//        for (int i = 0; i < 6; i++) {
//            for (int j = 0; j < 3; j++) {
//                for (int k = 0; k < 3; k++) {
//                    if (i == 3 - 1) {
//                        cube[i][j][3 - k - 1] = temp[i][j][k];
//                    }
//                }
//            }
//        }
//    }
    
    
    public void LeftAntiClock(int face,char[][][]cube) {
    	int[] tempColumn = new int[3];
        int[][] currentLeftFace = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                currentLeftFace[i][j] = cube[0][i][j];
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cube[0][i][j] = cube[4][i][j];  
                cube[4][i][j] = cube[5][i][j]; 
                cube[5][i][j] = cube[2][2 - i][2 - j];  

                if (i == 0) {
                     
                    tempColumn[j] = cube[3][2 - j][0];
                }
                if (i == 2) {
                     
                    cube[3][2 - j][0] = (char) tempColumn[j];
                }
            }
        }

    
        for (int i = 0; i < 3; i++) {
            cube[1][i][0] = (char) currentLeftFace[i][0];
        }
    }


    public void RightAntiClock(int col,char[][][] cube) {
    	char[][][] temp = new char[3][3][3];

         
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                temp[0][i][j] = cube[0][i][j];
                cube[0][i][j] = cube[2][i][j];
                cube[2][i][j] = cube[5][2 - i][2 - j];
                cube[5][2 - i][2 - j] = cube[4][i][j];
                cube[4][i][j] = temp[0][i][j];
            }
        }
        char[] tempColumn = new char[3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tempColumn[j] = cube[1][i][j];
            }
            for (int j = 0; j < 3; j++) {
                cube[1][i][j] = tempColumn[(j + 1) % 3];
            }
        }
    }
    
    public void UpClock(int face) {
        
    }

    public void UpAntiClock(int col) {
        
    }
    
    public void Row(int row, boolean isClockwise) {

    }

    public void Col(int col, boolean isClockwise) {

    }

	
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	char[][][] cube=new char[6][3][3];
	for (int face = 0; face < 6; face++) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                cube[face][row][col] = sc.next().charAt(0);
            }
        }
	}
	
}
}
