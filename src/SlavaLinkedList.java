import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class SlavaLinkedList<E> implements List<E> {

    private transient int size = 0;
    private transient Node<E> mFirst;
    private transient Node<E> mLast;

    public SlavaLinkedList() {
    }

    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super E> action) {

    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        final Node<E> oldLast = mLast;
        final Node<E> newNode = new Node<>(e, null);
        mLast = newNode;
        if (oldLast == null)
            mFirst = newNode;
        else
            oldLast.next = newNode;
        size++;
        return true;
    }

    private E destroy(Node<E> xPrev, Node<E> x) {
        Node<E> next = x.next;

        if (xPrev == null) {
            mFirst = mFirst.next;
        } else {
            xPrev.next = x.next;
        }

        if (next == null) {
            mLast = xPrev;
        } else if (xPrev != null) {
            xPrev.next = x.next;
        }

        size--;
        return x.item;
    }

    @Override
    public boolean remove(Object o) {
        Node<E> x = mFirst;
        Node<E> xPrev = null;
        for (int i = 0; i <= size - 1; i++, x = x.next) {
            if (o == null) {
                if (x.item == null) {
                    destroy(xPrev, x);
                    return true;
                }
            } else {
                if (x.item != null && o.equals(x.item)) {
                    destroy(xPrev, x);
                    return true;
                }
            }

            if (i == 0) {
                xPrev = mFirst;
            } else {
                xPrev = xPrev.next;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeIf(Predicate<? super E> filter) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void replaceAll(UnaryOperator<E> operator) {

    }

    @Override
    public void sort(Comparator<? super E> c) {

    }

    @Override
    public void clear() {
        mFirst = null;
        mLast = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("demo");
        }
        if (index == 0) {
            return mFirst.item;
        } else {
            Node<E> x = mFirst;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            return x.item;
        }
    }

    @Override
    public E set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("demo");
        } else {
            Node<E> x = mFirst;
            for (int i = 1; i <= index; i++) {
                x = x.next;
            }
            return x.item = element;
        }
    }

    @Override
    public void add(int index, E element) {
        if (size == index) {
            add(element);
            return;
        }

        Node<E> x = mFirst;
        Node<E> xPrev = null;
        Node<E> newX = new Node<E>(element, x.next);
        for (int i = 0; i < size; i++) {
            if (index == i) {
                if (index == 0){
                    mFirst = newX;
                } else {
                    xPrev.next = newX;
                }
                newX.next = x;
                break;
            }
            xPrev = x;
            x = x.next;
        }
        size++;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("demo");
        }

        Node<E> x = mFirst;
        Node<E> xPrev = null;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                return destroy(xPrev, x);
            }
            xPrev = x;
            x = x.next;
        }

        throw new IllegalStateException("Should never come here");
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        checkPositionIndex(index);
        return null; // new SlavaListIterator(index);
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public Spliterator<E> spliterator() {
        return null;
    }

    @Override
    public Stream<E> stream() {
        return null;
    }

    @Override
    public Stream<E> parallelStream() {
        return null;
    }

    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }


//    private class SlavaListIterator implements ListIterator<E>{
//        private Node<E> lastReturned;
//        private Node<E> next;
//        private int nextIndex;
//        private int expectedModCount = modCount;
//
//        SlavaListIterator(int index){
//            if (index == size) {
//                next = null;
//            } else {
//                next = node(index);
//            }
//
//            nextIndex = index;
//        }
//
//        @Override
//        public boolean hasNext() {
//            return false;
//        }
//
//        @Override
//        public E next() {
//            return null;
//        }
//
//        @Override
//        public boolean hasPrevious() {
//            return false;
//        }
//
//        @Override
//        public E previous() {
//            return null;
//        }
//
//        @Override
//        public int nextIndex() {
//            return 0;
//        }
//
//        @Override
//        public int previousIndex() {
//            return 0;
//        }
//
//        @Override
//        public void remove() {
//
//        }
//
//        @Override
//        public void set(E e) {
//
//        }
//
//        @Override
//        public void add(E e) {
//
//        }
//    }

//    Node<E> node(int index) {
//        // assert isElementIndex(index);
//
//        if (index < (size >> 1)) {
//            Node<E> x = mFirst;
//            for (int i = 0; i < index; i++)
//                x = x.next;
//            return x;
//        } else {
//            Node<E> x = mLast;
//            for (int i = size - 1; i > index; i--)
//                x = x.prev;
//            return x;
//        }
//    }

    private static class Node<E> {
        E item;
        Node<E> next;

        Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }
}
