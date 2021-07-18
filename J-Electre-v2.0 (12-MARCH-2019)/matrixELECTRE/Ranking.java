package matrixELECTRE;

//Copyright © 2017 by Valdecy Pereira, Helder Gomes Costa and Livia Dias de Oliveira Nepomuceno.

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

import java.util.Arrays;
import java.util.Comparator;

public class Ranking {
	public static String[][] matrixRanking(String [][] array) {

		String[][] arrayString = new String[array.length + 1][array.length + 4];
		String[][] arrayCount  = new String[array.length][3];
		String[][] arrayTotal  = new String[array.length][2];
		double[]   arrayDouble = new double[array.length];
		String str_a           = new String("");
		String str_b           = new String("");
		int elementcountPp;
		int elementcountPm;
		int elementcountI;
		int count;
		int search;

		for (int i = 0; i < arrayCount.length; i++) {
			for (int j = 0; j < arrayCount[0].length; j++){
				arrayCount[i][j] = "0";
			}
		}
		
		for (int i = 0; i < array.length; i++) {
			elementcountPp = 0;
			elementcountPm = 0;
			for (int j = 0; j < array[0].length; j++){
				if (array[i][j] == "P+"){
					elementcountPp = elementcountPp + 1;
					arrayCount[i][0] = Integer.toString(elementcountPp);
				}
				if (array[i][j] == "P-"){
					elementcountPm = elementcountPm + 1;
					arrayCount[i][1] = Integer.toString(elementcountPm);
				}
				arrayCount[i][2] = Integer.toString(elementcountPp - elementcountPm);
			}
		}

		for (int i = 1; i < arrayString.length; i++){
			if (i == 0){
				arrayString[0][0] = " "; 
			} else{
				arrayString[i][0] = "a" + i;
			}
			for (int j = 0; j < arrayString[0].length; j++){
				if (j == 0){
					arrayString[0][0] = ""; 
				} else if (j < array.length + 1){
					arrayString[0][j] = "a" + j;	
				} else if (j == array.length + 1){
					arrayString[0][j] = "P+";
					arrayString[0][j + 1] = "P-";
					arrayString[0][j + 2] = "T";
				}
				if (i > 0 && j > 0){
					arrayString[i][j] = "";
				}
				if (i > 0 && i < array.length + 1 && j > 0 && j < array.length + 1){
					arrayString[i][j] = array[i - 1][j - 1];
				}
				if (i > 0 && j > array.length){
					arrayString[i][j] = arrayCount[i - 1][j - (array.length + 1)];
				}
			}
		}

		for (int i = 0; i < array.length; i++) {
			arrayDouble[i] = Double.valueOf(arrayString[i + 1][(array.length + 3)]);
			arrayDouble[i] = arrayDouble[i] + (arrayTotal.length - 1);
		}

		for (int i = 0; i < arrayTotal.length; i++) {
			for (int j = 0; j < arrayTotal[0].length; j++){
				arrayTotal[i][0] = arrayString[i + 1][0]; 
				arrayTotal[i][1] = Integer.toString(Integer.valueOf(arrayCount[i][2]) + (arrayTotal.length - 1));
			}
		}

		elementcountI = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array[0].length; j++){
				if (array[i][j] == "I"){
					elementcountI = elementcountI + 1;
				}
			}
		}

		if (elementcountI > 0){
			for (int i = 0; i < array.length; i++) {
				for (int j = i + 1; j < array[0].length; j++){
					if (array[i][j] == "I" & arrayTotal[j][0] != "NA"){
						arrayTotal[i][0] = arrayTotal[i][0] + "; " + arrayTotal[j][0];
						arrayTotal[j][0] = "NA";
					}
				}
			}	
			for (int i = arrayTotal.length - 1; i > - 1; i--){
				if (arrayTotal[i][0] == "NA"){
					arrayTotal = MatrixOperations.get2DRemoveRowString(arrayTotal, i);
				}
			}
		}
		
		Arrays.sort(arrayTotal, new Comparator<String[]>() {
			@Override
			public int compare(final String[] entry1, final String[] entry2) {
				final Integer time1 = Integer.valueOf(entry1[1]);
				final Integer time2 = Integer.valueOf(entry2[1]);
				return time1.compareTo(time2);
			}
		});

		String[][] arrayTotalComplete  =  new String[arrayTotal.length][2];
		for (int i = arrayTotal.length - 1; i > -1; i--) {
			arrayTotalComplete[(arrayTotal.length - 1) - i][0] =  arrayTotal[i][0];
			arrayTotalComplete[(arrayTotal.length - 1) - i][1] =  Integer.toString(Integer.valueOf(arrayTotal[i][1]));
		}
		String[][] arrayRankFinal  =  new String[arrayTotalComplete.length + 1][arrayTotalComplete.length + 1];
		for (int i = 0; i < arrayRankFinal.length; i++) {
			for (int j = 0; j < arrayRankFinal[0].length; j++){
				arrayRankFinal[i][j] = "0.0";
			}
		}
		arrayRankFinal[0][0] = "";
		for (int i = 0; i < arrayTotalComplete.length; i++) {
				arrayRankFinal[i + 1][0] = arrayTotalComplete[i][0];
				arrayRankFinal[0][i + 1] = arrayTotalComplete[i][0];
		}
		String[][] arrayList  =  new String[arrayRankFinal.length - 1][arrayRankFinal.length - 1];
		for (int i = 0; i < arrayRankFinal.length - 1; i++) {
			for (int j = 0; j < arrayRankFinal[0].length - 1; j++){
				arrayList[i][j] = arrayRankFinal[i][j + 1];
			}
		}
		
			for (int j = 0; j < arrayList.length - 1; j++) {
				count = 0;
				for (int i = j + 1; i < arrayList[0].length; i++){
					str_a = arrayList[0][j];
					if (str_a.indexOf(";") >= 0){
						str_a = str_a.substring(0, str_a.indexOf(";"));
					}
					str_b = arrayList[0][i];
					if (str_b.indexOf(";") >= 0){
						str_b = str_b.substring(0, str_b.indexOf(";"));
					}
					
					if(MatrixOperations.get2DSearchString(str_a, str_b, arrayString) == "P+"){
						count = count + 1;
						arrayList[count][j] = arrayList[0][i];
					}
				}
				
			}
		for (int j = arrayList[0].length - 1; j > -1; j--) {
			search = 1;
			while (search == 1){
				for (int i = arrayList.length - 1; i > 0; i--) {
						str_a = arrayList[i][j];
						if (str_a.indexOf(";") >= 0){
							str_a = str_a.substring(0, str_a.indexOf(";"));
						}
						if (str_a != "0.0"){
							for (int k = i - 1; k > - 1; k--) {
								str_b = arrayList[k][j];
								if (str_b.indexOf(";") >= 0){
									str_b = str_b.substring(0, str_b.indexOf(";"));	
								}
								if(MatrixOperations.get2DSearchString(str_b, str_a, arrayString) == "P+"){
									search = 0;
									for (int m = 0; m < arrayRankFinal.length; m++) {
										for (int n = 0; n < arrayRankFinal[0].length; n++) {
											if(arrayRankFinal[m][0] == arrayList[k][j] && arrayRankFinal[0][n] == arrayList[i][j]){
												arrayRankFinal[m][n] = "1.0";
											}	
										}
									}
									for (int del = 1; del < arrayList.length; del++){
										if (arrayList[del][0] == arrayList[i][j]){
											arrayList[del][0] = "0.0";
										}
										if (arrayList[del][j] == arrayList[i][j]){
											arrayList[del][j] = "0.0";
										}
									}
									k = -2;
								}
							}
						}
				}
				search = 0;
			}	
		}
		return arrayRankFinal;	
	}
	
	public static String[][] matrixRanking_XY(String [][] array) {
		
		String[][] arrayXY = new String[array.length - 1][3];
		int count = 0;
		int rank_pos = 0;
		
		for (int i = 0; i < arrayXY.length; i++){
			arrayXY[i][0] = array[i + 1][0];
			arrayXY[i][1] = "";
			arrayXY[i][2] = "";
		}
		
		for (int j = 1; j < array[0].length; j++){
			count = 0;
			for (int i = 1; i < array.length; i++){
				if (array[i][j] == "1.0"){
					i =  array.length + 1;
					count = count + 1;
				}
			}
			if (count == 0){
				arrayXY[j - 1][2] = Integer.toString(rank_pos) + ".0"; 
				rank_pos = rank_pos + 1;
			}
		}
		
		for (int i = 1; i < array.length; i++){
			count = 0;
			for (int j = 1; j < array[0].length; j++){
				if (array[i][j] == "1.0" && arrayXY[i - 1][2] != ""){
					rank_pos =  Integer.parseInt(arrayXY[i - 1][2].substring(0, arrayXY[i - 1][2].indexOf(".")));
					arrayXY[j - 1][2] = Integer.toString(rank_pos + 1) + ".0";
				}
			}
		}
		
		rank_pos = 0;
		for (int i = 1; i < array.length; i++){
			for (int j = 1; j < array[0].length; j++){
				if (array[i][j] == "1.0"){
					arrayXY[j - 1][1] = Integer.toString(rank_pos) + ".0";
					rank_pos = rank_pos + 1;
				}
			}
			if (rank_pos > 0){
				i = array.length + 1;
			}
		}
		
		for (int i = 1; i < array.length; i++){
			for (int j = 1; j < array[0].length; j++){
				if (array[i][j] == "1.0" && arrayXY[i - 1][1] != ""){
					arrayXY[j - 1][1] = arrayXY[i - 1][1];
				}
			}
		}
		for (int i = 0; i < arrayXY.length; i++){
			if (arrayXY[i][1] == ""){
				arrayXY[i][1] = "0.0";
			}
		}
		
		for (int i = 0; i < arrayXY.length - 1; i++){
				for (int k = i + 1; k < arrayXY.length; k++){
					if(arrayXY[i][1].equals(arrayXY[k][1]) && arrayXY[i][2].equals(arrayXY[k][2])){
						arrayXY[k][1] = Integer.toString(Integer.parseInt(arrayXY[i][1].substring(0, arrayXY[i][1].indexOf("."))) + 1) + ".0";
					}
				}
		}

		return arrayXY;
	}

	public static void main(String[] args) {

	};
}
