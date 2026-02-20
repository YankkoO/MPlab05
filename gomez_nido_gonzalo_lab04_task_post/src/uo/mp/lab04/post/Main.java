package uo.mp.lab04.post;

import uo.mp.lab04.post.ui.NetworkApp;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        new NetworkApp().simulateClient();
    }

}
