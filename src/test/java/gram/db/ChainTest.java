package gram.db;

import gram.db.error.ChainBuildException;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: jeremymorgan
 * Date: 11/7/13
 * Time: 1:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class ChainTest {

    @Test
    public void addRootTest(){
        Chain c = new Chain();
        Node root = new Node();

        try{
            c.add( root );
        } catch ( ChainBuildException cbe ){
            Assert.fail();
        }

        Assert.assertTrue(true);
    }

    @Test
    public void addNodeTest() throws ChainBuildException{
        Chain chain = new Chain();
        Node common = new Node();

        common.setCommon(true);
        Node n = new Node();
        n.setStrand(1);

        chain.add( common );
        chain.add( n );

        Assert.assertTrue(true);
    }

    @Test
    public void findTest() throws ChainBuildException{
        Chain chain = new Chain();
        Node a = new Node();
        a.setStrand(1);
        a.setSequence("ATGTCGAA");

        Node c = new Node();
        c.setCommon(true);

        chain.add( c );
        chain.add( a );

        Node found = chain.find("ATGT",true);
        Assert.assertEquals(a.getSequence(), found.getSequence());
    }
}
