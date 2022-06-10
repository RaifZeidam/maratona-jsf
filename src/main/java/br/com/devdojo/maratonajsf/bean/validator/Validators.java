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
import javax.servlet.http.Part;
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
    public void validateFile(FacesContext context, UIComponent component, Object value)
            throws ValidatorException {
        Part file = (Part) value;

        try{
            validateFileNameLength(file);
            validateContentType(file);
            validateFileSize(file);
        }catch(RuntimeException e){
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    e.getMessage(),
                    "");
            throw new ValidatorException(message);
        }
    }
    private void validateFileNameLength(Part file) {
        if(file.getSubmittedFileName().length() > 10) {
            throw new RuntimeException("O nome + extensão não pode ser maior que 10 caracteres");
        }
    }
    private void validateContentType(Part file) {
        String contentType = file.getContentType();
        if(!contentType.equals("image/png") && !contentType.equals("image/jpge")) {
            throw new RuntimeException("Apenas imagens PNG e JPEG são permitidas");
        }
    }
    private void validateFileSize(Part file) {
        if(file.getSize() > 1048576) {
            throw new RuntimeException("O arquivo não pode exceder 1MB");
        }
    }
}
