package LC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
	static class Node{
		public String str;
		public Node parent;
		
		public Node(String str,Node parent) {
			this.str=str;
			this.parent = parent;
		}
	}
	public static boolean DistanceEqual1(String s1,String s2) {
		//如果传入String只有一个长度，说明距离必定为1
		if(s1.length()==1) return true;
		int Distance=0;
    	

		for(int i=0;i<s1.length();i++) {
			if(s1.charAt(i)==s2.charAt(i)) Distance++;
		}
		if(Distance==s1.length()-1) return true;
		else return false;
	}
	
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
    	//先判断wordList里面有没有endWord，没有的话直接返回，不可能成功
    	if(!wordList.contains(endWord)) return 0;
    	else if(wordList.contains(endWord) && beginWord.length()==1) return 2;
    	//有的话先将第一个Node加入队列
    	List<Node> queue = new ArrayList<Node>();
    	//用这个存储是否已被搜索
    	List<String> queue1 = new ArrayList<String>();
    	//把beginWord存入队列
    	queue.add(new Node(beginWord,null));

    	//开始进行遍历
    	while(!queue.isEmpty()) {
    		//先取出第一个
    		Node temp = queue.get(0);
    		//判断这是不是endword
    		if(temp.str.equals(endWord)) {
    			int index=0;
    			//输出parent的长度
    			while(temp!=null) {
    				temp = temp.parent;
    				index++;
    			}
    			return index;
    		}
    		
    		//首先判断已搜索队列里有没有
			if(queue1.contains(temp.str)) {
				queue.remove(temp);
				continue;
			}else {
				//加上已经遍历标识
				queue1.add(temp.str);

    			//找wordList里离temp距离为1的加入队列，index+1
    			for(String str:wordList) {
    				if(DistanceEqual1(str,temp.str)) {
    					queue.add(new Node(str,temp));
    				}
    			}
    		}
    		//让它出队列
    		queue.remove(0);
    	}
    	return 0;
    }
    
    
    public static void main(String[] args) {
    	String begin = "hit";
    	String end = "cog";
    	List<String> list =new ArrayList<String>();

    	list.add("hot"); 
    	list.add("dot"); 
    	list.add("dog");
    	list.add("lot");
    	list.add("log");
    	list.add("cog");
    	System.out.println(ladderLength(begin,end,list));
    }
}
