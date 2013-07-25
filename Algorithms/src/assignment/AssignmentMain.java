package assignment;
import java.util.ArrayList;
import java.util.Collections;

public class AssignmentMain {

	public static void main(String args[]) {

		double bestFPS[][] = new double[40][10];
		double avgFPS[][] = new double[40][10];
		double bestRBS[][] = new double[40][10];
		double avgRBS[][] = new double[40][10];
		double bestBT[][] = new double[40][10];
		double avgBT[][] = new double[40][10];
		double bestEP[][] = new double[40][10];
		double avgEP[][] = new double[40][10];
		double bestES[][] = new double[40][10];
		double avgES[][] = new double[40][10];
		double bestAIS[][] = new double[40][10];
		double avgAIS[][] = new double[40][10];
		double bestPSO[][] = new double[40][10];
		double avgPSO[][] = new double[40][10];
		
		int functionNumber = 3;

		for (int j = 0; j < 10; j++) {
			ArrayList<ElementData> population = new ArrayList<ElementData>();
			population = getPopulation(functionNumber);
			ElementData gbest= new ElementData();
			ArrayList<ElementData> populationPSO = new ArrayList<ElementData>();
			ArrayList<ElementData> offspringPSO = new ArrayList<ElementData>();
			ArrayList<ElementData> remainPSO = new ArrayList<ElementData>();
			ArrayList<ElementData> remainPSOSored = new ArrayList<ElementData>();
			populationPSO = population;
			for (int i = 0; i < 40; i++) {
				if(i==0){
					System.out.println("@@@@ " + i + "@@@");
					remainPSO = populationPSO;
					Collections.sort(remainPSO);
					bestPSO[i][j] = bestFitness(remainPSO); //
					avgPSO[i][j] = averageFitness(remainPSO);
					//populationPSO = offspringPSO;
						
				}
				else{
				System.out.println("@@@@ " + i + "@@@");
				offspringPSO = getOffSpringPSO(populationPSO, functionNumber,gbest);
				remainPSO = offspringPSO;
				Collections.sort(remainPSO);
				bestPSO[i][j] = bestFitness(remainPSO); //
				avgPSO[i][j] = averageFitness(remainPSO);
				populationPSO = offspringPSO;
				}
			}
		}

		
/*		for (int j = 0; j < 10; j++) {
			ArrayList<ElementData> population = new ArrayList<ElementData>();
			population = getPopulation(functionNumber);

			ArrayList<ElementData> populationAIS = new ArrayList<ElementData>();
			ArrayList<ElementData> offspringAIS = new ArrayList<ElementData>();
			ArrayList<ElementData> remainAIS = new ArrayList<ElementData>();
			ArrayList<ElementData> remainAISSored = new ArrayList<ElementData>();
			populationAIS = population;
			for (int i = 0; i < 40; i++) {
				System.out.println("@@@@ " + i + "@@@");
				offspringAIS = getOffSpringAIS(populationAIS, functionNumber);
				remainAIS = suvivalSelection(populationAIS, offspringAIS);
				remainAISSored.addAll(remainAIS);
				Collections.sort(remainAISSored);
				bestAIS[i][j] = bestFitness(remainAIS); //
				avgAIS[i][j] = averageFitness(remainAIS);
				populationAIS = remainAIS;
			}
		}
*/
		/*
		 * //ES //Calling method for ES ArrayList<ElementData> populationES= new
		 * ArrayList<ElementData>(); ArrayList<ElementData> offspringES = new
		 * ArrayList<ElementData>(); ArrayList<ElementData> remainES= new
		 * ArrayList<ElementData>(); ArrayList<ElementData> remainESSored= new
		 * ArrayList<ElementData>(); populationES= population; for (int i = 0; i
		 * < 20; i++) { offspringES=getoffSpringES(populationES,
		 * functionNumber); remainES=suvivalSelectionESFPS(offspringES); //
		 * bestES[i][j] = bestFitness(remainES); // avgES[i][j] =
		 * averageFitness(remainES); populationES = remainES; }
		 * 
		 * 
		 * //EP ArrayList<ElementData> populationEP= new
		 * ArrayList<ElementData>(); ArrayList<ElementData> offspringEP = new
		 * ArrayList<ElementData>(); ArrayList<ElementData> remainEP= new
		 * ArrayList<ElementData>(); ArrayList<ElementData> remainEPSored= new
		 * ArrayList<ElementData>(); populationEP= population; for (int i = 0; i
		 * < 40; i++) { offspringEP=getoffSpringEP(populationEP,
		 * functionNumber); remainEP=suvivalSelectionEPFPS(populationEP,
		 * offspringEP); //Collections.sort(remainEP); bestEP[i][j] =
		 * bestFitness(remainEP); avgEP[i][j] = averageFitness(remainEP);
		 * populationEP = remainEP; }
		 * 
		 * //FPS and T ArrayList<ElementData> populationFPS = new
		 * ArrayList<ElementData>(); ArrayList<ElementData> offspringFPS = new
		 * ArrayList<ElementData>(); ArrayList<ElementData> remainFPS = new
		 * ArrayList<ElementData>(); populationFPS = population; for (int i = 0;
		 * i < 40; i++) { offspringFPS = getOffSpringFPS(populationFPS,
		 * functionNumber); remainFPS = suvivalSelection(populationFPS,
		 * offspringFPS); Collections.sort(remainFPS); bestFPS[i][j] =
		 * bestFitness(remainFPS); avgFPS[i][j] = averageFitness(remainFPS);
		 * populationFPS = remainFPS; }
		 * 
		 * //RBS and T ArrayList<ElementData> populationRBS = new
		 * ArrayList<ElementData>(); ArrayList<ElementData> offspringRBS = new
		 * ArrayList<ElementData>(); ArrayList<ElementData> remainRBS = new
		 * ArrayList<ElementData>(); ArrayList<ElementData> remainRBSSorted =
		 * new ArrayList<ElementData>(); populationRBS = population; for (int i
		 * = 0; i < 40; i++) { offspringRBS = getOffSpringRBS(populationRBS,
		 * functionNumber); remainRBS = suvivalSelectionBT(populationRBS,
		 * offspringRBS); remainRBSSorted=remainRBS;
		 * Collections.sort(remainRBSSorted); bestRBS[i][j] =
		 * bestFitness(remainRBSSorted); avgRBS[i][j] =
		 * averageFitness(remainRBSSorted); populationRBS = remainRBS; }
		 * 
		 * //BT and T ArrayList<ElementData> populationBT = new
		 * ArrayList<ElementData>(); ArrayList<ElementData> offspringBT = new
		 * ArrayList<ElementData>(); ArrayList<ElementData> remainBT = new
		 * ArrayList<ElementData>(); populationBT = population;
		 * 
		 * for (int i = 0; i < 40; i++) { offspringBT =
		 * getOffSpringBT(populationBT, functionNumber); remainBT =
		 * suvivalSelection(populationBT, offspringBT);
		 * Collections.sort(remainBT); bestBT[i][j] = bestFitness(remainBT);
		 * avgBT[i][j] = averageFitness(remainBT); populationBT = remainBT; }
		 */
		// }//first for loop

		//System.out.println("### best ###");
		for (int i = 0; i < 40; i++) {
			for (int k = 0; k < 10; k++) {
				// System.out.print(bestRBS[i][k]+" ");
				// System.out.print(bestFPS[i][k]+" ");
				// System.out.print(bestBT[i][k]+" ");
				// System.out.print(bestEP[i][k]+" ");
				// System.out.print(bestES[i][k]+" ");
				//System.out.print(bestAIS[i][k] + " ");
				System.out.print(bestPSO[i][k] + " ");
			}
			System.out.println();
		}
		
		System.out.println("### average###");
		for (int i = 0; i < 40; i++) {
			for (int k = 0; k < 10; k++) {
				// System.out.print(avgRBS[i][k]+" ");
				// System.out.print(avgFPS[i][k]+" ");
				// System.out.print(avgBT[i][k]+" ");
				//System.out.print(avgEP[i][k] + " ");
				// System.out.print(avgES[i][k]+" ");
				//System.out.print(avgAIS[i][k] + " ");
				System.out.print(avgPSO[i][k] + " ");
			}
			System.out.println();
		}
		
		System.out.println(" $$$ Best and average $$$");
		for (int i = 0; i < 40; i++) {
			double sumBFPS = 0;
			double sumBRBS = 0;
			double sumBBT = 0;
			double sumAFPS = 0;
			double sumARBS = 0;
			double sumABT = 0;
			double sumABEP = 0;
			double sumAAEP = 0;
			double sumABES = 0;
			double sumAAES = 0;

			double sumABAIS = 0;
			double sumAAAIS = 0;
			double sumABPSO= 0;
			double sumAAPSO = 0;
			for (int k = 0; k < 10; k++) {
/*				sumBFPS += bestFPS[i][k];
				sumAFPS += avgFPS[i][k];

				sumBRBS += bestRBS[i][k];
				sumARBS += avgRBS[i][k];

				sumBBT += bestBT[i][k];
				sumABT += avgBT[i][k];
				sumABEP += bestEP[i][k];
				sumAAEP += avgEP[i][k];

				sumABES += bestES[i][k];
				sumAAES += avgES[i][k];

				sumABAIS += bestAIS[i][k];
				sumAAAIS += avgAIS[i][k];
*/
				sumABPSO+= bestPSO[i][k];
				sumAAPSO += avgPSO[i][k];
				}
			// System.out.println(i+1+" "+ sumBFPS/10+" "+sumAFPS/10);
			// System.out.println(i+1+" "+ sumBBT/10+" "+sumABT/10);
			// System.out.println(i+1+" "+ sumBRBS/10+" "+sumARBS/10);
			// System.out.println(i+1+" "+ sumABEP/10+" "+sumAAEP/10);
			// System.out.println(i+1+" "+ sumABES/10+" "+sumAAES/10);
			// System.out.println(i+1+" "+ sumABAIS/10+" "+sumAAAIS/10);
			System.out.println(i+1+" "+ sumABPSO/10+" "+sumAAPSO/10);
		}

	}

