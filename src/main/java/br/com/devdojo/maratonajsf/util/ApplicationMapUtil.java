package br.com.devdojo.maratonajsf.util;

import javax.faces.context.FacesContext;

/**
 * Created by Bakawaii on 01/06/2022.
 */
public class ApplicationMapUtil {
    public static Object getValueFromApplicationMap (String key){
        return FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().get(key);
    }

    public static void setValueInApplicationMap (String key, Object value){
        FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().put(key,value);
    }
}
