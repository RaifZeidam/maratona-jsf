package br.com.devdojo.maratonajsf.bean.validation;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by Bakawaii on 02/06/2022.
 */
@Named
@ViewScoped
public class ValidationTesteBean implements Serializable {
    private String password;

    public void save(){
        System.out.println(password);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