	//offspring for PSO
	public static ArrayList<ElementData> getOffSpringPSO(ArrayList<ElementData> pop,int funNum,ElementData gbest){
		ArrayList<ElementData> data = new ArrayList<ElementData>();
		ElementData pbest= new ElementData();
		data.addAll(pop);
		Collections.sort(data);
		pbest=data.get(0);
		if(pbest.getFn()>gbest.getFn())
		gbest=data.get(0);
		
		for (int i = 0; i < pop.size(); i++) {
			double numVX=(2*Math.random()*(pbest.getX()-pop.get(i).getX())+2*Math.random()*(gbest.getX()-pop.get(i).getX()))/10;
			double px=numVX+pop.get(i).getX();
			System.out.println("VX: "+numVX+" x: "+px );
			//pop.get(i).setX(px);
			double numVY=(pop.get(i).getY()+2*Math.random()*(pbest.getY()-pop.get(i).getY())+2*Math.random()*(gbest.getY()-pop.get(i).getY()))/10;
			double py=numVY+pop.get(i).getY();
			System.out.println("VY: "+numVY+" y: "+py);
			//pop.get(i).setY(py);
			if(funNum==2){
				if(px>2)
					pop.get(i).setX(2);
				else if(px<-2)
					pop.get(i).setX(-2);
				else
					pop.get(i).setX(px);
				if(py>3)
					pop.get(i).setY(3);
				else if(py<-1)
					pop.get(i).setY(-1);
				else
					pop.get(i).setY(py);
				pop.get(i).setFn((float) function2(pop.get(i).getX(), pop.get(i).getY()));
			}
			else if(funNum==3){
				if(px>4)
					pop.get(i).setX(4);
				else if(px<-4)
					pop.get(i).setX(-4);
				else
					pop.get(i).setX(px);
				if(py>4)
					pop.get(i).setY(4);
				else if(py<-4)
					pop.get(i).setY(-4);
				else
					pop.get(i).setY(py);
				pop.get(i).setFn((float) function3(pop.get(i).getX(), pop.get(i).getY()));
			}
		}
		System.out.println("### PSO algo ###");
		for (int i = 0; i < pop.size(); i++) {
			System.out.println("x=" + pop.get(i).getX() + " y="
					+ pop.get(i).getY() + " fn="
					+ pop.get(i).getFn());
		}
		System.out.println("### GBEST && PBEST ###");
		System.out.println("x=" + gbest.getX() + " y="
					+ gbest.getY() + " fn="
					+ gbest.getFn());
		System.out.println("x=" + pbest.getX() + " y="
				+ pbest.getY() + " fn="
				+ pbest.getFn());
		return pop;
	}
	
	
	//Artificial Immune System Algo
	public static ArrayList<ElementData> getOffSpringAIS(
			ArrayList<ElementData> pop, int funNum) {
		ArrayList<ElementData> data = new ArrayList<ElementData>();
		ArrayList<ElementData> F = new ArrayList<ElementData>();

		// initializing the total value of the function
		double totalFnParent = 0;
		for (int i = 0; i < pop.size(); i++) {
			totalFnParent += pop.get(i).getFn();
		}
		double arrayParent[] = new double[pop.size()];
		// Putting the value in array
		for (int i = 0; i < arrayParent.length; i++) {
			arrayParent[i] = pop.get(i).getFn() / totalFnParent;
			// System.out.println("array" + i + " " + array[i]);
		}

		// Creating the range in the temp arraylist
		ArrayList<functionRangeElement> tempParent = new ArrayList<functionRangeElement>();
		double num = 0;
		for (int i = 0; i < pop.size(); i++) {
			functionRangeElement element = new functionRangeElement(num, num
					+ arrayParent[i], pop.get(i));
			num += arrayParent[i];
			tempParent.add(element);
		}

		for (int i = 0; i < 4; i++) {
			// ArrayList<ElementData> tempTwo = new ArrayList<ElementData>();
			double ranNum = Math.random();
			if (ranNum >= tempParent.get(0).getFnStart()
					&& ranNum < tempParent.get(0).getFnEnd()) {
				F.add(tempParent.get(0).data);
			} else if (ranNum >= tempParent.get(1).getFnStart()
					&& ranNum < tempParent.get(1).getFnEnd()) {
				F.add(tempParent.get(1).data);
			} else if (ranNum >= tempParent.get(2).getFnStart()
					&& ranNum < tempParent.get(2).getFnEnd()) {
				F.add(tempParent.get(2).data);
			} else if (ranNum >= tempParent.get(3).getFnStart()
					&& ranNum < tempParent.get(3).getFnEnd()) {
				F.add(tempParent.get(3).data);
			} else if (ranNum >= tempParent.get(4).getFnStart()
					&& ranNum < tempParent.get(4).getFnEnd()) {
				F.add(tempParent.get(4).data);
			} else if (ranNum >= tempParent.get(5).getFnStart()
					&& ranNum < tempParent.get(5).getFnEnd()) {
				F.add(tempParent.get(5).data);
			} else if (ranNum >= tempParent.get(6).getFnStart()
					&& ranNum < tempParent.get(6).getFnEnd()) {
				F.add(tempParent.get(6).data);
			} else if (ranNum >= tempParent.get(7).getFnStart()
					&& ranNum < tempParent.get(7).getFnEnd()) {
				F.add(tempParent.get(7).data);
			} else if (ranNum >= tempParent.get(8).getFnStart()
					&& ranNum < tempParent.get(8).getFnEnd()) {
				F.add(tempParent.get(8).data);
			} else if (ranNum >= tempParent.get(9).getFnStart()
					&& ranNum < tempParent.get(9).getFnEnd()) {
				F.add(tempParent.get(9).data);
			}
		}

		// initializing the total value of the function
		double totalFnOffSpring = 0;
		for (int i = 0; i < F.size(); i++) {
			totalFnOffSpring += F.get(i).getFn();
		}
		double arrayOffSpring[] = new double[F.size()];
		// Putting the value in array
		for (int i = 0; i < arrayOffSpring.length; i++) {
			arrayOffSpring[i] = F.get(i).getFn() / totalFnOffSpring;
			// System.out.println("array" + i + " " + array[i]);
		}

		// Creating the range in the temp arraylist
		ArrayList<functionRangeElement> tempOffSpring = new ArrayList<functionRangeElement>();
		double numOffSpring = 0;
		for (int i = 0; i < F.size(); i++) {
			functionRangeElement element = new functionRangeElement(
					numOffSpring, numOffSpring + arrayOffSpring[i], F.get(i));
			numOffSpring += arrayOffSpring[i];
			tempOffSpring.add(element);
		}

		ArrayList<ElementData> mutatedClones = new ArrayList<ElementData>();
		for (int i = 0; i < 4; i++) {
			double ranNum = Math.random();
			if (ranNum >= tempOffSpring.get(0).getFnStart()
					&& ranNum < tempOffSpring.get(0).getFnEnd()) {
				mutatedClones.add(tempOffSpring.get(0).data);
			} else if (ranNum >= tempOffSpring.get(1).getFnStart()
					&& ranNum < tempOffSpring.get(1).getFnEnd()) {
				mutatedClones.add(tempOffSpring.get(1).data);
			} else if (ranNum >= tempOffSpring.get(2).getFnStart()
					&& ranNum < tempOffSpring.get(2).getFnEnd()) {
				mutatedClones.add(tempOffSpring.get(2).data);
			} else if (ranNum >= tempOffSpring.get(3).getFnStart()
					&& ranNum < tempOffSpring.get(3).getFnEnd()) {
				mutatedClones.add(tempOffSpring.get(3).data);
			}
		}
		System.out.println("### Before Mutation###");
		for (int i = 0; i < mutatedClones.size(); i++) {
			System.out.println("x=" + mutatedClones.get(i).getX() + " y="
					+ mutatedClones.get(i).getY() + " fn="
					+ mutatedClones.get(i).getFn());
		}

		mutatedClones = doMutation(mutatedClones, funNum);
		System.out.println("### Mutated Clones ###");
		for (int i = 0; i < mutatedClones.size(); i++) {
			System.out.println("x=" + mutatedClones.get(i).getX() + " y="
					+ mutatedClones.get(i).getY() + " fn="
					+ mutatedClones.get(i).getFn());
		}

		ArrayList<ElementData> randomElement = new ArrayList<ElementData>();
		for (int i = 0; i < 2; i++) {
			double ran = Math.random()*4;
			randomElement.add(mutatedClones.get((int) ran));
		}
		/*
		 * System.out.println("### randomElement ###"); for (int i = 0; i <
		 * randomElement.size(); i++) { System.out.println("x=" +
		 * randomElement.get(i).getX() + " y=" + randomElement.get(i).getY() +
		 * " fn=" + randomElement.get(i).getFn()); }
		 */
		// data.addAll(randomElement);
		ArrayList<ElementData> BT = new ArrayList<ElementData>();
		for (int j = 0; j < 2; j++) {
			ArrayList<ElementData> temp1 = new ArrayList<ElementData>();
			double ranNum1 = Math.random();
			if (ranNum1 >= 0 && ranNum1 < 0.25) {
				temp1.add(mutatedClones.get(0));
			} else if (ranNum1 >= 0.25 && ranNum1 < 0.5) {
				temp1.add(mutatedClones.get(1));
			} else if (ranNum1 >= 0.5 && ranNum1 < 0.75) {
				temp1.add(mutatedClones.get(2));
			} else if (ranNum1 >= 0.75 && ranNum1 < 1) {
				temp1.add(mutatedClones.get(3));
			}

			double ranNum2 = Math.random();
			if (ranNum2 >= 0 && ranNum2 < 0.25) {
				temp1.add(mutatedClones.get(0));
			} else if (ranNum2 >= 0.25 && ranNum2 < 0.5) {
				temp1.add(mutatedClones.get(1));
			} else if (ranNum2 >= 0.5 && ranNum2 < 0.75) {
				temp1.add(mutatedClones.get(2));
			} else if (ranNum2 >= 0.75 && ranNum2 < 1) {
				temp1.add(mutatedClones.get(3));
			}
			Collections.sort(temp1);
			BT.add(temp1.get(0));
		}
		/*
		 * System.out.println("### BT ###"); for (int i = 0; i < BT.size(); i++)
		 * { System.out.println("x=" + BT.get(i).getX() + " y=" +
		 * BT.get(i).getY() + " fn=" + BT.get(i).getFn()); }
		 */

		// data.addAll(F);
		// data.addAll(mutatedClones);
		data.addAll(randomElement);
		data.addAll(BT);
		/*
		 * System.out.println("### 4 ###"); for (int i = 0; i < data.size();
		 * i++) { System.out.println("x=" + data.get(i).getX() + " y=" +
		 * data.get(i).getY() + " fn=" + data.get(i).getFn()); }
		 */
		return data;
	}

