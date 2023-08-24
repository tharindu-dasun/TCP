package lk.ijse.gdse;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {

        //01.Client gen ganna string eka store karala thiyaganna variable 1
        String clientSentence;
        //02.Server eka magin Capital k eka thiyaganna thawa variable ekak one
        String capitalizedSentence;

        System.out.println("Waiting for Clients !");

        //03.create server socket
        ServerSocket welcomeSocket = new ServerSocket(9806);

        //04.client kenekgen mokak hari request ekak enakn server eka wait wela thiyenna

        while (true){
            Socket connectionSocket = welcomeSocket.accept();
            System.out.println("Connection is stablished !");

            //05.to read the String Client sent
            // (Socket eke input stream eken data tika read karagannawa )
            BufferedReader inFormClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            //06.Outputstream -- client ta yawanawa
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

            //07.Client gen ganna sentence eka store karaganna one kalin gaththu variable ekata
            clientSentence = inFormClient.readLine();

            //08.Client ewana eka Capital karala aai client ta yawana nisa e okkoma capital krn inna one
            capitalizedSentence =clientSentence.toUpperCase();

            //09.client ta send k one , byte eken byte ekta liyawenne(writeBytes)
            outToClient.writeBytes(capitalizedSentence);
        }
    }
}
