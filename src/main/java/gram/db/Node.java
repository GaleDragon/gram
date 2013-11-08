package gram.db;

/**
 * Created with IntelliJ IDEA.
 * User: jeremymorgan
 * Date: 11/7/13
 * Time: 11:59 AM
 * To change this template use File | Settings | File Templates.
 */
public class Node {
    private boolean common = false;
    private int strand = -1;
    private String sequence = "";
    private Node left = null;
    private Node right = null;

    public boolean isCommon() {
        return common;
    }

    public void setCommon(boolean common) {
        this.common = common;
    }

    public int getStrand() {
        return strand;
    }

    public void setStrand(int strand) {
        this.strand = strand;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getPast() {
        if ( this.getRight() == null ) {
            if (this.getLeft() == null){
                return null;
            } else {
                return this.getLeft();
            }
        } else if ( this.getLeft() == null ) {
            if (this.getRight() == null){
                return null;
            } else {
                return this.getRight();
            }
        } else {
            return this.getLeft();
        }
    }
}
