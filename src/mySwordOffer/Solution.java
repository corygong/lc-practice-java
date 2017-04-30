package mySwordOffer;

public class Solution {
	// 二维数组
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
	//替代""为%20
	public String replaceSpace(StringBuffer str){
		
		
		return null;
	}
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
	//二进制中1的个数
	public int NumberOf1(int n){
		int count=0;
		while(n!=0){
			count++;
			n=n & (n-1);
		}
		return count;
	}
	//数值的整数次方
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
	/**
	 * 调整数组顺序使得奇数都位于偶数前面，相对位置不变
	 *
	 * @param array
	 */
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
	
	//翻转链表
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
	
	//合并两个排序的链表
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
	
	/**
	 * 逆序对
	 * a[i]>a[j],i<j
	 * @param array
	 * @return
	 */
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
	
	/**
	 * A树是否包含B树
	 * @param root1
	 * @param root2
	 * @return
	 */
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
	
	/*public ArrayList<Integer> printMatrix(int[][] matrix){
		
	}*/
	
	/**
	 * 二叉树深度
	 * @param root
	 * @return
	 */
	public int TreeDepth(TreeNode root) {
        if(root==null){
            return 0;
        }else{
            return 1+((TreeDepth(root.left)>TreeDepth(root.right))?TreeDepth(root.left):TreeDepth(root.right));
        }  
    }
	
	
	
	
	
}
