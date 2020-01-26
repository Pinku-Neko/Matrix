/**
 * 
 */
package field;

import field.galoisField.GFPrime;

/**
 * @author Pinku_Neko
 *
 */
final class NumberTest {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		// TODO Auto-generated method stub
//		final FiniteField2 aNumber = new FiniteField2(1);
		final GFPrime anotherNumber = new GFPrime(2, 1);
		final GFPrime aNumber = new GFPrime(2, 1);
//		final RationalNumber aNumber = new RationalNumber(-1, 1);
//		final RationalNumber anotherNumber = new RationalNumber(1, -1);
		System.out.printf("Value: %s \n", aNumber.toString());
		System.out.printf("neutral element add: %s \n", aNumber.getNeutralElementAdd().toString());
		System.out.printf("neutral element mult: %s \n", aNumber.getNeutralElementMult().toString());
		System.out.printf("inverse element add: %s \n", aNumber.getInverseElementAdd().toString());
		System.out.printf("inverse element mult: %s \n", aNumber.getInverseElementMult().toString());
		System.out.printf("sum: %s \n", aNumber.add(anotherNumber).toString());
		System.out.printf("difference: %s \n", aNumber.substract(anotherNumber).toString());
		System.out.printf("product: %s \n", aNumber.multipliesWith(anotherNumber).toString());
		System.out.printf("quotient: %s \n", aNumber.dividedBy(anotherNumber).toString());
//		System.out.printf("%1.3f \n",anotherNumber.toDouble());
//		System.out.printf("%s",thirdNumber.toString());
	}

}
