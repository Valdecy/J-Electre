package guiELECTRE;

// Copyright © 2017 by Valdecy Pereira and Livia Dias de Oliveira Nepomuceno.

//This file is part of J-ELECTRE.
//
//J-ELECTRE is free software: you can redistribute it and/or modify
//it under the terms of the GNU General Public License as published by
//the Free Software Foundation, either version 3 of the License, or
//(at your option) any later version.
//
//J-ELECTRE is distributed in the hope that it will be useful,
//but WITHOUT ANY WARRANTY; without even the implied warranty of
//MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//GNU General Public License for more details.
//
//You should have received a copy of the GNU General Public License
//along with J-ELECTRE.  If not, see <http://www.gnu.org/licenses/>.

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class jsElectre {
	public static void writeFile_ei(String[][] electre_i_matrix, String[] kernel_vector) throws IOException {
		String path    = "";
		path           = "graph";
		File dir       = new File(path);
		FileWriter fw  = new FileWriter(new File(dir, "temp_.txt"));
		
		if (InterfaceElectre.electre == 1){
			fw  = new FileWriter(new File(dir, "electre_i.js"));
		}else if(InterfaceElectre.electre == 3){
			fw  = new FileWriter(new File(dir, "electre_i_v.js"));
		}
		
		fw.write("\t" + "var kernel = ["); 
		for (int i = 0; i < kernel_vector.length; i++) {
			if (i < kernel_vector.length - 1){
				fw.write("\"" + kernel_vector[i] + "\""  + ", ");	
			}else{
				fw.write("\"" + kernel_vector[i] + "\"" +  "];" + "\n" + "\n" + "\t" + "var electre = " + "\n" + "\t" + "[");
			}

		}
		
		for (int i = 0; i < electre_i_matrix.length; i++) {
			fw.write("\n" + "\t" + "  [");
			for (int j = 0; j < electre_i_matrix[0].length; j++) {
				if (i < electre_i_matrix.length - 1){
					fw.write("\"" + electre_i_matrix[i][j] + "\""  + ", ");
					if (j == electre_i_matrix[0].length - 1){
						fw.write("],");
					}							  	
				} else {
					fw.write("\"" + electre_i_matrix[i][j] + "\""  + ", ");
						if (j == electre_i_matrix[0].length - 1){
							fw.write("]" + "\n" + "\t" +  "];" );
						}
				}
			}
		}
		fw.close();
	}
	
	public static void writeFile_ei_s(String[][] electre_i_s_matrix, String[] kernel_vector, String[][] cycles) throws IOException {
		String path    = "";
		path           = "graph";
		File dir       = new File(path);
		FileWriter fw  = new FileWriter(new File(dir, "temp_.txt"));
		
		fw  = new FileWriter(new File(dir, "electre_i_s.js"));
		
		fw.write("\t" + "var kernel = ["); 
		for (int i = 0; i < kernel_vector.length; i++) {
			if (i < kernel_vector.length - 1){
				fw.write("\"" + kernel_vector[i] + "\""  + ", ");	
			}else{
				fw.write("\"" + kernel_vector[i] + "\"" +  "];" + "\n" + "\n" + "\t" + "var electre = " + "\n" + "\t" + "[");
			}

		}
		
		for (int i = 0; i < electre_i_s_matrix.length; i++) {
			fw.write("\n" + "\t" + "  [");
			for (int j = 0; j < electre_i_s_matrix[0].length; j++) {
				if (i < electre_i_s_matrix.length - 1){
					fw.write("\"" + electre_i_s_matrix[i][j] + "\""  + ", ");
					if (j == electre_i_s_matrix[0].length - 1){
						fw.write("],");
					}							  	
				} else {
					fw.write("\"" + electre_i_s_matrix[i][j] + "\""  + ", ");
						if (j == electre_i_s_matrix[0].length - 1){
							fw.write("]" + "\n" + "\t" +  "];" + "\n" + "\n" + "\t" + "var cycles = " + "\n" + "\t" + "[" );
						}
				}
			}
		}
		
		for (int i = 0; i < cycles.length; i++) {
			fw.write("\n" + "\t" + "  [");
			for (int j = 0; j < cycles[0].length; j++) {
				if (i < cycles.length - 1){
					fw.write("\"" + cycles[i][j] + "\""  + ", ");
					if (j == cycles[0].length - 1){
						fw.write("],");
					}							  	
				} else {
					fw.write("\"" + cycles[i][j] + "\""  + ", ");
						if (j == cycles[0].length - 1){
							fw.write("]" + "\n" + "\t" +  "];" );
						}
				}
			}
		}
		
		fw.close();
	}
	
	public static void writeFile_eii_eiii_eiv(String[][] a_matrix, String[][] d_matrix, String[][] m_matrix, String[][] rank_matrix, String[][] rank_matrix_XY) throws IOException {
		String path    = "";
		path           =  "graph";
		File dir       = new File(path);	
		FileWriter fw  = new FileWriter(new File(dir, "temp_.txt"));
		
		if (InterfaceElectre.electre == 4){
			fw  = new FileWriter(new File(dir, "electre_ii.js"));
		}else if (InterfaceElectre.electre == 5){
			fw  = new FileWriter(new File(dir, "electre_iii.js"));
		}else if(InterfaceElectre.electre == 6){
			fw  = new FileWriter(new File(dir, "electre_iv.js"));
		}
		
		fw.write("\t" + "var a_matrix = " + "\n" + "\t" + "["); 
		
		for (int i = 0; i < a_matrix.length; i++) {
			fw.write("\n" + "\t" + "  [");
			for (int j = 0; j < a_matrix[0].length; j++) {
				if (i < a_matrix.length - 1){
					fw.write("\"" + a_matrix[i][j] + "\""  + ", ");
					if (j == a_matrix[0].length - 1){
						fw.write("],");
					}							  	
				} else {
					fw.write("\"" + a_matrix[i][j] + "\""  + ", ");
						if (j == a_matrix[0].length - 1){
							fw.write("]" + "\n" + "\t" +  "];" + "\n" + "\n" + "\t" + "var d_matrix = " + "\n" + "\t" + "[");
						}
				}
			}
		}
		
		for (int i = 0; i < d_matrix.length; i++) {
			fw.write("\n" + "\t" + "  [");
			for (int j = 0; j < d_matrix[0].length; j++) {
				if (i < d_matrix.length - 1){
					fw.write("\"" + d_matrix[i][j] + "\""  + ", ");
					if (j == d_matrix[0].length - 1){
						fw.write("],");
					}							  	
				} else {
					fw.write("\"" + d_matrix[i][j] + "\""  + ", ");
						if (j == d_matrix[0].length - 1){
							fw.write("]" + "\n" + "\t" +  "];" + "\n" + "\n" + "\t" + "var m_matrix = " + "\n" + "\t" + "[");
						}
				}
			}
		}
		
		for (int i = 0; i < m_matrix.length; i++) {
			fw.write("\n" + "\t" + "  [");
			for (int j = 0; j < m_matrix[0].length; j++) {
				if (i < m_matrix.length - 1){
					fw.write("\"" + m_matrix[i][j] + "\""  + ", ");
					if (j == m_matrix[0].length - 1){
						fw.write("],");
					}							  	
				} else {
					fw.write("\"" + m_matrix[i][j] + "\""  + ", ");
						if (j == m_matrix[0].length - 1){
							fw.write("]" + "\n" + "\t" +  "];" + "\n" + "\n" + "\t" + "var electre = " + "\n" + "\t" + "[");
						}
				}
			}
		}
		
		for (int i = 0; i < rank_matrix.length; i++) {
			fw.write("\n" + "\t" + "  [");
			for (int j = 0; j < rank_matrix[0].length; j++) {
				if (i < rank_matrix.length - 1){
					fw.write("\"" + rank_matrix[i][j] + "\""  + ", ");
					if (j == rank_matrix[0].length - 1){
						fw.write("],");
					}							  	
				} else {
					fw.write("\"" + rank_matrix[i][j] + "\""  + ", ");
						if (j == rank_matrix[0].length - 1){
							fw.write("]" + "\n" + "\t" +  "];" + "\n" + "\n" + "\t" + "var xy = " + "\n" + "\t" + "[");
						}
				}
			}
		}
		
		for (int i = 0; i < rank_matrix_XY.length; i++) {
			fw.write("\n" + "\t" + "  [");
			for (int j = 0; j < rank_matrix_XY[0].length; j++) {
				if (i < rank_matrix_XY.length - 1){
					fw.write("\"" + rank_matrix_XY[i][j] + "\""  + ", ");
					if (j == rank_matrix_XY[0].length - 1){
						fw.write("],");
					}							  	
				} else {
					fw.write("\"" + rank_matrix_XY[i][j] + "\""  + ", ");
						if (j == rank_matrix_XY[0].length - 1){
							fw.write("]" + "\n" + "\t" +  "];" );
						}
				}
			}
		}
		
		fw.close();
		
	}
	public static void writeFile_e_tri(String[][] classification_matrix, double[][] projection) throws IOException {
		String path    = "";
		path           = "graph";
		File dir       = new File(path);
		FileWriter fw  = new FileWriter(new File(dir, "temp_.txt"));
		
		if (InterfaceElectre.electre == 7){
			fw  = new FileWriter(new File(dir, "electre_tri.js"));
		}else if(InterfaceElectre.electre == 8){
			fw  = new FileWriter(new File(dir, "electre_tri_me.js"));
		}
		
		fw.write("\t" + "var electre = " + "\n" + "\t" + "["); 
		
		for (int i = 0; i < classification_matrix.length; i++) {
			fw.write("\n" + "\t" + "  [");
			for (int j = 0; j < classification_matrix[0].length; j++) {
				if (i < classification_matrix.length){
					fw.write("\"" + classification_matrix[i][j] + "\""  + ", ");							  	
				} 
			}
			for (int j = 0; j < projection[0].length; j++) {
				if (i < projection.length - 1){
					fw.write("\"" + projection[i][j] + "\""  + ", ");
					if (j == projection[0].length - 1){
						fw.write("],");
					}							  	
				} else {
					fw.write("\"" + projection[i][j] + "\""  + ", ");
						if (j == projection[0].length - 1){
							fw.write("]" + "\n" + "\t" +  "];" );
						}
				}
			}
		}
		fw.close();
	}
}

