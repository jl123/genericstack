import java.util.Stack;

public class GenericStack<T>
{
   private int size;
   private StackNode top;

   public GenericStack()
   {
      size = 0;
      top = null;
   }

   public int getSize()
   {
      return size;
   }

   public void push(T data)
   {
      StackNode node = new StackNode(data);
      node.next = top;
      top = node;
      size++;
   }

   public T pop() throws StackEmptyException
   {
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

   public T peek() throws StackEmptyException
   {
      if (size == 0)
         throw new StackEmptyException();
      else
      {
         return (T) top.data;
      }
   }

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
      GenericStack<Character> stack2 = new GenericStack<>();
      String s = "0123456789";

      for (int i = 0; i < s.length(); i++)
      {
         stack.push(s.charAt(i));
      }

      for (int i = 0; i < s.length(); i++)
      {
         stack2.push(s.charAt(i));
      }
      System.out.println(stack.getSize()
      );
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
   }
}
class StackEmptyException extends Exception
{
   public StackEmptyException()
   {
      super();
   }
   @Override
   public String toString()
   {
      return "Stack empty.";
   }
}