package com.bee.sample.chl.exercises;

import java.text.NumberFormat;
  import java.util.HashMap;
  import java.util.Scanner;
  public class AmountOfConversion {
        //定义HashMap的value值
        public static final String EMPTY = "";
        public static final String ZERO = "零";
        public static final String ONE = "壹";
        public static final String TWO = "贰";
        public static final String THREE = "叁";
        public static final String FOUR = "肆";
        public static final String FIVE = "伍";
        public static final String SIX = "陆";
        public static final String SEVEN = "柒";
        public static final String EIGHT = "捌";
        public static final String NINE = "玖";
        public static final String TEN = "拾";
        public static final String HUNDRED = "佰";
        public static final String THOUSAND = "仟";
        public static final String TEN_THOUSAND = "万";
        public static final String HUNDRED_MILLION = "亿";
        public static final String YUAN = "元";
        public static final String JIAO = "角";
        public static final String FEN = "分";
        public static final String DOT = ".";
        private static AmountOfConversion formatter = null;
        //创建AmountOfConversion的实例对象
        //创建初始化一个HashMap对象
        private HashMap NumberMap = new HashMap();
        private HashMap HighnumberofMoney = new HashMap();
        //创建初始化一个NumberFormat对象
        private NumberFormat numberFormat = NumberFormat.getInstance();
        private AmountOfConversion() {
            //在用new创建AmountOfConversion对象时，为HashMap对象进行key-value的映射
            numberFormat.setMaximumFractionDigits(4);    //设置数据的小数部分的最大位数是4位
            numberFormat.setMinimumFractionDigits(2);    //设置数据的小数部分的最小位数是2位
            numberFormat.setGroupingUsed(false);         /*设置此格式中是不可以使用组。如果设置
  可以使用组，则数1234567 可能被格式化为 "1,234,567"*/
            NumberMap.put("0", ZERO);
            NumberMap.put("1", ONE);
            NumberMap.put("2", TWO);
            NumberMap.put("3", THREE);
            NumberMap.put("4", FOUR);
            NumberMap.put("5", FIVE);
            NumberMap.put("6", SIX);
            NumberMap.put("7", SEVEN);
            NumberMap.put("8", EIGHT);
            NumberMap.put("9", NINE);
            NumberMap.put(DOT, DOT);
            HighnumberofMoney.put("1", TEN);
            HighnumberofMoney.put("2", HUNDRED);
            HighnumberofMoney.put("3", THOUSAND);
            HighnumberofMoney.put("4", TEN_THOUSAND);
            HighnumberofMoney.put("5", TEN);
            HighnumberofMoney.put("6", HUNDRED);
            HighnumberofMoney.put("7", THOUSAND);
            HighnumberofMoney.put("8", HUNDRED_MILLION);
        }
        public static AmountOfConversion getInstance() {
              //判断AmountOfConversion对象formatter是否初始化
            if (formatter == null)
                formatter = new AmountOfConversion();
            return formatter;
        }
        //进行金额转换的多种数据类型
        public String format(String moneyStr) {
            String result = "不能进行金额转换！！";
            if (isConversion(moneyStr)) {
                result = convertIntegerTochinese(moneyStr);
                result = convertPointTochinese(result);
            }
            return result;
        }
        public String format(double moneyDouble) {
            return format(numberFormat.format(moneyDouble));
        }
        public String format(int moneyInt) {
            return format(numberFormat.format(moneyInt));
        }
        public String format(long moneyLong) {
            return format(numberFormat.format(moneyLong));
        }
        public String format(Number moneyNum) {
            return format(numberFormat.format(moneyNum));
        }
        private String convertIntegerTochinese(String moneyStr) {
              //将参数中传入的阿拉伯数字转换成中文
            String result;
            StringBuffer C2CStrBufer = new StringBuffer();
            for (int i = 0; i < moneyStr.length(); i++) {
                C2CStrBufer.append(NumberMap.get(moneyStr.substring(i, i + 1)));
            }
            // 拾佰仟万亿等都是汉字里面才有的单位，加上它们
            int indexOfDot = C2CStrBufer.indexOf(DOT);
            int moneyPatternCursor = 1;
            for (int i = indexOfDot - 1; i > 0; i--) {
                C2CStrBufer.insert(i, HighnumberofMoney.get(EMPTY + moneyPatternCursor));
                moneyPatternCursor = moneyPatternCursor == 8 ? 1 : moneyPatternCursor + 1;
            }
            String fractionPart = C2CStrBufer.substring(C2CStrBufer.indexOf("."));
            C2CStrBufer.delete(C2CStrBufer.indexOf("."), C2CStrBufer.length());
            while (C2CStrBufer.indexOf("零拾") != -1) {
                C2CStrBufer.replace(C2CStrBufer.indexOf("零拾"), C2CStrBufer.indexOf("零拾") + 2, ZERO);
            }
            while (C2CStrBufer.indexOf("零佰") != -1) {
                C2CStrBufer.replace(C2CStrBufer.indexOf("零佰"), C2CStrBufer.indexOf("零佰") + 2, ZERO);
            }
            while (C2CStrBufer.indexOf("零仟") != -1) {
                C2CStrBufer.replace(C2CStrBufer.indexOf("零仟"), C2CStrBufer.indexOf("零仟") + 2, ZERO);
            }
            while (C2CStrBufer.indexOf("零万") != -1) {
                C2CStrBufer.replace(C2CStrBufer.indexOf("零万"), C2CStrBufer.indexOf("零万") + 2, TEN_THOUSAND);
            }
            while (C2CStrBufer.indexOf("零亿") != -1) {
                C2CStrBufer.replace(C2CStrBufer.indexOf("零亿"), C2CStrBufer.indexOf("零亿 ") + 2, HUNDRED_MILLION);
            }
            while (C2CStrBufer.indexOf("零零") != -1) {
                C2CStrBufer.replace(C2CStrBufer.indexOf("零零"), C2CStrBufer.indexOf("零零 ") + 2, ZERO);
            }
            if (C2CStrBufer.lastIndexOf(ZERO) == C2CStrBufer.length() - 1){
                C2CStrBufer.delete(C2CStrBufer.length() - 1, C2CStrBufer.length());
            }
            C2CStrBufer.append(fractionPart);
            result = C2CStrBufer.toString();
            return result;
        }
        private String convertPointTochinese(String moneyStr) {
              //对小数点后面的数字进行汉字处理
            String result;
            StringBuffer C2CStrBufer = new StringBuffer(moneyStr);
            int indexOfDot = C2CStrBufer.indexOf(DOT);
            C2CStrBufer.replace(indexOfDot, indexOfDot + 1, YUAN);
            C2CStrBufer.insert(C2CStrBufer.length() - 1, JIAO);
            C2CStrBufer.insert(C2CStrBufer.length(), FEN);
            if (C2CStrBufer.indexOf("零角零分") != -1)
                // 没有零头，加整
            {
                C2CStrBufer.replace(C2CStrBufer.indexOf("零角零分"), C2CStrBufer.length(), " 整");}
            else if (C2CStrBufer.indexOf("零分") != -1)
                // 没有零分，加整
            {
                C2CStrBufer.replace(C2CStrBufer.indexOf("零分"), C2CStrBufer.length(), "整");
            }
            else {
                if (C2CStrBufer.indexOf("零角") != -1) {
                    C2CStrBufer.delete(C2CStrBufer.indexOf("零角"), C2CStrBufer.indexOf("零角") + 2);
                }
            }
            result = C2CStrBufer.toString();
            return result;
        }
        private boolean isConversion(String moneyStr) {
              //判断参数传来的数据是否符合进行转换的条件
            int fractionDigits = moneyStr.length() - moneyStr.indexOf(DOT) - 1;
            boolean flag = true;
            if (fractionDigits > 2) {
                System.out.println("金额" + moneyStr + "的小数位多于两位。"); // 精度不能比分低
                flag = false;
            }
            return flag;
        }
        public static void main(String args[]) {
            System.out.println("请输入金额数：");
            Scanner scanner = new Scanner(System.in);
            String str = scanner.next();
            System.out.println("转换后的金额为：");
            System.out.println(getInstance().format(new Double(str)));
        }
  }