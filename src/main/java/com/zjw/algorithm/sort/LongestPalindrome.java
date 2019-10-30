package com.zjw.algorithm.sort;

public class LongestPalindrome {
    public static String longestPalindrome(String str)
    {
        if(str==null||str.length()==0)
            return "";

        int max=0,current=0,length=str.length();
        String subString="";

        for(int i=0;i<length;i++)
        {
            //考虑回文字段为奇数长度
            for(int j=0;i-j>=0&&i+j<length;j++)
            {
                if(str.charAt(i-j)!=str.charAt(i+j))
                    break;
                current=j*2+1;
            }
            if(current>max)
            {
                max=current;
                subString=str.substring(i-max/2,i+max/2+1);
            }
            //考虑回文字段为偶数长度
            for(int j=0;i-j>=0&&i+j+1<length;j++)
            {
                if(str.charAt(i-j)!=str.charAt(i+j+1))
                    break;
                current=j*2+2;
            }
            if(current>max)
            {
                max=current;
                subString=str.substring(i-max/2+1,i+max/2+1);
            }
        }

        return subString;
    }


    public static void main(String[] args) {
        String str = "abcdcbad";
        longestPalindrome(str);
        System.out.println(str);
    }
}
