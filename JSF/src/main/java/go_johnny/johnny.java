/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package go_johnny;

import br.com.me42th.dao.cap1.FaturaDAO;
import br.com.me42th.model.cap1.Fatura;




public class johnny {
    public static void main(String[] args) {
        System.out.println(FaturaDAO.save(Fatura.getFatura()).getId());
    }
}
