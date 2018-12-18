package V50;

public class iteration_sort {
	public static void main(String[] args) {

        // skapar en int array av storleken 20
        int[] randomNumbers = new int[20];

        for (int i = 0; i < randomNumbers.length; i++) {

            // fyller arrayen med 20 slumpmässiga heltal mellan 0 och 20
            randomNumbers[i] = (int) (Math.random() * 20) + 1;
        }

        // skriver ut arrayen
        printIntArray(randomNumbers);

        // anroper bubblesort-metoden och skriver ut antal iterationer
        System.out.println("It took " + sort(randomNumbers) + " iterations to sort the int array using" +
                " bubble sort algorithm.\n");

        // skriver ut en sorterad array
        printIntArray(randomNumbers);
    }

	static int sort(int randomNumbers[]) //är som bubble sort fast om den bytter plats på två tal kollar den om den kan fortsätta 
    { 
		int counter = 0;
        int n = randomNumbers.length; // får samma längd som arrayen
        for (int i = 1; i < n; ++i) //går igenom hela arryen 
        { 
            int key = randomNumbers[i]; // är samma som talet på indexen i
            int j = i - 1; // är samma som talet på ett index före den över
  
            while (j >= 0 && randomNumbers[j] > key) // medans j är störe än 0 och indexen j är störe än indexen i på randomNumbers
            { 
            	randomNumbers[j + 1] = randomNumbers[j]; //bytter plats på siffrorna
                j = j - 1; // gör så att tidigare tal kan testas 
            } 
            counter++; //räknar hur många gånger den loppar
            randomNumbers[j + 1] = key; //gör så att sökningen forsätter framåt
        } 
        return counter;
    }

    /**
     * Metoden skriver ut en int array, sorterad eller osorterad
     * @param randomNumbers
     */
    static void printIntArray(int[] randomNumbers) {

        for (int j :
                randomNumbers) {
            System.out.print(j + " ");
        }
        System.out.println();
        System.out.println();
    }
}
