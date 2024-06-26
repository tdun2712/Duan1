/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Responsitory_IPL;

import java.util.ArrayList;
import model.KichThuoc;


/**
 *
 * @author phamt
 */
public interface KichThuocIPL {
    public ArrayList<KichThuoc> getALlKichThuoc();

    public Integer addKichThuoc(KichThuoc kichThuoc);

    public Integer updateKichThuoc(KichThuoc kichThuoc,int ID);

    public Integer delKichThuoc(int ID);
}
