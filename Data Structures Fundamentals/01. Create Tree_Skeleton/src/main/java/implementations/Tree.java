package implementations;

import interfaces.AbstractTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tree<E> implements AbstractTree<E> {
    private E value;
    private Tree<E> parent;
    private List<Tree<E>> children;

    public Tree(E value, Tree<E>... subtrees) {
        this.value = value;
        this.parent = null;
        this.children = new ArrayList<>();

        for (Tree<E> tree : subtrees) {
            children.add(tree);
            tree.parent = this;
        }
    }

    @Override
    public List<E> orderBfs() {
        List<E> result = new ArrayList<>();
        if (this.value == null) {
            return result;
        }
        ArrayDeque<Tree<E>> childrenQueue = new ArrayDeque<>();

        childrenQueue.offer(this);

        while (!childrenQueue.isEmpty()) {
            Tree<E> current = childrenQueue.poll();

            result.add(current.value);

            for (Tree<E> child : current.children) {
                childrenQueue.offer(child);
            }
        }
        return result;
    }

    @Override
    public List<E> orderDfs() {
        List<E> result = new ArrayList<>();

        this.doDfs(this, result);

//        ArrayDeque<Tree<E>> toTraverse = new ArrayDeque<>();
//
//        toTraverse.push(this);
//
//        while (!toTraverse.isEmpty()) {
//            Tree<E> current = toTraverse.pop();
//            for (Tree<E> child : current.children) {
//                toTraverse.push(child);
//            }
//            result.add(current.value);
//        }

        return result;
    }

    private void doDfs(Tree<E> tree, List<E> result) {
        for (Tree<E> child : tree.children) {
            doDfs(child, result);
        }

        result.add(tree.value);
    }

    @Override
    public void addChild(E parentKey, Tree<E> child) {
        Tree<E> searchedTree = find(parentKey);

        if (searchedTree == null) {
            throw new IllegalArgumentException();
        }

        searchedTree.children.add(child);
        child.parent = searchedTree;
    }

    private Tree<E> find(E parentKey) {
        ArrayDeque<Tree<E>> childrenQueue = new ArrayDeque<>();

        childrenQueue.offer(this);

        while (!childrenQueue.isEmpty()) {
            Tree<E> current = childrenQueue.poll();

            if (current.value.equals(parentKey)) {
                return current;
            }

            for (Tree<E> child : current.children) {
                childrenQueue.offer(child);
            }
        }

        return null;
    }

    @Override
    public void removeNode(E nodeKey) {
        Tree<E> nodeToRemove = find(nodeKey);

        if (nodeToRemove == null) {
            throw new IllegalArgumentException();
        }

        for (Tree<E> child : nodeToRemove.children) {
            child.parent = null;
        }
        nodeToRemove.children.clear();
        Tree<E> parent = nodeToRemove.parent;

        if (parent != null) {
            parent.children.remove(nodeToRemove);
        }

        nodeToRemove.value = null;
    }

    @Override
    public void swap(E firstKey, E secondKey) {
        Tree<E> firstNode = find(firstKey); //7
        Tree<E> secondNode = find(secondKey); //14

        if (firstNode == null || secondNode == null) {
            throw new IllegalArgumentException();
        }

        Tree<E> firstParent = firstNode.parent;
        Tree<E> secondParent = secondNode.parent;

        if (firstParent == null) {
            swapRoots(secondNode);
            secondNode.parent = null;
            return;
        } else if (secondParent == null) {
            swapRoots(firstNode);
            firstNode.parent = null;
            return;
        }

        int firstIndex = firstParent.children.indexOf(firstNode);
        int secondIndex = secondParent.children.indexOf(secondNode);

        firstParent.children.set(firstIndex, secondNode);
        secondParent.children.set(secondIndex, firstNode);
    }

    private void swapRoots(Tree<E> node) {
        this.value = node.value;
        this.parent = null;
        this.children = node.children;
    }
}



