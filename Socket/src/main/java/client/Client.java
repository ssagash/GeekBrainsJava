package client;

import javax.print.attribute.standard.JobHoldUntil;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.Socket;

public class Client {
    private final Socket socket;
    private final DataInputStream in;
    private final DataOutputStream out;


    public Client() throws IOException {
        socket = new Socket("localhost",1236);
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        runClient();
    }
    private void runClient(){
        JFrame frame = new JFrame("Cloud Storage");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,300);
        JTextArea ta= new JTextArea();
        JButton uploadButton = new JButton("Upload");
        frame.getContentPane().add(BorderLayout.CENTER,ta);
        frame.getContentPane().add(BorderLayout.SOUTH,uploadButton);
        frame.setVisible(true);
        uploadButton.addActionListener(a -> {
            System.out.println(sendFile(ta.getText()));
        });

    }

    private String sendFile(String filename) {
        try{
            File file = new File("client" + File.separator + filename);
            if ((file.exists())) {
                out.writeUTF("upload");
                out.writeUTF(filename);
                long length = file.length();
                out.writeLong(length);
                FileInputStream fis = new FileInputStream(file);
                int read = 0;
                byte[] buffer = new byte[256];
                while((read = fis.read(buffer)) != -1){
                    out.write(buffer,0,read);
                }
                out.flush();
                String status = in.readUTF();
                return status;
            }
            else {
                return "File is not exists";
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return "error";
    }

    public static void main(String[] args) throws IOException {
        new Client();

    }
}
