class AvlTree<AnyType extends Comparable<? super AnyType>> {
    private static final int ALLOWED_IMBALANCE = 1;
    private AvlNode<AnyType> root;// корневой узел

    public AvlTree() {
        root = null;
    }

    // Гашение
    public void makeEmpty() {
        root = null;
    }

    // Определяем, равно ли оно нулю
    public boolean isEmpty() {
        return root == null;
    }

    // Определяем, содержит ли порода дерева элемент x
    public boolean contains(AnyType x) {
        return contains(x, root);
    }

    // Находим наименьший элемент в дереве и возвращаем
    public AnyType findMin() throws Exception {
        if (isEmpty()) {
            throw new Exception();
        }
        return findMin(root).element;
    }

    // Находим самый большой элемент в дереве и возвращаем
    public AnyType findMax() throws Exception {
        if (isEmpty()) {
            throw new Exception();
        }
        return findMax(root).element;
    }

    // вставляем элемент x
    public void insert(AnyType x) {
        root = insert(x, root);
    }

    // удаляем элемент x
    public void remove(AnyType x) {
        root = remove(x, root);
    }

    // распечатать дерево
    public void printTree() {
        if (isEmpty()) {
            System.out.println("Пустое дерево");
        } else {
            printTree(root);
        }
    }

    // Распечатать дерево ---- "Обход по порядку
    private void printTree(AvlNode<AnyType> node) {
        if (node != null) {
            printTree(node.leftNode);
            System.out.print(node.element + " ");
            printTree(node.rightNode);
        }
    }

    // возвращает высоту дерева
    private int height(AvlNode<AnyType> node) {
        return node == null ? -1 : node.height;
    }

    // Вставляем узел x в дерево
    private AvlNode<AnyType> insert(AnyType x, AvlNode<AnyType> node) {
        if (node == null) {
            return new AvlNode<AnyType>(x, null, null);
        }
        int compareResult = x.compareTo(node.element);

        if (compareResult < 0) {
            node.leftNode = insert(x, node.leftNode);
        } else if (compareResult > 0) {
            node.rightNode = insert(x, node.rightNode);
        } else {
            ;
        }
        return balance(node);// балансируем дерево
    }

    // балансируем дерево
    private AvlNode<AnyType> balance(AvlNode<AnyType> node) {
        if (node == null) {
            return node;
        }
        // Разница в высоте между левым поддеревом и правым поддеревом превышает 1
        if (height(node.leftNode) - height(node.rightNode) > ALLOWED_IMBALANCE) {
            if (height(node.leftNode.leftNode) >= height(node.leftNode.rightNode)) {
                node = rotateWithLeftChild(node);
            } else {
                node = doubleWithLeftChild(node);
            }
        } else {
            if (height(node.rightNode) - height(node.rightNode) > ALLOWED_IMBALANCE) {
                if (height(node.rightNode.rightNode) >= height(node.rightNode.leftNode)) {
                    node = rotateWithRightChild(node);
                } else {
                    node = doubleWithRightChild(node);
                }
            }
        }
        node.height = Math.max(height(node.leftNode), height(node.rightNode));
        return node;
    }

    // удаляем узел x
    private AvlNode<AnyType> remove(AnyType x, AvlNode<AnyType> node) {
        if (node == null) {
            return node;
        }
        int compareResult = x.compareTo(node.element);
        if (compareResult < 0) {
            node.leftNode = remove(x, node.leftNode);
        } else if (compareResult > 0) {
            node.rightNode = remove(x, node.rightNode);
        } else if (node.leftNode != null && node.rightNode != null) {
            node.element = findMin(node.rightNode).element;
            node.rightNode = remove(node.element, node.rightNode);
        } else {
            node = (node.leftNode != null) ? node.leftNode : node.rightNode;
        }
        return balance(node);
    }

