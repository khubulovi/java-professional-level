package lesson2.Server;


import lesson2.Auntetication.AuthenticationService;

public interface  Server {
    void broadcastMessage(String message);

    void sendPrivateMessage(ClientHandler sender, String nickname, String message);

    boolean isLoggedIn(String nickname);

    void subscribe(ClientHandler client);

    void unsubscribe(ClientHandler client);


    AuthenticationService getAuthenticationService();
}
