package org.stockii.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 固定容量的优先队列，模拟大、小顶堆
 * @author tt
 *
 * @param <E>
 */
@SuppressWarnings({ "unchecked", "serial" })
public class FixSizedPriorityQueue<E extends Comparable> extends PriorityQueue<E> {
	
	private int maxSize;
	private boolean type;
	
	
	/**
	 * 构造函数
	 * @param size 大小
	 * @param type 类型
	 */
	public FixSizedPriorityQueue(int size, final boolean type) {
		super(size, new Comparator<E>() {
			public int compare(E e1, E e2) {
				if (type){//小顶堆；如果是e2.compareTo(e1)是大顶堆
					return e1.compareTo(e2);
				}else{
					return e2.compareTo(e1);
				}
				
			}
		});
		this.maxSize = size;
		this.type = type;

	}
	public boolean put(E e) {
		if (this.size() < maxSize) {
			return this.offer(e);
		}
		
		E peek = this.peek();
		if ((type&&e.compareTo(peek) > 0)||(!type&&e.compareTo(peek)<0)) {
			this.poll();
			this.offer(e);
		}
		
		return false;
	}
	
	public List<E> sort(){
		List list = new ArrayList();  

		while (true) {//有序输出
			E i = this.poll();
			if ( i == null) {
				break;
			}
			list.add(i);
		}
		
		Collections.reverse(list);
		
        return list;  
	}
}
