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

     public boolean add( int index, Object val) {
         if (index == 0)
             addAsHead( val);
         else {
             Node newElement = new Node( val);
             Node previousElement = headReference;
             for (int i = 1; i < index; i++)
                previousElement = previousElement.getReferenceToNextNode();
             newElement.setReferenceToNextNode( previousElement.getReferenceToNextNode());
             previousElement.setReferenceToNextNode(newElement);
         }
         return true;
     }

     public boolean remove(int index) {
         if (index == 0)
            headReference = headReference.getReferenceToNextNode();
         else {
         Node previousElement = headReference;
         for (int i = 1; i < index; i++)
            previousElement = previousElement.getReferenceToNextNode();
         previousElement.setReferenceToNextNode(
                        previousElement.getReferenceToNextNode().getReferenceToNextNode()
                                                );
         }
         return true;
     }

     public void set(int index, Object val) {
        Node node = headReference;
        for (int i = 0; i < index; i++)
          node = node.getReferenceToNextNode();
        node.setCargoReference( val);
     }
     public Object get( int index) {
         Node node = headReference;
         for (int i = 0; i < index; i++)
           node = node.getReferenceToNextNode();
         return node.getCargoReference();
     }
}
