package com.khanh.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class DesignerPDFViewer {
	
	/**
	 * https://www.hackerrank.com/challenges/designer-pdf-viewer/problem
	 * @param h
	 * @param word
	 * @return
	 */
	public int designerPdfViewer(List<Integer> h, String word) {
		System.out.println(word.charAt(1));
		
		int maxHeight = h.get(0);
		for (int i = 0; i < word.length(); i++) {
			maxHeight = Math.max(maxHeight, h.get(word.codePointAt(i) - 97));
		}
		return maxHeight * word.length();
	}

	public static void main(String[] args) {
		DesignerPDFViewer d = new DesignerPDFViewer();
		List<Integer> h = new ArrayList<>();
		h.add(1);
		h.add(3);
		h.add(1);
		h.add(3);
		h.add(1);
		h.add(4);
		h.add(1);
		h.add(3);
		h.add(2);
		h.add(5);
		h.add(5);
		h.add(5);
		h.add(5);
		h.add(5);
		h.add(5);
		h.add(5);
		h.add(5);
		h.add(5);
		h.add(5);
		h.add(5);
		h.add(5);
		h.add(5);
		h.add(5);
		h.add(5);
		h.add(5);
		h.add(7);

		int result = d.designerPdfViewer(h, "zaba");
		System.out.println("result: " + result);
	}
}
