package de.tu_darmstadt.gdi1.pacman.minimal;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LibraryFileReader {

	private String filename = null;
	private ArrayList<char[]> data = null;

	
	public LibraryFileReader(String filename) {
		this.filename = filename;
		this.data = new ArrayList<char[]>();
	}

	private ArrayList<char[]> readFile() {
		try {
			FileReader fr = new FileReader(filename);
			BufferedReader in = new BufferedReader(fr);

			String line;
			while ((line = in.readLine()) != null) {
				data.add(line.toCharArray());
			}

			in.close();
			fr.close();

			return data;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public char[][] get_map(){
		
		ArrayList<char[]> karte = this.readFile();
	
		java.util.Iterator<char[]> iter = karte.iterator();
		
		int hoehe = karte.size();
		int breite = iter.next().length;
		char[][] result_map = new char[hoehe][breite];
		
		iter = karte.iterator();
		
		for(int i = 0; i < hoehe ; i++){
			char[] tmp = iter.next();
			
			for(int j = 0; j< breite ;j++){
				
				result_map[i][j] = tmp[j];
				System.out.print(result_map[i][j]);
				
			}
			System.out.println();
		}
		
		return result_map;

	}

}
