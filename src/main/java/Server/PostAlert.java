package Server;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PostAlert {
    private boolean isSetup = false;
    private int messagedelay;
    private String messageContent;
    private String rawMessage;
    private ClientHandler clientHandler;


    public void parseMessage() throws Exception {
        Pattern pattern = Pattern.compile("^\\s?([0-9]+)\\s(.*)");
        Matcher decodedValues = pattern.matcher(rawMessage);
        decodedValues.find();

        messagedelay = Integer.parseInt(decodedValues.group(1));
        messageContent = decodedValues.group(2);
        isSetup = true;
    }

    public PostAlert(ClientHandler clientHandler, String message) {
        this.rawMessage = message;
        this.clientHandler = clientHandler;
    }

    public void post() {
        if (isSetup == false)
            return;

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                clientHandler.sendMessage(messageContent);
                timer.cancel();
            }
        }, messagedelay);
    }

}
