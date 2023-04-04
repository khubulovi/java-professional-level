package lesson2.Server;


import lesson2.Auntetication.AuthenticationService;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class ChatServer implements Server {
    private Set<ClientHandler> clients;
    private AuthenticationService authenticationService;
    private Socket socket;
    private ServerSocket serverSocket;

    public ChatServer() {
        try {
            System.out.println("Server is starting up");
            serverSocket = new ServerSocket(8081);
            clients = new HashSet<>();
            authenticationService = new AuthenticationService();
            System.out.println("Server is up");
            while (true) {
                System.out.println("Server is waiting for clients");
                socket = serverSocket.accept();
                System.out.println("Client connected: " + socket);
                new ClientHandler(this, socket);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public synchronized void broadcastMessage(String message) {
        for (ClientHandler clientHandler : clients) {
            clientHandler.sendMessage(message);
        }
    }

    @Override
    public synchronized void sendPrivateMessage(ClientHandler sender, String nickname, String message) {
        for (ClientHandler clientHandler : clients) {
            if (clientHandler.getName().equals(nickname)) {
                clientHandler.sendMessage("From " + sender.getName() + ": " + message);
            }
        }
    }

    @Override
    public synchronized boolean isLoggedIn(String nickname) {
        for (ClientHandler clientHandler : clients) {
            return clientHandler.getName().equals(nickname);
        }
        return false;
    }

    @Override
    public synchronized void subscribe(ClientHandler client) {
        clients.add(client);
    }

    @Override
    public synchronized void unsubscribe(ClientHandler client) {
        clients.remove(client);
    }

    @Override
    public AuthenticationService getAuthenticationService() {
        return authenticationService;
    }
}
