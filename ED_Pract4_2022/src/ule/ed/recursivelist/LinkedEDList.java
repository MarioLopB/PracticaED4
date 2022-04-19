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
			Node<T> aux = getNodePos(this.front, position-1);
			nuevo.next = aux.next;
			aux.next = nuevo;
		}
		
	}

	private Node<T> getNodePos(Node<T> current, int pos){
		Node<T> actual = current;
		if(current.next == null || pos == 1 || pos < this.size()){
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
		int pos = getNFirst(this.front, elem);

		if(pos > this.size()){
			pos = 0;
		}

		return pos;
	}

	private int getNFirst(Node<T> current, T elem){
		int pos;

		if(current == null){
			pos = 1;
		} else if(current.elem.equals(elem)){
			pos = 1;
		}  else{
			pos = 1 + getNFirst(current.next, elem);
		}

		return pos;
	}



	@Override
	public int getPosLast(T elem) {
		// TODO RECURSIVAMENTE
		int pos = getNLast(this.front, elem, nTimes(this.front, elem));

		if(pos > this.size()){
			pos = 0;
		}

		return pos;
	}

	private int nTimes(Node<T> current, T elem){
		int counter;

		if(current == null){
			counter = 0;
		} else if(current.elem.equals(elem)){
			counter = 1 + nTimes(current.next, elem);
		} else{
			counter = nTimes(current.next, elem);
		}

		return counter;
	}

	private int getNLast(Node<T> current, T elem, int nelems){
		int pos;

		if(current == null){
			pos = 0;
		} else if(current.elem.equals(elem) && nelems != 0){
			pos = 1 + getNLast(current.next, elem, nelems-1);
		} else if (nelems == 0){
			pos = 0;
		} else {
			pos = 1 + getNLast(current.next, elem, nelems);
		}

		return pos;
	}



	@Override
	public T removelast() throws EmptyCollectionException {
		// TODO RECURSIVAMENTE

		if(isEmpty())
			throw new EmptyCollectionException("Lista vacia");

		Node<T> aux = PenulElem(this.front);

		T removed = aux.next.elem;

		aux.next = null;

		return removed;

	}

	private Node<T> PenulElem(Node<T> current){
		Node<T> actual = null;
		if(current.next == null || current.next.next == null){
			actual = current;
		} else{
			actual = PenulElem(current.next);
		}

		return actual;
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
