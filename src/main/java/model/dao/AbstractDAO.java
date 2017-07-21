package model.dao;

import model.data.Base;

public interface AbstractDAO {          //Интерфейс с основными функциями всех будущих возможных DAO
    void saveBase(Base base);
    Base getBase();
}
