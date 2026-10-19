public class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val){
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {

    int capacity;
    private HashMap<Integer, Node> map;
    private Node leftNode;
    private Node rightNode;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.leftNode = new Node(0, 0);
        this.rightNode = new Node(0, 0);
        this.leftNode.next = this.rightNode;
        this.rightNode.prev = this.leftNode;
    }

    private void removeNode(Node node){
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        node.prev = null;
        node.next = null;
    }

    private void insertNode(Node node){
        Node prevNode = this.rightNode.prev;
        prevNode.next = node;
        node.prev = prevNode;
        node.next = this.rightNode;
        this.rightNode.prev = node;
    }
    
    public int get(int key) {
        if(this.map.containsKey(key)){
            Node node = this.map.get(key);
            removeNode(node);
            insertNode(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(this.map.containsKey(key)){
            removeNode(map.get(key));
        }

        Node newNode = new Node(key, value);
        map.put(key, newNode);
        insertNode(newNode);

        if(this.map.size() > this.capacity){
            Node lru = this.leftNode.next;
            removeNode(lru);
            this.map.remove(lru.key);
        }
    }
}
