package cn.zsy.eg.arithmetic;

public class RomeToArabic {

    public static void main(String[] args) {
        String s = "MCMXLIV";
        System.out.println(r2a(s));
        System.out.println(a2r(1944));
    }

    //罗马数字转阿拉伯数字：
    // 从前往后遍历罗马数字，如果某个数比前一个数小，则把该数加入到结果中；
    // 反之，则在结果中两次减去前一个数并加上当前这个数；
    // I、V、X、   L、   C、     D、     M
    // 1．5、10、50、100、500、1000
    private static int r2a(String in){
        int graph[] = new int[400];
        graph['I'] = 1;
        graph['V']=5;
        graph['X']=10;
        graph['L']=50;
        graph['C']=100;
        graph['D']=500;
        graph['M']=1000;

        char[] num = in.toCharArray();

        // 遍历这个数，用sum来总计和
        int sum = graph[num[0]];

        for(int i=0; i<num.length-1; i++){
            // 如果，i比i+1大的话，直接相加
            if(graph[num[i]] >= graph[num[i+1]]){
                sum += graph[num[i+1]];
            }
            // 如果i比i+1小的话，则将总和sum减去i这个地方数的两倍，同时加上i+1
            // 就相当于后边的数比左边的数大，则用右边的数减左边的数
            else{
                sum = sum + graph[num[i+1]] - 2*graph[num[i]];
            }
        }

        return sum;
    }

    // 阿拉伯数字转罗马数字：
    // 把所有小数字在前的组合也作为基本数字，再做一个对应的数值表就可以解决问题了。
    // I、V、X、   L、   C、     D、     M
    // 1．5、10、50、100、500、1000
    private static String a2r(int aNumber){
        if(aNumber < 1 || aNumber > 3999){
            return "-1";
        }

        int[] aArray = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] rArray = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        String rNumber = "";

        for(int i=0; i<aArray.length; i++){
            while(aNumber >= aArray[i]){
                rNumber += rArray[i];
                aNumber -= aArray[i];
            }
        }

        return rNumber;
    }

}


