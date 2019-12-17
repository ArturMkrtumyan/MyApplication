package com.example.myapplication.Model;

import com.example.myapplication.R;

import java.util.ArrayList;

public class Singleton {

    private static Singleton instance;

    private ArrayList<User> users;

    private User user0 = new User(0, "Aram", "Aramyan", R.drawable.images1);
    private User user1 = new User(1, "Armen", "Armenyan", R.drawable.images2);
    private User user2 = new User(2, "Arsen", "Arsenysn", R.drawable.images3);
    private User user3 = new User(3, "Samvel", "Samvelyan", R.drawable.images4);
    private User user4 = new User(4, "Karen", "Karenysn", R.drawable.images5);
    private User user5 = new User(5, "Petros ", "Petrosysn", R.drawable.images6);
    private User user6 = new User(6, "Artur", "Arturyan", R.drawable.images7);
    private User user7 = new User(7, "Gnun", "Gnunyan", R.drawable.images8);
    private User user8 = new User(8, "Hrach", "Hrachyan", R.drawable.images9);
    private User user9 = new User(9, "Hamlet", "Hamletyan", R.drawable.images10);
    private User user10 = new User(10, "Xachik", "Xachikyan", R.drawable.images11);
    private User user11 = new User(11, "Mariam", "Mariamyan", R.drawable.images12);
    private User user12 = new User(12, "Laura", "Laurayan", R.drawable.images13);
    private User user13 = new User(13, "Ani", "Aniysn", R.drawable.images14);
    private User user14 = new User(14, "Lusine", "Lusineyan", R.drawable.images15);


    private Singleton() {
    }

    public ArrayList<User> getUsersList() {
        users = new ArrayList<>();

        users.add(user0);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user6);
        users.add(user7);
        users.add(user8);
        users.add(user9);
        users.add(user10);
        users.add(user11);
        users.add(user12);
        users.add(user13);
        users.add(user14);

        return users;
    }


    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
