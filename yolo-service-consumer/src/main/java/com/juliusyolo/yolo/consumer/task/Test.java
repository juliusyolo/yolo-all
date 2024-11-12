package com.juliusyolo.yolo.consumer.task;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Julius Wong
 * <p>
 * 1
 * <p>
 * @since 1
 */
public class Test {

    public static void main(String[] args) {


//        AtomicInteger count = new AtomicInteger(0);
//        System.out.println(count.get());
//        inc(count);
//        System.out.println(count.get());
//
//        System.out.println(new Test().subList(new int[]{1, 1, 2, 4, 5, 6}, 6));


     //   System.out.println(new Test().exist(new char[][]{{'A','B','C','E'},{'S','F','C','S',},{'A','D','E','E'}}, "ABCCED"));

        System.out.println(new Test().exist(new char[][]
                        {{'b','b','a','a','b','a'},{'b','b','a','b','a','a'},{'b','b','b','b','b','b'},{'a','a','a','b','a','a'},{'a','b','a','a','b','b'}}
                , "abbbababaa"));
    }

    // [1,1,2,4,5,6]  6
    public List<List<Integer>> subList(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subResult = new ArrayList<>();
        subList(nums, 0, result, subResult, target);
        return result;
    }

    public static void inc(AtomicInteger count){
        Map<String,String[]> map = new HashMap<>();
        map.put("2",new String[]{"a","b","c"});
        map.put("3",new String[]{"d","e","f"});
        map.put("4",new String[]{"g","b","i"});
        map.put("5",new String[]{"j","k","l"});
        map.put("6",new String[]{"m","n","o"});
        map.put("7",new String[]{"p","q","s"});
        map.put("8",new String[]{"t","u","v"});
        map.put("9",new String[]{"w","x","y","z"});
       count.incrementAndGet();
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        AtomicBoolean existed =  new AtomicBoolean(false);
        for(int i = 0;i<m;i++){
            for(int j=0;j<n;j++){
                visited[i][j] = true;
                backtrace(board,word,board[i][j] + "",visited,i,j,existed);
                visited[i][j] = false;
            }
        }
        return existed.get();
    }

    public void backtrace(char[][] board,String word,String current,boolean[][] visited,int row,int col,AtomicBoolean existed){
        if(current.equals(word)){
            existed.set(true);
        }else{
            if(row + 1 < board.length&&!visited[row+1][col]){
                visited[row+1][col] = true;
                backtrace(board,word,current + board[row+1][col],copyVisited(visited),row+1,col,existed);
                visited[row+1][col] = false;
            }
            if(row - 1 >=0&&!visited[row-1][col]){
                visited[row-1][col] = true;
                backtrace(board,word,current + board[row-1][col],copyVisited(visited),row-1,col,existed);
                visited[row-1][col] = false;
            }
            if(col + 1 < board[0].length&&!visited[row][col+1]){
                visited[row][col+1] = true;
                backtrace(board,word,current + board[row][col+1],copyVisited(visited),row,col+1,existed);
                visited[row][col+1] = false;
            }
            if(col - 1 >= 0 &&!visited[row][col-1]){
                visited[row][col-1] = true;
                backtrace(board,word,current + board[row][col-1],copyVisited(visited),row,col-1,existed);
                visited[row][col-1] = false;
            }

        }
    }
    public boolean[][] copyVisited(boolean[][] visited){
        int m = visited.length;
        int n = visited[0].length;
        boolean [][] copyVisited = new boolean[m][n];
        for(int i = 0;i<m;i++){
            copyVisited[i] = Arrays.copyOf(visited[i],visited[i].length);
        }
        return copyVisited;
    }

    public void subList(int[] nums, int index, List<List<Integer>> result, List<Integer> subResult, int target) {
        if (index <= nums.length - 1 ) {
            if (nums[index] == target){
                subResult.add(nums[index]);
                result.add(subResult);
            }else {
                subResult.add(nums[index]);
                subList(nums, index + 1, result,new ArrayList<>(subResult) , target - nums[index]);
                subResult.remove(Integer.valueOf(nums[index]));
                subList(nums, index + 1, result, new ArrayList<>(subResult), target);
            }
        }
    }
}
