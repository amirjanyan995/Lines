package ru.game.frameHeaderFile;

public class GameCheck implements Constants {
	// private static GamePanel gamePanel=new GamePanel();
	private static final int BLOK_LENGTH = 5;
	private static int mas1[][] = new int[ARRAY_LENGTH][ARRAY_LENGTH];
	private static int mas2[][] = new int[ARRAY_LENGTH][ARRAY_LENGTH];
	private static int mas3[][] = new int[ARRAY_LENGTH][ARRAY_LENGTH];
	private static int mas4[][] = new int[ARRAY_LENGTH][ARRAY_LENGTH];

	private static int finishResultArray[][] = new int[ARRAY_LENGTH][ARRAY_LENGTH];

	/*
	 * glxavor xekavarox marmin
	 */
	public static int[][] headerCheck(int i, int j, int arr[][]) {
		for (int m = 0; m < arr.length; m++) {
			for (int n = 0; n < arr[m].length; n++) {
				mas1[m][n] = arr[m][n];
				mas2[m][n] = arr[m][n];
				mas3[m][n] = arr[m][n];
				mas4[m][n] = arr[m][n];
			}
		}
		horizontalCheck(i, j);
		verticalCheck(i, j);
		leftDiagonal(i, j);
		rigthDiagonal(i, j);
		for (int m = 0; m < arr.length; m++) {
			for (int n = 0; n < arr[m].length; n++) {
				if (mas1[m][n] == mas2[m][n] && mas2[m][n] == mas3[m][n] && mas3[m][n] == mas4[m][n]) {
					finishResultArray[m][n] = mas1[m][n];
				} else {
					finishResultArray[m][n] = 0;
				}
			}
		}

		return finishResultArray;
	}

	/*
	 * katarum e horizonakan stugum nshavc kordinatnerov mas1
	 */
	private static void horizontalCheck(int i, int j) {
		final int STAT = mas1[i][j];
		int counter = 0, blokStart = 0, blokEnd = 0;
		boolean check = false;
		for (int index = 0; index < mas1.length; index++) {
			if (mas1[i][index] == STAT) {
				if (counter == 0) {
					blokStart = index;
				}
				if (index == mas2.length - 1) {
					blokEnd = index;
					check = true;
				}
				counter++;
			} else {
				if (counter >= BLOK_LENGTH) {
					blokEnd = index - 1;
					check = true;
					break;
				}
				blokStart = 0;
				blokEnd = 0;
				counter = 0;
			}
		}
		if (!check) {
			blokStart = 0;
			blokEnd = 0;
		}

		if (j >= blokStart && j <= blokEnd && counter >= BLOK_LENGTH) {
			for (int index = blokStart; index <= blokEnd; index++) {
				mas1[i][index] = 0;
			}
		}
	}

	/*
	 * katarum e uxahayac stugum nshvac kordinatnerov mas2
	 */
	private static void verticalCheck(int i, int j) {
		final int STAT = mas2[i][j];
		int counter = 0, blokStart = 0, blokEnd = 0;
		boolean check = false;

		for (int index = 0; index < mas2.length; index++) {
			if (mas2[index][j] == STAT) {
				if (counter == 0) {
					blokStart = index;
				}
				if (index == mas2.length - 1) {
					blokEnd = index;
					check = true;
				}
				counter++;
			} else {
				if (counter >= BLOK_LENGTH) {
					blokEnd = index - 1;
					check = true;
					break;
				}
				blokStart = 0;
				blokEnd = 0;
				counter = 0;
			}
		}
		if (!check) {
			blokStart = 0;
			blokEnd = 0;
		}
		// System.out.println("start->"+blokStart);
		// System.out.println("end->"+blokEnd);

		if (i >= blokStart && i <= blokEnd && counter >= BLOK_LENGTH) {
			for (int index = blokStart; index <= blokEnd; index++) {
				mas2[index][j] = 0;
			}
		}
	}

