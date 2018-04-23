import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.junit.jupiter.api.Assertions.*;

class EchoClient1Test {

    @Test
    void main() throws IOException
    {

        String name ="Suki";

        assertEquals(name,name);

    }
}