	/*
	 * initialize the array using random number
	 */
	public static ArrayList<ElementData> getPopulation(int funNum) {
		ArrayList<ElementData> data = new ArrayList<ElementData>();
		if (funNum == 1) {
			for (int i = 0; i < 10; i++) {
				double x = generateRandomNumber(-5, 5);
				double y = generateRandomNumber(-5, 5);
				float fn = (float) function(x, y);
				ElementData ele = new ElementData(x, y, fn);
				data.add(ele);
			}
			System.out.println("### Population ###");
			for (int i = 0; i < data.size(); i++) {
				System.out.println("x=" + data.get(i).getX() + " y="
						+ data.get(i).getY() + " fn=" + data.get(i).getFn());
			}
		} else if (funNum == 2) {

			for (int i = 0; i < 10; i++) {
				double x = generateRandomNumber(-2, 2);
				double y = generateRandomNumber(-1, 3);
				float fn = (float) function2(x, y);
				ElementData ele = new ElementData(x, y, fn);
				data.add(ele);
			}
			System.out.println("### Population ###");
			for (int i = 0; i < data.size(); i++) {
				System.out.println("x=" + data.get(i).getX() + " y="
						+ data.get(i).getY() + " fn=" + data.get(i).getFn());
			}

		} else if (funNum == 3) {
			for (int i = 0; i < 10; i++) {
				double x = generateRandomNumber(-4, 4);
				double y = generateRandomNumber(-4, 4);
				float fn = (float) function3(x, y);
				ElementData ele = new ElementData(x, y, fn);
				data.add(ele);
			}
			System.out.println("### Population ###");
			for (int i = 0; i < data.size(); i++) {
				System.out.println("x=" + data.get(i).getX() + " y="
						+ data.get(i).getY() + " fn=" + data.get(i).getFn());
			}

		}

		return data;
	}

