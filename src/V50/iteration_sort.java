package V50;

public class iteration_sort {
	public static void main(String[] args) {

        // skapar en int array av storleken 20
        int[] randomNumbers = new int[20];

        for (int i = 0; i < randomNumbers.length; i++) {

            // fyller arrayen med 20 slumpm�ssiga heltal mellan 0 och 20
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

	static int sort(int randomNumbers[]) //�r som bubble sort fast om den bytter plats p� tv� tal kollar den om den kan forts�tta 
    { 
		int counter = 0;
        int n = randomNumbers.length; // f�r samma l�ngd som arrayen
        for (int i = 1; i < n; ++i) //g�r igenom hela arryen 
        { 
            int key = randomNumbers[i]; // �r samma som talet p� indexen i
            int j = i - 1; // �r samma som talet p� ett index f�re den �ver
  
            while (j >= 0 && randomNumbers[j] > key) // medans j �r st�re �n 0 och indexen j �r st�re �n indexen i p� randomNumbers
            { 
            	randomNumbers[j + 1] = randomNumbers[j]; //bytter plats p� siffrorna
                j = j - 1; // g�r s� att tidigare tal kan testas 
            } 
            counter++; //r�knar hur m�nga g�nger den loppar
            randomNumbers[j + 1] = key; //g�r s� att s�kningen fors�tter fram�t
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
