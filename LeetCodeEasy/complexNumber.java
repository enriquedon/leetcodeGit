final class ComplexNumber {

  /**
  * Static factory method returns an object of this class.
  */
  public static ComplexNumber valueOf(float aReal, float aImaginary) {
    return new ComplexNumber(aReal, aImaginary);
  }

  /**
  * Caller cannot see this private constructor.
  *
  * The only way to build a ComplexNumber is by calling the static 
  * factory method.
  */
  private ComplexNumber(float aReal, float aImaginary) {
    fReal = aReal;
    fImaginary = aImaginary;
  }

  private float fReal;
  float fImaginary;
  
  
  
  //..elided
} 



public class complexNumber {
	public static void main(String args[]){
		  
		ComplexNumber a=ComplexNumber.valueOf(1,1);
		  System.out.println(a.fImaginary);
	  }
}