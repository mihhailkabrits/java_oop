import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class FakeDataTest {
    private static FakeData fakeData;

    @BeforeClass
    public static void createTestFakeData(){
        fakeData = new FakeData();
    }

    @Test
    public void testFakeStringValue() throws Exception {
        String res = fakeData.fakeString();
        Assert.assertEquals("FirstSecond",fakeData.fakeString());

    }

    @Test
    public  void testFakeStringValueNotNull(){
        String res = fakeData.fakeString();
        Assert.assertNotNull(fakeData.fakeString());
    }


}