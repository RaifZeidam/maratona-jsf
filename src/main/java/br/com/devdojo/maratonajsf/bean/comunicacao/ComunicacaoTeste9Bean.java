package br.com.devdojo.maratonajsf.bean.comunicacao;

import org.omnifaces.util.Faces;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;

/**
 * Created by Bakawaii on 31/05/2022.
 */
@Named
@ViewScoped
public class ComunicacaoTeste9Bean implements Serializable {
    private String value;

    public void init() {
        value =Faces.getRequestCookie("nome");
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
