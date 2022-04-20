package ule.ed.recursivelist;

import static org.junit.Assert.*;

import org.junit.*;

import java.util.NoSuchElementException;


public class LinkedEDListTest {
	private LinkedEDList<String> lista;
	private LinkedEDList<String> lv;
	
	@Before
	public void test() {
		 lista= new LinkedEDList<String>();
		 lv = new LinkedEDList<String>();

		lv.addLast("A");
		lv.addLast("B");
		lv.addLast("C");

	}

	@Test
	public void test_Vacia() {
		assertEquals(0,lista.size());
	}
	
	@Test
	public void test_AddLast() {
		lista.addLast("2");
		Assert.assertFalse(lista.isEmpty());
		Assert.assertEquals("(2 )", lista.toString());
		lista.addLast("3");
		Assert.assertEquals("(2 3 )", lista.toString());
		lista.addLast("7");
		Assert.assertEquals("(2 3 7 )", lista.toString());
	}

	@Test
	public void test_Size() throws Exception{
		lista.addLast("2");
		Assert.assertFalse(lista.isEmpty());
		Assert.assertEquals("(2 )", lista.toString());
		Assert.assertEquals(1, lista.size());
		lista.addLast("3");
		Assert.assertEquals("(2 3 )", lista.toString());
		Assert.assertEquals(2, lista.size());
		lista.addLast("7");
		Assert.assertEquals("(2 3 7 )", lista.toString());
		Assert.assertEquals(3, lista.size());
	}
	
	@Test(expected=EmptyCollectionException.class)
	public void test_RemoveFirst_Vacia() throws EmptyCollectionException{
		lista.removeFirstElem("A");
	}

	@Test(expected=NullPointerException.class)
	public void test_addLast_ElementoNulo() {
			lista.addLast(null);
	}
	
	@Test
	public void linkedtestAddAntePenult_Varios() {
		lista.addLast("2");
		Assert.assertFalse(lista.isEmpty());
		Assert.assertEquals("(2 )", lista.toString());
		lista.addAntePenult("3");
		Assert.assertEquals("(3 2 )", lista.toString());
		lista.addAntePenult("7");
		Assert.assertEquals("(7 3 2 )", lista.toString());
		lista.addAntePenult("10");
		Assert.assertEquals("(7 10 3 2 )", lista.toString());
		
	}
	
	// TODO  AÑADIR RESTO DE METODOS DE TESTS

	@Test
	public void test_addPos() throws Exception{
		lv.addPos("D", 2);
		Assert.assertEquals("(A D B C )", lv.toString());
		Assert.assertEquals(4, lv.size());
	}

	@Test
	public void test_addPosEmtpy() throws Exception{
		lista.addPos("Z", 3);
		Assert.assertEquals("(Z )", lista.toString());
	}
	
	@Test
	public void test_getElemPos() throws Exception{
		Assert.assertEquals("B", lv.getElemPos(2));
		Assert.assertEquals("A", lv.getElemPos(1));
		Assert.assertEquals("C", lv.getElemPos(3));
	}

	@Test
	public void test_getPosFirst() throws Exception{
		lv.addPos("A", 6);
		lv.addPos("B", 3);
		Assert.assertEquals("(A B B C A )", lv.toString());
		Assert.assertEquals(2, lv.getPosFirst("B"));
		Assert.assertEquals(1, lv.getPosFirst("A"));
		Assert.assertEquals(0, lv.getPosFirst("Z"));
	}

	@Test
	public void test_getPosLast() throws Exception{
		lv.addPos("A", 6);
		lv.addPos("B", 3);
		Assert.assertEquals("(A B B C A )", lv.toString());
		Assert.assertEquals(3, lv.getPosLast("B"));
		Assert.assertEquals(5, lv.getPosLast("A"));
		Assert.assertEquals(0, lv.getPosLast("Z"));
	}

	@Test(expected = EmptyCollectionException.class)
	public void test_removeLastEmpty() throws Exception{
		lista.removelast();
	}

	@Test
	public void test_removeLast() throws Exception{
		lv.addPos("A", 6);
		lv.addPos("B", 3);
		Assert.assertEquals("(A B B C A )", lv.toString());
		Assert.assertEquals("A", lv.removelast());
		Assert.assertEquals("(A B B C )", lv.toString());
		Assert.assertEquals("C", lv.removelast());
		Assert.assertEquals("(A B B )", lv.toString());
	}

	@Test(expected = EmptyCollectionException.class)
	public void test_removePenultEmpty() throws Exception{
		lista.removePenult();
	}

	@Test(expected = NoSuchElementException.class)
	public void test_removePenultOneElem() throws Exception{
		lista.addLast("2");
		lista.removePenult();
	}

	@Test
	public void test_removePenult() throws Exception{
		lv.addPos("A", 6);
		lv.addPos("B", 3);
		Assert.assertEquals("(A B B C A )", lv.toString());
		Assert.assertEquals("C", lv.removePenult());
		Assert.assertEquals("(A B B A )", lv.toString());
		Assert.assertEquals("B", lv.removePenult());
		Assert.assertEquals("(A B A )", lv.toString());
	}

	@Test(expected = EmptyCollectionException.class)
	public void test_removeFirstElemEmpty() throws Exception{
		lista.removeFirstElem("A");
	}

	@Test(expected = NoSuchElementException.class)
	public void test_removeFirstElemNoElem() throws Exception{
		lv.removeFirstElem("V");
	}

	@Test
	public void test_removeFirstElem()throws Exception{
		lv.addPos("A", 6);
		lv.addPos("B", 3);
		Assert.assertEquals("(A B B C A )", lv.toString());
		Assert.assertEquals("A", lv.removeFirstElem("A"));
		Assert.assertEquals("(B B C A )", lv.toString());
		Assert.assertEquals("C", lv.removeFirstElem("C"));
		Assert.assertEquals("(B B A )", lv.toString());
		Assert.assertEquals("A", lv.removeFirstElem("A"));
		Assert.assertEquals("(B B )", lv.toString());
	}

	@Test(expected = EmptyCollectionException.class)
	public void test_removeLastElemEmpty() throws Exception{
		lista.removeLastElem("A");
	}

	@Test(expected = NoSuchElementException.class)
	public void test_removeLastElemNoElem() throws Exception{
		lv.removeLastElem("F");
	}

	@Test
	public void test_removeLastElem() throws Exception{
		lv.addPos("A", 6);
		lv.addPos("B", 3);
		Assert.assertEquals("(A B B C A )", lv.toString());
		Assert.assertEquals("A", lv.removeLastElem("A"));
		Assert.assertEquals("(A B B C )", lv.toString());
		Assert.assertEquals("B", lv.removeLastElem("B"));
		Assert.assertEquals("(A B C )", lv.toString());
		Assert.assertEquals("A", lv.removeLastElem("A"));
		Assert.assertEquals("(B C )", lv.toString());
	}

	@Test
	public void test_reverse() throws Exception{
		Assert.assertEquals("(A B C )", lv.toString());
		Assert.assertEquals("(B C A )", lv.reverse().toString());
	}

	@Test
	public void test_addFirst() throws Exception{
		lista.addFirst("A");
		lista.addFirst("B");
		Assert.assertEquals("(B A )", lista.toString());
	}

}
