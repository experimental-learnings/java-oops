package com.assignment.work;

public class QueueFiFoUsingStack {
	private int maxSize;
	   private long[] stackArray;
	   private int top;
	   public QueueFiFoUsingStack(int n) {
	      maxSize = n;
	      stackArray = new long[maxSize];
	      top = -1;
	   }
	   public void push(long j) {
	      stackArray[++top] = j;
	   }
	   public long pop() {
	      return stackArray[top--];
	   }
	   public boolean isEmpty() {
	      return (top == -1);
	   }
	   public boolean isFull() {
	      return (top == maxSize - 1);
	   }
	   public static void queueUsingStack(){
		   QueueFiFoUsingStack theStack = new QueueFiFoUsingStack(10); 
		   QueueFiFoUsingStack theStack1 = new QueueFiFoUsingStack(10); 
		      theStack.push(10);
		      theStack.push(20);
		      theStack.push(30);
		      theStack.push(40);
		      theStack.push(50);
		      while (!theStack.isEmpty()) {
		         long value = theStack.pop();
		         theStack1.push(value);
		      }
		      while (!theStack1.isEmpty()) {
			         long value = theStack1.pop();
			         System.out.print(value);
			         System.out.print(" ");
			      }
		      System.out.println("");
		   }
	   
	   public static void main(String[] args) {
		   queueUsingStack();
	   }
}
