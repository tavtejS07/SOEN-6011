import java.util.Scanner;
import static java.lang.Math.*;

public class GammaCalculator {
	
	
	/**
	 * This calculation uses Lanczos approximation formulae to calculate Gamma(x)
	 * 
	 * Gamma(x) = integral(t^(x-1) e^(-t), t=0 to infinity)
	 * 
	 * @param x
	 * @return
	 * @throws Exception 
	 */
	
	private static double logGamma(double x) throws Exception {
	
		double d = (x-0.5)*Functions.logarithmic(x+4.5) - (x+4.5);
		//System.out.println("value of d is" + d);
		
		double d1 = 1.0 + Functions.x1/(x+0) - Functions.x2/(x+1) + Functions.x3/(x+2)
				- Functions.x4/(x+3) + Functions.x5/(x+4) - Functions.x6/(x+5);
		
		//System.out.println("value of d1 is" + d1);
		//System.out.println(d+Functions.logarithmic(d1*Functions.square_root(2*Functions.pi)));
		
		return d+Functions.logarithmic(d1*Functions.square_root(2*Functions.pi));
	}
	
	private static double gamma(double x) throws Exception {
		return Functions.exponent(logGamma(x));
	}
	
	/**
	 * Stirling's approximation
	 * @param x
	 * @return
	 * @throws Exception 
	 */
	private static double strGamma(double x) throws Exception {
		return Functions.square_root(2*Functions.pi/x)*Functions.pow(x/Functions.e, x);
	}
	
	/**
	 * Gamma(x) = (x-1)*Gamma(x-1)
	 * x in Z+
	 * @param x
	 * @return
	 */
	private static int recursiveGamma(int x) throws Exception{
		if (x==0) {
			return 1;
		}else {
			return x*recursiveGamma(x-1);
		}
	}

	public static void main(String[] args){
		try {
			//GammaCalculator gc = new GammaCalculator();
			Scanner sc = new Scanner(System.in);
			double x = 0;
			int y = 0;
			System.out.println("Please enter the integer y for Recursive property of Gamma:");
			y = sc.nextInt();
			System.out.println(recursiveGamma(y));
			
			System.out.println("Onto the Calculations of next remaining functions");
			System.out.println("=================================================");
			
			System.out.println("please enter the number x:");
			while((x=sc.nextDouble()) != 0) {
				//System.out.println("please enter the number y:");
				//y = Integer.parseInt(sc.nextLine());
				
				System.out.println("Gamma \t\t\tLogGamma \t\tStirling");
				System.out.println("" + gamma(Double.valueOf(x)) 
				+ "\t" + logGamma(Double.valueOf(x)) + "\t" + strGamma(Double.valueOf(x)));
				//System.out.println("please enter the number:");
				System.out.println("Enter another number:");
				//x = Double.parseDouble(sc.nextLine());
			}
			
			sc.close();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
