package com.yunitski;

public class Pass {
    private static char lowChar(){
    char c = (char)((Math.random()*26)+97);
    return c;
}
    private static char upChar(){
        char c = (char)((Math.random()*26)+65);
        return c;
    }

    private static char num(){
        char c = (char)((Math.random()*10)+48);
        return c;
    }
    private static char symbol(){
        char c = (char) ((Math.random()*15)+33);
        return c;
    }
    private static int ran(){
        int i = (int)(Math.random()*12);
        return i;
    }
    public static StringBuilder generatePassWithAllChecks(int len){
        StringBuilder sp = new StringBuilder();
        for (int i = 0; i < len; i++){
            int r = ran();
            if (r < 3){
                sp.append(lowChar());
            }
            else if (r >= 3 && r < 6){
                sp.append(upChar());
            }
            else if (r >= 6 && r < 9){
                sp.append(num());
            }
            else if (r >= 9){
                sp.append(symbol());
            }
        }
        return sp;
    }
    public static StringBuilder getUpperOnly(int len){
        StringBuilder sp = new StringBuilder();
        for (int i = 0; i < len; i++){
            sp.append(upChar());
        }
        return sp;
    }
    public static StringBuilder getLowerOnly(int len){
        StringBuilder sp = new StringBuilder();
        for (int i = 0; i < len; i++){
            sp.append(lowChar());
        }
        return sp;
    }
    public static StringBuilder getNumsOnly(int len){
        StringBuilder sp = new StringBuilder();
        for (int i = 0; i < len; i++){
            sp.append(num());
        }
        return sp;
    }
    public static StringBuilder getSymOnly(int len){
        StringBuilder sp = new StringBuilder();
        for (int i = 0; i < len; i++){
            sp.append(symbol());
        }
        return sp;
    }
    public static StringBuilder getLowAndUp(int len){
        StringBuilder sp = new StringBuilder();

        for (int i = 0; i < len; i++){
            int r = ran();
            if (r < 6){
                sp.append(lowChar());
            } else {
                sp.append(upChar());
            }
        }
        return sp;
    }
    public static StringBuilder getLowAndNum(int len){
        StringBuilder sp = new StringBuilder();
        for (int i = 0; i < len; i++){
            int r = ran();
            if (r < 6){
                sp.append(lowChar());
            } else {
                sp.append(num());
            }
        }
        return sp;
    }
    public static StringBuilder getLowAndSym(int len){
        StringBuilder sp = new StringBuilder();
        for (int i = 0; i < len; i++){
            int r = ran();
            if (r < 6){
                sp.append(lowChar());
            } else {
                sp.append(symbol());
            }
        }
        return sp;
    }
    public static StringBuilder getUpAndNum(int len){
        StringBuilder sp = new StringBuilder();
        for (int i = 0; i < len; i++){
            int r = ran();
            if (r < 6){
                sp.append(upChar());
            } else {
                sp.append(num());
            }
        }
        return sp;
    }
    public static StringBuilder getUpAndSym(int len){
        StringBuilder sp = new StringBuilder();
        for (int i = 0; i < len; i++){
            int r = ran();
            if (r < 6){
                sp.append(upChar());
            } else {
                sp.append(symbol());
            }
        }
        return sp;
    }
    public static StringBuilder getNumAndSym(int len){
        StringBuilder sp = new StringBuilder();
        for (int i = 0; i < len; i++){
            int r = ran();
            if (r < 6){
                sp.append(num());
            } else {
                sp.append(symbol());
            }
        }
        return sp;
    }
    public static StringBuilder getLowAndUpAndSym(int len){
        StringBuilder sp = new StringBuilder();
        for (int i = 0; i < len; i++){
            int r = ran();
            if (r < 4){
                sp.append(lowChar());
            } else if (r >= 4 && r < 8){
                sp.append(upChar());
            } else if (r >= 8){
                sp.append(symbol());
            }
        }
        return sp;
    }
    public static StringBuilder getLowAndUpAndNum(int len){
        StringBuilder sp = new StringBuilder();
        for (int i = 0; i < len; i++){
            int r = ran();
            if (r < 4){
                sp.append(lowChar());
            } else if (r >= 4 && r < 8){
                sp.append(upChar());
            } else if (r >= 8){
                sp.append(num());
            }
        }
        return sp;
    }
    public static StringBuilder getUpAndSymAndNum(int len){
        StringBuilder sp = new StringBuilder();
        for (int i = 0; i < len; i++){
            int r = ran();
            if (r < 4){
                sp.append(num());
            } else if (r >= 4 && r < 8){
                sp.append(upChar());
            } else if (r >= 8){
                sp.append(symbol());
            }
        }
        return sp;
    }
    public static StringBuilder getSymAndNumAndLow(int len){
        StringBuilder sp = new StringBuilder();
        for (int i = 0; i < len; i++){
            int r = ran();
            if (r < 4){
                sp.append(lowChar());
            } else if (r >= 4 && r < 8){
                sp.append(num());
            } else if (r >= 8){
                sp.append(symbol());
            }
        }
        return sp;
    }
}