	//offspring for Evolutionary Programming
	public static ArrayList<ElementData> getoffSpringEP(
			ArrayList<ElementData> pop, int funNum) {
		ArrayList<ElementData> data = new ArrayList<ElementData>();

		System.out.println("@@@ Mutation @@@");
		for (int i = 0; i < pop.size(); i++) {
			data.add(doGaussianMutation(pop.get(i), funNum));
		}

		System.out.println("### Off Spring ###");
		for (int i = 0; i < data.size(); i++) {
			System.out.println("x=" + data.get(i).getX() + " y="
					+ data.get(i).getY() + " fn=" + data.get(i).getFn());
		}
		return data;
	}

	//offspring for Evolutionary Strategies
	public static ArrayList<ElementData> getoffSpringES(
			ArrayList<ElementData> pop, int funNum) {
		ArrayList<ElementData> data = new ArrayList<ElementData>();
		System.out.println("### Off Spring ###");
		for (int i = 0; i < 16; i++) {
			ArrayList<ElementData> temp1 = new ArrayList<ElementData>();
			for (int j = 0; j < 2; j++) {
				double ranNum = Math.random();
				if (ranNum >= 0 && ranNum < 0.1) {
					temp1.add(pop.get(0));
				} else if (ranNum >= 0.1 && ranNum < 0.2) {
					temp1.add(pop.get(1));
				} else if (ranNum >= 0.2 && ranNum < 0.3) {
					temp1.add(pop.get(2));
				} else if (ranNum >= 0.3 && ranNum < 0.4) {
					temp1.add(pop.get(3));
				} else if (ranNum >= 0.4 && ranNum < 0.5) {
					temp1.add(pop.get(4));
				} else if (ranNum >= 0.5 && ranNum < 0.6) {
					temp1.add(pop.get(5));
				} else if (ranNum >= 0.6 && ranNum < 0.7) {
					temp1.add(pop.get(6));
				} else if (ranNum >= 0.7 && ranNum < 0.8) {
					temp1.add(pop.get(7));
				} else if (ranNum >= 0.8 && ranNum < 0.9) {
					temp1.add(pop.get(8));
				} else if (ranNum >= 0.9 && ranNum < 1) {
					temp1.add(pop.get(9));
				}

			}
			double x1 = 0, x2 = 0, y1 = 0, y2 = 0;
			double x = 0, y = 0;
			float fn = 0;
			double randX = Math.random();
			double randY = Math.random();
			x1 = temp1.get(0).getX();
			x2 = temp1.get(1).getX();
			y1 = temp1.get(0).getY();
			y2 = temp1.get(1).getY();
			if (randX < 0.5)
				x = x1;
			else
				x = x2;
			if (randY < 0.5)
				y = y1;
			else
				y = y2;
			if (funNum == 1) {
				fn = (float) function(x, y);
			} else if (funNum == 2) {
				fn = (float) function2(x, y);
			} else if (funNum == 3) {
				fn = (float) function3(x, y);
			}
			ElementData ele1 = new ElementData(x, y, fn);
			data.add(ele1);
			System.out.println("x=" + ele1.getX() + " y=" + ele1.getY()
					+ " fn=" + ele1.getFn());
		}
		ArrayList<ElementData> dataMutated = new ArrayList<ElementData>();
		for (int i = 0; i < data.size(); i++) {
			double checkMutation = Math.random();
			if (checkMutation < 0.2) {
				ElementData ele = new ElementData();
				ele = doGaussianMutation(data.get(i), funNum);
				dataMutated.add(ele);
				System.out.println("Mutated at " + i);
			} else
				dataMutated.add(data.get(i));
		}
		System.out.println("### Mutated ###");
		for (int i = 0; i < dataMutated.size(); i++) {
			System.out.println("x=" + dataMutated.get(i).getX() + " y="
					+ dataMutated.get(i).getY() + " fn="
					+ dataMutated.get(i).getFn());
		}
		// data.add(doGaussianMutation(pop.get(i),funNum));

		return dataMutated;
	}

	//offspring for FPS
	public static ArrayList<ElementData> getOffSpringFPS(
			ArrayList<ElementData> pop, int funNum) {
		ArrayList<ElementData> data = new ArrayList<ElementData>();

		// initializing the total value of the function
		double totalFn = 0;
		for (int i = 0; i < pop.size(); i++) {
			totalFn += pop.get(i).getFn();
		}
		double array[] = new double[pop.size()];
		// Putting the value in array
		for (int i = 0; i < array.length; i++) {
			array[i] = pop.get(i).getFn() / totalFn;
			// System.out.println("array" + i + " " + array[i]);
		}

		// Creating the range in the temp arraylist
		ArrayList<functionRangeElement> temp = new ArrayList<functionRangeElement>();
		double num = 0;
		for (int i = 0; i < pop.size(); i++) {
			functionRangeElement element = new functionRangeElement(num, num
					+ array[i], pop.get(i));
			num += array[i];
			temp.add(element);
		}

		for (int i = 0; i < 5; i++) {
			ArrayList<ElementData> tempTwo = new ArrayList<ElementData>();
			for (int j = 0; j < 2; j++) {

				double ranNum = Math.random();
				if (ranNum >= temp.get(0).getFnStart()
						&& ranNum < temp.get(0).getFnEnd()) {
					tempTwo.add(temp.get(0).data);
				} else if (ranNum >= temp.get(1).getFnStart()
						&& ranNum < temp.get(1).getFnEnd()) {
					tempTwo.add(temp.get(1).data);
				} else if (ranNum >= temp.get(2).getFnStart()
						&& ranNum < temp.get(2).getFnEnd()) {
					tempTwo.add(temp.get(2).data);
				} else if (ranNum >= temp.get(3).getFnStart()
						&& ranNum < temp.get(3).getFnEnd()) {
					tempTwo.add(temp.get(3).data);
				} else if (ranNum >= temp.get(4).getFnStart()
						&& ranNum < temp.get(4).getFnEnd()) {
					tempTwo.add(temp.get(4).data);
				} else if (ranNum >= temp.get(5).getFnStart()
						&& ranNum < temp.get(5).getFnEnd()) {
					tempTwo.add(temp.get(5).data);
				} else if (ranNum >= temp.get(6).getFnStart()
						&& ranNum < temp.get(6).getFnEnd()) {
					tempTwo.add(temp.get(6).data);
				} else if (ranNum >= temp.get(7).getFnStart()
						&& ranNum < temp.get(7).getFnEnd()) {
					tempTwo.add(temp.get(7).data);
				} else if (ranNum >= temp.get(8).getFnStart()
						&& ranNum < temp.get(8).getFnEnd()) {
					tempTwo.add(temp.get(8).data);
				} else if (ranNum >= temp.get(9).getFnStart()
						&& ranNum < temp.get(9).getFnEnd()) {
					tempTwo.add(temp.get(9).data);
				}
			}
			double x1 = 0, x2 = 0, y1 = 0, y2 = 0;
			float fn1, fn2;
			x1 = tempTwo.get(0).getX();
			x2 = tempTwo.get(1).getX();
			y1 = tempTwo.get(0).getY();
			y2 = tempTwo.get(1).getY();
			if (funNum == 1) {
				fn1 = (float) function(x1, y2);
				fn2 = (float) function(x2, y1);
				ElementData ele1 = new ElementData(x1, y2, fn1);
				data.add(ele1);
				ElementData ele2 = new ElementData(x2, y1, fn2);
				data.add(ele2);
			} else if (funNum == 2) {
				fn1 = (float) function2(x1, y2);
				fn2 = (float) function2(x2, y1);
				ElementData ele1 = new ElementData(x1, y2, fn1);
				data.add(ele1);
				ElementData ele2 = new ElementData(x2, y1, fn2);
				data.add(ele2);

			} else if (funNum == 3) {
				fn1 = (float) function3(x1, y2);
				fn2 = (float) function3(x2, y1);
				ElementData ele1 = new ElementData(x1, y2, fn1);
				data.add(ele1);
				ElementData ele2 = new ElementData(x2, y1, fn2);
				data.add(ele2);

			}
		}
		data = doMutation(data, funNum);
		System.out.println("### Offspring mutation ###");
		for (int i = 0; i < data.size(); i++) {
			System.out.println("x=" + data.get(i).getX() + " y="
					+ data.get(i).getY() + " fn=" + data.get(i).getFn());
		}
		return data;
	}

