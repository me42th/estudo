/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package go_johnny;

import br.com.me42th.dao.EditoraDAO;



public class johnny {
    public static void main(String[] args) {
       EditoraDAO.remove(EditoraDAO.search(1));
       
        System.out.println(EditoraDAO.search(1));
    }
}
