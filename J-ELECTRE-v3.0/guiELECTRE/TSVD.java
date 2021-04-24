package guiELECTRE;

//Copyright © 2017 by Valdecy Pereira and Livia Dias de Oliveira Nepomuceno.

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

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.SingularValueDecomposition;

public class TSVD {

	public static double[][] getTruncatedSVD(double[][] matrix, final int k) {
	    
		SingularValueDecomposition svd = new SingularValueDecomposition(new Array2DRowRealMatrix(matrix));

	    double[][] truncatedU = new double[svd.getU().getRowDimension()][k];
	    svd.getU().copySubMatrix(0, truncatedU.length - 1, 0, k - 1, truncatedU);

	    double[][] truncatedS = new double[k][k];
	    svd.getS().copySubMatrix(0, k - 1, 0, k - 1, truncatedS);

	    double[][] truncatedVT = new double[k][svd.getVT().getColumnDimension()];
	    svd.getVT().copySubMatrix(0, k - 1, 0, truncatedVT[0].length - 1, truncatedVT);

	    RealMatrix projection2D = (new Array2DRowRealMatrix(truncatedU)).multiply(new Array2DRowRealMatrix(truncatedS));

	    return projection2D.getData();

	}
	

}
