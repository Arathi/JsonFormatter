import com.undsf.jsonformatter.Formatter;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Arathi on 2015/11/05.
 */
public class TestFormatter {
    @Test
    public void testFormat(){
        String json = "{\"data1\":100,\"data2\":\"hello\",\"list\":[\"String 1\",\"String 2\",\"String 3\"]}";
        String rightFormattedJson =
            "{\n" +
            "  \"data1\": 100,\n" +
            "  \"data2\": \"hello\",\n" +
            "  \"list\": [\n" +
            "    \"String 1\",\n" +
            "    \"String 2\",\n" +
            "    \"String 3\"\n" +
            "  ]\n" +
            "}";
        String formattedJson = Formatter.format(json);
        assertEquals(formattedJson, rightFormattedJson);
    }
}
