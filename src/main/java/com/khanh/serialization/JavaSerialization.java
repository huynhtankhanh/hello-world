package com.khanh.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

public class JavaSerialization {
	public static void main(String args[]) {
		// Serialization
		try {
			// Creating the object
			Student s1 = new Student(211, "Khanh Huynh", LocalDate.of(1988, 12, 10));
			// Creating stream and writing the object
			FileOutputStream fout = new FileOutputStream("f.txt");
			ObjectOutputStream out = new ObjectOutputStream(fout);
			out.writeObject(s1);
			out.flush();
			// closing the stream
			out.close();
			System.out.println("success");
		} catch (Exception e) {
			System.out.println(e);
		}

		// Deserialization
		try {
			// Creating stream to read the object
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("f.txt"));
			Student s = (Student) in.readObject();
			// printing the data of the serialized object
			System.out.println(s.getId() + " " + s.getName() + " " + s.getBirthDate());
			// closing the stream
			in.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
