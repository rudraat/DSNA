public class LinkedList < T >{

    private int size;
    private Node<T> head;
    private Node<T> last;

    private static class Node<T> {
        T value;
        Node<T> next;



        Node(T data){
            value = data;
            next = null;
        }
    }

    LinkedList(){
    }

    public boolean isEmpty(){
        return(size == 0);
    }

    public int getSize(){
        return size;
    }

    public T front(){

        return head.value;
    }

    public T back(){

        return last.value;
    }

    public void push_front(T element) {
        Node<T> pushed = new Node<>(element);

        pushed.next = head;
        head = pushed;
        pushed = null;
        size++;
    }

    public T pop_front() {

        if(head == null){
            //error;
            return null;
        }

            T vToPop = head.value;
            head = head.next;
            size--;
            return vToPop;
    }

    public void push_back(T element) {
        Node<T> pushed = new Node<>(element);

        last.next = pushed;
        last = pushed;
        pushed = null;
        size++;
    }

    public T pop_back() {

        Node<T> beforeLast = head;
        T vToPop = last.value;

        while(beforeLast.next != last){
            beforeLast = beforeLast.next;
        }

        last = beforeLast;
        beforeLast.next = null;
        size--;
        return vToPop;

    }

    public void insert(T element, int pos){

    }

    public void erase(int pos){

    }

    public void swap(LinkedList<T> first, LinkedList<T> second) {
        LinkedList<T> temp = first;

        first = second;
        second = temp;

    }

    public void resize(int nsize) {
        if(nsize >= size) return;
        int i = 0;
        Node<? extends T> current = this.head;


        while(i < nsize){
            current = current.next;
            i++;
        }
        size = nsize;
        current.next = null;
    }

    public void clear() {
        this.size = 0;
        this.head = null;
    }

    public void remove( T val) {
        LinkedList<T> temp = new LinkedList<>();
        Node<T> curr = head;

        while (curr.next != null){
            if(curr.value.equals(val)){
                temp.push_back(curr.value);
            }
            curr = curr.next;

        }

        this.head = temp.head;
        temp.head = null;

    }

    public void remove_if() {

    }

    public void unique() {

    }

    public void merge() {

    }

    public void sort() {

    }

    public void reverse() {

    }

}
