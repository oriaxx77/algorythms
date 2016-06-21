package com.oriaxx77.algorythm.knapsack;

public class Item {
	private int weight;
	private int value;
	
	public Item(int value,int weight) {
		super();
		this.value = value;
		this.weight = weight;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public int getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "Item [weight=" + weight + ", value=" + value + "]";
	}
	
	
}
