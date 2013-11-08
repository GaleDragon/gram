package gram.db;

import gram.db.error.ChainBuildException;

/**
 * Created with IntelliJ IDEA.
 * User: jeremymorgan
 * Date: 11/7/13
 * Time: 11:58 AM
 * To change this template use File | Settings | File Templates.
 */

public class Chain {

    private Node root = null;

    private Chain add( Node n, Node root ) throws ChainBuildException {
        int strand = n.getStrand();

        if (this.root == null){
            if (n.isCommon()){
                this.root = n;
                return this;
            } else {
                this.root = new Node();
                this.root.setCommon(true);
                return this.add( n );
            }
        }

        if (root == null){
            root = this.root;
        }

        if (root.isCommon()){
            if (strand == 1){
                if ( root.getLeft() == null ){
                    root.setLeft( n );
                }else{
                    throw new ChainBuildException( );
                }
            } else if ( strand == 2 ) {
                if ( root.getRight() == null ){
                    root.setRight( n );
                }else{
                    throw new ChainBuildException( );
                }
            }
        }

        if (n.isCommon()) {
            if (root.getLeft() != null && root.getRight() != null){
                root.getRight().setRight( n );
                root.getLeft().setLeft( n );
            } else {
                throw new ChainBuildException();
            }
        }

        return this;
    }

    public Chain add( Node n ) throws ChainBuildException {
        return this.add( n, null );
    }

    private Node find( String sequence, Node root, boolean substring ){
        if (root == null) {
            root = this.root;
        }

        if (substring){
            if (root.getSequence().contains(sequence)){
                return root;
            }

            if (root.getRight() != null){
                if (root.getRight().getSequence().contains(sequence)){
                    return root.getRight();
                }
            }
            if (root.getLeft() != null){
                if (root.getLeft().getSequence().contains(sequence)){
                    return root.getLeft();
                }
            }
            if (root.getLeft() == null || root.getRight() == null){
                return null;
            } else {
                return this.find(sequence, root.getLeft().getLeft(), substring);
            }

        } else {
            if (root.getSequence().equals(sequence)){
                return root;
            }

            if (root.getRight() != null){
                if (root.getRight().getSequence().equals(sequence)){
                    return root.getRight();
                }
            }
            if (root.getLeft() != null){
                if (root.getLeft().getSequence().equals(sequence)){
                    return root.getLeft();
                }
            }
            if (root.getLeft() == null || root.getRight() == null){
                return null;
            } else {
                return this.find(sequence, root.getLeft().getLeft(), substring);
            }
        }

    }

    public Node find( String sequence, boolean substring ){
        if (this.root == null)
            return null;

        return this.find( sequence, null, substring );
    }

    public Node getRoot(){
        return this.root;
    }

    private Node[] traverseAndReturnLevelNodes( int level, Node root ){
        if (level == 0){
            Node[] n = new Node[1];
            n[0] = root;
            return n;
        }

        if (level == 1 && root.isCommon()){
            Node[] ns = new Node[2];
            ns[0] = root.getLeft();
            ns[1] = root.getRight();
            return ns;
        }

        return this.traverseAndReturnLevelNodes( level-1, root.getPast() );
    }

    public Node[] traverseAndReturnLevelNodes(int level){
        return this.traverseAndReturnLevelNodes( level, null );
    }

    public String generatePatch() {
        String patch = "";



        return patch;
    }
}
