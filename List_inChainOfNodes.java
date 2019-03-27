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

    private Node getNode(int index){
      Node node;
      int i;
      for (node = headReference , i = 0;
           i < index;
           node = node.getReferenceToNextNode() , i++);
      return node;
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

     public boolean add( int index, Object val) {
         if (index == 0)
             addAsHead( val);
         else {
             Node newElement = new Node( val , getNode( index));
             getNode(index - 1).setReferenceToNextNode( newElement);

             // Node newElement = new Node(set(index , val));
             // newElement.setReferenceToNextNode(getNode( index + 1));
             // getNode( index).setReferenceToNextNode( newElement);
         }
         return true;
     }

     public boolean remove(int index) {
         if (index == 0)
            headReference = headReference.getReferenceToNextNode();
         else {
             Node previousElement = getNode(index - 1);
             previousElement.setReferenceToNextNode( // set next node 2 nodes ahead, so the node between is skipped
                            previousElement.getReferenceToNextNode().getReferenceToNextNode()
                                                    );
         }
         return true;
     }

     public Object set(int index, Object val) {
         Object result = getNode( index).getCargoReference();
         getNode( index).setCargoReference( val);
         return result;
     }
     public Object get( int index) {
         return getNode( index).getCargoReference();
     }
}
