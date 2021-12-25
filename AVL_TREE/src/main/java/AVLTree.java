/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author A. Enes
 */
public class AVLTree {
    Node root;
    
    /*
    >N'nin "height" parametresini döndürür. N null ise 0 döndürülür.
    */
    int height(Node N) {
        if (N == null)
            return 0;
        return N.height;
    }
    /*
    >a ile b değerlerinin büyük olanını döndürür.
    */
    int max(int a, int b) {
        return (a > b) ? a : b;
    }
    
    /*
    >y Node'unun sol child'ı x'e atanır.
    >x(y'nin sol child'ı)'in sağ child'ı T2'de tutulur.
    >x(y'nin sol child'ı)'in yeni sağ child'ı olarak y Node'u atanır.
    >y Node(x'in yeni sağ child'ı)'unun sol child'ına T2(x'in eski sağ child'ı) atanır.
    > y Node'unun "height" değeri yeni düzene göre güncellenir.
    > x Node'unun "height" değeri yeni düzene göre güncellenir.
    > x Node'u döndürülür.
    */
    Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;
        x.right = y;
        y.left = T2;
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;
        return x;
    }
    
    /*
    >x Node'unun sağ child'ı y'ye atanır.
    >y(x'in sağ child'ı)'nin sol child'ı T2'de tutulur. 
    >y(x'in sağ child'ı)'nin yeni sol child'ı olarak x Node'u atanır.
    >y Node(x'in yeni sağ child'ı)'unun sol child'ına T2(x'in eski sağ child'ı) atanır.
    > x Node'unun "height" değeri yeni düzene göre güncellenir.
    > y Node'unun "height" değeri yeni düzene göre güncellenir.
    > y Node'u döndürülür.
    */
    Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;
        y.left = x;
        x.right = T2;
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;
        return y;
    }

    /*
    >N'nin sol derinliği sağ derinliğinden çıkaralır ve sonuç dönürülür. Eğer
        N null ise 0 döndürülür.
    */
    
    int getBalanceFactor(Node N) {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }

    
    Node insertNode(Node node, int item) {
        /*
        >(node == null) koşulu: node(Parent) null ise item'den bir node 
            oluşturulur, kök olarak atanır ve sonuç döndürülür.
        >(item < node.item) koşulu: node(Parent)'da depolanan item eklenecek
            itemden büyük ise recursion uygulanır ve döndürülen sonuç node(Parent)'un
            soluna atanır .
        >(item > node.item) koşulu: node(Parent)'da depolanan item eklenecek
            itemden küçük ise recursion uygulanır ve döndürülen sonuç node(Parent)'un
            sağına atanır .
        */
        if (node == null)
            return (new Node(item));
        if (item < node.item)
            node.left = insertNode(node.left, item);
        else if (item > node.item)
            node.right = insertNode(node.right, item);
        else
            return node;
        /*
        >söz konusu node'un derinliği güncellenir.(Recursive func. olduğu için 
            tüm parent node'lar etkilenir.)
        >ağacın dengesi sorgulanır.
        */
        node.height = 1 + max(height(node.left), height(node.right));
        int balanceFactor = getBalanceFactor(node);
        /*
        >denge'nin mutlak değeri 1'den büyükse rightRotate veya leftRotate
            işlemleri işlemi uygulanarak ağaç dengesi sağlanır.
        */
        if (balanceFactor > 1) {
            /*
            >(item < node.left.item) koşulu: node(Parent)'ın solunda depolanan item 
                eklenecek itemden büyük ise node(Parent)'a rightRotate işlemi
                uygulanır.
            >item > node.left.item) koşulu: node(Parent)'ın solunda depolanan item 
                eklenecek itemden küçük ise node(Parent)'ın soluna leftRotate
                işlemi uygulanır. Ardından döndürülen sonuç node(Parent)'ın soluna
                atanır ve döndürülen sonuç return edilir.
            */
            if (item < node.left.item) {
                return rightRotate(node);
            } 
            else if (item > node.left.item) {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }
        if (balanceFactor < -1) {
            /*
            >(item > node.right.item) koşulu: node(Parent)'ın sağında depolanan item 
                eklenecek itemden büyük ise node(Parent)'a leftRotate işlemi
                uygulanır ve döndürülen sonuç return edilir.
            >item > node.left.item) koşulu: node(Parent)'ın sağında depolanan item 
                eklenecek itemden küçük ise node(Parent)'ın sağına rightRotate
                işlemi uygulanır. Ardından döndürülen sonuç node(Parent)'ın sağına
                atanır ve döndürülen sonuç return edilir.
            */
            if (item > node.right.item) {
                return leftRotate(node);
            } 
            else if (item < node.right.item) {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }
        return node;
    }
    //standart  ağaç print işlemi yapar.
    public void printTree(Node currPtr, String indent, boolean last) {
        if (currPtr != null) {
            System.out.print(indent);
        if (last) {
            System.out.print("R----");
            indent += "   ";
        }
        else {
            System.out.print("L----");
            indent += "|  ";
        }
        System.out.println(currPtr.item);
        printTree(currPtr.left, indent, false);
        printTree(currPtr.right, indent, true);
        }  
    }
}