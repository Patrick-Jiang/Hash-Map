package hashMap;

import java.util.*;

public class HashMap<K, V> implements Map<K, V> {

	private static int CAPACITY = 11;
	private static double LOAD_FACTOR = 0.75;
	private Entry<K, V>[] table;

	private double loadFactor;
	private int threshold;
	private int size;
	private int usedCapacity;

	public HashMap() {
		this(CAPACITY, LOAD_FACTOR);
	}

	public HashMap(int initialCapacity) {
		this(initialCapacity, LOAD_FACTOR);
	}

	public HashMap(int initialCapacity, double loadFactor) {
		if (loadFactor <= 0 || loadFactor >= 1 || initialCapacity <= 0) {
			throw new IllegalArgumentException();
		}
		this.table = new Entry[initialCapacity];
		this.loadFactor = loadFactor;
		this.threshold = (int) (initialCapacity * loadFactor);
	}

	public Entry<K, V>[] getTable() {
		return table;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0 ;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public V get(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V put(K key, V value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V remove(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator keys() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator values() {
		// TODO Auto-generated method stub
		return null;
	}

}
