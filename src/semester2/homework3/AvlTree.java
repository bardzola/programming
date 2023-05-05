package semester2.homework3;

import java.util.LinkedList;
import java.util.Queue;

public class AvlTree {
    public Node root;

    public AvlTree(){
        root = null;
    }

    public class Node{

        public int value;

        public Node left;

        public Node right;

        public Node(int value){
            this.value = value;
            left = null;
            right = null;
        }
    }

    public AvlTree insert(int value){
        Node tmp = new Node(value);
        if (root == null){
            this.root = tmp;
            return this;
        }
        Node currentNode = root;
        while (true){
            if (currentNode.value == value) return this;
            if (value < currentNode.value){
                if (currentNode.left == null){
                    currentNode.left = tmp;
                    this.balanceCheck(this.root);
                    return this;
                } else {
                    currentNode = currentNode.left;
                }
            } else {
                if (currentNode.right == null){
                    currentNode.right = tmp;
                    this.balanceCheck(this.root);
                    return this;
                } else
                    currentNode = currentNode.right;

            }
        }
    }

    public Node find(int value){
        Node currentNode = root;
        while (currentNode != null){
            if (currentNode.value == value) return currentNode;
            if (currentNode.value > value){
                if (currentNode.left == null) return null;
                else currentNode = currentNode.left;
            } else {
                if (currentNode.right == null) return null;
                else currentNode = currentNode.right;
            }
        }
        return null;
    }

    public Node findUncle(Node nephew){
        Node dad = findParentOfNode(nephew);
        Node uncle = findParentOfNode(dad);
        if (uncle.left == dad) return uncle.right;
        else return uncle.left;
    }

    public void printPathToNode(Node node){
        Node check = find(node.value);
        if (check == null) System.out.println("There is no such node");
        check = this.root;
        while (check.value != node.value){
            System.out.print(check.value + ", ");
            if (check.value > node.value){
                check = check.left;
            } else
                check = check.right;

        }
        System.out.print(check.value + ", ");
        System.out.println();
    }

    public Node findParentOfNode(Node child){
        Node currentNode = root;
        while (currentNode != null){
            if (currentNode.right == child || currentNode.left == child) break;
            if (child.value > currentNode.value){
                if (currentNode.right == null) return null;
                else currentNode = currentNode.right;
            } else {
                if (currentNode.left == null) return null;
                else currentNode = currentNode.left;
            }
        }
        return currentNode;
    }

    public AvlTree delete(int value){
        Node tmp = this.find(value);
        if (tmp == null)
            return this;
        if (tmp == root && tmp.right != null && tmp.left != null){
            tmp = tmp.right;
            int count = 0;
            while (tmp.left != null){
                count++;
                tmp = tmp.left;
            }
            if (count == 0){
                tmp.left = root.left;
                root = tmp;
            } else {
                Node tmpFather = findParentOfNode(tmp);
                tmpFather.left = tmp.right;
                tmp.left = root.left;
                tmp.right = root.right;
                root = tmp;
            }
            this.balanceCheck(this.root);
            return this;
        }

        if (tmp == root && (tmp.right == null || tmp.left == null)){
            if (tmp.right == null && tmp.left == null){
                root = null;
                return this;
            }
            if (tmp.right != null){
                root = tmp.right;
                return this;
            }
            root = tmp.left;
            return this;

        }


        if (tmp.left == null && tmp.right == null){
            Node tmpFather = findParentOfNode(tmp);
            if (tmpFather.left == tmp){
                tmpFather.left = null;
            } else if (tmpFather.right == tmp){
                tmpFather.right = null;
            }
            this.balanceCheck(this.root);
            return this;
        }

        if (tmp.left == null && tmp.right != null || tmp.right == null && tmp.left != null){
            Node tmpFather = findParentOfNode(tmp);
            if (tmpFather.left == tmp){
                if (tmp.right == null){
                    tmpFather.left = tmp.left;
                } else if (tmp.left == null){
                    tmpFather.left = tmp.right;
                }
            } else if (tmpFather.right == tmp){
                if (tmp.right == null){
                    tmpFather.right = tmp.left;
                } else if (tmp.left == null){
                    tmpFather.right = tmp.right;
                }
            }
            this.balanceCheck(this.root);
            return this;
        }

        if (tmp.left != null && tmp.right != null){
            Node tmpFather = findParentOfNode(tmp);
            Node movingTmp = tmp.right;
            int count = 0;
            while (movingTmp.left != null){
                count++;
                movingTmp = movingTmp.left;
            }
            if (count == 0){
                movingTmp.left = tmp.left;
                if (tmpFather.left == tmp){
                    tmpFather.left = movingTmp;
                } else if (tmpFather.right == tmp){
                    tmpFather.right = movingTmp;
                }
            } else {
                Node fatherMovingTmp = findParentOfNode(movingTmp);
                if (movingTmp.right != null){
                    fatherMovingTmp.left = movingTmp.right;
                } else fatherMovingTmp.left = null;
                movingTmp.left = tmp.left;
                movingTmp.right = tmp.right;
                if (tmpFather.left == tmp){
                    tmpFather.left = movingTmp;
                } else if (tmpFather.right == tmp){
                    tmpFather.right = movingTmp;
                }
            }
            this.balanceCheck(this.root);
            return this;
        }
        this.balanceCheck(this.root);
        return this;
    }

