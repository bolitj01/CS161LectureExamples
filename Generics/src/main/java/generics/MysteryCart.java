package generics;

public class MysteryCart <I> {
	private I[] cart;
	private int size;
	
	public MysteryCart(int size) {
		cart = (I[]) new Object[size];
    }
	
	public void addItem(I item) {
		for (int i = 0; i < cart.length; i++) {
			if (cart[i] == null) {
				cart[i] = item;
				return;
			}
		}
	}
	
	public I getItem(I item) {
		for (I element : cart) {
			if (element != null && element.equals(item)) {
				return element;
			}
		}
		return null;
    }
	
	public I removeItem(I item) {
		for (int i = 0; i < cart.length; i++) {
            if (cart[i] != null && cart[i].equals(item)) {
                I temp = cart[i];
                cart[i] = null;
                return temp;
            }
        }
        return null;
    }
	
	public String toString() {
		String result = "";
        for (I item : cart) {
            result += item + "\n";
        }
        return result;
    }
}
