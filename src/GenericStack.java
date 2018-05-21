public class GenericStack<T>
{
   private int size;
   private StackNode top;

   public GenericStack()
   {
      size = 0;
      top = null;
   }
   //return number of items in stack
   public int getSize()
   {
      return size;
   }
   //add data to stack
   public void push(T data)
   {
      StackNode node = new StackNode(data);
      node.next = top;
      top = node;
      size++;
   }
   //remove and return value of "top" element
   public T pop() throws StackEmptyException
   {
      //throw error if stack empty
      if (size == 0)
         throw new StackEmptyException();
      else
      {
         StackNode retNode = top;
         top = top.next;
         size--;
         return (T) retNode.data;
      }
   }
   //return value of "top" element without removing
   public T peek() throws StackEmptyException
   {
      if (size == 0)
         throw new StackEmptyException();
      else
      {
         return (T) top.data;
      }
   }
   //Nodes that contain data
   private class StackNode<T>
   {
      T data;
      StackNode next;

      StackNode(T data)
      {
         next = null;
         this.data = data;
      }
   }

   public static void main(String[] args) throws StackEmptyException
   {
      GenericStack<Character> stack = new GenericStack<>();
      GenericStack<Integer> stack2 = new GenericStack<>();
      String s = "0123456789";
      int sum = 0;

      //push data on to stacks
      for (int i = 0; i < s.length(); i++)
      {
         stack.push(s.charAt(i));
      }

      for (int i = 0; i < s.length(); i++)
      {
         stack2.push(Integer.parseInt(String.valueOf(s.charAt(i))));
      }

      System.out.println("Stacck of Characters");
      System.out.println("Character Stack size" + stack.getSize());
      for (int i = s.length(); i >= 0; i--)
      {
         try
         {
            System.out.println(stack.pop());
         } catch (StackEmptyException e)
         {
            System.out.println("Pop: " + e);
         }
      }
      try
      {
         System.out.println(stack.peek());
      }
      catch (StackEmptyException e)
      {
         System.out.println("Peek: " + e);
      }
      System.out.println("Stack of Integers");
      System.out.println("Integer Stack size " + stack2.getSize());
      for (int i = s.length(); i >= 0; i--)
      {
         try
         {
            sum += stack2.pop();
         } catch (StackEmptyException e)
         {
            System.out.println("Pop: " + e);
         }
      }
      System.out.println("Sum of integer stack: " + sum);
   }


}
class StackEmptyException extends Exception
{
   public StackEmptyException()
   {
   }
   @Override
   public String toString()
   {
      return "Stack empty.";
   }
}