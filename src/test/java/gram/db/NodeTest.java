package gram.db;

import org.junit.Test;
import org.junit.Assert;

/**
 * Created with IntelliJ IDEA.
 * User: jeremymorgan
 * Date: 11/7/13
 * Time: 12:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class NodeTest {

    @Test
    public void sequenceTest(){
        Node node = new Node();
        node.setSequence("ATGT");

        String seq = node.getSequence();
        Assert.assertEquals("ATGT",seq);
    }
}
