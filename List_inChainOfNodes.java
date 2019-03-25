/**
  Represent a list, implemented in a chain of nodes
 */

public class List_inChainOfNodes{
    private Node headReference;

    /**
      Construct an empty list
     */
     public List_inChainOfNodes() {
         headReference = null;
     }

    /**
      @return the number of elements in this list
     */
    public int size() {
        if (headReference == null)
            return 0;
        else
            return size( headReference);
    }
    private int size( Node node) {
        if (node.getReferenceToNextNode() == null)
            return 1;
        else
            return size(node.getReferenceToNextNode()) + 1;
    }


     /**
       @return a string representation of this list,
       format:
           # elements [element0,element1,element2,]
      */
    public String toString() {
        if (headReference == null)
            return "0 []";
        else {
            String result = size() + " [";
            result += toString( headReference) + "]";
            return result;

        }
    }
    private String toString( Node node) {
        if (node.getReferenceToNextNode() == null)
            return node.getCargoReference() + ",";
        else
            return node.getCargoReference() + ","
                + toString(node.getReferenceToNextNode());
    }


    /**
      Append @value to the head of this list.

      @return true, in keeping with conventions yet to be discussed
     */
     public boolean addAsHead( Object val) {
        Node newHead = new Node( val);
        newHead.setReferenceToNextNode( headReference);
        headReference = newHead;
        return true;
     }
     public void set(int index, Object val) {
        Node node = headReference;
        int i = 0;
        while(i < index)
          node = node.getReferenceToNextNode();
        node.setCargoReference( val);
     }
}
