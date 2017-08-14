package view;

import controllers.DownloadController;
import exceptions.MyNotPhoneNumberException;
import factory.EntityFactory;
import model.data.Contact;
import model.data.Group;
import model.services.ContactService;
import model.services.GroupService;
import org.xml.sax.SAXException;


import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

public class View implements Observer{


    private DownloadController controller = new DownloadController();
    private EntityFactory entityFactory = new EntityFactory();
    private boolean log = true;

    public void update(Observable model, Object bool){          //Основная функция визуализации

        Scanner in = new Scanner(System.in);
        RequestEnum req = RequestEnum.o;                              //Инициализация перечиления команд

        while (log) {
            System.out.println("Введите логин:");
            String login = in.nextLine();
            System.out.println("Введите пароль");
            String password = in.nextLine();

            log = !controller.login(login, password);
        }


        while (true) {
            if(req == RequestEnum.l){                              //Команда выхода из программы
                break;
            }
            else {
                switch (req) {
                    case o:                                     //Команда на вывод меню (команда по умолчанию)

                        System.out.println(" Выберите букву запроса");
                        System.out.println("a Создание контакта\n" +
                                "b Редактирование контакта\n" +
                                "c Удаление контакта\n" +
                                "d Назначение группы контакту (лейбл)\n" +
                                "e Удаление группы у контакта\n" +
                                "f Просмотр информации о контактах\n" +
                                "g Просмотр контактов определенной группы\n" +
                                "h Просмотр списка всех групп\n" +
                                "i Добавление новой группы\n" +
                                "j Удаление группы\n" +
                                "k Редактирование группы\n" +
                                "l Выйти");
                        req = RequestEnum.valueOf(in.nextLine());
                        break;

                    case a:                                     //Команда добавления контакта

                        addContact();
                        req = RequestEnum.o;
                        continue;

                    case b:                                     //Команда редактирования контакта

                        redContact();
                        req = RequestEnum.o;
                        continue;

                    case c:                                     //Команда удаления контакта

                        try {
                            delContact();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        req = RequestEnum.o;
                        continue;

                    case d:                                     //Команда назначения группы контакту

                        try {
                            addContactGroup();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        req = RequestEnum.o;
                        continue;

                    case e:                                     //Команда удаления группы у контакта

                        try {
                            delContactGroup();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        req = RequestEnum.o;
                        continue;

                    case f:                                     //Команда отображения всех контактов

                        try {
                            System.out.println(ContactService.getInstance().getAll());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        req = RequestEnum.o;
                        continue;

                    case g:                                     //Команда отображения контактов определённой группы
                        try {
                            showGroupContact();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        req = RequestEnum.o;
                        continue;

                    case h:                                     //Команда отображения всех групп

                        try {
                            System.out.println(GroupService.getInstance().getAll());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        req = RequestEnum.o;
                        continue;

                    case i:                                     //Команда добавления новой группы

                        addGroup();
                        req = RequestEnum.o;
                        continue;

                    case j:                                     //Команда удаления группы

                        try {
                            delGroup();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        req = RequestEnum.o;
                        continue;

                    case k:                                     //Команда редактирования группы

                        try {
                            redGroup();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        req = RequestEnum.o;
                        continue;
                }
            }
        }
    }

    public void addContact() {                                   //Функция добавления контакта

        try {                                                   //Проверка кастомного исключения на проверку на номер телефона
            Scanner in = new Scanner(System.in);
            System.out.print("Введите имя: ");
            String name = in.nextLine();
            System.out.print("Введите фамилию: ");
            String lustName = in.nextLine();
            System.out.print("Введите номер: ");
            String number = in.nextLine();
            controller.addContact((Contact) entityFactory.getEntity(name, lustName, number));
        }
        catch (Exception e){
            System.out.println("Введите корректный номер");
        }
    }

    public void redContact(){                                   //Функция редактирования контакта

        try {                                                   //Проверка кастомного исключения на проверку на номер телефона

            Scanner in = new Scanner(System.in);
            System.out.print("Выберите индекс контакта: ");
            System.out.println(ContactService.getInstance().getAll());
            int id = in.nextInt();
            String next = in.nextLine();
            System.out.print("Введите имя: ");
            String name = in.nextLine();
            System.out.print("Введите фамилию: ");
            String lustName = in.nextLine();
            System.out.print("Введите номер: ");
            String number = in.nextLine();

            for (Contact contact : ContactService.getInstance().getAll()) {
                if (id == contact.getId()) {
                    contact.setFirstName(name);
                    contact.setLastName(lustName);
                    contact.setNumber(number);
                    controller.updateContact(contact, id);
                }
            }

        }
        catch (MyNotPhoneNumberException e){
            System.out.println("Введите корректный номер");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delContact() throws Exception {                                   //Функция удаления контакта

        Scanner in = new Scanner(System.in);
        System.out.println(ContactService.getInstance().getAll());
        System.out.print("Выберите индекс контакта: ");

        int id = in.nextInt();

        controller.deliteContact(id);
    }

    public void addContactGroup() throws Exception {                              //Функция назначения группы контакту

        Scanner in = new Scanner(System.in);
        System.out.println(ContactService.getInstance().getAll());
        System.out.print("Выберите индекс контакта: ");

        int idC = in.nextInt();
        System.out.println(GroupService.getInstance().getAll());
        System.out.print("Выберите индекс группы: ");

        int idG = in.nextInt();

        controller.addContactGroup(idC,idG);


    }

    public void delContactGroup() throws Exception {                              //Функция удаления группы у контакта

        Scanner in = new Scanner(System.in);
        System.out.println(ContactService.getInstance().getAll());
        System.out.print("Выберите индекс контакта: ");

        int idC = in.nextInt();

        for (Contact contact :ContactService.getInstance().getAll()){
            if (contact.getId() == idC){
                if(!contact.getGroupId().isEmpty()) {
                    System.out.println("Выберите индекс группы");
                    int idG = in.nextInt();
                    controller.removeContactGroup(idC,idG);
                }
            }
        }
    }

    public void showGroupContact() throws Exception {                             //Функция отображения всех контактов заданной группы

        Scanner in = new Scanner(System.in);
        System.out.println(GroupService.getInstance().getAll());
        System.out.print("Выберите индекс группы: ");

        int idG = in.nextInt();

        for (Contact contact :ContactService.getInstance().getAll()){
            if(!contact.getGroupId().isEmpty()) {
                if (contact.containGroup(idG)){
                    System.out.println(contact);
                }
            }
        }
    }

    public void addGroup(){                                     //Функция создания новой группы

        Scanner in = new Scanner(System.in);
        System.out.print("Введите название: ");
        String name = in.nextLine();
        controller.addGroup((Group)entityFactory.getEntity(name));
    }

    public void delGroup() throws Exception {                                     //Функция удаления группы

        Scanner in = new Scanner(System.in);
        System.out.println(GroupService.getInstance().getAll());
        System.out.print("Выберите индекс группы: ");
        int id = in.nextInt();

        controller.deliteGroup(id);
    }

    public void redGroup() throws Exception {                                     //Функция редактирования группы

        Scanner in = new Scanner(System.in);
        System.out.println(GroupService.getInstance().getAll());
        System.out.print("Выберите индекс группы: ");
        int id = in.nextInt();
        System.out.println("Выберите название: ");
        String name = in.nextLine();

        for (Group group:GroupService.getInstance().getAll()){
            if (group.getId() == id){
                group.setName(name);
                controller.updateGroup(group,id);
            }
        }
    }

}
