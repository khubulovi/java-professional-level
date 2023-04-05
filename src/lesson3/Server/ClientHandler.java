package lesson3.Server;



import lesson3.User.User;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Objects;

public class ClientHandler {
    private Server server;
    private Socket socket;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;

    private String name;

    public ClientHandler(Server server, Socket socket) {
        try {
            this.server = server;
            this.socket = socket;
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());

            listenForClientMessage();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    private void doAuthentication() {
        try {
            while (true) {
                boolean checkIsLoggedIn = false;
                String str = dataInputStream.readUTF();
                if (str.startsWith("/auth")) {
                    String[] parts = str.split("\\s");
                    User user = server.getAuthenticationService().doAuthentication(parts[1], parts[2]);
                    if (user != null) {
                        if (!server.isLoggedIn(user.getNick())) {
                            checkIsLoggedIn = true;
                            sendMessage("Login successful");
                            name = user.getNick();
                            server.broadcastMessage(name + " is logged in");
                            server.subscribe(this);
                        } else {
                            sendMessage("Authentication error. Account already logged in.");
                        }
                    } else {
                        sendMessage("Wrong login or password");
                    }
                }
                if (checkIsLoggedIn)
                    return;
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }


    private void listenForClientMessage() {
        new Thread(() -> {
            try {
                doAuthentication();
                receiveMsg();
            } catch (Exception exception) {
                exception.printStackTrace();
            } finally {
                server.unsubscribe(this);
            }
        }).start();
    }

    private void receiveMsg() {
        try {
            while (true) {
                StringBuilder message = new StringBuilder(dataInputStream.readUTF());
                if (message.toString().equals("/exit")) {
                    break;
                }
                if (message.toString().contains("/w")) {
                    String[] parts = message.toString().split("\\s");
                    String nickname = parts[1];
                    message = new StringBuilder();
                    for (int i = 0; i < parts.length; i++) {
                        if (i > 1) {
                            message.append(" ").append(parts[i]);
                        }
                    }
                    server.sendPrivateMessage(this, nickname, message.toString());
                } else {
                    server.broadcastMessage(name + ": " + message.toString());
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void sendMessage(String message) {
        try {
            dataOutputStream.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        ClientHandler that = (ClientHandler) object;
        return Objects.equals(server, that.server) &&
                Objects.equals(socket, that.socket) &&
                Objects.equals(dataInputStream, that.dataInputStream) &&
                Objects.equals(dataOutputStream, that.dataOutputStream) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(server, socket, dataInputStream, dataOutputStream, name);
    }
}