    public void printTree(Node node){
        if (node == null) return;
        printTree(node.right);
        System.out.print(node.value + ", ");
        printTree(node.left);

//        while (this.root != null){
//            Node maxNode = root;
//            if (maxNode.right != null){
//                while (maxNode.right != null){
//                    maxNode = maxNode.right;
//                }
//                System.out.print(maxNode.value + ", ");
//                Node parent = findParentOfNode(maxNode);
//                parent.right = maxNode.left;
//            } else if (maxNode.right == null){
//                System.out.print(maxNode.value + ", ");
//                if (root.left != null){
//                    root = root.left;
//                } else {
//                    root = null;
//                }
//            }
//        }
    }

    public void balanceCheck(Node node){
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            Node tmp = queue.poll();
            if (nodeHeight(tmp.right) - nodeHeight(tmp.left) > 1){
                Node tmpRight = tmp.right;
                if (nodeHeight(tmpRight.right) - nodeHeight(tmpRight.left) != -1){
                    tmp.right = tmpRight.left;
                    tmpRight.left = tmp;
                    if (root == tmp){
//                        tmp.right = tmpRight.left;
//                        tmpRight.left = tmp;
                        root = tmpRight;
                    } else {
                        Node parentTmp = findParentOfNode(tmp);
//                        tmp.right = tmpRight.left;
//                        tmpRight.left = tmp;
                        if (parentTmp.left == tmp) parentTmp.left = tmpRight;
                        else parentTmp.right = tmpRight;
                    }
                } else if (nodeHeight(tmpRight.right) - nodeHeight(tmpRight.left) == -1){
                    Node tmpRightLeft = tmpRight.left;
                    tmp.right = tmpRightLeft.left;
                    tmpRight.left = tmpRightLeft.right;
                    tmpRightLeft.left = tmp;
                    tmpRightLeft.right = tmpRight;
                    if (root == tmp){
//                        tmp.right = tmpRightLeft.left;
//                        tmpRight.left = tmpRightLeft.right;
//                        tmpRightLeft.left = tmp;
//                        tmpRightLeft.right = tmpRight;
                        root = tmpRightLeft;
                    } else {
                        Node parentTmp = findParentOfNode(tmp);
//                        tmp.right = tmpRightLeft.left;
//                        tmpRight.left = tmpRightLeft.right;
//                        tmpRightLeft.left = tmp;
//                        tmpRightLeft.right = tmpRight;
                        if (parentTmp.left == tmp) parentTmp.left = tmpRightLeft;
                        else parentTmp.right = tmpRightLeft;
                    }
                }
                break;
            } else if (nodeHeight(tmp.right) - nodeHeight(tmp.left) < -1){
                Node tmpLeft = tmp.left;
                if (nodeHeight(tmpLeft.right) - nodeHeight(tmpLeft.left) != 1){
                    tmp.left = tmpLeft.right;
                    tmpLeft.right = tmp;
                    if (root == tmp){
//                        tmp.left = tmpLeft.right;
//                        tmpLeft.right = tmp;
                        root = tmpLeft;
                    } else {
                        Node parentTmp = findParentOfNode(tmp);
//                        tmp.left = tmpLeft.right;
//                        tmpLeft.right = tmp;
                        if (parentTmp.left == tmp) parentTmp.left = tmpLeft;
                        else parentTmp.right = tmpLeft;
                    }
                } else if (nodeHeight(tmpLeft.right) - nodeHeight(tmpLeft.left) == 1){
                    Node tmpLeftRight = tmpLeft.right;
                    tmp.left = tmpLeftRight.right;
                    tmpLeft.right = tmpLeftRight.left;
                    tmpLeftRight.right = tmp;
                    tmpLeftRight.left = tmpLeft;
                    if (root == tmp){
//                        tmp.left = tmpLeftRight.right;
//                        tmpLeft.right = tmpLeftRight.left;
//                        tmpLeftRight.right = tmp;
//                        tmpLeftRight.left = tmpLeft;
                        root = tmpLeftRight;
                    } else {
                        Node parentTmp = findParentOfNode(tmp);
//                        tmp.left = tmpLeftRight.right;
//                        tmpLeft.right = tmpLeftRight.left;
//                        tmpLeftRight.right = tmp;
//                        tmpLeftRight.left = tmpLeft;
                        if (parentTmp.left == tmp) parentTmp.left = tmpLeftRight;
                        else parentTmp.right = tmpLeftRight;
                    }
                }
                break;
            }
            //System.out.println(nodeHeight(tmp.right) - nodeHeight(tmp.left));
            if (tmp.left != null){
                queue.add(tmp.left);
            }
            if (tmp.right != null){
                queue.add(tmp.right);
            }
        }
        //Recursive depth-first search
//        System.out.println(nodeHeight(node.right) - nodeHeight(node.left));
//        if (node.left != null) balanceCheck(node.left);
//        if (node.right != null) balanceCheck(node.right);
    }

    public int nodeHeight(Node node){
        if (node == null) return 0;
        return 1 + Math.max(nodeHeight(node.left), nodeHeight(node.right));
    }


}


