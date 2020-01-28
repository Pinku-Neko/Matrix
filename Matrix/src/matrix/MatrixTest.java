package matrix;

import field.RationalNumber;
import field.galoisField.GF4;
import field.galoisField.GF8;
import field.galoisField.GF9;
import field.galoisField.GFPrime;
import matrix.reforming.MatrixReforming;

/**
 * This class is used to create matrix with given fields
 * 
 * @author Pinku_Neko
 *
 */
class MatrixTest {

	/**
	 * This is used to create matrix objects with given 2d array of fields
	 * 
	 * @param args default arguments, not related here
	 */
	public static void main(final String[] args) {

		final RationalNumber[][] rationalArray2D = new RationalNumber[][] {
				{ new RationalNumber(4, 7), new RationalNumber(-2, 6), new RationalNumber(-2, 9) },
				{ new RationalNumber(-2, 1), new RationalNumber(3, -1), new RationalNumber(-4, 1) },
				{ new RationalNumber(3, -2), new RationalNumber(7, 2), new RationalNumber(1, 4) } };
		final Matrix<RationalNumber> rationalMatrix = new Matrix<RationalNumber>(rationalArray2D);
		// System.out.println(rationalMatrix.toString());
		// MatrixReforming.gaussianElimination(rationalMatrix);
		// System.out.println(rationalMatrix.toString());

		final GFPrime[][] finiteField3Array2D = new GFPrime[][] {
				{ new GFPrime(3, 0), new GFPrime(3, 0), new GFPrime(3, 0), new GFPrime(3, 2), new GFPrime(3, 1),
						new GFPrime(3, 0) },
				{ new GFPrime(3, 0), new GFPrime(3, 0), new GFPrime(3, 0), new GFPrime(3, 2), new GFPrime(3, 1),
						new GFPrime(3, 0) },
				{ new GFPrime(3, 1), new GFPrime(3, 2), new GFPrime(3, 1), new GFPrime(3, 0), new GFPrime(3, 1),
						new GFPrime(3, 1) },
				{ new GFPrime(3, 2), new GFPrime(3, 1), new GFPrime(3, 1), new GFPrime(3, 2), new GFPrime(3, 2),
						new GFPrime(3, 1) },
				{ new GFPrime(3, 2), new GFPrime(3, 1), new GFPrime(3, 1), new GFPrime(3, 2), new GFPrime(3, 2),
						new GFPrime(3, 1) },
				{ new GFPrime(3, 2), new GFPrime(3, 1), new GFPrime(3, 1), new GFPrime(3, 2), new GFPrime(3, 2),
						new GFPrime(3, 1) } };
		final Matrix<GFPrime> finiteField3Matrix = new Matrix<GFPrime>(finiteField3Array2D);
		System.out.println(finiteField3Matrix.toString());
		MatrixReforming.gaussianElimination(finiteField3Matrix);
		System.out.println(finiteField3Matrix.toString());

		final GFPrime[][] finiteField3Array2D2 = new GFPrime[][] {
				{ new GFPrime(3, 1), new GFPrime(3, 2), new GFPrime(3, 1), new GFPrime(3, 0), new GFPrime(3, 0),
						new GFPrime(3, 2) },
				{ new GFPrime(3, 1), new GFPrime(3, 0), new GFPrime(3, 1), new GFPrime(3, 2), new GFPrime(3, 1),
						new GFPrime(3, 2) },
				{ new GFPrime(3, 1), new GFPrime(3, 0), new GFPrime(3, 1), new GFPrime(3, 2), new GFPrime(3, 1),
						new GFPrime(3, 0) },
				{ new GFPrime(3, 0), new GFPrime(3, 0), new GFPrime(3, 2), new GFPrime(3, 1), new GFPrime(3, 2),
						new GFPrime(3, 2) },
				{ new GFPrime(3, 1), new GFPrime(3, 1), new GFPrime(3, 0), new GFPrime(3, 2), new GFPrime(3, 1),
						new GFPrime(3, 2) },
				{ new GFPrime(3, 0), new GFPrime(3, 0), new GFPrime(3, 0), new GFPrime(3, 0), new GFPrime(3, 0),
						new GFPrime(3, 1) } };
		final Matrix<GFPrime> finiteField3Matrix2 = new Matrix<GFPrime>(finiteField3Array2D2);
		System.out.println(finiteField3Matrix2.toString());
		MatrixReforming.gaussianElimination(finiteField3Matrix2);
		System.out.println(finiteField3Matrix2.toString());

		final GF4[][] finiteField4Array2D = new GF4[][] { { new GF4(3), new GF4(1), new GF4(3), new GF4(1) },
				{ new GF4(1), new GF4(3), new GF4(0), new GF4(2) }, { new GF4(3), new GF4(3), new GF4(0), new GF4(0) },
				{ new GF4(2), new GF4(0), new GF4(2), new GF4(1) }, { new GF4(7), new GF4(1), new GF4(0), new GF4(1) },
				{ new GF4(0), new GF4(0), new GF4(0), new GF4(2) },
				{ new GF4(3), new GF4(3), new GF4(1), new GF4(1) }, };
		final Matrix<GF4> finiteField4Matrix = new Matrix<GF4>(finiteField4Array2D);
		// System.out.println(finiteField4Matrix.toString());
		// MatrixReforming.gaussianElimination(finiteField4Matrix);
		// System.out.println(finiteField4Matrix.toString());

		final GF8[][] finiteField8Array2D = new GF8[][] { { new GF8(3), new GF8(1), new GF8(3), new GF8(1) },
				{ new GF8(1), new GF8(3), new GF8(0), new GF8(2) }, { new GF8(3), new GF8(3), new GF8(0), new GF8(0) },
				{ new GF8(2), new GF8(0), new GF8(2), new GF8(1) }, { new GF8(4), new GF8(1), new GF8(0), new GF8(1) },
				{ new GF8(0), new GF8(0), new GF8(0), new GF8(2) },
				{ new GF8(3), new GF8(3), new GF8(1), new GF8(1) }, };
		final Matrix<GF8> finiteField8Matrix = new Matrix<GF8>(finiteField8Array2D);
		// System.out.println(finiteField8Matrix.toString());
		// MatrixReforming.gaussianElimination(finiteField8Matrix);
		// System.out.println(finiteField8Matrix.toString());

		final GF9[][] finiteField9Array2D = new GF9[][] {
				{ new GF9(0), new GF9(0), new GF9(1), new GF9(7), new GF9(3), new GF9(6), new GF9(2) },
				{ new GF9(2), new GF9(6), new GF9(2), new GF9(3), new GF9(5), new GF9(1), new GF9(5) },
				{ new GF9(3), new GF9(2), new GF9(6), new GF9(5), new GF9(3), new GF9(0), new GF9(0) }

		};
		final Matrix<GF9> finiteField9Matrix = new Matrix<GF9>(finiteField9Array2D);
		// System.out.println(finiteField9Matrix.toString());
		// MatrixReforming.gaussianElimination(finiteField9Matrix);
		// System.out.println(finiteField9Matrix.toString());

	}

}
