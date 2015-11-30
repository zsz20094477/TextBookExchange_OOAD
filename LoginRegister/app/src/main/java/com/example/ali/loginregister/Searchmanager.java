package com.example.ali.loginregister;

/**
 * Created by Aayush on 11/28/2015.
 */
public class Searchmanager {
private String book;
    private String result;

    public Searchmanager(String title)
{
    book = title;

}

public void searchResult()
{

DatabaseManager ds = DatabaseManager.getInstance();
    ds.searchBook(book);


}

    public String getResult()
    {
        return result;
    }


}