	/*
	 * katarum e dzax stugum nshvac kordinatnerov mas3
	 */
	private static void leftDiagonal(int i, int j) {
		final int STAT = mas3[i][j];
		int counter = 0;
		int blokStartI = 0, blokEndI = 0;
		int blokStartJ = 0, blokEndJ = 0;
		boolean check = false;
		boolean q = false;

		int startI = (i - j >= 0) ? (i - j) : 0;
		// System.out.println("start I-"+startI);
		int startJ = (j - i > 0) ? (j - i) : 0;
		// System.out.println("start J-"+startJ);

		// dzax ankyunagcic nerqev
		if (i - j >= 0) {
			for (int m = startI, n = startJ; m < mas3.length; m++, n++) {
				if (mas3[m][n] == STAT) {
					if (counter == 0) {
						blokStartI = m;
						blokStartJ = n;
					}
					if (m == i & n == j)
						q = true;
					if (m == mas3.length - 1) {
						blokEndI = m;
						blokEndJ = n;
						check = true;
					}
					counter++;
				} else {
					if (counter >= BLOK_LENGTH) {
						blokEndI = m - 1;
						blokEndJ = n - 1;
						check = true;
						break;
					}
					blokStartI = 0;
					blokStartJ = 0;
					blokEndI = 0;
					blokEndJ = 0;
					counter = 0;
					q = false;
				}
			}
			if (!check) {
				blokStartI = 0;
				blokStartJ = 0;
				blokEndI = 0;
				blokEndJ = 0;
			}
		} else {// dzax ankyunagcic verev
			for (int m = startI, n = startJ; n < mas3.length; m++, n++) {
				if (mas3[m][n] == STAT) {
					if (counter == 0) {
						blokStartI = m;
						blokStartJ = n;
					}
					if (m == i & n == j)
						q = true;
					if (n == mas3.length - 1) {
						blokEndI = m;
						blokEndJ = n;
						check = true;
					}
					counter++;
				} else {
					if (counter >= BLOK_LENGTH) {
						blokEndI = m - 1;
						blokEndJ = n - 1;
						check = true;
						break;
					}
					blokStartI = 0;
					blokStartJ = 0;
					blokEndI = 0;
					blokEndJ = 0;
					counter = 0;
					q = false;
				}
			}
			if (!check) {
				blokStartI = 0;
				blokStartJ = 0;
				blokEndI = 0;
				blokEndJ = 0;
			}
		}
		//
		if (q && counter >= BLOK_LENGTH) {
			if (i - j >= 0) {
				for (int m = blokStartI, n = blokStartJ; m <= blokEndI; m++, n++) {
					// System.out.println("i-"+m+" j-"+n);
					mas3[m][n] = 0;
				}
			} else {
				for (int m = blokStartI, n = blokStartJ; n <= blokEndJ; m++, n++) {
					// System.out.println("i-"+m+" j-"+n);
					mas3[m][n] = 0;
				}
			}
		}
	}

	/*
	 * katarum e aj ankyunagci stugum mas4
	 */
	private static void rigthDiagonal(int i, int j) {
		final int STAT = mas4[i][j];
		int counter = 0;
		int blokStartI = 0, blokEndI = 0;
		int blokStartJ = 0, blokEndJ = 0;
		boolean check = false;
		boolean q = false;

		int startI = (i + j <= ARRAY_LENGTH - 1) ? 0 : (i - ((ARRAY_LENGTH - 1) - j));
		// System.out.println("start I-"+startI);
		int startJ = (i + j <= ARRAY_LENGTH - 1) ? (i + j) : ARRAY_LENGTH - 1;
		// System.out.println("start J-"+startJ);

		// ankyunagcic verev
		if (i + j <= (ARRAY_LENGTH - 1)) {
			for (int m = startI, n = startJ; n >= 0; m++, n--) {
				if (mas4[m][n] == STAT) {
					if (counter == 0) {
						blokStartI = m;
						blokStartJ = n;
					}
					if (m == i & n == j)
						q = true;
					if (n == 0) {
						blokEndI = m;
						blokEndJ = n;
						check = true;
					}
					counter++;
				} else {
					if (counter >= BLOK_LENGTH) {
						blokEndI = m - 1;
						blokEndJ = n + 1;
						check = true;
						break;
					}
					blokStartI = 0;
					blokStartJ = 0;
					blokEndI = 0;
					blokEndJ = 0;
					counter = 0;
					q = false;
				}
			}
		} else {// ankyunagcic nerqev
			for (int m = startI, n = startJ; m < mas4.length; m++, n--) {
				if (mas4[m][n] == STAT) {
					if (counter == 0) {
						blokStartI = m;
						blokStartJ = n;
					}
					if (m == i & n == j)
						q = true;
					if (m == mas4.length - 1) {
						blokEndI = m;
						blokEndJ = n;
						check = true;
					}
					counter++;
				} else {
					if (counter >= BLOK_LENGTH) {
						blokEndI = m - 1;
						blokEndJ = n + 1;
						check = true;
						break;
					}
					blokStartI = 0;
					blokStartJ = 0;
					blokEndI = 0;
					blokEndJ = 0;
					counter = 0;
					q = false;
				}
			}
		}

		if (q && counter >= BLOK_LENGTH) {
			if (i + j <= (ARRAY_LENGTH - 1)) {
				for (int m = blokStartI, n = blokStartJ; n >= blokEndJ; m++, n--)
					mas4[m][n] = 0;

			} else {
				for (int m = blokStartI, n = blokStartJ; m <= blokEndI; m++, n--)
					mas4[m][n] = 0;

			}
		}
	}
}