	//offspring for RBS
	public static ArrayList<ElementData> getOffSpringRBS(
			ArrayList<ElementData> pop, int funNum) {

		ArrayList<ElementData> data = new ArrayList<ElementData>();
		double array[] = new double[10];
		double totalfn = 55;
		Collections.sort(pop);

		// Putting the value in array
		double rank = 10;
		for (int i = 0; i < 10; i++) {
			array[i] = rank / totalfn;
			rank--;
			// System.out.println("array" + i + " " + array[i]);
		}

		ArrayList<functionRangeElement> temp = new ArrayList<functionRangeElement>();
		double num = 0;
		for (int i = 0; i < pop.size(); i++) {
			functionRangeElement element = new functionRangeElement(num, num
					+ array[i], pop.get(i));
			num += array[i];
			temp.add(element);
		}
		for (int j = 0; j < 5; j++) {

			ArrayList<ElementData> tempTwo = new ArrayList<ElementData>();
			for (int i = 0; i < 2; i++) {
				double ranNum = Math.random();
				if (ranNum >= temp.get(0).getFnStart()
						&& ranNum < temp.get(0).getFnEnd()) {
					tempTwo.add(temp.get(0).data);
				} else if (ranNum >= temp.get(1).getFnStart()
						&& ranNum < temp.get(1).getFnEnd()) {
					tempTwo.add(temp.get(1).data);
				} else if (ranNum >= temp.get(2).getFnStart()
						&& ranNum < temp.get(2).getFnEnd()) {
					tempTwo.add(temp.get(2).data);
				} else if (ranNum >= temp.get(3).getFnStart()
						&& ranNum < temp.get(3).getFnEnd()) {
					tempTwo.add(temp.get(3).data);
				} else if (ranNum >= temp.get(4).getFnStart()
						&& ranNum < temp.get(4).getFnEnd()) {
					tempTwo.add(temp.get(4).data);
				} else if (ranNum >= temp.get(5).getFnStart()
						&& ranNum < temp.get(5).getFnEnd()) {
					tempTwo.add(temp.get(5).data);
				} else if (ranNum >= temp.get(6).getFnStart()
						&& ranNum < temp.get(6).getFnEnd()) {
					tempTwo.add(temp.get(6).data);
				} else if (ranNum >= temp.get(7).getFnStart()
						&& ranNum < temp.get(7).getFnEnd()) {
					tempTwo.add(temp.get(7).data);
				} else if (ranNum >= temp.get(8).getFnStart()
						&& ranNum < temp.get(8).getFnEnd()) {
					tempTwo.add(temp.get(8).data);
				} else if (ranNum >= temp.get(9).getFnStart()
						&& ranNum < temp.get(9).getFnEnd()) {
					tempTwo.add(temp.get(9).data);
				}
			}
			double x1 = 0, x2 = 0, y1 = 0, y2 = 0;
			float fn1 = 0, fn2 = 0;
			x1 = tempTwo.get(0).getX();
			x2 = tempTwo.get(1).getX();
			y1 = tempTwo.get(0).getY();
			y2 = tempTwo.get(1).getY();
			if (funNum == 1) {
				fn1 = (float) function(x1, y2);
				fn2 = (float) function(x2, y1);
			} else if (funNum == 2) {
				fn1 = (float) function2(x1, y2);
				fn2 = (float) function2(x2, y1);
			} else if (funNum == 3) {
				fn1 = (float) function3(x1, y2);
				fn2 = (float) function3(x2, y1);
			}
			ElementData ele1 = new ElementData(x1, y2, fn1);
			data.add(ele1);
			ElementData ele2 = new ElementData(x2, y1, fn2);
			data.add(ele2);
		}
		data = doMutation(data, funNum);
		System.out.println("### Offspring mutation ###");
		for (int i = 0; i < data.size(); i++) {
			System.out.println("x=" + data.get(i).getX() + " y="
					+ data.get(i).getY() + " fn=" + data.get(i).getFn());
		}
		return data;
	}

	//offspring for BT
	public static ArrayList<ElementData> getOffSpringBT(
			ArrayList<ElementData> pop, int funNum) {
		ArrayList<ElementData> data = new ArrayList<ElementData>();
		System.out.println("### Off Sprting ###");
		for (int i = 0; i < 5; i++) {
			ArrayList<ElementData> temp1 = new ArrayList<ElementData>();
			/*
			 * int tempR1=(int) (Math.random() * 10); int tempR2=(int)
			 * (Math.random() * 10); int tempR3=(int) (Math.random() * 10); int
			 * tempR4=(int) (Math.random() * 10);
			 */
			for (int j = 0; j < 2; j++) {
				double ranNum = Math.random();
				if (ranNum >= 0 && ranNum < 0.1) {
					temp1.add(pop.get(0));
				} else if (ranNum >= 0.1 && ranNum < 0.2) {
					temp1.add(pop.get(1));
				} else if (ranNum >= 0.2 && ranNum < 0.3) {
					temp1.add(pop.get(2));
				} else if (ranNum >= 0.3 && ranNum < 0.4) {
					temp1.add(pop.get(3));
				} else if (ranNum >= 0.4 && ranNum < 0.5) {
					temp1.add(pop.get(4));
				} else if (ranNum >= 0.5 && ranNum < 0.6) {
					temp1.add(pop.get(5));
				} else if (ranNum >= 0.6 && ranNum < 0.7) {
					temp1.add(pop.get(6));
				} else if (ranNum >= 0.7 && ranNum < 0.8) {
					temp1.add(pop.get(7));
				} else if (ranNum >= 0.8 && ranNum < 0.9) {
					temp1.add(pop.get(8));
				} else if (ranNum >= 0.9 && ranNum < 1) {
					temp1.add(pop.get(9));
				}

			}

			ArrayList<ElementData> temp2 = new ArrayList<ElementData>();
			for (int j = 0; j < 2; j++) {
				double ranNum = Math.random();
				if (ranNum >= 0 && ranNum < 0.1) {
					temp2.add(pop.get(0));
				} else if (ranNum >= 0.1 && ranNum < 0.2) {
					temp2.add(pop.get(1));
				} else if (ranNum >= 0.2 && ranNum < 0.3) {
					temp2.add(pop.get(2));
				} else if (ranNum >= 0.3 && ranNum < 0.4) {
					temp2.add(pop.get(3));
				} else if (ranNum >= 0.4 && ranNum < 0.5) {
					temp2.add(pop.get(4));
				} else if (ranNum >= 0.5 && ranNum < 0.6) {
					temp2.add(pop.get(5));
				} else if (ranNum >= 0.6 && ranNum < 0.7) {
					temp2.add(pop.get(6));
				} else if (ranNum >= 0.7 && ranNum < 0.8) {
					temp2.add(pop.get(7));
				} else if (ranNum >= 0.8 && ranNum < 0.9) {
					temp2.add(pop.get(8));
				} else if (ranNum >= 0.9 && ranNum < 1) {
					temp2.add(pop.get(9));
				}
			}
			Collections.sort(temp1);
			Collections.sort(temp2);
			double x1 = 0, x2 = 0, y1 = 0, y2 = 0;
			float fn1 = 0, fn2 = 0;
			x1 = temp1.get(0).getX();
			x2 = temp2.get(0).getX();
			y1 = temp1.get(0).getY();
			y2 = temp2.get(0).getY();
			if (funNum == 1) {
				fn1 = (float) function(x1, y2);
				fn2 = (float) function(x2, y1);
			} else if (funNum == 2) {
				fn1 = (float) function2(x1, y2);
				fn2 = (float) function2(x2, y1);
			} else if (funNum == 3) {
				fn1 = (float) function3(x1, y2);
				fn2 = (float) function3(x2, y1);
			}
			ElementData ele1 = new ElementData(x1, y2, fn1);
			data.add(ele1);
			ElementData ele2 = new ElementData(x2, y1, fn2);
			data.add(ele2);
			System.out.println("x=" + ele1.getX() + " y=" + ele1.getY()
					+ " fn=" + ele1.getFn());
			System.out.println("x=" + ele2.getX() + " y=" + ele2.getY()
					+ " fn=" + ele2.getFn());
		}
		/*
		 * System.out.println("### Offspring ###"); for (int i = 0; i <
		 * data.size(); i++) { System.out.println("x=" + data.get(i).getX() +
		 * " y=" + data.get(i).getY() + " fn=" + data.get(i).getFn()); }
		 */
		data = doMutation(data, funNum);
		System.out.println("### Offspring mutation ###");
		for (int i = 0; i < data.size(); i++) {
			System.out.println("x=" + data.get(i).getX() + " y="
					+ data.get(i).getY() + " fn=" + data.get(i).getFn());
		}
		return data;
	}

