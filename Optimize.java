import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner; 
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class Optimize{
    public static void main(String[] args){
        ArrayList<String> names = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("data.txt"));
            while (scanner.hasNextLine()){
                names.add(scanner.nextLine());
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("beep boop wrong");
        }

        int tableSize = 37;
        int minProbes = Integer.MAX_VALUE;
        int countMin = 0;

        for (int i=0;i<5;i++){
            for (int j=0;j<5;j++){
                for (int k=0;k<5;k++){
                    for (int l=0;l<5;l++){
                        for (int m=0;m<5;m++){
                            for (int n=0;n<5;n++){
                                for (int o=0;o<5;o++){
                                    for (int p=0;p<5;p++){
                                        for (int q =0;q<5;q++){
                                            try {
                                                int[] weights = new int[]{i,j,k,l,m,n,o,p,q};
                                                LPHashTable LPtable = new LPHashTable(tableSize);
                                                LPtable.setWeights(weights);
                                                int quantity = 0;
                                                while (quantity < names.size()){
                                                    LPtable.insert(names.get(quantity));
                                                    quantity++;
                                                }
                                                if (LPtable.getProbeCount() < minProbes){
                                                    minProbes = LPtable.getProbeCount();
                                                    countMin = 1;
                                                }
                                                else if (LPtable.getProbeCount() == minProbes){
                                                    countMin++;
                                                }


                                            }catch (IllegalStateException e) {
                                                continue;
                                            }
                                            


                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        try {
            FileWriter fileWriter = new FileWriter("results.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(minProbes + " " + countMin);
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println("beep boop wrong");
        }

    }
    
}