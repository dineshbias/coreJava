/**
 * 
 */
package custom.data.structure.array;

/**
 * @author edinjos
 *
 */
public class Test2D {

	/**
	 * 
	 */
	public Test2D() {
		System.out.println("Test2D instantiated....");
	}

	public static void main(String... args) {

		int[][] data = new int[4][3];

		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				data[i][j] = (i + 1) * (j + 1);
			}
		}

		for (int[] row : data) {

			for (int column : row) {
				System.out.print(column + " ");
			}
			System.out.println();
		}

		int[] sumrows = new int[data.length];
		int[] sumColumns = new int[data[0].length];

		System.out.println("Rows size:" + sumrows.length);
		System.out.println("Columns size:" + sumColumns.length);

		for (int i = 0; i < sumrows.length; i++) {

			for (int j = 0; j < sumColumns.length; j++) {
				sumrows[i] = sumrows[i] + data[i][j];
				sumColumns[j] = sumColumns[j] + data[i][j];
			}
		}

		for (int row : sumrows) {
			System.out.print(row + " ");
		}

		System.out.println();

		for (int column : sumColumns) {
			System.out.print(column + " ");
		}
		System.out.println("\n*******");
		int count = 0;
		for (int k = 1; k < sumrows.length - 1; k++) {
			int sumBefore = 0;
			int sumAfter = 0;
			for (int l = 0; l < k; l++) {
				sumBefore = sumBefore + sumrows[l];
			}
			for (int m = k + 1; m < sumrows.length; m++) {
				sumAfter = sumAfter + sumrows[m];
			}
			System.out.println(k + ": " + sumBefore + " " + sumAfter);
			if (sumBefore == sumAfter)
				count++;
		}
		
		System.out.println("\n*******");
		
		for (int k = 1; k < sumColumns.length - 1; k++) {
			int sumBefore = 0;
			int sumAfter = 0;
			for (int l = 0; l < k; l++) {
				sumBefore = sumBefore + sumColumns[l];
			}
			for (int m = k + 1; m < sumColumns.length; m++) {
				sumAfter = sumAfter + sumColumns[m];
			}
			System.out.println(k + ": " + sumBefore + " " + sumAfter);
			if (sumBefore == sumAfter)
				count++;
		}
		
		System.out.println("Count:"+ count);
	}
}
