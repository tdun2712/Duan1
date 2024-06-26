/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Responsitory_IPL;

import java.util.ArrayList;
import model.Anh;


/**
 *
 * @author phamt
 */
public interface AnhIPL {
     public ArrayList<Anh> getALlAnh();

    public Integer addAnh(Anh anh);

    public Integer updateAnh(Anh anh,int ID);

    public Integer delAnh(int ID);
}
