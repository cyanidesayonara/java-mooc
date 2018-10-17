
import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import static org.junit.Assert.assertTrue;
import org.junit.Rule;
import org.junit.Test;

@Points("06-07")
public class RoundRobinTest {

    @Rule
    public MockStdio io = new MockStdio();

    @Test
    public void test1() throws Throwable {
        String in = "tulosta\nlopeta\n";
        io.setSysIn(in);
        RoundRobin.main(new String[]{});
        assertTrue("Kun syöte on:\n" + in + ", tulostuksessa pitäisi olla \"1 3 5 7 9\". Nyt ei ollut.\nTulostus oli:\n" + io.getSysOut(), io.getSysOut().contains("1 3 5 7 9"));
    }

    @Test
    public void test2() throws Throwable {
        String in = "siirra\nsiirra\ntulosta\nlopeta\n";
        io.setSysIn(in);
        RoundRobin.main(new String[]{});
        assertTrue("Kun syöte on:\n" + in + ", tulostuksessa pitäisi olla \"5 7 9 1 3\". Nyt ei ollut.\nTulostus oli:\n" + io.getSysOut(), io.getSysOut().contains("5 7 9 1 3"));
    }

    @Test
    public void test3() throws Throwable {
        String in = "siirra\nsiirra\nsiirra\nsiirra\ntulosta\nlopeta\n";
        io.setSysIn(in);
        RoundRobin.main(new String[]{});
        assertTrue("Kun syöte on:\n" + in + ", tulostuksessa pitäisi olla \"9 1 3 5 7\". Nyt ei ollut.\nTulostus oli:\n" + io.getSysOut(), io.getSysOut().contains("9 1 3 5 7"));
    }
    
    @Test
    public void test4() throws Throwable {
        String in = "siirra\nsiirra\nsiirra\nsiirra\nsiirra\ntulosta\nlopeta\n";
        io.setSysIn(in);
        RoundRobin.main(new String[]{});
        assertTrue("Kun syöte on:\n" + in + ", tulostuksessa pitäisi olla \"1 3 5 7 9\". Nyt ei ollut.\nTulostus oli:\n" + io.getSysOut(), io.getSysOut().contains("1 3 5 7 9"));
    }

}
