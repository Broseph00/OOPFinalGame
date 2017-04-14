import com.iteration3.model.Map.Map;
import com.iteration3.model.Map.Region;
import com.iteration3.model.Map.River;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class RegionTest {

    @Test
    public void testReg1(){
        Region region = new Region();
        River river = new River(1);
        region.addRiver(river);
        region.printRegion();
    }

    @Test
    public void testReg2(){
        Region region = new Region();
        River river = new River(1,3,5);
        region.addRiver(river);
        region.printRegion();
    }

    @Test
    public void testReg3(){
        Region region = new Region();
        River river = new River(2,4,6);
        region.addRiver(river);
        region.printRegion();
    }

    @Test
    public void testReg4(){
        Region region = new Region();
        River river = new River(1,2);
        region.addRiver(river);
        region.printRegion();
    }

    @Test
    public void testReg5(){
        Region region = new Region();
        River river = new River(1,3);
        region.addRiver(river);
        region.printRegion();
    }

    @Test
    public void testReg6(){
        Region region = new Region();
        River river = new River(1,3);
        region.addRiver(river);
        region.addBridge(3);
        region.printRegion();
    }

    @Test
    public void testReg7(){
        Region region = new Region();
        River river = new River(1,3);
        region.addRiver(river);
        region.addBridge(1);
        region.printRegion();
    }

    @Test
    public void testReg8(){
        Region region = new Region();
        River river = new River(1,3, 5);
        region.addRiver(river);
        region.addBridge(5);
        region.printRegion();
    }

    @Test
    public void testReg9(){
        Region region = new Region();
        River river = new River(1,3, 5);
        region.addRiver(river);
        region.addBridge(5);
        region.addBridge(3);
        region.addBridge(1);
        region.addBridge(1);
        region.printRegion();
    }

    @Test
    public void testReg10(){
        Region region = new Region();
        River river = new River(1,6);
        region.addRiver(river);
        region.addBridge(2);
        region.printRegion();
    }
}
