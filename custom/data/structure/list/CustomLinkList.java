/**
 * 
 */
package custom.data.structure.list;

/**
 * @author edinjos
 *
 */
public class CustomLinkList<T> {
	
	private int counter;
	private Node<T> element;

	/**
	 * 
	 */
	public CustomLinkList() {
		System.out.println("CustomLinkList instantiated....");
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public Node<T> getElement() {
		return element;
	}

	public void setElement(Node<T> element) {
		this.element = element;
	}

	public void add(T data) {

		if (null == element) {
			element = new Node<T>(data);
			incrementCounter();
			return;
		}

		Node<T> tempNode = new Node<T>(data);
		Node<T> current = element;

		if (null != current) {

			while (null != current.getNextRef()) {
				current = current.getNextRef();
			}
			current.setNextRef(tempNode);
			incrementCounter();
		}

	}

	public void remove(int index) {

		if (index == 1) {

			element = element.getNextRef();

		} else {
			Node<T> currentNode = element;

			for (int i = 0; i < index; i++) {

				if (null == currentNode.getNextRef()) {
					return;
				}

				currentNode = currentNode.getNextRef();

			}
			currentNode.setNextRef(currentNode.getNextRef().getNextRef());
			decrementCounter();
		}
	}

	public T get(int index) {

		if (index < 0) {
			return null;
		}

		Node<T> currentNode = element;

		if (null != element) {
			for (int i = 0; i < index; i++) {

				if (null == currentNode.getNextRef()) {
					return null;
				}

				currentNode = currentNode.getNextRef();
			}

		}
		return currentNode.getData();
	}

	private void incrementCounter() {
		counter++;
	}

	private void decrementCounter() {
		counter--;
	}

	public int size() {
		return counter;
	}
}
