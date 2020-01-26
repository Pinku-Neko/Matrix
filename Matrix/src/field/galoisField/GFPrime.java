/**
 * 
 */
package field.galoisField;

import field.Field;

/**
 * @author Pinku_Neko
 *
 */
public class GFPrime implements Field<GFPrime> {

	private final int value;
	private final int amountElements;
	/**
	 * 
	 */
	public GFPrime(final int amountElements, final int argument) {
		checkIfValid(amountElements);
		this.amountElements = amountElements;
		if (argument < 0) {
			this.value = ( (0 - argument) % this.amountElements);
		} else {
			this.value = (argument % this.amountElements);
		}
	}

	private void checkIfValid(final int amountElements) {
		if (amountElements < 2) {
			throw new IllegalArgumentException("the given amount of elements cannot be 1 or less than 1.");
		}
		if ( !( isPrime(amountElements) ) ) {
			throw new IllegalArgumentException("the given amount of elements is not prime.");
		}
	}

	private boolean isPrime(final int amountElements) {
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
