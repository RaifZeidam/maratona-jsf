package br.com.devdojo.maratonajsf.taglibfunction;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;

/**
 * Created by Bakawaii on 10/06/2022.
 */
public class TagLibFunctions {
    public static String capitalize(String str) {
        return WordUtils.capitalizeFully(str);
    }
}