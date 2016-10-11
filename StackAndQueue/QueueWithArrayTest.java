package StackAndQueue;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
public class QueueWithArrayTest{
	QueueWithArray queue = new QueueWithArray(5);
	@Test
	public void isEmptyPass(){		
		assertTrue(!queue.isEmpty());
	}
	@Test
	public void isFullPass(){
		assertTrue(!queue.isFull());
	}

}
