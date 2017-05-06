package mySwordOffer;

import java.util.*；

/**
 * 剑指offer上的66道算法题
 * @author corygong
 *
 */



public class Solution {
	//2、单例模式
	
	//3、二维数组的查找
	public boolean Find(int[][] array, int target) {
		int row = 0;
		int col = array[0].length - 1;
		while (row <= array.length - 1 && col >= 0) {
			if (target == array[row][col])
				return true;
			else if (target > array[row][col])
				row++;
			else
				col--;
		}
		return false;
	}
	//4、替换空格 ，替代""为%20
	public String replaceSpace(StringBuffer str){
		
		
		return null;
	}
	
	//5、从尾到头打印链表
	//递归和循环
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode){
		Stack<Integer> stack=new Stack<Integer>();
		while(listNode!=null && listNode.next!=null){
			stack.push(listNode.val);
			listNode=listNode.next;
		}
		ArrayList<Integer> result=new ArrayList<Integer>();
		while(!stack.isEmpty()){
			result.add(stack.pop());
		}
		return result;
	}
	
	public ArrayList<Integer> printListFromTailToHead1(ListNode listNode){
		//ArrayList<Integer> result=new ArrayList<Integer>();
		if(listNode!=null){
			if(listNode.next!=null){
				printListFromTailToHead1(listNode.next);
			}
			
			
		}
		//return result;
	}
	
	//6、重建二叉树
	
	public TreeNode reConstructBinaryTree(int[] pre,int[] in){
		
	}
	
	//7、用两个栈实现队列
	
	//8、旋转数组的最小数字
	
	//9、fibonacci
	//跳台阶
		public int JumpFloor(int target){
			if(target==1){return 1;}
			if(target==2){return 2;}
			int totalNum=0;
			int num1=2;
			int num2=1;
			for(int i=3;i<target;i++){
				totalNum=num1+num2;
				num2=num1;
				num1=totalNum;	
			}
			return totalNum;
		}
		
	//10、二进制中1的个数
	public int NumberOf1(int n){
		int count=0;
		while(n!=0){
			count++;
			n=n & (n-1);
		}
		return count;
	}
	
	//11、数值的整数次方
	public double Power(double base,int exponent){
		/*if(exponent==0) return 1;
		
		if(exponent==1) return base;
		double result=Power(base,exponent>>1);
		result*=result;
		
		if(exponent%2==1){
			result*=base;
		}
		return result;*/
		double result=1;
		for(int i=0;i<Math.abs(exponent);i++){
			result*=base;
		}
		if(exponent<0){
			result=1/result;
		}
		return result;
	}
	
	
	//12、打印1到n的最大位数
	
	
	
	//13、o(1)删除链表结点
	
	
	//14、调整数组顺序使得奇数都位于偶数前面，相对位置不变
	
	public void reOrderArray(int[] array){
		if(array==null || array.length==0){
			return ;
		}
		for(int i=0;i<array.length;i++){
			if(array[i]%2==1){
				int tem=array[i];
				int j=i-1;
				while(j>=0 && array[j]%2==0){
					array[j+1]=array[j];
					j--;
				}
				array[j+1]=tem;
			}
		}
		
	}
	//15、链表中倒数第k个结点
	
	
	//16、翻转链表
	public ListNode ReverseList(ListNode head){
		if(head==null){
			return null;
		}
		ListNode pre=null;
		ListNode next=null;
		while(head!=null){
			next=head.next;
			head.next=pre;
			pre=head;
			head=next;
		}
		return pre;
	}
	
	//17、合并两个排序的链表
	public ListNode Merge(ListNode list1,ListNode list2){
		if(list1==null) return list2;
		if(list2==null) return list1;
		ListNode mergeList=null;
		if(list1.val<list2.val){
			mergeList=list1;
			mergeList.next=Merge(list1.next, list2);
		}else{
			mergeList=list2;
			mergeList.next=Merge(list1, list2.next);
		}
		return mergeList;
	}

	
	
	//18、树的子结构。。A树是否包含B树
	 
	public boolean HasSubTree(TreeNode root1,TreeNode root2){
		boolean result=false;
		if(root1!=null && root2!=null){
			if(root1.val==root2.val){
				result=DoesAHasB(root1, root2);
			}
			if(!result){
				result=HasSubTree(root1.left, root2);
			}
			if(!result){
				result=HasSubTree(root1.right, root2);
			}
			
		}
		return result;
	}
	public boolean DoesAHasB(TreeNode root1,TreeNode root2){
		if(root2==null) return true;
		if(root1==null) return false;
		if(root1.val!=root2.val){
			return false;
		}
		return DoesAHasB(root1.left, root2.left) && DoesAHasB(root1.right, root2.right);
	}
	
	//19、二叉树的镜像
	
	//20、顺时针打印矩阵
	public ArrayList<Integer> printMatrix(int[][] array){
		ArrayList<Integer> result=new ArrayList<Integer>();
		int rows=array.length;
		int cols=array[0].length;
		int start=0;
		while(rows>start*2 && cols>start*2){
			printMatrixInCircle(array, rows, cols);
		}
		
		return result;
	}
	public void printMatrixInCircle(int[][] matrix,int rows,int cols){
		
	}
	
	
	//21、包含min函数的栈
	
	
	//22、栈的压入 弹出
	
	
	//23、从上往下打印二叉树
	
	
	//24、BST后序遍历
	
	
	//25、二叉树中和为某一值的路径
	
	
	//26、复杂链表的复制
	
	//27 二叉树和双向链表
	
	//28、字符串的排列
	
	
	//29、数组中出现次数大于一半的数字
	
	
	//30\最小的k个数
	
	//31\连续子数组的最大和
	
	
	//32\从1到n整数中1出现的次数
	
	//33\把数组排成最小的数
	
	//34、丑数
	
	//35、第一个只出现一次的字符
	
	//36、数组中的逆序对
	public static int InversePairs(int[] array){
		if(array==null ||array.length<0){
			return 0;
		}
		int[] copy=new int[array.length];
		System.arraycopy(array, 0, copy, 0, array.length);
		int pairNum=InversePairs(array,copy,0,array.length-1);
		return pairNum;
	}
	public static int InversePairs(int[] array,int[] copy,int begin,int end){
		if(begin == end){
			return 0;
		}
		int mid=(begin+end)/2;
		int left=InversePairs(copy,array,begin,mid);
		int right=InversePairs(copy,array, mid+1, end);
		
		int i=mid,j=end,pos=end;
		int count=0;
		while(i>=begin && j>=mid+1){
			if(array[i]>array[j]){
				copy[pos--]=array[i--];
				count+=j-mid;
			}else{
				copy[pos--]=array[j--];
			}
		}
		while(i>=begin){
			copy[pos--]=array[i--];
		}
		while(j>=mid+1){
			copy[pos--]=array[j--];
		}
		return left+right+count;
	}
	
	public static void main(String[] args) {
		int[] tes ={7,5,1,6,4};
		System.out.println(InversePairs(tes));
	}
	
	//37、两个链表的第一个公共节点
	
	
	//38、数字在排序数组中出现的次数
	
	
	//39、二叉树深度
	 
	public int TreeDepth(TreeNode root) {
        if(root==null){
            return 0;
        }else{
            return 1+((TreeDepth(root.left)>TreeDepth(root.right))?TreeDepth(root.left):TreeDepth(root.right));
        }  
    }
	
	
	//40、数组中只出现一次的数字
	
	//41、和为s的两个数字 和为s的连续整数序列
	
	
	//42、翻转单词顺序  左旋转字符串
	
	//43、n个骰子的点数
	
	//44、扑克牌的顺子
	
	//45、圆圈中最后剩下的数字
	
	//46、求1+2+。。。+n
	
	//47、不用加减乘除做加法
	
	
	//48、不能被继承的类
	
	//49、字符串转换成整数
	
	//50、树中两个节点的最低公共祖先
	
	//51、数组中重复的数字
	
	//52、构建数组乘积
	
	//53、正则匹配
	
	//54、表示数值的字符串
	
	//55、字符流中第一个不重复的字符
	
	//56、链表中环的入口节点
	
	//57、删除链表中重复的结点
	
	//58、二叉树的下一个节点
	
	//59、对称的二叉树
	
	//60、把二叉树打印成多行
	
	//61、按之字形打印二叉树
	
	//62、序列化二叉树
	
	//63、BST的第k个结点
	
	//64、数据流的中位数
	
	//65、滑动窗口的最大值
	
	//66、矩阵中的路径
	
	//67、机器人的运动路径
	
	public ArrayList<Integer> topK(int[] input,int k){
		ArrayList<Integer> list=new ArrayList<Integer>();
		if(input==null || input.length<=0 ||input.length<k){
			return list;
		}
		//构建大顶堆
		for(int i =k/2-1;i>=0;i--){
			adjustMaxHeapSort(input,i,k-1);
		}
		int tmp;
		//从第k个元素开始和大顶堆的堆顶比较
		for(int i=k;i<input.length;i++){
			if(input[i] <input[0]){
				tmp=input[0];
				input[0]=input[i];
				input[i]=tmp;
				adjustMaxHeapSort(input, 0, k-1);
			}
		}
		for(int j=0;j<k;j++){
			list.add(input[j]);
		}
		return list;
		
	}
	public void adjustMaxHeapSort(int[] input,int i,int k){
		int temp=input[i];
		for(int j=2*i+1;j<=k;j=j*2+1){
			if(j<k && input[j]<input[j+1]){
				j++;
			}
			if(temp >input[j]){
				break;
			}
			input[i]=input[j];
			i=j;
			
		}
		input[i]=temp;
	}
	
	
	public TreeLinkNode getNext(TreeLinkNode pNode){
		if(pNode==null){
			return null;
		}
		if(pNode.right!= null){
			pNode=pNode.right;
			while(pNode.left!=null){
				pNode=pNode.left;
			}
			return pNode;
		}
		//向上查找
		while(pNode.next!=null){
			if(pNode ==pNode.next.left){
				return pNode.next;
			}
			pNode=pNode.next;
		}
		return null;
		
	}
	
	
	
	
	
	
	
}
