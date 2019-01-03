/**
 * 
 */
package ocp.design.cache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author dinesh.joshi
 *
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {

	private static final long serialVersionUID = 5887323847051463959L;
	private int size;

	private LRUCache(int size) {
		super(size, 0.5f, true);
		this.size = size;

	}

	public static <K, V> LRUCache<K, V> getInstance(int size) {
		return new LRUCache<K, V>(size);
	}

	public void setMaxSize(int size) {
		this.size = size;
	}

	@Override
	protected boolean removeEldestEntry(Map.Entry<K, V> entry) {
		return size() > size;
	}
}
