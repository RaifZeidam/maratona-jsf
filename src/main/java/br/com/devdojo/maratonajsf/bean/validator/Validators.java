package br.com.devdojo.maratonajsf.bean.validator;

import br.com.devdojo.maratonajsf.bean.login.LoginBean;
import org.omnifaces.util.Callback;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by Bakawaii on 02/06/2022.
 */
@Named
@RequestScoped
public class Validators implements Serializable {
    private List<String> emailsDB = asList("alo@gmail.com", "tchau@gmail.com");

    @Inject
    private LoginBean loginBean;

    public void validateDuplicatedEmail(FacesContext context, UIComponent component, Object value)
            throws ValidatorException {
//        System.out.println(loginBean.getLanguage());
        String email = (String) value;
        if (emailsDB.contains(email)) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "O email já existe cadastrado",
                    "");
            throw new ValidatorException(message);
        }
    }
}
