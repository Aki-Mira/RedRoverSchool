//DESCRIPTION:
//        Check to see if a string has the same amount of 'x's and 'o's. The method must return a boolean and be case insensitive. The string can contain any char.
//
//        Examples input/output:
//
//        XO("ooxx") => true
//        XO("xooxx") => false
//        XO("ooxXm") => true
//        XO("zpzpzpp") => true // when no 'x' and 'o' is present should return true
//        XO("zzoo") => false
//SOLUTION:
public class Main {
    public static void main(String[] args) {
String string = "ooxXm";
System.out.println(getXO(string));

    }
    public static boolean getXO (String str) {
    str = str.toLowerCase();
    System.out.println(str);
    String [] letters = str.split("");
    int countO = 0;
    int countX = 0;
    for (String letter : letters) {
        if ( letter.equals("o") ) {
            countO++;
        }
            else if ( letter.equals("x") ) {
            countX++;
        }
                else {
                    continue;
            }
        }
    if ( countX == countO ) {
        return true;
    }
    else {
        return false;
    }
    }

    }
