
import java.util.Scanner;
import java.util.HashMap;
import java.util.Random;
import java.io.*;

public class ReadTestFile {

    private Integer lawnHeight;
    private Integer lawnWidth;
    private Integer[][] lawnInfo;
    private Integer mowerX, mowerY;
    private String mowerDirection;
    private HashMap<String, Integer> xDIR_MAP;
    private HashMap<String, Integer> yDIR_MAP;

    private final int EMPTY_CODE = 0;
    private final int GRASS_CODE = 1;
    private final int CRATER_CODE = 2;

    public void readTestFile(String testFileName) {
        final String DELIMITER = ",";

        try {
            Scanner takeCommand = new Scanner(new File(testFileName));
            String[] tokens;
            int i, j, k;

            // read in the lawn information
            tokens = takeCommand.nextLine().split(DELIMITER);
            this.lawnWidth = Integer.parseInt(tokens[0]);
            tokens = takeCommand.nextLine().split(DELIMITER);
            this.lawnHeight = Integer.parseInt(tokens[0]);

            // generate the lawn information
            this.lawnInfo = new Integer[lawnWidth][lawnHeight];
            for (i = 0; i < lawnWidth; i++) {
                for (j = 0; j < lawnHeight; j++) {
                    lawnInfo[i][j] = GRASS_CODE;
                }
            }

            // read in the lawnmower starting information
            tokens = takeCommand.nextLine().split(DELIMITER);
            int numMowers = Integer.parseInt(tokens[0]);
            for (k = 0; k < numMowers; k++) {
                tokens = takeCommand.nextLine().split(DELIMITER);
                mowerX = Integer.parseInt(tokens[0]);
                mowerY = Integer.parseInt(tokens[1]);
                mowerDirection = tokens[2];

                // mow the grass at the initial location
                lawnInfo[mowerX][mowerY] = EMPTY_CODE;
            }

            // read in the crater information
            tokens = takeCommand.nextLine().split(DELIMITER);
            int numCraters = Integer.parseInt(tokens[0]);
            for (k = 0; k < numCraters; k++) {
                tokens = takeCommand.nextLine().split(DELIMITER);

                // place a crater at the given location
                lawnInfo[Integer.parseInt(tokens[0])][Integer.parseInt(tokens[1])] = CRATER_CODE;
            }

            takeCommand.close();
            System.out.println(lawnInfo.toString())
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println();
        }
    }
}