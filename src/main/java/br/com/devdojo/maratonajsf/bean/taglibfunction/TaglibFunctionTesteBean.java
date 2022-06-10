package br.com.devdojo.maratonajsf.bean.taglibfunction;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by Bakawaii on 10/06/2022.
 */
@Named
@ViewScoped
public class TaglibFunctionTesteBean implements Serializable {
    private List<String> names = asList("shimazu toyoshisa", "oda nobunaga", "nasu no yoichi");

    public void init() {
        names.forEach(name -> System.out.println(WordUtils.capitalizeFully(name)));
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }
}
