package org.java.collection.ali;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class OrderList {
	
	private final ArrayList<Integer>  elements;
	
	private final int  maxSize;

	//读多写少 有序 
	// 二元组 位置和数据
	public OrderList(int maxSize) {
		elements = new ArrayList<>(maxSize);
		this.maxSize = maxSize;
	}
	//红黑树
	private final RBTree<Integer> tree = new RBTree<Integer>();
	public void add(int e){
		synchronized (elements) {
			//CopyOnWriteArrayList 读多写少
			//读操作远远大于写操作 volatile  实现无锁并发 参考 jdk1.6 ConcrrentHashMap 读写
			    ArrayList<Object> list  = new ArrayList<>(elements.size()+1);
			    tree.insert(e);
	            tree.inOrder(list);
	            setArray(list.toArray());
		}
		
	}
	
	private void setArray(Object[] newElements) {
		Field f = null;
		Field fs = null;
		try {
			f = elements.getClass().getDeclaredField("elementData");
			f.setAccessible(true);
			fs = elements.getClass().getDeclaredField("size");
			fs.setAccessible(true);
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		
		try {
			f.set(elements, newElements);
			fs.set(elements, (int)fs.get(elements)+1);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		
	}


	

	public int get(int i){
		return elements.get(i);
	}
	
	
	
   //红黑树排序
	public class RBTree<T extends Comparable<T>> {
		private RBTNode<T> mRoot; // 根结点
		private static final boolean RED = false;
		private static final boolean BLACK = true;

		public class RBTNode<T extends Comparable<T>> {
			boolean color; // 颜色
			T key; // 关键字(键值)
			RBTNode<T> left; // 左孩子
			RBTNode<T> right; // 右孩子
			RBTNode<T> parent; // 父结点

			public RBTNode(T key, boolean color, RBTNode<T> parent, RBTNode<T> left, RBTNode<T> right) {
				this.key = key;
				this.color = color;
				this.parent = parent;
				this.left = left;
				this.right = right;
			}

			public T getKey() {
				return key;
			}

			public String toString() {
				return "" + key + (this.color == RED ? "(R)" : "B");
			}
		}

		public RBTree() {
			mRoot = null;
		}

		private RBTNode<T> parentOf(RBTNode<T> node) {
			return node != null ? node.parent : null;
		}

		private boolean colorOf(RBTNode<T> node) {
			return node != null ? node.color : BLACK;
		}

		private boolean isRed(RBTNode<T> node) {
			return ((node != null) && (node.color == RED)) ? true : false;
		}

		private boolean isBlack(RBTNode<T> node) {
			return !isRed(node);
		}

		private void setBlack(RBTNode<T> node) {
			if (node != null)
				node.color = BLACK;
		}

		private void setRed(RBTNode<T> node) {
			if (node != null)
				node.color = RED;
		}

		private void setParent(RBTNode<T> node, RBTNode<T> parent) {
			if (node != null)
				node.parent = parent;
		}

		private void setColor(RBTNode<T> node, boolean color) {
			if (node != null)
				node.color = color;
		}

		

		
		private void inOrder(RBTNode<T> tree,List<Object> a) {
			if (tree != null) {
				inOrder(tree.left,a);
				a.add(tree.key) ;
				inOrder(tree.right,a);
			}
		}

		public void inOrder(List<Object> list) {
			inOrder(mRoot,list);
			
		}

		
		
		
		private RBTNode<T> search(RBTNode<T> x, T key) {
			if (x == null)
				return x;
			int cmp = key.compareTo(x.key);
			if (cmp < 0)
				return search(x.left, key);
			else if (cmp > 0)
				return search(x.right, key);
			else
				return x;
		}

		public RBTNode<T> search(T key) {
			return search(mRoot, key);
		}

		
		private RBTNode<T> iterativeSearch(RBTNode<T> x, T key) {
			while (x != null) {
				int cmp = key.compareTo(x.key);
				if (cmp < 0)
					x = x.left;
				else if (cmp > 0)
					x = x.right;
				else
					return x;
			}
			return x;
		}

		public RBTNode<T> iterativeSearch(T key) {
			return iterativeSearch(mRoot, key);
		}

		

		

		
		private void leftRotate(RBTNode<T> x) {
			RBTNode<T> y = x.right;
			x.right = y.left;
			if (y.left != null)
				y.left.parent = x;
			y.parent = x.parent;
			if (x.parent == null) {
				this.mRoot = y; 
			} else {
				if (x.parent.left == x)
					x.parent.left = y; 
				else
					x.parent.right = y; 
			}
			y.left = x;
			x.parent = y;
		}

		
		private void rightRotate(RBTNode<T> y) {
			RBTNode<T> x = y.left;
			y.left = x.right;
			if (x.right != null)
				x.right.parent = y;
			x.parent = y.parent;
			if (y.parent == null) {
				this.mRoot = x; 
			} else {
				if (y == y.parent.right)
					y.parent.right = x; 
				else
					y.parent.left = x; 
			}
			x.right = y;
			y.parent = x;
		}

		
		private void insertFixUp(RBTNode<T> node) {
			RBTNode<T> parent, gparent;
			while (((parent = parentOf(node)) != null) && isRed(parent)) {
				gparent = parentOf(parent);
				if (parent == gparent.left) {
					RBTNode<T> uncle = gparent.right;
					if ((uncle != null) && isRed(uncle)) {
						setBlack(uncle);
						setBlack(parent);
						setRed(gparent);
						node = gparent;
						continue;
					}
					if (parent.right == node) {
						RBTNode<T> tmp;
						leftRotate(parent);
						tmp = parent;
						parent = node;
						node = tmp;
					}
					setBlack(parent);
					setRed(gparent);
					rightRotate(gparent);
				} else { 
					RBTNode<T> uncle = gparent.left;
					if ((uncle != null) && isRed(uncle)) {
						setBlack(uncle);
						setBlack(parent);
						setRed(gparent);
						node = gparent;
						continue;
					}
					if (parent.left == node) {
						RBTNode<T> tmp;
						rightRotate(parent);
						tmp = parent;
						parent = node;
						node = tmp;
					}
					setBlack(parent);
					setRed(gparent);
					leftRotate(gparent);
				}
			}
			setBlack(this.mRoot);
		}

		private void insert(RBTNode<T> node) {
			int cmp;
			RBTNode<T> y = null;
			RBTNode<T> x = this.mRoot;
			while (x != null) {
				y = x;
				cmp = node.key.compareTo(x.key);
				if (cmp < 0)
					x = x.left;
				else
					x = x.right;
			}
			node.parent = y;
			if (y != null) {
				cmp = node.key.compareTo(y.key);
				if (cmp < 0)
					y.left = node;
				else
					y.right = node;
			} else {
				this.mRoot = node;
			}
			node.color = RED;
			insertFixUp(node);
		}

		
		public void insert(T key) {
			RBTNode<T> node = new RBTNode<T>(key, BLACK, null, null, null);
			if (node != null)
				insert(node);
		}
		
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		 
		OrderList or = new OrderList(4);
		or.add(5);
		or.add(3);
		or.add(3);
		or.add(1);
		System.out.println(or.get(0)+" "+or.get(1)+" "+or.get(2)+" "+or.get(3));
		 
		 
	}
	
	

}
