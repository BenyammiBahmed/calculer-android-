package com.example.bahmed.calculator;

public class cal {
    public static int nbrop(String s) {
        int nbr = 0;
        if(s.length()>0)

            if (s.charAt(0)=='-')
                s=s.substring(1, s.length());
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) == '/') || (s.charAt(i) == 'X') || (s.charAt(i) == '-') || (s.charAt(i) == '+'))
                nbr++;

        }
        return nbr;
    }

    public static int nbropmul(String s) {
        int nbr = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) == '/') || (s.charAt(i) == 'X'))
                nbr++;

        }
        return nbr;
    }

    public static int posopmult(String s) {

        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) == '/') || (s.charAt(i) == 'X'))
                return i;

        }

        return -1;
    }

    public static int posop(String s) {
        if (s.charAt(0)=='-')
            s=s.substring(1, s.length());

        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) == '/') || (s.charAt(i) == 'X') || (s.charAt(i) == '-') || (s.charAt(i) == '+'))
                return i;

        }

        return -1;
    }

    public static int lastposop(String s) {

        for (int i = s.length()-1; i >= 0; i--) {

            if ( (s.charAt(i) == '-') || (s.charAt(i) == '+'))
                return i;

        }

        return -1;
    }
    public static int lastposop2(String s) {

        for (int i = s.length()-1; i >= 0; i--) {

            if ( (s.charAt(i) == '-') || (s.charAt(i) == '+')|| (s.charAt(i) == 'X')|| (s.charAt(i) == '/'))
                return i;

        }

        return -1;
    }


    public static String resultat(String s) {
        int i;
        double a, b;
        boolean l=false;
        while (nbrop(s) != 0) {
            l=true;
            while (nbropmul(s) != 0) {

                i = posopmult(s);
                if (nbrop(s.substring(0, i - 1)) == 0) {
                    a = Double.parseDouble(s.substring(0, i));

                    if (posop(s.substring(i + 1, s.length())) != -1)
                        b = Double.parseDouble(s.substring(i + 1, i + 1 + posop(s.substring(i + 1, s.length()))));
                    else
                        b = Double.parseDouble(s.substring(i + 1, s.length()));
                    switch (s.charAt(i)) {
                        case '/':
                            if (b == 0)
                                return "erreur";
                            if (nbrop(s.substring(i + 1, s.length())) == 0)
                                s = String.valueOf(a / b);
                            else
                                s = a / b + s.substring(i + 1 + posop(s.substring(i)));
                            break;
                        case 'X':
                            if (nbrop(s.substring(i + 1, s.length())) == 0)
                                s = String.valueOf(a * b);
                            else
                                s = a * b + s.substring(i + 1 + posop(s.substring(i)));
                    }

                } else {
                    a = Double.parseDouble(s.substring(lastposop(s.substring(0, i - 1)) + 1, i));

                    if (posop(s.substring(i + 1, s.length())) != -1)
                        b = Double.parseDouble(s.substring(i + 1, i + 1 + posop(s.substring(i + 1, s.length()))));
                    else
                        b = Double.parseDouble(s.substring(i + 1, s.length()));

                    switch (s.charAt(i)) {
                        case '/':
                            if (b == 0)
                                return "erreur";
                            s = s.substring(0, 1 + lastposop(s.substring(0, i - 1))) + a / b
                                    + s.substring(i + 1 + posop(s.substring(i + 1)), s.length());

                            break;
                        case 'X':
                            s = s.substring(0, 1 + lastposop(s.substring(0, i - 1))) + a * b
                                    + s.substring(i + 1 + posop(s.substring(i + 1)), s.length());

                            break;
                    }
                }
            }
            if (nbrop(s) != 0) {
                i = posop(s);
                if (nbrop(s.substring(0, i)) == 0) {

                    a = Double.parseDouble(s.substring(0, i));

                    if (posop(s.substring(i + 1, s.length())) != -1) {
                        System.out.println("jgnjg" + s.substring(i + 1, i + 1 + posop(s.substring(i + 1, s.length()))));
                        b = Double.parseDouble(s.substring(i + 1, i + 1 + posop(s.substring(i + 1, s.length()))));
                    } else
                        b = Double.parseDouble(s.substring(i + 1, s.length()));

                    switch (s.charAt(i)) {
                        case '+':
                            if (nbrop(s.substring(i + 1, s.length())) == 0)
                                s = String.valueOf(a + b);
                            else
                                s = (a + b) + (s.substring(i + 1 + posop(s.substring(i + 1, s.length())), s.length()));
                            System.out.println(a + b);
                            break;
                        case '-':
                            if (nbrop(s.substring(i + 1, s.length())) == 0)
                                s = String.valueOf(a - b);
                            else
                                s = (a - b) + s.substring(i + 1 + posop(s.substring(i + 1, s.length())));
                            break;
                    }

                }

                else {
                    a = Double.parseDouble(s.substring(lastposop(s.substring(0, i - 1)), i));

                    if (posop(s.substring(i + 1, s.length())) != -1)
                        b = Double.parseDouble(s.substring(i + 1, posop(s.substring(i + 1, s.length()))));
                    else
                        b = Double.parseDouble(s.substring(i + 1, s.length()));

                    switch (s.charAt(i)) {
                        case '+':
                            if (nbrop(s.substring(i + 1, s.length())) == 0)
                                s = String.valueOf(a + b);
                            else

                                s = s.substring(0, lastposop(s.substring(0, i - 1))) + (a + b)
                                        + s.substring(posop(s.substring(i)));

                            break;
                        case '-':
                            if (nbrop(s.substring(i + 1, s.length())) == 0)
                                s = String.valueOf(a - b);
                            else
                                s = s.substring(0, lastposop(s.substring(0, i - 1))) + (a - b)
                                        + s.substring(posop(s.substring(i)));
                    }

                }
            }
        }
        if(l){
        double d=Double.parseDouble(s)%1;

        if(d==0)
            s=String.valueOf(s.substring(0,s.length()-2));}
        return s;

    }
    public static   boolean nbrpoint(String s){
        for (int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='.')
                return true;
        }
        return false;
    }
}
