package Nords;

public  class CoordinateCalculation {
	/*-------------------------------------------
	nords[0] = X-coordinate
	nords[1] = Y-coordinate
	nords[2] = X+1-coordinate
	nords[3] = Y+1-coordinate
	-------------------------------------------*/
	static int area(int[] nords) {
		int sum = 0;
		for(int i = 0; i < nords.length; i += 2) {
			if(i == nords.length - 2) {
				sum += (nords[i]*nords[1] - nords[0]*nords[i+1]) / 2;
			} else {
				sum += (nords[i]*nords[i+3] - nords[i+2]*nords[i+1]) / 2;
			}
		}
		return sum;
	}

	static int[] getCenter(int[] nords) {
		int a = area(nords);
		int[] g = new int[2];

		for(int i = 0; i < nords.length; i += 2) {
			if(i == nords.length - 2) {
				g[0] += ((Math.pow(nords[0], 3) - Math.pow(nords[i], 3)) * (nords[1] - nords[i+1]) / 3 +
						(Math.pow(nords[0], 2) - Math.pow(nords[i], 2)) * (nords[0]*nords[i+1] - nords[i]*nords[1]) / 2) /
						(nords[0] - nords[i]);

				g[1] += ((Math.pow(nords[1], 3) - Math.pow(nords[i+1], 3)) * (nords[0] - nords[i]) / 3 +
						(Math.pow(nords[1], 2) - Math.pow(nords[i+1], 2)) * (nords[i]*nords[1] - nords[0]*nords[i+1]) / 2) /
						(nords[1] - nords[i+1]);
			} else {
				g[0] += ((Math.pow(nords[i+2], 3) - Math.pow(nords[i], 3)) * (nords[i+3] - nords[i+1]) / 3 +
						(Math.pow(nords[i+2], 2) - Math.pow(nords[i], 2)) * (nords[i+2]*nords[i+1] - nords[i]*nords[i+3]) / 2) /
						(nords[i+2] - nords[i]);

				g[1] += ((Math.pow(nords[i+3], 3) - Math.pow(nords[i+1], 3)) * (nords[i+2] - nords[i]) / 3 +
						(Math.pow(nords[i+3], 2) - Math.pow(nords[i+1], 2)) * (nords[i]*nords[i+3] - nords[i+2]*nords[i+1]) / 2) /
						(nords[i+3] - nords[i+1]);
			}
		}

		g[0] = Math.abs(g[0] / a);
		g[1] = Math.abs(g[1] / a);
		return g;
	}

	/*-------------------------------------------
	nords[0] = X-Max
	nords[1] = Y-Max
	nords[2] = X-Min
	nords[3] = Y-Min
	-------------------------------------------*/
	static int[] min_max(int[] nords) {
		int xMax = nords[0];	//とりあえず最大値をn[0]に設定して変数xMaxに代入
		int yMax = nords[1];	//とりあえず最大値をn[0]に設定して変数yMaxに代入
		int xMin = nords[0];	//とりあえず最小値をn[0]に設定して変数minに代入
		int yMin = nords[1];	//とりあえず最小値をn[0]に設定して変数minに代入

		int xMaxIndex = 0;
		int yMaxIndex = 1;
		int xMinIndex = 0;
		int yMinIndex = 1;
		for (int i = 0; i < nords.length; i += 2) {
			if (xMax < nords[i]) {
				xMax = nords[i];
				xMaxIndex = i;
			}
			if(yMax < nords[i + 1]) {
				yMax = nords[i + 1];
				yMaxIndex = i + 1;
			}
			if (xMin > nords[i]) {
				xMin = nords[i];
				xMinIndex = i;
			}
			if(yMin > nords[i+1]) {
				yMin = nords[i+1];
				yMinIndex = i + 1;
			}
		}
		return  new int[] {xMaxIndex, yMaxIndex, xMinIndex, yMinIndex};
	}
}
