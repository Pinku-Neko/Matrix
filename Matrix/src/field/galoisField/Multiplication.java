package field.galoisField;

/**
 * this contains the table of multiplication 
 * for galois field of an non-prime amount of elements
 * 
 * @author Pinku_Neko
 *
 */
enum Multiplication {
	
	/**
	 * the table of multiplication for galois field of 4 elements
	 * 
	 * fundamental rule: α² = 1 + α.
	 */
	F4(new int[][]{
		
		{0,0,0,0},
		{0,1,2,3},
		{0,2,3,1},
		{0,3,1,2}
		
	} ),

	/**
	 * the table of addition for galois field of 8 elements 
	 * 
	 * fundamental rules: β^3 = 1 + β.
	 */
	F8(new int[][]{

		{0,0,0,0,0,0,0,0},
		{0,1,2,3,4,5,6,7},
		{0,2,4,6,5,7,1,3},
		{0,3,6,5,1,2,7,4},
		{0,4,5,1,7,3,2,6},
		{0,5,7,2,3,6,4,1},
		{0,6,1,7,2,3,4,5},
		{0,7,3,4,6,1,5,2}

	} ),
	
	/**
	 * the table of multiplication for galois field of 9 elements 
	 * 
	 * fundamental rules: ι²= -1. 
	 */
	F9(new int[][]{

		{0,0,0,0,0,0,0,0,0},
		{0,1,2,3,4,5,6,7,8},
		{0,2,1,6,8,7,3,5,4},
		{0,3,6,2,5,8,1,4,7},
		{0,4,8,5,6,1,7,2,3},
		{0,5,7,8,1,3,4,6,2},
		{0,6,3,1,7,4,2,8,5},
		{0,7,5,4,2,6,8,3,1},
		{0,8,4,7,3,2,5,1,6}

	} );

	/**
	 * the table as the element of each enumeration
	 */
	private final int[][] table;
	
	/**
	 * create the enumeration having the element table 
	 * for access to table
	 * 
	 * @param table
	 */
	private Multiplication(final int[][] table) {
		this.table = table;
	}

	/**
	 * return the table for the user
	 * 
	 * @return the table
	 */
	public int[][] getTable() {
		return this.table;
	}
}
