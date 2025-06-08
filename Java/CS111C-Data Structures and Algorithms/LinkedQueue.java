/**
 A class that implements a queue of objects by using
 a chain of linked nodes that has both head and tail references.
 
 @author Frank M. Carrano
 @author Timothy M. Henry
 @version 5.0
 */
public final class LinkedQueue<T> implements QueueInterface<T>
{
   private Node firstNode; // References node at front of queue
   private Node lastNode;  // References node at back of queue
   private int length;
   
   public LinkedQueue()
   {
      firstNode = null;
      lastNode = null;
      length = 0;
   } // end default constructor
	
   public void enqueue(T newEntry)
   {
      Node newNode = new Node(newEntry, null);
      
      if (isEmpty())
         firstNode = newNode;
      else
         lastNode.setNextNode(newNode);
      
      lastNode = newNode;
      length++;
   } // end enqueue

   public T getFront()
   {
      if (isEmpty())
         throw new EmptyQueueException();
      else
         return firstNode.getData();
   } // end getFront
   
   public T dequeue()
   {
      T front = getFront();  // Might throw EmptyQueueException
                             // Assertion: firstNode != null
      firstNode.setData(null);
      firstNode = firstNode.getNextNode();
      length--;
      if (firstNode == null)
         lastNode = null;
      return front;
   } // end dequeue
		
   public boolean isEmpty()
   {
      return (firstNode == null) && (lastNode == null);
   } // end isEmpty
   
   public void clear()
   {
      firstNode = null;
      lastNode = null;
      length = 0;
   } // end clear

   public int getLength()
   {
      return length;
   }

   public boolean checkForEntry(T myData)
   {
      Node localCurrentNode = firstNode;
      if(isEmpty())
         throw new EmptyQueueException();
      else
      {
         while(localCurrentNode != null)
         {  
            if(localCurrentNode.getData().equals(myData))
            {
              return true;
            }
            localCurrentNode = localCurrentNode.getNextNode();
         }
         return false;
      }
   } // end of checkForEntry helper method


   public void moveToBack(T queueEntry)
   {
      Node localLastNode = null;
      Node localCurrentNode = firstNode;
      if(isEmpty())
      {
         throw new EmptyQueueException();
      }

      if (firstNode.getData().equals(queueEntry))
      {
         T frontData = dequeue();
         enqueue(frontData);
         return;
      }

      while (localCurrentNode != null)
      {
         if (localCurrentNode.getData().equals(queueEntry)) {
            localLastNode.setNextNode(localCurrentNode.getNextNode()); // Remove current node
            localCurrentNode.setNextNode(null);
            enqueue(localCurrentNode.getData());
            localCurrentNode.setData(null); // Optional: clear data
            break; // Exit the loop once the element is moved
         }
         localLastNode = localCurrentNode;
         localCurrentNode = localCurrentNode.getNextNode();
      }
   } // end of moveToBack method

   private class Node
   {
      private T    data; // Entry in queue
      private Node next; // Link to next node
      
      private Node(T dataPortion)
      {
         data = dataPortion;
         next = null;
      } // end constructor
      
      private Node(T dataPortion, Node linkPortion)
      {
         data = dataPortion;
         next = linkPortion;
      } // end constructor
      
      private T getData()
      {
         return data;
      } // end getData
      
      private void setData(T newData)
      {
         data = newData;
      } // end setData
      
      private Node getNextNode()
      {
         return next;
      } // end getNextNode
      
      private void setNextNode(Node nextNode)
      {
         next = nextNode;
      } // end setNextNode
   } // end Node
} // end Linkedqueue
