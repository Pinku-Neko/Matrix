/**
 * 
 */
package field.galoisField;

/**
 * this contains the table of addition for 
 * galois field of an non-prime amount of elements
 * 
 * @author Pinku_Neko
 *
 */
enum Addition {
	
	
	/**
	 * the table of addition for galois field of 4 elements
	 * 
	 * fundamental rule: 1 + 1 = 0, α + α = 0.
	 */
	F4(new int[][]{

		{0,1,2,3},
		{1,0,3,2},
		{2,3,0,1},
		{3,2,1,0}

	} ),

	F8(new int[][]{

		/**
		 * the table of addition for galois field of 8 elements 
		 * 
		 * fundamental rules: 1 + 1 = 0, β + β = 0, β² + β² = 0.
		 */
		{0,1,2,3,4,5,6,7},
		{1,0,3,2,5,4,7,6},
		{2,3,0,1,6,7,4,5},
		{3,2,1,0,7,6,5,4},
		{4,5,6,7,0,1,2,3},
		{5,4,7,6,1,0,3,2},
		{6,7,4,5,2,3,0,1},
		{7,6,5,4,3,2,1,0},

	} ),
	
	/**
	 * the table of addition for galois field of 9 elements 
	 * 
	 * fundamental rules: 1 + 1 = -1, ι + ι = -ι. 
	 */
	F9(new int[][]{

		{0,1,2,3,4,5,6,7,8},
		{1,2,0,4,5,3,7,8,6},
		{2,0,1,5,3,4,8,6,7},
		{3,4,5,6,7,8,0,1,2},
		{4,5,3,7,8,6,1,2,0},
		{5,3,4,8,6,7,2,0,1},
		{6,7,8,0,1,2,3,4,5},
		{7,8,6,1,2,0,4,5,3},
		{8,6,7,2,0,1,5,3,4}

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
	private Addition(final int[][] table) {
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