	//Survival Selection
	public static ArrayList<ElementData> suvivalSelection(
			ArrayList<ElementData> pop, ArrayList<ElementData> os) {

		ArrayList<ElementData> data = new ArrayList<ElementData>();
		ArrayList<ElementData> remain = new ArrayList<ElementData>();
		data.addAll(pop);
		data.addAll(os);
		Collections.sort(data);
		/*
		 * Print all the data in descending order
		 */
		/*
		 * for (int i = 0; i < data.size(); i++) { System.out.println("fn of " +
		 * i + " is " + data.get(i).fn); remain.add(data.get(i)); }
		 */
		System.out.println("### Remaining ###");
		for (int i = 0; i < 10; i++) {
			remain.add(data.get(i));
			System.out.println("x=" + data.get(i).getX() + " y="
					+ data.get(i).getY() + " fn=" + data.get(i).getFn());
		}
		return remain;
	}

	//Survival Selection BT
	public static ArrayList<ElementData> suvivalSelectionBT(
			ArrayList<ElementData> pop, ArrayList<ElementData> os) {

		ArrayList<ElementData> remain = new ArrayList<ElementData>();

		for (int i = 0; i < 10; i++) {
			double popD = Math.random() * 10;
			double osD = Math.random() * 10;
			ArrayList<ElementData> data = new ArrayList<ElementData>();
			data.add(pop.get((int) popD));
			data.add(os.get((int) osD));
			Collections.sort(data);
			remain.add(data.get(0));
		}

		/*
		 * Print all the data in descending order
		 */
		/*
		 * for (int i = 0; i < data.size(); i++) { System.out.println("fn of " +
		 * i + " is " + data.get(i).fn); remain.add(data.get(i)); }
		 */
		System.out.println("### Remaining ###");
		for (int i = 0; i < 10; i++) {
			System.out.println("x=" + remain.get(i).getX() + " y="
					+ remain.get(i).getY() + " fn=" + remain.get(i).getFn());
		}
		return remain;
	}

	//Survival Selection EP with FPS
	public static ArrayList<ElementData> suvivalSelectionEPFPS(
			ArrayList<ElementData> parent, ArrayList<ElementData> os) {
		ArrayList<ElementData> data = new ArrayList<ElementData>();
		data.addAll(parent);
		data.addAll(os);
		// initializing the total value of the function
		double totalFn = 0;
		for (int i = 0; i < data.size(); i++) {
			totalFn += data.get(i).getFn();
		}
		double array[] = new double[data.size()];
		// Putting the value in array
		for (int i = 0; i < array.length; i++) {
			array[i] = data.get(i).getFn() / totalFn;
			// System.out.println("array" + i + " " + array[i]);
		}

		// Creating the range in the temp arraylist
		ArrayList<functionRangeElement> temp = new ArrayList<functionRangeElement>();
		double num = 0;
		for (int i = 0; i < data.size(); i++) {
			functionRangeElement element = new functionRangeElement(num, num
					+ array[i], data.get(i));
			num += array[i];
			temp.add(element);
		}
		ArrayList<ElementData> tempTwo = new ArrayList<ElementData>();
		for (int i = 0; i < 10; i++) {
			double ranNum = Math.random();
			if (ranNum >= temp.get(0).getFnStart()
					&& ranNum < temp.get(0).getFnEnd()) {
				tempTwo.add(temp.get(0).data);
			} else if (ranNum >= temp.get(1).getFnStart()
					&& ranNum < temp.get(1).getFnEnd()) {
				tempTwo.add(temp.get(1).data);
			} else if (ranNum >= temp.get(2).getFnStart()
					&& ranNum < temp.get(2).getFnEnd()) {
				tempTwo.add(temp.get(2).data);
			} else if (ranNum >= temp.get(3).getFnStart()
					&& ranNum < temp.get(3).getFnEnd()) {
				tempTwo.add(temp.get(3).data);
			} else if (ranNum >= temp.get(4).getFnStart()
					&& ranNum < temp.get(4).getFnEnd()) {
				tempTwo.add(temp.get(4).data);
			} else if (ranNum >= temp.get(5).getFnStart()
					&& ranNum < temp.get(5).getFnEnd()) {
				tempTwo.add(temp.get(5).data);
			} else if (ranNum >= temp.get(6).getFnStart()
					&& ranNum < temp.get(6).getFnEnd()) {
				tempTwo.add(temp.get(6).data);
			} else if (ranNum >= temp.get(7).getFnStart()
					&& ranNum < temp.get(7).getFnEnd()) {
				tempTwo.add(temp.get(7).data);
			} else if (ranNum >= temp.get(8).getFnStart()
					&& ranNum < temp.get(8).getFnEnd()) {
				tempTwo.add(temp.get(8).data);
			} else if (ranNum >= temp.get(9).getFnStart()
					&& ranNum < temp.get(9).getFnEnd()) {
				tempTwo.add(temp.get(9).data);
			} else if (ranNum >= temp.get(10).getFnStart()
					&& ranNum < temp.get(10).getFnEnd()) {
				tempTwo.add(temp.get(10).data);
			} else if (ranNum >= temp.get(11).getFnStart()
					&& ranNum < temp.get(11).getFnEnd()) {
				tempTwo.add(temp.get(11).data);
			} else if (ranNum >= temp.get(12).getFnStart()
					&& ranNum < temp.get(12).getFnEnd()) {
				tempTwo.add(temp.get(12).data);
			} else if (ranNum >= temp.get(13).getFnStart()
					&& ranNum < temp.get(13).getFnEnd()) {
				tempTwo.add(temp.get(13).data);
			} else if (ranNum >= temp.get(14).getFnStart()
					&& ranNum < temp.get(14).getFnEnd()) {
				tempTwo.add(temp.get(14).data);
			} else if (ranNum >= temp.get(15).getFnStart()
					&& ranNum < temp.get(15).getFnEnd()) {
				tempTwo.add(temp.get(15).data);
			} else if (ranNum >= temp.get(16).getFnStart()
					&& ranNum < temp.get(16).getFnEnd()) {
				tempTwo.add(temp.get(16).data);
			} else if (ranNum >= temp.get(17).getFnStart()
					&& ranNum < temp.get(17).getFnEnd()) {
				tempTwo.add(temp.get(17).data);
			} else if (ranNum >= temp.get(18).getFnStart()
					&& ranNum < temp.get(18).getFnEnd()) {
				tempTwo.add(temp.get(18).data);
			} else if (ranNum >= temp.get(19).getFnStart()
					&& ranNum < temp.get(19).getFnEnd()) {
				tempTwo.add(temp.get(19).data);
			}
		}
		System.out.println("### Remianing ###");
		Collections.sort(tempTwo);
		for (int i = 0; i < tempTwo.size(); i++) {
			System.out.println("x=" + tempTwo.get(i).getX() + " y="
					+ tempTwo.get(i).getY() + " fn=" + tempTwo.get(i).getFn());
		}
		return tempTwo;
	}

