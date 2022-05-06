package Server;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class PostAlertTest {
    Pattern pattern = Pattern.compile("^\\s?([0-9]+)\\s(.*)");

    @org.junit.jupiter.api.Test
    void parseMessage() {
        //given
        int ExpectedMessageDelay = 788;
        String ExpectedMessageContent = "eustachy";
        String rawMessage = "788 eustachy";

        //when
        Matcher decodedValues = pattern.matcher(rawMessage);
        decodedValues.find();
        int ActualMessageDelay = Integer.parseInt(decodedValues.group(1));
        String ActualMessageContent = decodedValues.group(2);

        //then
        assertEquals(ActualMessageDelay, ExpectedMessageDelay);
        assertEquals(ActualMessageContent, ExpectedMessageContent);
    }

}