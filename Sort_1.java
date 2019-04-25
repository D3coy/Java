public class Sort_1 
{

	public static void main(String[] args) 
	{
		int[] array = {10, 20, 5, 3, 92, 12};
		int temp, i, j;
		
		System.out.print("Исходный массив: ");
		for (i = 0; i < array.length; i++) {		//не отсортирован
			
			System.out.print(array[i] + " ");
			
		}
		
		System.out.print("\n\nМассив по убыванию: ");
		for (i = 0; i < 4; i++) {								//здесь не просто так <4>
			
			for (j = 0; j < array.length - i - 1; j++) {
				
				if (array[j] < array[j + 1]) {
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		for (i = 0; i < array.length; i++) {
			
			System.out.print(array[i] + " ");
			
		}
		
		System.out.print("\n\nМассив по возрастанию: ");
		for (i = 0; i < array.length - 1; i++) {
			
			for (j = 0; j < array.length - i - 1; j++) {
				
				if (array[j] > array[j + 1]) {
					
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					
				}
			}
		}
		
		for (i = 0; i < array.length; i++) {
			
			System.out.print(array[i] + " ");
			
		}
	}
}
