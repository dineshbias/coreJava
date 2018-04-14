/**
 * 
 */
package custom.data.structure.list;

/**
 * @author edinjos
 *
 */
public class Node<T> {
		
	private T data;
	private Node<T> nextRef;
	
	/**
	 * 
	 */
	public Node() {
		System.out.println("Node Constructor instantiated....");
	}
	
	public Node(T data) {
		System.out.println("Node Constructor instantiated...." + data);
		this.data = data;
	}
	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getNextRef() {
		return nextRef;
	}

	public void setNextRef(Node<T> nextRef) {
		this.nextRef = nextRef;
	}
	

}
