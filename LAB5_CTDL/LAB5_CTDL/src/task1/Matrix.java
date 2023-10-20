package task1;

import java.util.Iterator;

public class Matrix {
	// add 2 matrices
	public static int[][] add(int[][] a, int[][] b) {
		int row = a.length;
		int col = a[0].length;

		int[][] c = new int[row][col];
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[0].length; j++) {
				c[i][j] = a[i][j] + b[i][j];
			}
		}
		return c;

	}
	// subtract 2 matrices
	public static int[][]subtract(int[][] a, int[][] b) {
         int row = a.length;
         int col = a[0].length;
         int[][] d = new int[row][col];
         for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				d[i][j] = a[i][j] - b[i][j];
				
			}
		}
         return d;
	}
     
	// multiply 2 matrices
	public static int[][] multiply(int[][] a, int[][] b) {
         int row = a.length;
         int col = a[0].length;
         int p = b[0].length;
         int[][] e = new int[row][p];
         for (int i = 0; i < e.length; i++) {
			for (int j = 0; j < p; j++) {
				for (int k = 0; k < col; k++) {
					e[i][j] += a[i][k]*b[k][j];
				}
				
				
			}
		}
         return e;
	}
	public static void testMultiplyMatrix() {
		int[][]a = {
				{1,2,3},
				{4,5,6}    
		};
		int[][]b = {
				{7,8},
				{9,10},
				{11,12}
		};
		int[][] result = multiply(a, b);
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				System.out.format("%4d", result[i][j]);
			}
			System.out.println();
		}
	}
	
	// tranpose a matrix
	public static int[][] transpose(int[][] a) {
		int row = a.length;
		int col = a[0].length;
		int[][] b = new int[col][row];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				b[j][i] = a[i][j];
			}
		}
		return b;
	}
  
	public static void testTranposeMatrix() {
		int[][]a = {
				{1,2,3},
				{4,5,6}
		};
		 int[][] result = transpose(a);
		 for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Test cho trường hợp cộng hai ma trận: ");
		int[][] a = {
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};
		
		int[][] b = {
				{9,8,7},
				{6,5,4},
				{3,2,1}
					
					
				
		};
		
		int[][] c = add(a, b);
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[0].length; j++) {
				System.out.format("%4d", c[i][j]);
			}
			
			System.out.println();
		}
		
		System.out.println("Test cho trường hợp trừ hai ma trận: ");
		
		int[][] d = subtract(a, b);
		for (int i = 0; i < d.length; i++) {
			for (int j = 0; j < d[0].length; j++) {
				System.out.format("%4d", d[i][j]);
			}
			System.out.println();
		}
		
		//
		System.out.println("Test cho trường hợp nhân 2 ma trận");
            testMultiplyMatrix();
        
	//
            System.out.println("Test cho trường hợp ma trận chuyển vị");
            testTranposeMatrix();
}
}