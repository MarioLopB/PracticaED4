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

	@Test(expected = NullPointerException.class)
	public void test_AddAntePunultNull() throws Exception{
		lv.addAntePenult(null);
	}

	@Test
	public void test_AddAntePenultimoEmpty(){
		lista.addAntePenult("1");
		Assert.assertEquals("(1 )", lista.toString());
	}
	
	// TODO  A??ADIR RESTO DE METODOS DE TESTS

	@Test(expected = IllegalArgumentException.class)
	public void test_addPos_Pos0() throws Exception{
		lv.addPos("F", 0);
	}

	@Test(expected = NullPointerException.class)
	public void test_addPos_PosNull() throws Exception{
		lv.addPos(null, 2);
	}

	@Test
	public void test_addPos() throws Exception{
		lv.addPos("D", 2);
		lv.addPos("F",3);
		Assert.assertEquals("(A D F B C )", lv.toString());
		lv.addPos("G", 6);
		lv.addPos("H", 2);
		Assert.assertEquals("(A H D F B C G )", lv.toString());
		lv.addPos("O", 1);
		Assert.assertEquals("(O A H D F B C G )", lv.toString());
		Assert.assertEquals(8, lv.size());
	}

	@Test
	public void test_addPosEmtpy() throws Exception{
		lista.addPos("Z", 3);
		Assert.assertEquals("(Z )", lista.toString());
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_getElemPosOutOfRange() throws Exception{
		lv.getElemPos(4);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_getElemPosZero() throws Exception{
		lv.getElemPos(0);
	}

	@Test
	public void test_getElemPos() throws Exception{
		Assert.assertEquals("B", lv.getElemPos(2));
		Assert.assertEquals("A", lv.getElemPos(1));
		Assert.assertEquals("C", lv.getElemPos(3));
	}

	@Test(expected = NullPointerException.class)
	public void test_getPosFirstNull() throws Exception{
		lv.getPosFirst(null);
	}

	@Test(expected = NoSuchElementException.class)
	public void test_getPosFirstNoElem() throws Exception{
		lv.getPosFirst("R");
	}

	@Test
	public void test_getPosFirst() throws Exception{
		lv.addPos("A", 6);
		lv.addPos("B", 3);
		Assert.assertEquals("(A B B C A )", lv.toString());
		Assert.assertEquals(2, lv.getPosFirst("B"));
		Assert.assertEquals(1, lv.getPosFirst("A"));
	}

	@Test(expected = NullPointerException.class)
	public void test_getPosLastNull() throws Exception{
		lv.getPosLast(null);
	}

	@Test(expected = NoSuchElementException.class)
	public void test_getPosLastNoElem() throws Exception{
		lv.getPosLast("F");
	}

	@Test
	public void test_getPosLast() throws Exception{
		lv.addPos("A", 6);
		lv.addPos("B", 3);
		Assert.assertEquals("(A B B C A )", lv.toString());
		Assert.assertEquals(3, lv.getPosLast("B"));
		Assert.assertEquals(5, lv.getPosLast("A"));
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
		Assert.assertEquals("B", lv.removePenult());
		Assert.assertEquals("(A A )", lv.toString());
		Assert.assertEquals("A", lv.removePenult());
		Assert.assertEquals("(A )", lv.toString());

	}

	@Test(expected = EmptyCollectionException.class)
	public void test_removelastEmpty() throws Exception{
		lista.removelast();
	}

	@Test
	public void test_removelast() throws Exception{
		Assert.assertEquals("C", lv.removelast());
		Assert.assertEquals("(A B )", lv.toString());
		Assert.assertEquals("B", lv.removelast());
		Assert.assertEquals("(A )", lv.toString());
		Assert.assertEquals("A", lv.removelast());
		Assert.assertEquals("()", lv.toString());
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
		Assert.assertEquals("B", lv.removeFirstElem("B"));
		Assert.assertEquals("(B )", lv.toString());
		Assert.assertEquals("B", lv.removeFirstElem("B"));
		Assert.assertEquals("()", lv.toString());

	}

	@Test
	public void test_removeFirstElem2()throws Exception{
		lv.addLast("B");
		Assert.assertEquals("(A B C B )", lv.toString());
		Assert.assertEquals("B", lv.removeFirstElem("B"));
		Assert.assertEquals("(A C B )", lv.toString());
		Assert.assertEquals("C", lv.removeFirstElem("C"));
		Assert.assertEquals("(A B )", lv.toString());
	}


	@Test(expected = EmptyCollectionException.class)
	public void test_removeLastElemEmpty() throws Exception{
		lista.removeLastElem("A");
	}

	@Test(expected = NullPointerException.class)
	public void test_removeLastElemNull() throws Exception{
		lv.removeLastElem(null);
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
		Assert.assertEquals("C", lv.removeLastElem("C"));
		Assert.assertEquals("(B )", lv.toString());
		Assert.assertEquals("B", lv.removeLastElem("B"));
		Assert.assertEquals("()", lv.toString());

	}

	@Test
	public void test_removeLastElem2() throws Exception{
		lv.addPos("B", 3);
		Assert.assertEquals("(A B B C )", lv.toString());
		Assert.assertEquals("A", lv.removeLastElem("A"));
		Assert.assertEquals("(B B C )", lv.toString());
		Assert.assertEquals("B", lv.removeLastElem("B"));
		Assert.assertEquals("(B C )", lv.toString());
		Assert.assertEquals("B", lv.removeLastElem("B"));
		Assert.assertEquals("(C )", lv.toString());
		Assert.assertEquals("C", lv.removeLastElem("C"));
		Assert.assertEquals("()", lv.toString());

	}

	@Test
	public void test_reverse() throws Exception{
		Assert.assertEquals("(A B C )", lv.toString());
		Assert.assertEquals("(C B A )", lv.reverse().toString());
	}

	@Test
	public void test_addFirst() throws Exception{
		lista.addFirst("A");
		lista.addFirst("B");
		Assert.assertEquals("(B A )", lista.toString());
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_toStringFromUntilReverse0() throws Exception{
		lv.toStringFromUntilReverse(0,0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_toStringFromUntilReverseNeg() throws Exception{
		lv.toStringFromUntilReverse(1,-2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_toStringFromUntilReverseMinorFrom() throws Exception{
		lv.toStringFromUntilReverse(1,2);
	}

	@Test
	public void test_toStringFromUntilReverse() throws Exception{
		lv.addPos("A", 6);
		lv.addPos("B", 3);
		Assert.assertEquals("(A B B C A )", lv.toString());
		Assert.assertEquals("(C B B )", lv.toStringFromUntilReverse(4,2));
		Assert.assertEquals("(A C B B )", lv.toStringFromUntilReverse(6, 2));
		Assert.assertEquals("(C B )", lv.toStringFromUntilReverse(4, 3));
		Assert.assertEquals("(A C B B A )", lv.toStringFromUntilReverse(7, 1));
		Assert.assertEquals("(A )", lv.toStringFromUntilReverse(1, 1));
		Assert.assertEquals("(B B )", lv.toStringFromUntilReverse(3, 2));
		Assert.assertEquals("(A )", lv.toStringFromUntilReverse(34,5));

	}

	@Test
	public void test_oddToString() throws Exception{
		lv.addPos("A", 6);
		lv.addPos("B", 3);
		lv.addLast("F");
		Assert.assertEquals("(A B B C A F )", lv.toString());
		Assert.assertEquals("(B C F A B A )", lv.toStringEvenOdd());
	}

	@Test
	public void test_oddToString2() throws Exception{
		lista.addLast("A");
		lista.addLast("B");
		lista.addLast("C");
		lista.addLast("D");
		lista.addLast("E");
		lista.addLast("F");
		lista.addLast("G");
		Assert.assertEquals("(A B C D E F G )", lista.toString());
		Assert.assertEquals("(B D F G E C A )", lista.toStringEvenOdd());
	}

}
