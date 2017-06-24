package Players;

public class Gracz extends Player{


    public Gracz(){
        name = "";
        punkty = 0;
        typGracza = "Gracz";
        timeLimit = 360;
    }

    public Gracz(String _name, int _punkty){
        name = _name;
        punkty = _punkty;
        typGracza = "Gracz";
        timeLimit = 360;
    }


}


