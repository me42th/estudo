/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.me42th.controll;

import br.com.me42th.model.CPF;
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
@FacesConverter(forClass = CPF.class)
public class CPFConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        value = value.trim();
        if(!Pattern.matches("[0-9]{9}[-][0-9]{2}",value)){
            FacesMessage mensagem = new FacesMessage("Informe um CPF valido"+value);
            mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ConverterException(mensagem);
        }
        
        return new CPF(
                value.split("-")[0],
                value.split("-")[1].charAt(0),
                value.split("-")[1].charAt(1)
        ); 
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
       return value.toString();
    }
    
}
