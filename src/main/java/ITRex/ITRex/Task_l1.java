package ITRex.ITRex;

import java.util.Arrays;

public class Task_l1 {

    public static void main(String[] args) {

	String str = "suscessss the thee dcckcaoouoo a ae and coffee";
	System.out.println(simplifyText(str));
    }

    public static String simplifyText(String str) {

	String originalStr = str;

	str = removeC(str);

	str = removeDouble(str);

	str = removeE(str);

	str = removeArticles(originalStr, str);

	return str;
    }

    public static String removeArticles(String originalStr, String str) {

	String originalArray[] = originalStr.split(" ");
	String strArray[] = str.split(" ");
	int emptySpace = 0;

	for (int i = 0; i < originalArray.length; i++) {
	    String word = originalArray[i];

	    if (word.equals("")) {
		emptySpace++;
		continue;
	    } else if (word.matches("\\b(the|a|an)\\b")) {
		strArray[i - emptySpace] = "";
	    }
	}

	str = Arrays.toString(strArray).replace(",", "").replaceAll("[\\[\\]]", "");

	return str;
    }

    public static String removeE(String str) {

	str = str.replaceAll("e(?!\\S)", "");

	return str;
    }

    public static String removeDouble(String str) {

	String strPrevious = "";

	while (!str.equals(strPrevious)) {
	    strPrevious = str;

	    str = str.replaceAll("(e)\\1", "i");

	    str = str.replaceAll("(o)\\1", "u");

	    str = str.replaceAll("(.)\\1", "$1");
	}
	return str;
    }

    public static String removeC(String str) {

	int indexC = str.indexOf("c");

	while (indexC != -1) {
	    String combination = "";

	    if (indexC + 1 != str.length()) {
		combination = str.substring(indexC, indexC + 2);
	    } else {
		combination = str.substring(indexC, indexC + 1);
	    }

	    switch (combination) {
	    case "ci":
		str = str.substring(0, indexC) + "si" + str.substring(indexC + 2);
		break;
	    case "ce":
		str = str.substring(0, indexC) + "se" + str.substring(indexC + 2);
		break;
	    case "ck":
		str = str.substring(0, indexC) + "k" + str.substring(indexC + 2);
	    default:
		str = str.substring(0, indexC) + "k" + str.substring(indexC + 1);
		break;
	    }
	    indexC = str.indexOf("c");
	}
	return str;
    }

}
