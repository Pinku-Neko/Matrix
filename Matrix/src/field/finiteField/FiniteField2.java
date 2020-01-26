/**
 * 
 */
package field.finiteField;

import field.Field;

/**
 * @author Pinku_Neko
 *
 */
public class FiniteField2 implements Field<FiniteField2> {

	private final byte value;
	
	/**
	 * 
	 */
	public FiniteField2(final int argument) {
		if (argument < 0) {
			this.value = (byte) ( (0 - argument) % 2);
		} else {
			this.value = (byte) (argument % 2);
		}
	}

	@Override
	public String toString() {
		return String.format("%d", this.value);
	}



	/**
	 * @return the value
	 */
	public byte getValue() {
		return this.value;
	}

	@Override
	public FiniteField2 getNeutralElementAdd() {
		return new FiniteField2(0);
	}

	@Override
	public FiniteField2 getNeutralElementMult() {
		return new FiniteField2(1);
	}

	@Override
	public FiniteField2 getInverseElementAdd() {
		return new FiniteField2(0 - this.value);
	}

	@Override
	public FiniteField2 getInverseElementMult() {
		if (this.isZero()) {
			throw new IllegalArgumentException("Zero does not have an inverse element for multiplication.");
		} else {
			return new FiniteField2(1 / this.value);
		}
	}

	@Override
	public FiniteField2 add(final FiniteField2 element) {
		return new FiniteField2(this.value + element.value);
	}

	@Override
	public FiniteField2 substract(final FiniteField2 element) {
		return this.add(element.getInverseElementAdd());
	}

	@Override
	public FiniteField2 multipliesWith(final FiniteField2 element) {
		return new FiniteField2(this.value * element.value);
	}

	@Override
	public FiniteField2 dividedBy(final FiniteField2 element) {
		return this.multipliesWith(element.getInverseElementMult());
	}

	@Override
	public void checkIfDefined(final FiniteField2 element) {
		if (element == null) {
			throw new NullPointerException("This element is not defined.");
		}
	}
	
	@Override
	public boolean isSameAs(final FiniteField2 element) {
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

}
