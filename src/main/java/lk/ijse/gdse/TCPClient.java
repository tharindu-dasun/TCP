package lk.ijse.gdse;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws IOException {

        //01. client enter k sentence eka
        String sentence;
        //02. server eken capitalized karala dena sentence eka
        String capitalizedSentence;

        //03. userge input eka ganna
        //System.in = inputStreamObject (inputStreamObject ta puluwan eka sarekata eka byte ekka gane read k)
        //InputStreamReader deal k data wala byte stream ekath ekka
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

        //04. client socket ekak hadaganna one eka ganna
        Socket clientSocket = new Socket("localhost",9806);

        //05. Client gen string eka ganna
        System.out.println("Enter a String !");

        //06. E gaththa string eka Server ekata yawanna one (Output stram)
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

        //07.to read the String Client entered
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        //08. Read line
        sentence = inFromUser.readLine();

        //09. yawanna one server ekata
        outToServer.writeBytes(sentence + '\n');

        //10. server eken modified sentence eka enawa eka ganna
        //(Server eken ena eke line eka read karanna)
        capitalizedSentence = inFromServer.readLine();

        //11. print the modified sentence // modifiedSentence
        System.out.println("FROM SERVER : " + capitalizedSentence);

        //12. connection eka awasan nisa socket eka close k
        clientSocket.close();
    }
}
