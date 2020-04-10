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
		return size == 0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		for (int i = 0; i < this.table.length; i++) {
			this.table[i] = null;
		}
		this.size = 0;
		this.usedCapacity = 0;
	}

	private int getMatchingOrNextAvailableBucket(K key) {
		int startingPoint = key.hashCode() % table.length;
		boolean hasMatch = false;
		int bucket = -1;
		for (int i = startingPoint; i < table.length; i++) {
			if (table[i] != null) {
				if (key.equals(table[i].getKey())) {
					hasMatch = true;
					bucket = i;
					return bucket;
				}
			}
		}
		if (!hasMatch) {
			for (int i = startingPoint; i < table.length; i++) {
				if (table[i] == null) {
					bucket = i;
					return bucket;
				}
			}
		}

		return bucket;
	}

	@Override
	public V get(K key) {
		if (size == 0) {
			return null;
		}
		// TODO Auto-generated method stub

		return table[getMatchingOrNextAvailableBucket(key)].getValue();

	}

	@Override
	public V put(K key, V value) {
		// TODO Auto-generated method stub
		if (key == null || value == null) {
			throw new NullPointerException();
		}

		V oldValue = null;

		int bucket = getMatchingOrNextAvailableBucket(key);

		if (table[bucket] == null) {
			size++;
			usedCapacity++;
		} else {
			oldValue = table[bucket].getValue();
		}

		table[bucket] = new Entry<>(key, value);

		if (usedCapacity >= threshold) {
			rehash();
		}
		return oldValue;
	}

	@Override
	public V remove(K key) {
		// TODO Auto-generated method stub
		if (key == null) {
			throw new NullPointerException();
		}
		int bucket = getMatchingOrNextAvailableBucket(key);
		if (table[bucket] != null) {
			V removedValue = table[bucket].getValue();
			table[bucket] = new Entry<>(key, null);
			size--;
			return removedValue;
		} else {
			return null;
		}

	}

	private int resize() {
		int newSize = (table.length * 2) + 1;
		boolean primeFound = false;
		boolean evenlyDivisible = false;

		while (!primeFound) {
			for (int i = 3; i <= (int) Math.sqrt(newSize); i++) {
				if (newSize % i == 0) {
					evenlyDivisible = true;
				}
			}

			if (evenlyDivisible == false) {
				primeFound = true;
			} else {
				evenlyDivisible = false;
				newSize += 2;
			}
		}
		return newSize;
	}

	private void rehash() {
		Entry<K, V>[] oldTable = table;
		int capacity = this.resize();
		table = new Entry[capacity];
		size = 0;
		usedCapacity = 0;
		threshold = (int) (capacity * loadFactor);

		for (int i = 0; i < oldTable.length; i++) {
			if (oldTable[i] != null && oldTable[i].getValue() != null) {
				put(oldTable[i].getKey(), oldTable[i].getValue());
			}
		}
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
