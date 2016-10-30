package ru.game.frameHeaderFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFS {
	private static final int ARRAY_LENGHT = 9;
	private static List<ArrayList<Integer>> collection;
	private static boolean []used;
	private static int start;
	private static int end;
	//private int [][]mas=new int[ARRAY_LENGHT][ARRAY_LENGHT];
	public static boolean dfs(int [][]mas,int startI,int startJ,int endI,int endJ){
		start=(startI*ARRAY_LENGHT)+startJ;
		end=(endI*ARRAY_LENGHT)+endJ;
		
		//System.out.println(start);
		//System.out.println(end);
		collection=new ArrayList<ArrayList<Integer>>(ARRAY_LENGHT * ARRAY_LENGHT);
		
		used=new boolean[ARRAY_LENGHT*ARRAY_LENGHT];
		
		for(int i=0;i<mas.length;i++){
			for(int j=0;j<mas[i].length;j++){
				mas[i][j]=mas[i][j];
			}
		}
		initGraf(mas,start);
		
		boolean result=checkGref(start, end);
		
		System.gc();
		
		return result;
	}
	
	private static void initGraf(int [][]mas,int start){
		ArrayList<Integer> col;
		for (int i = 0; i < mas.length; i++) {
			for (int j = 0; j < mas[i].length; j++) {
				col = new ArrayList<Integer>();
				if(mas[i][j]==0||start==((i*ARRAY_LENGHT)+j)){
					// 1
					if (i - 1 >= 0) {
						if (mas[i - 1][j] == 0)
							col.add(((i - 1) * ARRAY_LENGHT) + j);
					}
					// 2
					if (j + 1 < ARRAY_LENGHT) {
						if (mas[i][j + 1] == 0)
							col.add((i * ARRAY_LENGHT) + (j + 1));
					}
					// 3
					if (i + 1 < ARRAY_LENGHT) {
						if (mas[i + 1][j] == 0)
							col.add(((i + 1) * ARRAY_LENGHT) + j);
					}
					// 4
					if (j - 1 >= 0) {
						if (mas[i][j - 1] == 0)
							col.add((i * ARRAY_LENGHT) + (j - 1));
					}
				}
				collection.add(col);
			}
		}
		//artacel graf@ List-i tesqov
		/*
		for(int i=0;i<collection.size();i++){
			System.out.println(i+"-->"+collection.get(i));
		}*/
	}
	private static boolean checkGref(int start,int end){
		Stack<Integer> stack=new Stack<Integer>();
		DFS(start,stack);
		
		if(stack.contains(end))
			return true;
		else
			return false;
	}
	private static void DFS(int v,Stack<Integer> stack){
		if(used[v])return;
		
		used[v]=true;
		
		stack.add(v);
			
		for(int i=0;i<collection.get(v).size();i++){
			DFS(collection.get(v).get(i),stack);
		}
	}

}
