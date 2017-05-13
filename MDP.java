
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MDP {
    
    public static void main(String[] args) {
        //initialize states
        State[][] gridWorld = new State[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                gridWorld[i][j] = new State(i, j);
            }
        }
        
        //assign relevent values condition specific
        for (int i = 0; i < gridWorld.length; i++) {
            for (int j = 0; j < 10; j++) {
                //gonna need spec conditions for boundaries maybe a second loop
                //go left
                if((j-1)>=0){
                    //if teleporting tile change value
                    List<State> stateList=new ArrayList<>();
                    List<Double> probabilityList=new ArrayList<>();
                    List<Double> rewardList=new ArrayList<>();
                    //in bounds
                    String direction = "left";
                    stateList.add(gridWorld[i][j-1]);
                    probabilityList.add(1.0);
                    rewardList.add(-1.0);
                    gridWorld[i][j].addHashState(direction, stateList);
                    gridWorld[i][j].addHashTransition(direction, probabilityList);
                    gridWorld[i][j].addTransitionReward(direction, rewardList);
                }else{
                    //out of bounds
                    //if teleporting tile change value
                    List<State> stateList=new ArrayList<>();
                    List<Double> probabilityList=new ArrayList<>();
                    List<Double> rewardList=new ArrayList<>();
                    //in bounds
                    String direction = "left";
                    stateList.add(gridWorld[i][j]);
                    probabilityList.add(1.0);
                    rewardList.add(-5.0);
                    gridWorld[i][j].addHashState(direction, stateList);
                    gridWorld[i][j].addHashTransition(direction, probabilityList);
                    gridWorld[i][j].addTransitionReward(direction, rewardList);
                }
                //go right
                if((j+1)< 10){
                    //if teleporting tile change value
                    List<State> stateList=new ArrayList<>();
                    List<Double> probabilityList=new ArrayList<>();
                    List<Double> rewardList=new ArrayList<>();
                    //in bounds
                    String direction = "right";
                    stateList.add(gridWorld[i][j+1]);
                    probabilityList.add(1.0);
                    if(j == 8 && i == 9){
                        rewardList.add(100.0);
                    }else{
                        rewardList.add(-1.0);
                    }
                    
                    gridWorld[i][j].addHashState(direction, stateList);
                    gridWorld[i][j].addHashTransition(direction, probabilityList);
                    gridWorld[i][j].addTransitionReward(direction, rewardList);
                }else{
                    //if teleporting tile change value
                    List<State> stateList=new ArrayList<>();
                    List<Double> probabilityList=new ArrayList<>();
                    List<Double> rewardList=new ArrayList<>();
                    //in bounds
                    String direction = "right";
                    stateList.add(gridWorld[i][j]);
                    probabilityList.add(1.0);
                    rewardList.add(-5.0);
                    gridWorld[i][j].addHashState(direction, stateList);
                    gridWorld[i][j].addHashTransition(direction, probabilityList);
                    gridWorld[i][j].addTransitionReward(direction, rewardList);
                }
                //go up
                if((i-1)>=0){
                    //if teleporting tile change value
                    List<State> stateList=new ArrayList<>();
                    List<Double> probabilityList=new ArrayList<>();
                    List<Double> rewardList=new ArrayList<>();
                    //in bounds
                    String direction = "up";
                    stateList.add(gridWorld[i-1][j]);
                    probabilityList.add(1.0);
                        rewardList.add(-1.0);
                    
                    gridWorld[i][j].addHashState(direction, stateList);
                    gridWorld[i][j].addHashTransition(direction, probabilityList);
                    gridWorld[i][j].addTransitionReward(direction, rewardList);
                }else{
                    //if teleporting tile change value
                    List<State> stateList=new ArrayList<>();
                    List<Double> probabilityList=new ArrayList<>();
                    List<Double> rewardList=new ArrayList<>();
                    //in bounds
                    String direction = "up";
                    stateList.add(gridWorld[i][j]);
                    probabilityList.add(1.0);
                    rewardList.add(-5.0);
                    gridWorld[i][j].addHashState(direction, stateList);
                    gridWorld[i][j].addHashTransition(direction, probabilityList);
                    gridWorld[i][j].addTransitionReward(direction, rewardList);
                }
                
                //go down
                if((i+1)<10){
                    //if teleporting tile change value
                    List<State> stateList=new ArrayList<>();
                    List<Double> probabilityList=new ArrayList<>();
                    List<Double> rewardList=new ArrayList<>();
                    //in bounds
                    String direction = "down";
                    stateList.add(gridWorld[i+1][j]);
                    probabilityList.add(1.0);
                    if(i == 8 && j ==9){
                        rewardList.add(100.0);
                    }else{
                        rewardList.add(-1.0);
                    }
                    gridWorld[i][j].addHashState(direction, stateList);
                    gridWorld[i][j].addHashTransition(direction, probabilityList);
                    gridWorld[i][j].addTransitionReward(direction, rewardList);
                }else{
                    //if teleporting tile change value
                    List<State> stateList=new ArrayList<>();
                    List<Double> probabilityList=new ArrayList<>();
                    List<Double> rewardList=new ArrayList<>();
                    //in bounds
                    String direction = "down";
                    stateList.add(gridWorld[i][j]);
                    probabilityList.add(1.0);
                    rewardList.add(-5.0);
                    gridWorld[i][j].addHashState(direction, stateList);
                    gridWorld[i][j].addHashTransition(direction, probabilityList);
                    gridWorld[i][j].addTransitionReward(direction, rewardList);
                }
            } 
        }
        System.out.println("");
        for (int k = 0; k < 18; k++) {
            
        
        double[][] newValue = new double[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                newValue[i][j] = gridWorld[i][j].newValueCalculation();
            }
            //System.out.println("\n");
        }
        newValue[9][9] = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                //System.out.print(newValue[i][j]+"  ");
                gridWorld[i][j].setValue(newValue[i][j]);
                //System.out.print(gridWorld[i][j].getValue()+"  ");
            }
            //System.out.println("\n");
        }
        }
        
        for (int i = 0; i < gridWorld.length; i++) {
            for (int j = 0; j < gridWorld.length; j++) {
                System.out.print(gridWorld[i][j].getValue()+"  ");
                
            }
            System.out.println("\n");
        }
        
        gridWorld[8][9].TestStuff();
        System.out.println("Phew done setting up mostly");
    }
    
    public static void argmaxCalc(State s, State s1){
        
    }
    
}
