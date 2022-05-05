package Server;

import java.io.IOException;
import java.util.*;

public class PostAlert {
    int delay;
    String message;
    ClientHandler clientHandler;

    private void validateUserInput(){

    }
    public PostAlert(ClientHandler clientHandler, String message){
        this.message = message;
        this.clientHandler = clientHandler;
    }
    public void post(String msg, ClientHandler handler) {

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                System.out.println(msg);
                clientHandler.sendMessage(msg);
                timer.cancel();
            }
        }, delay);
    }

}
