package org.java.serialize;

import java.util.Arrays;

/**
 * 序列化是缓存对象的缓存池的构造
 * @author wu.qiang
 * 
 * 
 * 缓存池对象的构造分两层
 * 
 * 第一层最新hash值的存放
 * 第二层保存被替换hash的所在位置
 * 第三层缓存对象的存放
 * 
 * 使用第一层，第二层是为了防止遍历整个缓存池，利用第一层和第二层构造一个查找区间减少遍历
 *
 */
public class HandleTable {
	
	   /* number of mappings in table/next available handle */
    private int size;
    /* size threshold determining when to expand hash spine */
    private int threshold;
    /* factor for computing size threshold */
    private final float loadFactor;
    /* maps hash value -> candidate handle value */
    private int[] spine;
    /* maps handle value -> next candidate handle value */
    private int[] next;
    /* maps handle value -> associated object */
    private Object[] objs;
    
    
    /**
     * Creates new HandleTable with given capacity and load factor.
     */
    HandleTable(int initialCapacity, float loadFactor) {
        this.loadFactor = loadFactor;
        spine = new int[initialCapacity];
        next = new int[initialCapacity];
        objs = new Object[initialCapacity];
        threshold = (int) (initialCapacity * loadFactor);
        clear();
    }

    /**
     * Assigns next available handle to given object, and returns handle
     * value.  Handles are assigned in ascending order starting at 0.
     */
    int assign(Object obj) {
        if (size >= next.length) {
            growEntries();
        }
        if (size >= threshold) {
            growSpine();
        }
        insert(obj, size);
        return size++;
    }

    /**
     * Looks up and returns handle associated with given object, or -1 if
     * no mapping found.
     */
    int lookup(Object obj) {
        if (size == 0) {
            return -1;
        }
        int index = hash(obj) % spine.length;
        for (int i = spine[index]; i >= 0; i = next[i]) {
            if (objs[i] == obj) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Resets table to its initial (empty) state.
     */
    void clear() {
        Arrays.fill(spine, -1);
        Arrays.fill(objs, 0, size, null);
        size = 0;
    }

    /**
     * Returns the number of mappings currently in table.
     */
    int size() {
        return size;
    }

    /**
     * Inserts mapping object -> handle mapping into table.  Assumes table
     * is large enough to accommodate new mapping.
     */
    private void insert(Object obj, int handle) {
        int index = hash(obj) % spine.length;
        objs[handle] = obj;
        next[handle] = spine[index];
        spine[index] = handle;
    }

    /**
     * Expands the hash "spine" -- equivalent to increasing the number of
     * buckets in a conventional hash table.
     */
    private void growSpine() {
        spine = new int[(spine.length << 1) + 1];
        threshold = (int) (spine.length * loadFactor);
        Arrays.fill(spine, -1);
        for (int i = 0; i < size; i++) {
            insert(objs[i], i);
        }
    }

    /**
     * Increases hash table capacity by lengthening entry arrays.
     */
    private void growEntries() {
        int newLength = (next.length << 1) + 1;
        int[] newNext = new int[newLength];
        System.arraycopy(next, 0, newNext, 0, size);
        next = newNext;

        Object[] newObjs = new Object[newLength];
        System.arraycopy(objs, 0, newObjs, 0, size);
        objs = newObjs;
    }

    /**
     * Returns hash value for given object.
     */
    private int hash(Object obj) {
        return System.identityHashCode(obj) & 0x7FFFFFFF;
    }
    
    public static void main(String[] args) {
    	
    	/**
    	 * 处理hash冲突
    	 * 1.开放地址法:
    	 *   1)线性探测再散列
    	 *   2)平方探测再散列
    	 *   3)伪随机探测再散列
    	 * 2.链地址法
    	 * 3.再哈希，产生冲突使用另个hash函数直到没有产出冲突
    	 * 4.建立一个公共溢出区，产生冲突的放到公共溢出区中
    	 * 
    	 */
    	HandleTable table = new HandleTable(10, 3);
    	
    	for(int i=0;i<16;i++) {
    		table.assign(new User());
    	}
    	
    	table.lookup(new User());
    	
    	
    	/**
    	 * spine  使用hash算法
    	 * 
    	 * next   存放hash冲突位置上的值
    	 * 
    	 * 
    	 * objs   存放所有对象
    	 * 
    	 * 
    	 * 
    	 * 
    	 */
		
	}

}
