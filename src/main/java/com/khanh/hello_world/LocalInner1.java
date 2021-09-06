package com.khanh.hello_world;


/**
 * Java Local inner class
 * A class i.e., created inside a method, is called local inner class in java. 
 * Local Inner Classes are the inner classes that are defined inside a block. 
 * Generally, this block is a method body. Sometimes this block can be a for loop, or an if clause. 
 * Local Inner classes are not a member of any enclosing classes. 
 * They belong to the block they are defined within, 
 * due to which local inner classes cannot have any access modifiers associated with them. 
 * However, they can be marked as final or abstract. These classes have access to the fields of the class enclosing it.
 * If you want to invoke the methods of the local inner class, you must instantiate this class inside the method.
 * @author DELL
 *
 */
public class LocalInner1 {
	private int data = 30;// instance variable

	void display() {
		// local inner class can only mark as final or abstract
		final class Local {
			void msg() {
				System.out.println(data);
			}
		}
		Local l = new Local();
		l.msg();
	}

	public static void main(String args[]) {
		LocalInner1 obj = new LocalInner1();
		obj.display();
	}
}