    // Одно вращение ---> Соответствующий дисбаланс: ---> Высота левого узла левого поддерева больше высоты правого узла левого поддерева
    private AvlNode<AnyType> rotateWithLeftChild(AvlNode<AnyType> k2) {
        AvlNode<AnyType> k1 = k2.leftNode;
        k2.leftNode = k1.rightNode;
        k1.rightNode = k2;
        k2.height = Math.max(height(k2.leftNode), height(k2.rightNode)) + 1;
        k1.height = Math.max(height(k1.leftNode), k2.height) + 1;
        return k1;
    }

    // Одиночное вращение ---> Соответствующий дисбаланс: ---> Высота правого узла правого поддерева больше, чем высота левого узла правого поддерева
    private AvlNode<AnyType> rotateWithRightChild(AvlNode<AnyType> k2) {
        AvlNode<AnyType> k1 = k2.rightNode;
        k2.rightNode = k1.leftNode;
        k1.leftNode = k2;
        k2.height = Math.max(height(k2.rightNode), height(k2.leftNode)) + 1;
        k1.height = Math.max(height(k1.rightNode), k2.height) + 1;
        return k1;
    }

    // Двойное вращение ---> Соответствующий дисбаланс: ---> Высота левого узла левого поддерева меньше высоты правого узла левого поддерева
    private AvlNode<AnyType> doubleWithLeftChild(AvlNode<AnyType> k3) {
        k3.leftNode = rotateWithLeftChild(k3.leftNode);
        return rotateWithLeftChild(k3);
    }

    // Двойное вращение ---> Соответствующий дисбаланс: ---> Высота правого узла правого поддерева меньше высоты правого узла правого поддерева
    private AvlNode<AnyType> doubleWithRightChild(AvlNode<AnyType> k3) {
        k3.rightNode = rotateWithLeftChild(k3.rightNode);
        return rotateWithLeftChild(k3);
    }

    // В зависимости от природы дерева, самый большой элемент в дереве находится в дальней правой части дерева
    private AvlNode<AnyType> findMax(AvlNode<AnyType> node) {
        if (node != null) {
            while (node.rightNode != null) {
                node = node.rightNode;
            }
        }
        return node;
    }

    // В соответствии с природой дерева поиска наименьший элемент находится слева
    private AvlNode<AnyType> findMin(AvlNode<AnyType> node) {
        if (node == null) {
            return null;
        } else if (node.leftNode == null) {
            return node;
        }
        return findMin(node.leftNode);
    }

    // находим элемент x
    private boolean contains(AnyType x, AvlNode<AnyType> node) {
        if (node == null) {
            return false;
        }
        int compareResult = x.compareTo(node.element);
        if (compareResult < 0) {
            return contains(x, node.leftNode);// Находим левое поддерево
        } else if (compareResult > 0) {
            return contains(x, node.rightNode);// Находим правильное поддерево
        } else {
            return true;
        }
    }

    // класс узла --- внутренний класс
    private static class AvlNode<AnyType> {
        AnyType element;
        AvlNode<AnyType> leftNode;
        AvlNode<AnyType> rightNode;
        int height;// Высота узла

        public AvlNode(AnyType element) {
            this(element, null, null);
        }

        public AvlNode(AnyType theElment, AvlNode<AnyType> lNode, AvlNode<AnyType> rNode) {
            element = theElment;
            leftNode = lNode;
            rightNode = rNode;
            height = 0;
        }

    }

    public void traverseInOrder(AvlNode node) {
        if (node != null) {
            traverseInOrder(node.leftNode);
            System.out.print(" " + node.element);
            traverseInOrder(node.rightNode);
        }
    }
    public void  inOrder(){
        traverseInOrder(root);
    }

    //нисходящий
    public void traversePreOrder(AvlNode node) {
        if (node != null) {
            System.out.print(" " + node.element);
            traversePreOrder(node.leftNode);
            traversePreOrder(node.rightNode);
        }
    }
    public void  preOrder(){
        traversePreOrder(root);
    }

    //восходящий
    public void traversePostOrder(AvlNode node) {
        if (node != null) {
            traversePostOrder(node.leftNode);
            traversePostOrder(node.rightNode);
            System.out.print(" " + node.element);
        }
    }
    public void  postOrder(){
        traversePostOrder(root);
    }
}

