
import kareltherobot.*; 


/**
 * @author :  D. Appel
 */
public class Problem1 extends Robot
{
    public Problem1(int st, int av, Direction dir, int numBeepers) {
        super(st, av, dir, numBeepers);
    }
    int rowOne = 0;
    int rowTwo = 0;
    int rowThree = 0;
    int rowFour = 0;
    int rowFive = 0;
    int rowSix = 0;
    int rowSeven = 0;
    int beeperNum = 0;
    int rowNum = 1;
    int[]unsorted = new int[7];
    public void sortBeepers() {
        reposition();
        collectAllBeepers();
        sortList();
        placeBeepers();
    }
    public boolean collectAllBeepers(){
        beeperNum = 0;
        while (nextToABeeper()){
            pickBeeper();
            beeperNum ++;
            move();
            if (!nextToABeeper()){
                //Will set a variable equal to the number of beepers specific to that row
                if (rowNum == 1) {
                    rowOne = beeperNum;
                    unsorted[rowNum] = rowOne;
                    rowNum ++;
                }
                else if (rowNum == 2) {
                    rowTwo = beeperNum;
                    unsorted[rowNum] = rowTwo;
                    rowNum ++;
                }
                else if (rowNum == 3) {
                    rowThree = beeperNum;
                    unsorted[rowNum] = rowThree;
                    rowNum ++;
                }
                else if (rowNum == 4) {
                    rowFour = beeperNum;
                    unsorted[rowNum] = rowFour;
                    rowNum ++;
                }
                else if (rowNum == 5) {
                    rowFive = beeperNum;
                    unsorted[rowNum] = rowFive;
                    rowNum ++;
                }
                else if (rowNum == 6) {
                    rowSix = beeperNum;
                    unsorted[rowNum] = rowSix;
                    rowNum ++;
                }
                else if (rowNum == 7) {
                    rowSeven = beeperNum;
                    unsorted[rowNum] = rowSeven;
                    rowNum ++;
                }
                moveToNextRow();
            }
            moveToNextRow();
        }
        return true;
    }
    public void sortList(){
        
    }
    public void placeBeepers(){
        
    }
    public boolean moveToNextRow(){
        while (frontIsClear()){
            move();
            if (!frontIsClear()){
                turnLeft();
                move();
                turnLeft();
                collectAllBeepers();
            }
        }
        return true;
    }
    public boolean reposition(){
        move();
        turnLeft();
        while (frontIsClear()){
            move();
        }
        turnLeft();
        turnLeft();
        return true;
    }
}

