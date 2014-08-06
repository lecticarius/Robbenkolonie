//package de.tu_darmstadt.gdi1.pacman.view;
//
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.Reader;
//
//public class Filereader {
//
//	public Filereader() {
//
//	}
//
//	public void ReaderNew(String s) {
//
//		Reader reader = null;
//		try {
//			reader = new FileReader(s);
//			System.out.println("Folgende Map wird gespielt:");
//			for (int c; (c = reader.read()) != (1 * -1);) {
//				System.out.println(c);
//
//			}
//		} catch (IOException e) {
//			System.err.println("Fehler beim Lesen der Datei!");
//		} finally {
//			try {
//				reader.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//
//	}
//
//}
