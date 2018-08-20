package com.acme.algorithm;

public class RankNode {

	public int data;
	public int leftSize;
	public RankNode left, right;
	
	public RankNode(int d) {
		data = d;
	}

	public void insert(int n) {
		if(n <= data) {
			if(left == null) {
				left = new RankNode(n);
			}else {
				left.insert(n);
			}
			leftSize++;
		}else {
			if(right == null) {
				right = new RankNode(n);
			}else {
				right.insert(n);
			}
		}
	}
	
	public int getRank(int d) {
		if(d == data) {
			return leftSize;
		}
		if(d < data) {
			if(left == null) return -1;
			return left.getRank(d);
		}else {
			int rightRank = (right == null)? -1: right.getRank(d);
			if(rightRank == -1) return -1;
			else return leftSize + 1 + rightRank;
		}
	}
}
