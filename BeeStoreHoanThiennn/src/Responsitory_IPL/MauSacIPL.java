/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Responsitory_IPL;

import java.util.ArrayList;
import model.MauSac;

/**
 *
 * @author phamt
 */
public interface MauSacIPL {

    public ArrayList<MauSac> getALlMauSac();

    public Integer addMauSac(MauSac mauSac);

    public Integer updateMauSac(MauSac mauSac,int Id);

    public Integer delMauSac(int ID);
    
    MauSac getID(String ten);
}
