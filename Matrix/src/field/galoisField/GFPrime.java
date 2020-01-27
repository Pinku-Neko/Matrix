/**
 * 
 */
package field.galoisField;

import field.Field;

/**
 * a galois field having prime amount of elements 
 * 
 * a galois field (also called finite field) 
 * of finite amount of elements. The galois 
 * field is divided in two different types. 
 * 
 * This class represents the galois field, in which 
 * the amount of elements is prime.
 * 
 * @author Pinku_Neko
 *
 */
public class GFPrime implements Field<GFPrime> {

	/**
	 * The value or index of each element. 
	 * 
	 * Each element has its equivalent class, which
	 * the difference between them is the amount of 
	 * elements
	 */
	private final int value;
	
	
	/**
	 * The amount of elements in a galois field. 
	 * 
	 * Each time a value is added by another number 
	 * to the amount of elements or above it, it will 
	 * be subtracted by the amount of elements until it 
	 * is in the range again.
	 */
	private final int amountElements;
	
	/**
	 * create a number in a given galois field 
	 * 
	 * precondition: the amount of elements is a prime number
	 * 
	 * postcondition: create a number of galois field having 
	 * given amount of elements 
	 * and adjust the value to its equivalent class between 
	 * 0 and amount of elements
	 */
	public GFPrime(final int amountElements, int argument) {
		checkIfValid(amountElements);
		this.amountElements = amountElements;
		while (argument < 0) {
			argument = argument + this.amountElements;
		}
		if (argument >= this.amountElements) {
			argument = (argument % this.amountElements);
		}
		this.value = argument;
	}

	/**
	 * check if a number is valid aka. prime.
	 * 
	 * do nothing if the number is prime, 
	 * otherwise throw an IllegalArgumentException
	 * 
	 * @param amountElements the given argument tends to be used 
	 * to create a galois field
	 */
	private void checkIfValid(final int amountElements) {
		if ( !( isPrime(amountElements) ) ) {
			throw new IllegalArgumentException("the given amount of elements is not prime.");
		}
	}

	/**
	 * check if a number is prime. 
	 * 
	 * return true if the number is prime as following
	 * 
	 * @param amountElements
	 * @return true if the number is prime, otherwise false
	 */
	private boolean isPrime(final int amountElements) {
		if (amountElements < 2) {
			return false;
		} 
		if (amountElements < 4) {
			return true;
		} else {
			for (int i = 2; i < Math.sqrt( amountElements); i++) {
				if (amountElements / i == 0) {
					return false;
				}
			}
			return true;
		}
	}

	@Override
	public String toString() {
		return String.format("%d", this.value);
	}



	/**
	 * @return the value
	 */
	public int getValue() {
		return this.value;
	}

	@Override
	public GFPrime getNeutralElementAdd() {
		return new GFPrime(this.amountElements, 0);
	}

	@Override
	public GFPrime getNeutralElementMult() {
		return new GFPrime(this.amountElements, 1);
	}

	@Override
	public GFPrime getInverseElementAdd() {
		return new GFPrime(this.amountElements, 0 - this.value);
	}

	@Override
	public GFPrime getInverseElementMult() {
		if (this.isZero()) {
			throw new IllegalArgumentException("Zero does not have an inverse element for multiplication.");
		} else {
			return new GFPrime(this.amountElements, 1 / this.value);
		}
	}

	@Override
	public GFPrime add(final GFPrime element) {
		return new GFPrime(this.amountElements, this.value + element.value);
	}

	@Override
	public GFPrime substract(final GFPrime element) {
		return this.add(element.getInverseElementAdd());
	}

	@Override
	public GFPrime multipliesWith(final GFPrime element) {
		return new GFPrime(this.amountElements, this.value * element.value);
	}

	@Override
	public GFPrime dividedBy(final GFPrime element) {
		return this.multipliesWith(element.getInverseElementMult());
	}

	@Override
	public void checkIfDefined(final GFPrime element) {
		if (element == null) {
			throw new NullPointerException("This element is not defined.");
		}
	}
	
	@Override
	public boolean isSameAs(final GFPrime element) {
		if(element == null) {
			return false;
		}
		if (this.value == element.value) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isZero() {
		return this.isSameAs(this.getNeutralElementAdd());
	}

	@Override
	public boolean isOne() {
		return this.isSameAs(this.getNeutralElementMult());
	}

}
