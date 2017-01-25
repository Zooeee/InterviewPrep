
public class BitQuestions {
	public static int singleNumberTwice(int[] numbers){
		int result = 0;
		int i;
		for (i=0; i<numbers.length; i++){
			result ^= numbers[i];
		}
		return result;
	}
}
