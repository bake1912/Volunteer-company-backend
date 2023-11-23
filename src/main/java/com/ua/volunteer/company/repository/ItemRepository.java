package com.ua.volunteer.company.repository;

import com.ua.jooq.Tables;
import com.ua.volunteer.company.entity.Item;
import com.ua.volunteer.company.entity.Photo;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ItemRepository {

    @Autowired
    private DSLContext dsl;

    public List<Item> getAllItems(){
        List<Item> items = dsl.select().from(Tables.CLOTHINGITEM).fetchInto(Item.class);
        return items;
    }

    public Item getItem(Integer id){
        Item item = dsl.select().from(Tables.CLOTHINGITEM)
                .where(Tables.CLOTHINGITEM.ID.eq(id))
                .fetchOneInto(Item.class);
        return item;
    }

    public Item updateItem(Item item){
        Item returningItem = dsl.update(Tables.CLOTHINGITEM)
                .set(Tables.CLOTHINGITEM.DESCRIPTION,item.getDescription())
                .set(Tables.CLOTHINGITEM.SEX_NAME,item.getSexName())
                .set(Tables.CLOTHINGITEM.SIZE_NAME,item.getSizeName())
                .set(Tables.CLOTHINGITEM.TYPE_NAME,item.getTypeName())
                .set(Tables.CLOTHINGITEM.NAME,item.getName())
                .where(Tables.CLOTHINGITEM.ID.eq(item.getId()))
                .returning()
                .fetchOneInto(Item.class);
        return returningItem;
    }

    public void deleteItem(Integer id){
        dsl.delete(Tables.CLOTHINGITEM).where(Tables.CLOTHINGITEM.ID.eq(id)).execute();
    }

    public Item createItem(Item item){
        Item returningItem = dsl.insertInto(Tables.CLOTHINGITEM)
                .set(Tables.CLOTHINGITEM.DESCRIPTION,item.getDescription())
                .set(Tables.CLOTHINGITEM.SEX_NAME,item.getSexName())
                .set(Tables.CLOTHINGITEM.SIZE_NAME,item.getSizeName())
                .set(Tables.CLOTHINGITEM.TYPE_NAME,item.getTypeName())
                .set(Tables.CLOTHINGITEM.NAME,item.getName())
                .returning()
                .fetchOneInto(Item.class);
        return returningItem;
    }

    public void createPhoto(Integer itemId,byte[] photo){
        dsl.insertInto(Tables.ITEMPHOTO)
                .set(Tables.ITEMPHOTO.PHOTO,photo)
                .set(Tables.ITEMPHOTO.ITEM_ID,itemId)
                .execute();
    }

public List< Photo> getItemPhotos(Integer id){
       List <Photo> photos = dsl.select().from(Tables.ITEMPHOTO)
                .where(Tables.ITEMPHOTO.ITEM_ID.eq(id))
                .fetchInto(Photo.class);
       return  photos;
}

}
