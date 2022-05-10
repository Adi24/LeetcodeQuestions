import java.util.*;

public class WordSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
		char[][] board = {{'a','b','c'},{'a','e','d'},{'a','f','g'}};
		
		String wordToSearch = "eat";
		
	//	String[] words = {"oath","pea","eat","rain"};
//		String[] words = {"abcdefg","gfedcbaaa","eaabcdgfa","befa","dgc","ade"};
		String[] words = {"abcdefg"};	

		List<String> finalResult = new ArrayList<>();
		
	//	boolean answer = solve(board, wordToSearch);
	//	System.out.println("Final result is ::"+ answer);
		
		for(int i=0 ; i<words.length; i++) {
			boolean check = solve(board, words[i]);
			
			if(check) {
				finalResult.add(words[i]);
			}
			
			for(int a =0; a<board.length; a++) {
				for(int b=0; b<board[a].length; b++) {
					System.out.print(board[a][b] + " ");
				}
				
				System.out.println("\n");
			}
			
		}
		
		System.out.println("Final list is ::"+finalResult);
		
		
	}
	
	public static boolean solve(char[][] board, String wordToSearch) {

		boolean result = false;
		for(int i = 0; i<board.length; i++) {
			for(int j=0; j<board[i].length; j++) {
				
					if(board[i][j] == wordToSearch.charAt(0)) {
						result = dfs(board, i, j, 0, wordToSearch);
						if(result) {
							return result;
						}

					}					
			}
		}
		
		return result;
	}
	
	

	private static boolean dfs(char[][] board, int i, int j , int count, String wordToSearch) {
		// TODO Auto-generated method stub
		
		if(count == wordToSearch.length()) {
			return true;
		}
		
		if(i<0 || i>=board.length || j<0 || j>=board[i].length || board[i][j]!=wordToSearch.charAt(count)) {
			return false;
		}
		
		char temp = board[i][j];
		board[i][j] = '0';
		
		if(dfs(board, i+1, j, count+1, wordToSearch) 
				|| dfs(board, i-1, j , count+1, wordToSearch)
				|| dfs(board, i, j+1, count+1, wordToSearch)
				|| dfs(board, i, j-1, count+1, wordToSearch)) {
	//		board[i][j] = wordToSearch.charAt(count);
			board[i][j] = temp;
			
			return true;
		}
		
//		board[i][j] = wordToSearch.charAt(count);
		board[i][j] = temp;
		
		return false;
	}

}
