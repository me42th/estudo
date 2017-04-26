/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.me42th.controll;

import br.com.me42th.model.RCI;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author david
 */
@FacesConverter(forClass = RCI.class)
public class RCIConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        value = value.trim();
            if(!Pattern.matches("[0-9]{10}[-]?[0-9]{2}",value)){
                FacesMessage mensagem = new FacesMessage("Informe um RCI válido");
                mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ConverterException(mensagem);
            }
        int cont = 10;    
        String v1 = value.substring(0,10);
        String v2 = !value.contains("-")?value.substring(cont++,cont):value.substring(++cont,++cont) ;
        String v3 =  value.substring(cont,++cont);
        Boolean v4 = value.contains("-");
        
        return new RCI(
        v1,v2,v3,v4
        );
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return value.toString();
    }

    
}
