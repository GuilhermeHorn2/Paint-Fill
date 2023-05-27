package misc;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;



public class main_misc2 {
	
	
	public static class pixel{
		public String color;
		public boolean visited = false;
		public int x;
		public int y;
		
		public pixel(String c) {
			color = c;
		}
		public void visit(){
			visited = true;
		}
		public void set_color(String c){
			color = c;
		}
		
	}
		
	
	
	public static void main(String[] args) {
	//(a+b)%k = ((a % k)+(b % k)) % k    || ||
	
	
		
		
	}	
	
	/*
	 * You can implement this using depth-first search (or breadth-first search). Each adjacent
       pixel of the "right" color is a connected edge. 
	 */
	
	
	
	private static ArrayList<pixel> adjacent_pixels(ArrayList<ArrayList<pixel>> screen,int x,int y){
		
		ArrayList<pixel> adj = new ArrayList<>();
		
		if(x-1 >= 0){
			adj.add(screen.get(x-1).get(y));
		}
		if(y-1 >= 0) {
			adj.add(screen.get(x).get(y-1));
		}
		if(x+1 < screen.get(x).size()) {
			adj.add(screen.get(x+1).get(y));
		}
		if(y+1 < screen.get(y).size()) {
			adj.add(screen.get(x).get(y+1));
		}
		return adj;
		
	}
	
	private static void change_color(int x,int y,ArrayList<ArrayList<pixel>> screen,String color){
		if(!screen.get(x).get(y).color.equals(color)){
			screen.get(x).get(y).set_color(color);
		}
	}
	
	private static void paint_fill(ArrayList<ArrayList<pixel>> screen,int x,int y,String color){
		
		LinkedList<pixel> queue = new LinkedList<>();
		change_color(x,y,screen,color);
		ArrayList<pixel> adj = adjacent_pixels(screen,x,y);
		queue.addFirst(screen.get(x).get(y));
		
		while(!queue.isEmpty()) {
			pixel p = queue.removeLast();
			
			change_color(p.x,p.y,screen,color);
			
			ArrayList<pixel> p_adj = adjacent_pixels(screen,p.x,p.y);
			
			for(int i = 0;i < p_adj.size();i++){
				if(!p_adj.get(i).visited){
					queue.addFirst(p_adj.get(i));
					p_adj.get(i).visit();
				}
			}
			
		}
		
		
	}
	
	} 
	
