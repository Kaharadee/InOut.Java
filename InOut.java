	import java.io.*;
	import java.util.*;
	/*
     * InOut.java 10.0 07 Jan 2016
     *
     * Copyright (c) School of Geography.
     * University of Leeds, Leeds, West Yorkshire, YK.LS2 9JT
     * All rights reserved.
     *
     * This code is provided under the Academic Free License v.3.0
     * For details, please see the http://opensource.org/licenses/AFL-3.0
     */


    /**
     * This class reads in and writes out geographical data in text file format.
     * It contains a accessor method.
     * @author Dennis Macharia :dennismacharia59@yahoo.co.uk
     * @version 10.0 07 Jan 2016
     */
	public class InOut {
		public double [][] readData(File f){
			FileReader fr = null;
            try {
			fr = new FileReader (f);
			} catch (FileNotFoundException fnfe) {
		     fnfe.printStackTrace();
			}
			
			//Wrap this in a BufferedReader
			BufferedReader br = new BufferedReader(fr);
			// Remember fr is a FileReader not a File.

			int lines = -1;
			String textIn = " ";
			String[] file = null;

			try {
			while (textIn != null) {
			textIn = br.readLine();
			lines++;
			}
			file = new String[lines];

			// close the buffer here and remake both FileReader and 
			// buffer to set it back to the file start.
			br.close();
			fr= new FileReader(f);
			br= new BufferedReader(fr);
			for (int i = 0; i < lines; i++) {
			file[i] = br.readLine();
			}
				br.close();

			} catch (IOException ioe) {}
			
			//Run through the array and use a StringTokenizer
			double[][] data = new double [lines][];

			for (int i = 0; i < lines; i++) {
			StringTokenizer st = new StringTokenizer(file[i],", ");
			data[i] = new double[st.countTokens()];
			int j = 0;
			while (st.hasMoreTokens()) { 		
			data[i][j] = Double.parseDouble(st.nextToken()); 
			j++;
			}
			} 
			
			for (int i = 0; i < data.length; i++) {
				for (int j = 0; j < data[i].length; j++) {
				System.out.print(data[i][j] + " ");
					//data [i][j]++;
				}
				System.out.println("");
			}

			return data;
			
			}
		public void writeData (double[][] dataIn){
			// Our writing code will go here.
			File f = new File("Density.txt");
			
			// Code to make a FileWriter (again, in a try-catch block).
			FileWriter fw = null;

			try {

			fw = new FileWriter (f, true);

			} catch (IOException ioe) {
			ioe.printStackTrace();
			}
			
			// Code to wrap it in a BufferedWriter.
			BufferedWriter bw = new BufferedWriter (fw);

			String tempStr = "";

			try {
			for (int i = 0; i < dataIn.length; i++) {
			for (int j = 0; j < dataIn[i].length; j++) {

			tempStr = String.valueOf(dataIn[i][j]); 
			bw.write(tempStr + ", ");
			

			}
			bw.newLine();	
			}
			bw.close();

			} catch (IOException ioe) {}
			
			;
		}
	}