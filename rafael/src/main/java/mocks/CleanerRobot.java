package mocks;

import java.util.HashSet;
import java.util.Set;

/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */

interface Robot {
    public boolean move();
    public void turnLeft();
    public void turnRight();
    public void clean();
}
class Pair<T> {
    T a;
    T b;
    public Pair(T a, T b){
        this.a = a;
        this.b = b;
    }
}

class CleanerRobot {

    private static void main(String[] args) {
        CleanerRobot obj = new CleanerRobot();
        obj.cleanRoom(new Robot() {
            @Override
            public boolean move() {
                return false;
            }
            @Override
            public void turnLeft() {
                //TODO
            }

            @Override
            public void turnRight() {
            //TODO
            }

            @Override
            public void clean() {
                //TODO
            }
        });
    }

    private int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } }; //up right down left
    private Set<String> visited = new HashSet<>();
    private Robot robot;

    public void goBack() {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }

    private void backtrack(int r, int c, int dir) {
        visited.add(new String(r+" "+c));
        robot.clean(); //clean curr cell
        //explore
        for(int i=0; i<4; i++) {
            int newDir = (dir+i)%4; //could be just increment by 1 every time
            int newR = r + directions[newDir][0];
            int newC = c + directions[newDir][1];
            //validity
            if(! visited.contains(newR+" "+newC) && robot.move()) {
                backtrack(newR, newC, newDir);
                //go back to original position
                goBack();
            }
            //already visited or robot can't move
            robot.turnRight();
        }
    }

    public void cleanRoom(Robot robot) {
        this.robot = robot;
        backtrack(0, 0, 0);
    }
}