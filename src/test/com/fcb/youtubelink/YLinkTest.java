import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import com.fcb.youtubelink.*;

public class YLinkTest {

    @Test public void testgetAllLinks() {
        YLink test = new YLink("https://www.youtube.com/watch?v=3CZYMfE5vLM");
        ArrayList<YTResult> ytResults = null;
        ytResults = test.getAllLinks();
        System.out.println("ALLLINKS:" + "\n");
        for(YTResult yt : ytResults)
            System.out.println(yt.getData() + "\n");
        assertTrue("getAllLinks should return 'true'", ytResults.size() != 0);
    }
    @Test public void testgetVidLinks() {
        YLink test = new YLink("https://www.youtube.com/watch?v=3CZYMfE5vLM");
        ArrayList<YTResult> ytResults = null;
        ytResults = test.getVidLinks();
        System.out.println("VIDLINKS:" + "\n");
        for(YTResult yt : ytResults)
            System.out.println(yt.getData() + "\n");
        assertTrue("getVidLinks should return 'true'", ytResults.size() != 0);
    }
}