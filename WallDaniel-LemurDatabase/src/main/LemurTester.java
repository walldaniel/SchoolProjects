package main;

public class LemurTester {

	public static void main(String[] args) {
		TreeLemur treeLemur = new TreeLemur();
		DesertLemur desertLemur = new DesertLemur();
		JungleLemur jungleLemur = new JungleLemur();
		
		System.out.println(treeLemur.toString());
		System.out.println(desertLemur.toString());
		System.out.println(jungleLemur.toString());
	}

}
