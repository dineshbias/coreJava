/**
 * 
 */
package ocp.generics;

/**
 * @author edinjos
 *
 */
public class GenericClassMulipleParams<T, U> {
	private T contents;
	private U sizeLimit;
	
	public GenericClassMulipleParams() {
		System.out.println("GenericClassMulipleParams constructor");
	}
	
	public GenericClassMulipleParams(T contents, U sizeLimit) {
		this.contents = contents;
		this.sizeLimit = sizeLimit;
	}
	
	public T getContents(){
		return contents;
	}
	
	public U getSizeLimit(){
		return sizeLimit;
	}
	
	public <V,W> W getContentsDefault(V v, W w){
		System.out.println("getContentsDefault");
		return w;
	}
	
	
	
	
}
