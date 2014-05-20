package co.edu.unal.lenguajes;

import java.util.Arrays;
import java.util.List;

public class ProbabilistcTuringMachineTest {

	public static void main(String[] args) {
		String even = "even";
		String odd = "odd";
		String accepted = "accepted";
		String rejected = "rejected";

		char blank = '_';
		String input = "110101";
		int moveDirection = 1;
		TranscictionFunction d1 = new TranscictionFunction(even, '0', even,
				'0', moveDirection, 0.9);
		TranscictionFunction d2 = new TranscictionFunction(even, '0', odd, '0',
				moveDirection, 0.1);
		TranscictionFunction d3 = new TranscictionFunction(even, '1', odd, '1',
				moveDirection, 0.9);
		TranscictionFunction d4 = new TranscictionFunction(even, '1', even,
				'1', moveDirection, 0.1);
		TranscictionFunction d5 = new TranscictionFunction(even, blank,
				accepted, blank, moveDirection, 1);
		TranscictionFunction d6 = new TranscictionFunction(odd, '0', odd, '0',
				moveDirection, 0.9);
		TranscictionFunction d7 = new TranscictionFunction(odd, '0', even, '0',
				moveDirection, 0.1);
		TranscictionFunction d8 = new TranscictionFunction(odd, '1', even, '1',
				moveDirection, 0.9);
		TranscictionFunction d9 = new TranscictionFunction(odd, '1', odd, '1',
				moveDirection, 0.1);
		TranscictionFunction d10 = new TranscictionFunction(odd, blank,
				rejected, blank, moveDirection, 1);
		List<TranscictionFunction> functions = Arrays.asList(d1, d2, d3, d4,
				d5, d6, d7, d8, d9, d10);
		int a = 0,r = 0;
		for(int i=0;i<999;i++){
			ProbabilisticTuringMachine ptm = new ProbabilisticTuringMachine(blank,
					Arrays.asList('1', '0'), even,
					Arrays.asList(accepted, rejected), functions, input);
		
			while (!ptm.isFinal()) {
				try {
					ptm.step();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("Estado final = " + ptm.getCurrentState());
			
			if(ptm.getCurrentState()==accepted){
				a+=1;
			}else if(ptm.getCurrentState()==rejected){
				r+=1;
			}
		}
		System.out.println("Prob accepted = "+(a/1000.0)*100);
		System.out.println("Prob rejected = "+(r/1000.0)*100);
		
	}

}
