package com.fpp.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Item extends MySql {
    
    public Item() throws IllegalAccessException, InstantiationException {
        this.connect();
    }

	public void getItem(int id) throws InstantiationException, IllegalAccessException, SQLException {
        String sql = "SELECT * FROM items WHERE `id` =? LIMIT 1";
        PreparedStatement ps = conn.prepareStatement(sql);
       
        
        close();
//        if (list!=null) //return list.get(0);
//        return null;
    }

	/*public List<Item> rows(ResultSet rs) throws SQLException {
        if(rs!=null){
            List<Item> list=new ArrayList<Item>();
            while (rs.next()){
                list.add(row(rs));
            }
            return list;
        }
        return null;
    }*/
	
//	public Item row(ResultSet rs) throws SQLException {
//        Item item = new Item();
//        item.setId(rs.getInt("id"));
//        item.setName(rs.getString("name"));
//        item.setCategory(rs.getString("category"));
//        item.setAddedBy(rs.getInt("added_by"));
//        item.setPrice(rs.getDouble("price"));
//        item.setStatus(rs.getString("status"));
//        item.setContactPerson(rs.getString("contact_person"));
//        item.setContactPhone(rs.getString("contact_phone"));
//        item.setDetails(rs.getString("details"));
//        return item;
//    }

}
