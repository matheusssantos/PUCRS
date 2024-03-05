import java.util.LinkedList;

public class GenericTree<T> {

  private Node root;
  private int count;
  private int height = 0;
  

  public Node searchNodeRef(T element, Node parent) {
    if (parent == null) return null;
    
    if (element == parent.element) return parent;

    Node aux = null;
    final int length = parent.getSubtreeSize();
    for (int i = 0; i < length; i++) {
      aux = this.searchNodeRef(element, parent.getSubtree(i));
      if (aux.element == element) {
        return aux;
      }
    }

    return aux;
  }

  private Node searchByElement(T element) {
    return this.searchNodeRef(element, this.root);
  }

  public boolean add(T element, Node parent) {
    Node aux = this.searchNodeRef(parent.element, this.root);

    if (aux == null) return false;

    aux.parent = parent;
    aux.addSubtree(aux);
    this.count++;
    return true;
  }

  public boolean removeBranch(T element) {
    Node aux = this.searchNodeRef(element, this.root);
    if (aux == null) return false;

    Node parent = aux.parent;
    final boolean removed = parent.removeSubtree(aux);
    aux.parent = null;
    this.count--;

    return removed;
  }





  private class Node {
    T element;
    Node parent;
    LinkedList<Node> subtrees;

    public Node(T element) {
      this.element = element;
      this.parent = null;
      this.subtrees = new LinkedList<>();
    }

    public void addSubtree(Node n) {
      n.parent = this;
      this.subtrees.add(n);
    }

    public boolean removeSubtree(Node n) {
      n.parent = null;
      return this.subtrees.remove(n);
    }


    public Node getSubtree(int index) {
      if (index < 0 || index > this.subtrees.size()) {
        return null;
      }

      return this.subtrees.get(index);
    }

    public int getSubtreeSize() {
      return this.subtrees.size();
    }
  }
}