package ule.ed.recursivelist;

import java.beans.PropertyEditorSupport;
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
		int num = nsize(this.front);
		return num;
	}

	private int nsize(Node<T> current){
		int size;

		if(current == null){
			size = 0;
		} else{
			size = 1 + nsize(current.next);
		}

		return size;
	}



	@Override
	public boolean isEmpty() {
		// TODO 
		return this.front == null;
	}



	@Override
	public void addLast(T elem) {
		// TODO RECURSIVAMENTE
		if(elem == null)
			throw new NullPointerException();

		Node<T> nuevo = new Node<T>(elem);

		if(isEmpty()){
			this.front = nuevo;
		} else{
			Node<T> last = LastElem(front);
			last.next = nuevo;
		}
	}

	private Node<T> LastElem(Node<T> current){
		Node<T> actual = null;
		if(current == null || current.next == null){
			actual = current;
		} else{
			actual = LastElem(current.next);
		}

		return actual;
	}

	@Override
	public String toString() {
		// TODO RECURSIVAMENTE
		StringBuffer cadena = new StringBuffer();

		cadena.append("(");
		cadena.append(toStringElems(this.front));
		cadena.append(")");
	
		return cadena.toString();
	}

	private String toStringElems(Node<T> current){
		StringBuffer cadena = new StringBuffer();

		if(current == null){
			cadena.append("");
		} else {
			cadena.append(current.elem + " " + toStringElems(current.next));
		}

		return cadena.toString();
	}


	@Override
	public void addAntePenult(T elem) {
		// TODO RECURSIVAMENTE
		Node<T> nuevo = new Node<T>(elem);

		if(isEmpty()){
			this.front = nuevo;
		} else if(this.front.next == null || this.front.next.next == null){
			nuevo.next = this.front;
			this.front = nuevo;
		} else{
			Node<T> ante = getAntePenult(this.front);
			nuevo.next = ante.next;
			ante.next = nuevo;
		}
		
	}

	private Node<T> getAntePenult(Node<T> current){
		Node<T> actual = null;

		if(current.next == null || current.next.next.next == null){
			actual = current;
		} else {
			actual = getAntePenult(current.next);
		}

		return actual;
	}



	@Override
	public void addPos(T elem, int position) {
		// TODO RECURSIVAMENTE

		Node<T> nuevo = new Node<T>(elem);

		if(isEmpty()){
			this.front= nuevo;
		} else{
			Node<T> aux = getNodePos(this.front, position);
			nuevo.next = aux.next;
		}
		
	}

	private Node<T> getNodePos(Node<T> current, int pos){
		Node<T> actual = current;
		if(current == null || pos == 1){
			actual = current;
		} else{
			actual = getNodePos(current.next, pos-1);
		}

		return actual;
	}


	@Override
	public T getElemPos(int position) {
		// TODO RECURSIVAMENTE
		return getElem(front, position);
	}

	private T getElem(Node<T> current, int pos){
		T result;


		if(current == null || pos == 1){
			result = current.elem;
		} else {
			result = getElem(current.next, pos-1);
		}

		return result;
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

		if(isEmpty())
			throw new EmptyCollectionException("Lista vacia");

		T removed = null;

		if(this.front.next == null){
			removed = this.front.elem;
			this.front = null;
		} else{
			removed = this.front.elem;
			this.front = this.front.next;
		}

		return removed;
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