	//Survival Selection ES with FPS
	public static ArrayList<ElementData> suvivalSelectionESFPS(
			ArrayList<ElementData> os) {
		ArrayList<ElementData> remain = new ArrayList<ElementData>();
		Collections.sort(os);
		/*
		 * Print all the data in descending order
		 */
		/*
		 * for (int i = 0; i < data.size(); i++) { System.out.println("fn of " +
		 * i + " is " + data.get(i).fn); remain.add(data.get(i)); }
		 */
		System.out.println("### Remaining ###");
		for (int i = 0; i < 10; i++) {
			remain.add(os.get(i));
			System.out.println("x=" + os.get(i).getX() + " y="
					+ os.get(i).getY() + " fn=" + os.get(i).getFn());
		}
		return os;
	}

	//function #1
	public static double function(double x, double y) {
		return (x * x + y * y);
	}

	//function #2
	public static double function2(double x, double y) {
		return (100 * (((x * x) - (y)) * ((x * x) - (y))) + ((1 - (x)) * (1 - (x))));
	}

	//function #3
	public static double function3(double x, double y) {
		return (((x * x) + y - 11) * ((x * x) + y - 11) + (x + (y * y) - 7)
				* (x + (y * y) - 7));
	}

	//best fitness single value
	public static double bestFitness(ArrayList<ElementData> d) {
		System.out.println("best value is ??? " + d.get(0).getFn());
		return d.get(0).getFn();
	}

	//average fitness value 
	public static double averageFitness(ArrayList<ElementData> d) {
		double avg = 0;
		for (int i = 0; i < d.size(); i++) {
			avg += d.get(i).getFn();
		}
		avg = avg / 10;
		System.out.println("Average value is ???" + avg);
		return avg;
	}

	// Genetating random number
	public static double generateRandomNumber(int min, int max) {
		return (min + (max - min) * Math.random());
	}

	//Performing mutation
	public static ArrayList<ElementData> doMutation(
			ArrayList<ElementData> data, int funNum) {
		if (funNum == 1) {
			for (int i = 0; i < data.size(); i++) {
				double checkMutationX = Math.random();
				if (checkMutationX < 0.2) {
					double ranX = Math.random() / 4;
					// signcheck for random number 0.5 +
					System.out.println("Mutation " + i);
					double checkOX = Math.random();
					if (checkOX > 0.5) {
						if (ranX + data.get(i).getX() <= 5) {
							System.out.println(data.get(i).getX() + " + "
									+ ranX);
							data.get(i).setX(ranX + data.get(i).getX());
							data.set(
									i,
									new ElementData(data.get(i).getX(), data
											.get(i).getY(), (float) function(
											data.get(i).getX(), data.get(i)
													.getY())));
						} else {
							System.out.println(data.get(i).getX() + " 5 ");
							data.get(i).setX(5);
							data.set(
									i,
									new ElementData(data.get(i).getX(), data
											.get(i).getY(), (float) function(
											data.get(i).getX(), data.get(i)
													.getY())));
						}
					} else {
						if (data.get(i).getX() - ranX >= -5) {
							System.out.println(data.get(i).getX() + " - "
									+ ranX);
							data.get(i).setX(data.get(i).getX() - ranX);
							data.set(
									i,
									new ElementData(data.get(i).getX(), data
											.get(i).getY(), (float) function(
											data.get(i).getX(), data.get(i)
													.getY())));
						} else {
							System.out.println(data.get(i).getX() + " 5");
							data.get(i).setX(-5);
							data.set(
									i,
									new ElementData(data.get(i).getX(), data
											.get(i).getY(), (float) function(
											data.get(i).getX(), data.get(i)
													.getY())));
						}
					}

				}
				double checkMutationY = Math.random();
				if (checkMutationY < 0.2) {
					double ranY = Math.random() / 4;
					System.out.println("Mutation " + i);
					double checkOY = Math.random();
					if (checkOY > 0.5) {
						if (ranY + data.get(i).getY() <= 5) {
							System.out.println(data.get(i).getY() + " + "
									+ ranY);
							data.get(i).setY(ranY + data.get(i).getY());
							data.set(
									i,
									new ElementData(data.get(i).getX(), data
											.get(i).getY(), (float) function(
											data.get(i).getX(), data.get(i)
													.getY())));
						} else {
							System.out.println(data.get(i).getY() + " ");
							data.get(i).setY(5);
							data.set(
									i,
									new ElementData(data.get(i).getX(), data
											.get(i).getY(), (float) function(
											data.get(i).getX(), data.get(i)
													.getY())));
						}
					} else {
						if (data.get(i).getY() - ranY >= -5) {
							System.out.println(data.get(i).getY() + " - "
									+ ranY);
							data.get(i).setY(data.get(i).getY() - ranY);
							data.set(
									i,
									new ElementData(data.get(i).getX(), data
											.get(i).getY(), (float) function(
											data.get(i).getX(), data.get(i)
													.getY())));
						} else {
							System.out.println(data.get(i).getY() + " 5");
							data.get(i).setY(-5);
							data.set(
									i,
									new ElementData(data.get(i).getX(), data
											.get(i).getY(), (float) function(
											data.get(i).getX(), data.get(i)
													.getY())));
						}
					}
				}
			}
		} else if (funNum == 2) {
			for (int i = 0; i < data.size(); i++) {
				double checkMutationX = Math.random();
				if (checkMutationX < 0.2) {
					double ranX = Math.random() / 4;
					// signcheck for random number 0.5 +
					System.out.println("Mutation " + i);
					double checkOX = Math.random();
					if (checkOX > 0.5) {
						if (ranX + data.get(i).getX() <= 2) {
							System.out.println(data.get(i).getX() + " + "
									+ ranX);
							data.get(i).setX(ranX + data.get(i).getX());
							data.set(
									i,
									new ElementData(data.get(i).getX(), data
											.get(i).getY(), (float) function2(
											data.get(i).getX(), data.get(i)
													.getY())));
						} else {
							System.out.println(data.get(i).getX() + " 2 ");
							data.get(i).setX(2);
							data.set(
									i,
									new ElementData(data.get(i).getX(), data
											.get(i).getY(), (float) function2(
											data.get(i).getX(), data.get(i)
													.getY())));
						}
					} else {
						if (data.get(i).getX() - ranX >= -2) {
							System.out.println(data.get(i).getX() + " - "
									+ ranX);
							data.get(i).setX(data.get(i).getX() - ranX);
							data.set(
									i,
									new ElementData(data.get(i).getX(), data
											.get(i).getY(), (float) function2(
											data.get(i).getX(), data.get(i)
													.getY())));
						} else {
							System.out.println(data.get(i).getX() + " -2");
							data.get(i).setX(-2);
							data.set(
									i,
									new ElementData(data.get(i).getX(), data
											.get(i).getY(), (float) function2(
											data.get(i).getX(), data.get(i)
													.getY())));
						}
					}
				}
				double checkMutationY = Math.random();
				if (checkMutationY < 0.2) {
					double ranY = Math.random() / 4;
					System.out.println("Mutation " + i);
					double checkOY = Math.random();
					if (checkOY > 0.5) {
						if (ranY + data.get(i).getY() <= 3) {
							System.out.println(data.get(i).getY() + " + "
									+ ranY);
							data.get(i).setY(ranY + data.get(i).getY());
							data.set(
									i,
									new ElementData(data.get(i).getX(), data
											.get(i).getY(), (float) function2(
											data.get(i).getX(), data.get(i)
													.getY())));
						} else {
							System.out.println(data.get(i).getY() + " 3");
							data.get(i).setY(3);
							data.set(
									i,
									new ElementData(data.get(i).getX(), data
											.get(i).getY(), (float) function2(
											data.get(i).getX(), data.get(i)
													.getY())));
						}
					} else {
						if (data.get(i).getY() - ranY >= -1) {
							System.out.println(data.get(i).getY() + " - "
									+ ranY);
							data.get(i).setY(data.get(i).getY() - ranY);
							data.set(
									i,
									new ElementData(data.get(i).getX(), data
											.get(i).getY(), (float) function2(
											data.get(i).getX(), data.get(i)
													.getY())));
						} else {
							System.out.println(data.get(i).getY() + " -1");
							data.get(i).setY(-1);
							data.set(
									i,
									new ElementData(data.get(i).getX(), data
											.get(i).getY(), (float) function2(
											data.get(i).getX(), data.get(i)
													.getY())));
						}
					}
				}
			}
		} else if (funNum == 3) {

			for (int i = 0; i < data.size(); i++) {
				double checkMutationX = Math.random();
				if (checkMutationX < 0.2) {
					double ranX = Math.random() / 4;
					// signcheck for random number 0.5 +
					System.out.println("Mutation " + i);
					double checkOX = Math.random();
					if (checkOX > 0.5) {
						if (ranX + data.get(i).getX() <= 4) {
							System.out.println(data.get(i).getX() + " + "
									+ ranX);
							data.get(i).setX(ranX + data.get(i).getX());
							data.set(
									i,
									new ElementData(data.get(i).getX(), data
											.get(i).getY(), (float) function3(
											data.get(i).getX(), data.get(i)
													.getY())));
						} else {
							System.out.println(data.get(i).getX() + " 4 ");
							data.get(i).setX(4);
							data.set(
									i,
									new ElementData(data.get(i).getX(), data
											.get(i).getY(), (float) function3(
											data.get(i).getX(), data.get(i)
													.getY())));
						}
					} else {
						if (data.get(i).getX() - ranX >= -4) {
							System.out.println(data.get(i).getX() + " - "
									+ ranX);
							data.get(i).setX(data.get(i).getX() - ranX);
							data.set(
									i,
									new ElementData(data.get(i).getX(), data
											.get(i).getY(), (float) function3(
											data.get(i).getX(), data.get(i)
													.getY())));
						} else {
							System.out.println(data.get(i).getX() + " -4");
							data.get(i).setX(-4);
							data.set(
									i,
									new ElementData(data.get(i).getX(), data
											.get(i).getY(), (float) function3(
											data.get(i).getX(), data.get(i)
													.getY())));
						}
					}
				}
				double checkMutationY = Math.random();
				if (checkMutationY < 0.2) {
					double ranY = Math.random() / 4;
					System.out.println("Mutation " + i);
					double checkOY = Math.random();
					if (checkOY > 0.5) {
						if (ranY + data.get(i).getY() <= 4) {
							System.out.println(data.get(i).getY() + " + "
									+ ranY);
							data.get(i).setY(ranY + data.get(i).getY());
							data.set(
									i,
									new ElementData(data.get(i).getX(), data
											.get(i).getY(), (float) function3(
											data.get(i).getX(), data.get(i)
													.getY())));
						} else {
							System.out.println(data.get(i).getY() + " 4");
							data.get(i).setY(4);
							data.set(
									i,
									new ElementData(data.get(i).getX(), data
											.get(i).getY(), (float) function3(
											data.get(i).getX(), data.get(i)
													.getY())));
						}
					} else {
						if (data.get(i).getY() - ranY >= -4) {
							System.out.println(data.get(i).getY() + " - "
									+ ranY);
							data.get(i).setY(data.get(i).getY() - ranY);
							data.set(
									i,
									new ElementData(data.get(i).getX(), data
											.get(i).getY(), (float) function3(
											data.get(i).getX(), data.get(i)
													.getY())));
						} else {
							System.out.println(data.get(i).getY() + " -4");
							data.get(i).setY(-4);
							data.set(
									i,
									new ElementData(data.get(i).getX(), data
											.get(i).getY(), (float) function3(
											data.get(i).getX(), data.get(i)
													.getY())));
						}
					}
				}
			}

		}
		return data;
	}

