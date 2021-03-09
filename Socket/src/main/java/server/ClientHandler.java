package server;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private final Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run(){
        try (DataOutputStream out = new DataOutputStream(socket.getOutputStream());
             DataInputStream in = new DataInputStream(socket.getInputStream())){
            while (true){
                String command = in.readUTF();
                if ("upload".equals(command)){
                    try {
                        File file = new File("server" + File.separator + in.readUTF());
                        if (!file.exists()) {
                            file.createNewFile();
                        }
                        long size = in.readLong();
                        FileOutputStream fos = new FileOutputStream(file);
                        byte[] buffer = new byte[256];
                        for (int i = 0; i < (size+255)/256; i++) {//FIXME
                            int read = in.read(buffer);
                            fos.write(buffer, 0, read);
                        }
                        fos.close();
                        out.writeUTF("Done");
                    }catch (Exception e){
                        out.writeUTF("Error");
                    }
                } else if ("download".equals(command)){
                    // TODO: 02.03.2021
                }else if ("remove".equals(command)){
                    // TODO: 02.03.2021
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
