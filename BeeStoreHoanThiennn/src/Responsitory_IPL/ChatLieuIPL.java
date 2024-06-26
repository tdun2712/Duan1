/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Responsitory_IPL;

import java.util.ArrayList;
import model.ChatLieu;
import model.KichThuoc;

/**
 *
 * @author phamt
 */
public interface ChatLieuIPL {
  public ArrayList<ChatLieu> getALlChatLieu();

    public Integer addChatLieu(ChatLieu chatLieu);

    public Integer updateChatLieu(ChatLieu chatLieu,int ID);

    public Integer delChatLieu(int ID);
}