	//Performing Gaussian mutation
	public static ElementData doGaussianMutation(ElementData element, int funNum) {
		double ranx1 = Math.random();
		double ranx2 = Math.random();
		double y1 = 0;
		float fn1 = 0;
		ElementData mutated = new ElementData();
		y1 = Math.pow((-2 * Math.log(ranx1)), 0.5)
				* Math.cos(2 * Math.PI * ranx2);
		if (funNum == 1) {
			if (element.getX() + ranx1 > 5 && element.getX() + ranx1 > 0)
				mutated.setX(5);
			else if (element.getX() + ranx1 < -5 && element.getX() + ranx1 < 0)
				mutated.setX(-5);
			else
				mutated.setX(element.getX() + ranx1);
			if (element.getY() + y1 > 5 && element.getY() + y1 > 0)
				mutated.setY(5);
			else if (element.getY() + y1 < -5 && element.getY() + y1 < 0)
				mutated.setY(-5);
			else
				mutated.setY(element.getY() + y1);
			fn1 = (float) function(mutated.getX(), mutated.getY());
			mutated.setFn(fn1);
			/*
			 * System.out.println(element.getX() + " + " +
			 * ranx1+" = "+mutated.getX()); System.out.println(element.getY() +
			 * " + " + y1+" = "+mutated.getY()); System.out.println( + fn1);
			 */
		} else if (funNum == 2) {
			if ((element.getX() + ranx1) > 2 && (element.getX() + ranx1) > 0)
				mutated.setX(2);
			else if ((element.getX() + ranx1) < -2
					&& (element.getX() + ranx1) < 0)
				mutated.setX(-2);
			else
				mutated.setX(element.getX() + ranx1);
			if ((element.getY() + y1) > 3 && (element.getY() + y1) > 0)
				mutated.setY(3);
			else if ((element.getY() + y1) < -1 && (element.getY() + y1) < 0)
				mutated.setY(-1);
			else
				mutated.setY(element.getY() + y1);
			fn1 = (float) function2(mutated.getX(), mutated.getY());
			mutated.setFn(fn1);
		} else if (funNum == 3) {

			if ((element.getX() + ranx1) > 4)
				mutated.setX(4);
			else if ((element.getX() + ranx1) < -4)
				mutated.setX(-4);
			else
				mutated.setX(element.getX() + ranx1);
			if ((element.getY() + y1) > 4 && (element.getY() + y1 > 0))
				mutated.setY(4);
			else if ((element.getY() + y1) < -4 && (element.getY() + y1 < 0))
				mutated.setY(-4);
			else
				mutated.setY(element.getY() + y1);
			fn1 = (float) function3(mutated.getX(), mutated.getY());
			mutated.setFn(fn1);
			/*
			 * System.out.println(element.getX() + " + " +
			 * ranx1+" = "+mutated.getX()); System.out.println(element.getY() +
			 * " + " + y1+" = "+mutated.getY()); System.out.println( + fn1);
			 */

		}
		return mutated;
	}
}