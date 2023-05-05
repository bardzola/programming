package semester2.homework3;

public class TestHomeWork3 {
    public static void testHomeWork3(){
        AvlTree avlTree = new AvlTree();
        avlTree.insert(10);
        avlTree.insert(6);
        avlTree.insert(15);
        avlTree.insert(9);
        avlTree.insert(13);
        avlTree.insert(20);
        avlTree.insert(14);
        avlTree.insert(7);
        avlTree.insert(19);
        avlTree.insert(18);
        avlTree.delete(20);


        AvlTree avlTree1 = new AvlTree();
        avlTree1.insert(1);
        avlTree1.insert(2);
        avlTree1.insert(3);
        avlTree1.insert(10);
        avlTree1.insert(7);


        AvlTree.Node newNode = avlTree.find(9);
        AvlTree.Node newNode2 = avlTree.find(14);
        AvlTree.Node nodeUncle = avlTree.findUncle(avlTree.find(14));
        avlTree.printPathToNode(newNode2);
        System.out.println(avlTree.nodeHeight(avlTree.find(9)));
        avlTree.delete(15);
        avlTree.printTree(avlTree.root);
        System.out.println();
        //avlTree1.balanceCheck(avlTree1.root);
    }
}
