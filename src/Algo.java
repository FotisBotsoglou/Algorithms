import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Random;

    public class Algo {
        public static void main(String[] args) {
            int[] array={5,3,6,2,9,8,1};
            int[] ar1 ={5,3,2,1,5,1,4};
            int[] fin =addArrays(array,ar1);
            int[] mul = multiplyArrays(array,ar1);
            System.out.println(Arrays.toString(mul));
            System.out.println(Arrays.toString(fin));

        }
        public static int SumOfTheArray(int [] array){
            int sum = 0;
            for (int i=1; i<array.length; i++){
                sum+=array[i];
            }
            return sum;
        }
        public static int MulOfTheArray(int[] array){
            int mul=1;
            for (var elem:array){
                mul*=elem;
            }
            return mul;
        }
        public static int getMax(int[] array){
            int max= Integer.MIN_VALUE;
            for (var elem: array){
                if (elem>max){
                    max=elem;
                }
            }
            return max;

        }
        public static int getMin(int[] array){
            int min = array[0];
            for (int i=1; i<array.length; i++){
                if (array[i]<min)
                    min=array[i];
            }
            return min;
        }

        public static BigDecimal getAverage(int[] array){

            double sum = 0;
            for (int i=0; i<array.length; i++){
                sum+=array[i];
            }
            return new BigDecimal(sum/array.length).setScale(2, RoundingMode.HALF_UP);
        }
        public static int secondMax(int[] array){
            int max = array[0];
            int secondMax= array[1];
            for ( var elem:array){
                if (elem>max){
                    secondMax = max;
                    max = elem;
                }
                else if (elem > secondMax && max!=elem){
                    secondMax= elem;
                }
            }
            return secondMax;
        }
        public static int sumOfSquares(int[] array){
            int sum= 0;
            for (int i=0; i<array.length; i++){
                double x = Math.pow(array[i],2);
                sum+=x;
            }
            return sum;
        }
        public static int countOfElementsInTheArray(int[] array,int val){
            int count =0;
            for (var elem:array){
                if (elem==val){
                    count++;
                }
            }
            return count;
        }
        public static int fib(int n){
            if (n==0 || n==1)
                return n;
            return fib(n-1)+fib(n-2);
        }
        public static int tribonacci(int n){
            if (n==0||n==1)
                return 0;
            if (n==2)
                return 1;

            return tribonacci(n-1)+tribonacci(n-2)+tribonacci(n-3);
        }
        public static int factorial(int n){
            if ( n==0)
                return 1;

            return n*factorial(n-1);
        }
        public static int binarySearch(int[] array,int val) {
            int start=0;
            int finish= array.length-1;
            int count = 0;
            while (start<=finish){
                count++;
                int middle= (start+finish)/2;
                if (val==array[middle]) {
                    System.out.println(count);
                    return middle;
                }
                else if (val>array[middle]){
                    start=middle+1;

                }
                else{
                    finish=middle-1;

                }
            }

            return -1;
        }
        public static int recBinarySearch(int[] array,int val,int start,int finish){
            if (start>finish)
                return -1;
            else {
                int middle= (start+finish)/2;
                if (val==array[middle])
                    return middle;
                else if (val>array[middle]){
                    return   recBinarySearch(array,val,middle+1,finish);
                }
                else return recBinarySearch(array,val,start,middle-1);
            }
        }
        public static int linearSearch(int[] array,int val){
            int count=0;
            for (int i=0; i<array.length; i++){
                count++;
                if (val==array[i]){

                    System.out.println(count);
                    return i;
                }
            }
            return -1;
        }
        public static void selectionSort(int[] array){
            int minimum;
            for (int i=0; i<array.length; i++){
                minimum=i;
                for (int j=i+1; j<array.length; j++){
                    if (array[j]<array[minimum]){
                        minimum=j;
                    }
                }
                int temp=array[i];
                array[i]=array[minimum];
                array[minimum]=temp;
            }
        }
        public static  void insertionSort(int[] array){
            for (int i=1; i<array.length; i++){
                for (int j=i; j>=1; j--){
                    if (array[j]<array[j-1]){
                        int temp=array[j];
                        array[j]=array[j-1];
                        array[j-1]=temp;
                    }
                }
            }
        }
        public static void bubbleSort(int[] array){
            for (int i= array.length-1; i>=1; i--){
                for (int j=0; j<i; j++){
                    if (array[j]>array[j+1]){
                        int temp = array[j];
                        array[j]=array[j+1];
                        array[j+1]=temp;
                    }
                }
            }
        }
        public static boolean symmetricArray(int[] array){
            for (int i =0,j=array.length-1;i<j; i++,j--){
                if (array[i]!=array[j]){
                    return false;
                }
            }
            return true;
        }
        public static int[] shiftRight(int[] array,int offset){
            int[] rotated = new int[array.length];
            for (int i=0; i<array.length; i++){
                rotated[(i+offset)%array.length] = array[i];
            }
            return rotated;
        }
        public static int[] shiftLeft(int[] array,int offset){
            int[] rotated = new int[array.length];
            for (int i=0; i<array.length; i++){
                rotated[i]=array[(i+offset)%array.length];
            }
            return rotated;
        }
        public static int[] addOne(int[] array){
            int carry=1;
            int sum;
            int[] out = new int[array.length+1];
            for (int i= array.length-1; i>=0; i--){
                sum= array[i]+carry;
                out[i+1]=sum%10;
                carry= sum/10;
            }
            out[0]=carry;
            return out;
        }
        public static int[] twoBigInts(int[] ar1,int[] ar2){
            if ((ar1==null||ar2==null) || (ar1.length!=ar2.length)){
                throw new IllegalArgumentException();
            }
            int [] out = new int[ar1.length+1];
            int carry=0;
            int sum;
            for (int i= ar1.length-1; i>=0; i--){
                sum= ar1[i]+ar2[i]+carry;
                out[i+1] = sum%10;
                carry= sum/10;
            }
            out[0]=carry;
            return out;
        }
        public static void mergeSort(int[] array){
            int finish= array.length;
            int middle= finish/2;
            if (finish<2)
                return;

            int[] left= new int[middle];
            int[] right=new int[finish-middle];

            for (int i=0; i<middle; i++){
                left[i]=array[i];
            }
            for (int i=middle; i<array.length; i++){
                right[i-middle]=array[i];
            }
            mergeSort(left);
            mergeSort(right);
            merge(array,left,right);
        }
        public static void merge(int[] array,int[] left,int[] right){
            int leftSize=left.length;
            int rightSize=right.length;

            int i=0,j=0,k=0;
            while (i<leftSize && j<rightSize){
                if (left[i]<=right[j]){
                    array[k]=left[i];
                    i++;
                }
                else {
                    array[k]=right[j];
                    j++;
                }
                k++;
            }
            while (i<leftSize){
                array[k]=left[i];
                i++;
                k++;
            }
            while (j<rightSize){
                array[k]=right[j];
                j++;
                k++;
            }
        }
        public static void quickSort(int[] array,int lowIndex,int highIndex){
            if (lowIndex>=highIndex)
                return;

            int pivotIndex = new Random().nextInt(highIndex-lowIndex)+lowIndex;
            int pivot=array[pivotIndex];
            swap(array,pivotIndex,highIndex);

            int leftPointer = lowIndex;
            int rightPointer=highIndex;
            while (leftPointer<rightPointer){
                while (array[leftPointer]<=pivot && leftPointer<rightPointer){
                    leftPointer++;
                }
                while (array[rightPointer]>=pivot && leftPointer<rightPointer){
                    rightPointer--;
                }

                swap(array,leftPointer,rightPointer);
            }
            swap(array,leftPointer,highIndex);
            quickSort(array,lowIndex,leftPointer-1);
            quickSort(array,leftPointer+1,highIndex);
        }
        public static void quickSort(int[] array){
            quickSort(array,0,array.length-1);
        }
        public static void swap(int[] array,int num1,int num2){
            int temp = array[num1];
            array[num1]=array[num2];
            array[num2]=temp;
        }
        public static int[] deepCopy(int[] array){
            int[] copy=new int[array.length];
            for (int i=0; i<array.length; i++){
                copy[i]=array[i];
            }
            return copy;
        }
        public static int[] addArrays(int[] ar1,int[] ar2){
            int[] array =new int[ar1.length];
            if (ar1.length!=ar2.length)
                return null;

            for (int i=0; i<ar1.length; i++){
                array[i]=ar1[i]+ar2[i];
            }
            return array;
        }
        public static int[] multiplyArrays(int[] ar1,int[] ar2){
            int[] array= new int[ar1.length];
            if (ar1.length!=ar2.length)
                return null;
            for (int i =0; i<ar1.length; i++){
                array[i]=ar1[i] * ar2[i];
            }
            return array;
        }
    }

