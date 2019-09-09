import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BinarySerchTree {
    private static class Node{
        int key;
        int value;

        Node left;
        Node right;
    }
    private Node root = null;

    //查找
    public int get(int key){
        Node cur = root;
        while (cur != null){
            if(key == cur.key){
                return cur.value;
            }else if(key < cur.key){
                cur = cur.left;
            }else{
                cur = cur.right;
            }
        }
        return -1;
    }

    //插入
    public int put(int key,int value){
        if(root == null){
            root = new Node();
            root.key = key;
            root.value = value;
            return -1;
        }

        Node parent = null;
        Node cur = root;
        while(cur != null){
            if(key == cur.key){
                int oldValue = cur.value;
                cur.value = value;
                return oldValue;
            }else if(key < cur.key){
                parent = cur;
                cur = cur.left;
            }else{
                parent = cur;
                cur = cur.right;
            }
        }

        Node node = new Node();
        node.key = key;
        node.value = value;
        if(key < parent.key){
            parent.left = node;
        }else {
            parent.right = node;
        }
       return -1;
    }

    public int getOrDefault(int key, int defaultValue){
        Node cur = root;
        while (cur != null){
            if(key == cur.key){
                return cur.value;
            }else if(key < cur.key){
                cur = cur.left;
            }else{
                cur = cur.right;
            }
        }
        return defaultValue;
    }

    public Set<Integer> keySet(){
        Set<Integer> result = new HashSet<>();
        if(root == null){
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node front = queue.poll();
            result.add(front.key);
            if(front.left != null){
                queue.add(front.left);
            }
            if(front.right != null){
                queue.add(front.right);
            }
        }
        return result;
    }


}
