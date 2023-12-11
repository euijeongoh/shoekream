package com.shoekream.member.util;

import java.util.Random;

public class GenerateTempPwd {
	
	private int pwdCycle = 2;
    private final char[] passwordFirst =  { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
                                            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 
                                            'w', 'x', 'y', 'z' };
    private final char[] passwordSecond = {'!', '@', '#', '$', '%', '^', '&', '*', '(' , ')'};
    private final char[] passwordThird = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
    private final char[] passwordRest = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
							            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 
							            'w', 'x', 'y', 'z', '!', '@', '#', '$', '%', '^', '&', '*',
							            '(', ')', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
    
    
    public String executeGenerate() {
        Random random = new Random(System.currentTimeMillis());
        int tablelength1 = passwordFirst.length;
        int tablelength2 = passwordSecond.length;
        int tablelength3 = passwordThird.length;
        int tablelengthR = passwordRest.length;
        
        StringBuffer buf = new StringBuffer();
        
        for(int i = 0; i < pwdCycle; i++) {
            buf.append(passwordFirst[random.nextInt(tablelength1)]);
            buf.append(passwordSecond[random.nextInt(tablelength2)]);
            buf.append(passwordThird[random.nextInt(tablelength3)]);
            buf.append(passwordRest[random.nextInt(tablelengthR)]);
        }
        
        return buf.toString();
    }

    public int getPwdCycle() {
        return pwdCycle;
    }

    public void setPwdCycle(int pwdLength) {
        this.pwdCycle = pwdCycle;
    }
	
}
