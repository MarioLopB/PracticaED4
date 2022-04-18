package ule.ed.recursivelist;

import java.util.NoSuchElementException;


public class LinkedEDList<T> implements EDList<T> {

	//	referencia al primer  de la lista
	private Node<T> front;

	

	private class Node<T> {

		Node(T element) {
			this.elem = element;
			this.next = null;
		}

		T elem;

		Node<T> next;
	}



	@Override
	public int size() {
		// TODO RECURSIVAMENTE
		return 0;
	}



	@Override
	public boolean isEmpty() {
		// TODO 
		return false;
	}



	@Override
	public void addLast(T elem) {
		// TODO RECURSIVAMENTE
		
	}

	@Override
	public String toString() {
		// TODO RECURSIVAMENTE
	
		return null;
	}

	@Override
	public void addAntePenult(T elem) {
		// TODO RECURSIVAMENTE
		
	}



	@Override
	public void addPos(T elem, int position) {
		// TODO RECURSIVAMENTE
		
	}


	@Override
	public T getElemPos(int position) {
		// TODO RECURSIVAMENTE
		return null;
	}



	@Override
	public int getPosFirst(T elem) {
		// TODO RECURSIVAMENTE
		return 0;
	}



	@Override
	public int getPosLast(T elem) {
		// TODO RECURSIVAMENTE
		return 0;
	}



	@Override
	public T removelast() throws EmptyCollectionException {
		// TODO RECURSIVAMENTE
		return null;
	}



	@Override
	public T removePenult() throws EmptyCollectionException {
		// TODO RECURSIVAMENTE
		return null;
	}



	@Override
	public T removeFirstElem(T elem) throws EmptyCollectionException {
		// TODO RECURSIVAMENTE
		return null;
	}



	@Override
	public T removeLastElem(T elem) throws EmptyCollectionException {
		// TODO RECURSIVAMENTE
		return null;
	}



	@Override
	public EDList<T> reverse() {
		// TODO RECURSIVAMENTE
		return null;
	}



	@Override
	public String toStringFromUntilReverse(int from, int until) {
		// TODO RECURSIVAMENTE
		return null;
	}



	@Override
	public String toStringEvenOdd() {
		// TODO RECURSIVAMENTE
		return null;
	}
	
	
	
	
}
