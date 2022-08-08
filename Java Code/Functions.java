public class Functions {
	
	public Functions() {}
	
	public static final double pi = 3.141592653589793;
	public static final double e = 2.7182818284590451;
	public static final double x1 = 76.18009173;
	public static final double x2 = 86.50532033;
	public static final double x3 = 24.01409822;
	public static final double x4 = 1.231739516;
	public static final double x5 = 0.00120858003;
	public static final double x6 = 0.00000536382;
	public static final double ln2 = 0.6931471805599453;
	
	/**
	 * calculating e^x
	 * @param x
	 * @return
	 */

    public static double exponent(double x){
        if(x<0){
            return 1/exponent(-x);
        }
        else if(Double.isNaN(x)){
        	return Double.NaN;
        }

        double d = 1;
        for (int i = 1; i < 1000; i++) {
            double y = 1;
            for (int j = 1; j <= i; j++) {
                y = y * x/j;
            }
            d += y;
        }
        return d;
    }
    
    /**
     * calculating log(x)
     * @param x
     * @return
     */

    public static double logarithmic(double x){
        if(Double.isNaN(x) || x<0){
            return Double.NaN;
        }
        if(x==0){
            return 1;
        }
        
        double d = 0;
        for (int i = 1; i < 1000; i++) {
            int a = 2*i-1;
            double e = 1.0/a;
            for (int j = 0; j < a; j++) {
                e = e*(x-1)/(x+1);
            }
            d+=e;
        }
        return 2*d;
    }
    
    /**
     * Calculating sqrt(x)
     * @param x
     * @return
     * @throws Exception
     */

    public static double square_root(double x) throws Exception{
        double result = 1;
    	if(x<0){
            return Double.NaN;
        }
        if(x==0 || x==1){
            return x;
        }
        
        double power = 0.5;
        if(x>0) {
        	result = pow(x,power);
        }
        return result;
    }
    
    /**
     * calculating x^y
     * @param x -- x is a double
     * @param y -- y is an integer
     * @return
     */
    public static double pow(double x, int y) {
    	double d = 1;
    	if(y==0) {
    		return 1;
    	}
    	if(x==0) {
    		return 0;
    	}
    	
    	while(y > 0) {
    		if(y%2 == 0) {
    			y = y/2;
    			x = x*x;
    		}else {
    			y = y-1;
    			d *= x;
    		}
    	}
    	
    	if(y<0) {
    		x = 1/x;
    		y = -y;
    	}
    	return d;
    }
    
    /**
     * calculating x^y
     * @param x -- x is a double
     * @param y -- y is a double
     * @return
     * @throws Exception
     */
    
    public static double pow(double x, double y) throws Exception{
    	if(y==0) {
    		return 1;
    	}
    	if(x==0) {
    		return 0;
    	}
    	
    	double d = exponent(y* logarithmic(x));
    	return d;
    }
}
