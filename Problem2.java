
import kareltherobot.*; 


/**
 * @author :  D. Appel
 */
public class Problem2 extends Robot
{
    public Problem2(int st, int av, Direction dir, int numBeepers) {
        super(st, av, dir, numBeepers);
    }
    
    public void buildFence() {
        faceBeepers();
        
    }
    public boolean faceBeepers(){
        // Will make Karel face North to find the Beepers 
        if (frontIsClear()) {
            if (facingNorth()) {
                collectBeepers();
            }
            else if (facingEast()) {
                turnLeft();
                collectBeepers();
            }
        }
        else if (facingWest()){
            turnRight();
            collectBeepers();
        }
        else {
            turnLeft();
            turnLeft();
        }
        return true;
    }
    public boolean collectBeepers() {
        while (frontIsClear()) {
            if (nextToABeeper()) {
                while (nextToABeeper()) {
                    pickBeeper();
                }
                move();
                turnRight();
                while (frontIsClear()) {
                    move();
                }
                turnRight();
                assembleFence();
            }
            else {
                move();
            }
        }
        return true;
    }
    public void turnRight(){
        turnLeft();
        turnLeft();
        turnLeft();
    }
    public boolean assembleFence(){
        if (frontIsClear()) {
            turnLeft();
            if (!frontIsClear()) {
                putBeeper();
                turnRight();
                move();
            }
            else if (frontIsClear()) {
                putBeeper();
                move();
            }
            assembleFence();
        }
        return true;
    }
}

