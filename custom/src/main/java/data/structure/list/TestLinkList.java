/**
 * 
 */
package custom.data.structure.list;

/**
 * @author edinjos
 *
 */
public class TestLinkList {

	/**
	 * 
	 */
	public TestLinkList() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CustomLinkList<String> list = new CustomLinkList<String>();
		list.add("Dinesh");
		list.add("Ankita");
		list.add("Ankuli");
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
	}
}
