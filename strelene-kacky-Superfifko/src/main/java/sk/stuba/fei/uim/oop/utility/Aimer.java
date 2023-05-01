package sk.stuba.fei.uim.oop.utility;

public class Aimer {
    private boolean state;

    public void setStateToTrue(){
       state=true;
    }

    public void setStateToFalse(){
        state=false;
    }
    public String getState(){
        if(state){
            return "Aimed";
        }
        else{
            return "Unaimed";
        }
    }

    public Aimer(){
        state=false;
    }
}
