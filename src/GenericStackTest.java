import org.junit.Assert;
import org.junit.Test;
import sun.net.www.content.text.Generic;

import java.util.Stack;

import static org.junit.Assert.*;

public class GenericStackTest
{
   @Test
   public void peekTest() throws StackEmptyException
   {
      int num = Integer.MAX_VALUE;
      GenericStack<Integer> stack = new GenericStack<>();

      for (int i = 0; i < 4; i++)
      {
         stack.push(i);
      }
      stack.pop();
      num = stack.peek();
      assertEquals(num,2);
      assertEquals(stack.getSize(),3);
   }

   @Test
   public void pushTest() throws StackEmptyException
   {
      GenericStack<Integer> stack = new GenericStack<>();

      for (int i = 0; i < 100; i++)
      {
         stack.push(i);
      }
      assertEquals(stack.getSize(), 100);
   }

   @Test
   public void isEmptyTest() throws StackEmptyException
   {
      GenericStack<Integer> stack = new GenericStack();

      for (int i = 0; i < 10; i++)
      {
         stack.push(i);
      }
      assertEquals(stack.isEmpty(), false);
      while (!stack.isEmpty())
      {
         stack.pop();
      }
      assertEquals(stack.isEmpty(), true);
   }

   @Test(expected = StackEmptyException.class)
   public void testStackEmptyExc() throws StackEmptyException
   {
      GenericStack<Integer> stack = new GenericStack<>();

      for (int i = 0; i < 10; i++)
      {
         stack.push(i);
      }
      for (int i = 0; i < 11; i++)
      {
         stack.pop();
      }
   }

}