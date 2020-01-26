package matrix;

import field.RationalNumber;
import field.finiteField.FiniteField2;
import field.finiteField.FiniteField4;
import matrix.reforming.MatrixReforming;

/**
 * This class is used to create matrix with 
 * given fields
 * 
 * @author Pinku_Neko
 *
 */
class MatrixTest {

	/**
	 * This is used to create matrix objects with
	 * given 2d array of fields
	 * 
	 * @param args default arguments, not related here
	 */
	public static void main(final String[] args) {
		final RationalNumber[][] rationalArray2D = new RationalNumber[][] {
			{new RationalNumber(4,7),new RationalNumber(-2,6),new RationalNumber(-2,9)},
			{new RationalNumber(-2,1),new RationalNumber(3,-1),new RationalNumber(-4,1)},
			{new RationalNumber(3,-2),new RationalNumber(7,2),new RationalNumber(1,4)}
		};
		final Matrix<RationalNumber> rationalMatrix = new Matrix<RationalNumber>(rationalArray2D);
		System.out.println(rationalMatrix.toString());
		MatrixReforming.gaussianElimination(rationalMatrix);
		System.out.println(rationalMatrix.toString());
		final FiniteField2[][] finiteField2Array2D = new FiniteField2[][] {
			{new FiniteField2(1),new FiniteField2(1),new FiniteField2(1),new FiniteField2(1),new FiniteField2(1)},
			{new FiniteField2(0),new FiniteField2(0),new FiniteField2(1),new FiniteField2(1),new FiniteField2(1)},
			{new FiniteField2(0),new FiniteField2(1),new FiniteField2(1),new FiniteField2(0),new FiniteField2(0)},
			{new FiniteField2(0),new FiniteField2(1),new FiniteField2(0),new FiniteField2(1),new FiniteField2(0)},
			{new FiniteField2(0),new FiniteField2(0),new FiniteField2(0),new FiniteField2(0),new FiniteField2(0)}
		};
		final Matrix<FiniteField2> finiteField2Matrix = new Matrix<FiniteField2>(finiteField2Array2D);
		System.out.println(finiteField2Matrix.toString());
		MatrixReforming.gaussianElimination(finiteField2Matrix);
		System.out.println(finiteField2Matrix.toString());
		final FiniteField4[][] finiteField4Array2D = new FiniteField4[][] {
			{new FiniteField4(3),new FiniteField4(1),new FiniteField4(3),new FiniteField4(1)},
			{new FiniteField4(1),new FiniteField4(3),new FiniteField4(0),new FiniteField4(2)},
			{new FiniteField4(3),new FiniteField4(3),new FiniteField4(0),new FiniteField4(0)},
			{new FiniteField4(2),new FiniteField4(0),new FiniteField4(2),new FiniteField4(1)},
			{new FiniteField4(-4),new FiniteField4(1),new FiniteField4(0),new FiniteField4(1)},
			{new FiniteField4(0),new FiniteField4(0),new FiniteField4(0),new FiniteField4(2)},
			{new FiniteField4(3),new FiniteField4(3),new FiniteField4(1),new FiniteField4(1)},
		};
		final Matrix<FiniteField4> finiteField4Matrix = new Matrix<FiniteField4>(finiteField4Array2D);
		System.out.println(finiteField4Matrix.toString());
		MatrixReforming.gaussianElimination(finiteField4Matrix);
		System.out.println(finiteField4Matrix.toString());
	}

}
