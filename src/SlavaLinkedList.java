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
        final Node<E> newNode = new Node<>(oldLast, e, null);
        mLast = newNode;
        if (oldLast == null)
            mFirst = newNode;
        else
            oldLast.next = newNode;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
//        Node<E> x = mFirst;
        if (size != 0) {
            mFirst = null;
            size--;
            return true;
        } else {
            return false;
        }
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

    }

    @Override
    public E remove(int index) {
        E element;
        Node<E> x = mFirst;
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("demo");
        }

        if (size == 1) {
            element = mFirst.item;
            mFirst = null;
            mLast = null;
            size--;
            return element;
        }

        for (int i = 0; i <= size; i++) {
            if (index == 0) {
                element = mFirst.item;
                mFirst = x.next;
                size--;
                return element;

            }
            if (i == index && index <= size - 2) {
                element = x.next.item;
                x.next = x.next.next;
                size--;
                return element;

            }
            if (i == index && index == size - 1) {
                element = x.next.item;
                x.next = null;
                mLast = x;
                size--;
                return element;

            }
            if (i == 0) {
                continue;
            } else {
                x = x.next;
            }
        }

        return mFirst.item;
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

    Node<E> node(int index) {
        // assert isElementIndex(index);

        if (index < (size >> 1)) {
            Node<E> x = mFirst;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<E> x = mLast;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
