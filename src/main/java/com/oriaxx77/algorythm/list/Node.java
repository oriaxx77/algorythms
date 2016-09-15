package com.oriaxx77.algorythm.list;

public class Node<T> {
	private T value;
	private Node<T> next;
	
	public Node( T value, Node<T> next){
		this.value = value;
		this.next = next;
	}

	public T getValue() {
		return value;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}

	@Override
	public int hashCode() {
        int hashCode = 1;
        Node<T> node = this;
        while ( node != null ){
            hashCode = 31*hashCode + ( node.getValue() != null ? value.hashCode(): 0) ;
            node = node.getNext();
        }
        return hashCode;
    }

	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
	
		Node<T> other = (Node) obj;
		Node<T> node = this;
		
		while ( node != null && other !=null ){
			
			if ( (other.getValue() == null && node.getValue() != null) ||
				 (other.getValue() != null && node.getValue() == null ) || 
				 (! other.getValue().equals( node.getValue() ))) {
				return false;
			}
		
			node = node.next;
			other = other.next;
		}
		
		if ( (node == null && other != null) ||
			 (node != null && node == null ) ){
			return false;
		}
		
		return true;
	}
	
	
	
	
}
