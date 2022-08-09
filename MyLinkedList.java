//Keagan Badenhorst 34209433
public class MyLinkedList<E>  
{
	private Node<E> head, tail;
 
	public MyLinkedList() 
    {
		head = null;
		tail = null;
    }
	
	public void sortlist()
	{
		Node<E> ptr = head;
		Node<E> index = null;
		E temp = null;
		
		if ( head == null)
		{
			System.out.println("The list is empty, cannot sort");
		}
		else
		{
			while (ptr != null)
			{
				index = ptr.next;
				while (index != null)
				{
					if(((Comparable)ptr.element).compareTo(index.element)>0)
					{
						temp = ptr.element;
						ptr.element = index.element;
						index.element = temp;
					}
					index= index.next;
				}
				ptr = ptr.next;
			}
		}
	}

  
	public E getFirst() 
	{
		if (head == null)
		{
			return null;
		}
		else 
		{
			return head.element;
		}
    }


	public E getLast() 
	{
		if (head==null) 
		{
			return null;
		}
		else 
		{
			return tail.element;
		}
	}
	
	public int getListSize()
	{
		int listSize = 0;
		
		Node<E> ptr = head;
		
		for (ptr= head;ptr!=null; ptr=ptr.next) 
		{
			listSize++; 
		}
		return listSize;
		
	}
	
	public int calculate()
	{
		Node<E> ptr = head;
		int k=0;
		for(ptr=head; ptr!= null; ptr= ptr.next)
		{
			k = k + (Integer)ptr.element;
		}
		return k;
	}
	
	/*public E removelast()
	{
		if(head == null || head.next == null)
		{
			return null;
		}
		
		Node <E> secondlast = head;
		while(secondlast.next.next != null)
		{
			secondlast = secondlast.next;
		}
		Node <E> temp = secondlast.next;
		secondlast.next = null;
		return temp.element;
	}*/
	
	public E removelast()
	{
		if(head == null || head.next == null)
		{
			return null;
		}
		
		Node<E> ptr = head;
		Node<E> prevptr = null;
		
		for(ptr= head; ptr.next!=null; ptr=ptr.next)
		{
		   prevptr=ptr;
		   
		}
		
		E temp = prevptr.next.element;
		tail = prevptr;
		prevptr.next = null;
		
		return temp;
	}
	
	public boolean contains(E item)
	{
		Node<E> prt =head; 
		
		while(prt != null)
		{
			if(prt.element.equals(item))
			{
				
				return true;
			}
			prt=prt.next;
		}
		return false;
	}
	
	
	public MyLinkedList makePalindrome()
	{
		if (this.head == null)
			return null;
		
		MyLinkedList returnlist = new MyLinkedList();
		
		Node<E> ptr = head;
		
		
		while ((ptr!= null) )
	    {
			returnlist.append(ptr.element.toString());
			ptr=ptr.next;
	    }
		
		ptr = head;
		Node<E> prvPtr = null;
		Node<E> temp = null;
		while (ptr != null)
	    {
			temp = ptr.next;
			ptr.next = prvPtr;
			prvPtr = ptr;
			ptr = temp;
	    }
		head = prvPtr;
		
		for (ptr= head;ptr!=null; ptr=ptr.next) 
		{
			returnlist.append(ptr.element.toString());
		}	
		return returnlist;
	}
	
	public MyLinkedList getLastHalf()
	{
		if (head == null)
			return null;
		
		MyLinkedList returnlist = new MyLinkedList();
		
		Node<E> ptr = head;
		
		int k=0;
		for (ptr= head;ptr!=null; ptr=ptr.next) 
		{
			if(k >= ((this.getListSize()/2)))
			{
				returnlist.append(ptr.element.toString());
			}
			k++;
		}
		
		return returnlist;
		
	}

 
	public void prepend(E e) 
	{
		Node<E> newNode = new Node<>(e); 
		newNode.next = head; 
		head = newNode; 
	   
		if (tail == null)
		  tail = head;
	}

 
    public void append(E item) 
	{
		Node<E> newNode = new Node<>(item); 
		if (head == null) 
		{
			head = tail = newNode;
		}
		else 
		{
			tail.next = newNode; 
			tail = newNode; 
		}
    }
  
 	public E removeFirst() 
	{
		if (head == null) 
		{
			return null;
		}
		else 
		{
			E temp = head.element;
			head = head.next;
			if (head == null) 
			{
				tail = null;
			}
			return temp;
		}
    }

	public bool delete(E item)
    {
		int num=0;
	   Node<E> ptr = head;
	   Node<E> prvPtr = null;
	   while (ptr!= null&& ((Comparable)ptr.element).compareTo(item)!= 0)
	   {
		   num++;
		   prvPtr=ptr;
		   ptr=ptr.next;
	   }
	   if (ptr == null)
		   return false;
	   if (ptr==head) 
		   head= head.next;
	   else 
		   prvPtr.next=ptr.next;
	   if (ptr==tail)
		   tail=prvPtr;
	   System.out.println(num);
	   return true;
    }
	
	public MyLinkedList merge(MyLinkedList paramlist)
	{
		Node<E> ptrThis, ptrParam;
		ptrThis = head;
		ptrParam = paramlist.head;
		MyLinkedList returnlist = new MyLinkedList();
		
		if(head==null)
		{
			while(ptrParam != null)
			{
				returnlist.append(ptrParam.element);
				ptrParam = ptrParam.next;
			}
			return returnlist;
			
		}
		
		if(paramlist.head == null)
		{
			while(ptrThis != null)
			{
				returnlist.append(ptrThis.element);
				ptrThis = ptrThis.next;
			}
			return returnlist; 
		}
		
		while((ptrThis != null) && (ptrParam != null))
		{
			if (((Comparable)ptrThis.element).compareTo(ptrParam.element)<=0)
			{
				returnlist.append(ptrThis.element);
				ptrThis = ptrThis.next;
			}
			else
			{
				returnlist.append(ptrParam.element);
				ptrParam = ptrParam.next;
			}
		}
		
		if(ptrThis == null)
		{
			while(ptrParam != null)
			{
				returnlist.append(ptrParam.element);
				ptrParam = ptrParam.next;
			}
		}
		if(ptrParam == null) 
		{
			while(ptrThis != null)
			{
				returnlist.append(ptrThis.element);
				ptrThis = ptrThis.next;
			}
		}
		return returnlist;
	}
 
	public String toString() 
	{
		String result = "[";

		Node<E> ptr = head;
		for (ptr= head;ptr!=null; ptr=ptr.next) 
		{
			 result = result +  ptr.element.toString();     
			 if (ptr.next != null)
				 result = result + ","; 
		}
		result += "]"; 
		return result;
    }


	public void clear() 
	{
		head = tail = null;
	}


	private static class Node<E> 
	{
		E element;
			Node<E> next;
			public Node(E element) 
			{
				this.element = element;
				next = null;
			}
	}
	
	
} 
