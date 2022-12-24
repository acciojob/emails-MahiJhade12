package com.driver;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

public class Gmail extends Email {


    public class mail{
        Date date;
        String sender;
        String message;
        mail(Date date, String sender, String message){
            this.date=date;
            this.sender=sender;
            this.message=message;
        }
    }
    int inboxCapacity;
    ArrayList<mail> received;
    ArrayList<mail> trash;
    //maximum number of mails inbox can store
    //Inbox: Stores mails. Each mail has date (Date), sender (String), message (String). It is guaranteed that message is distinct for all mails.
    //Trash: Stores mails. Each mail has date (Date), sender (String), message (String)
    public Gmail(String emailId, int inboxCapacity) {
        super(emailId);
        this.inboxCapacity=inboxCapacity;
        this.received=new ArrayList<>();
        this.trash=new ArrayList<>();
    }

    public void receiveMail(Date date, String sender, String message){
        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
        // It is guaranteed that:
        // 1. Each mail in the inbox is distinct.
        // 2. The mails are received in non-decreasing order. This means that the date of a new mail is greater than equal to the dates of mails received already.
         mail newMail=new mail(date,sender,message);
        if(received.size()==inboxCapacity){
             trash.add(received.remove(0));
         }
         else {
             received.add(newMail);
         }

    }

    public void deleteMail(String message){
        // Each message is distinct
        // If the given message is found in any mail in the inbox, move the mail to trash, else do nothing
        for(mail m:received){
            if(received.contains(message)){
                received.remove(m);
            }
        }
    }

    public String findLatestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the latest mail present in the inbox
        if(received.isEmpty()){
            return null;
        }
        else {
           int n=received.size();
           mail Mail=received.get(n-1);
           String lastMsg=Mail.message;
            return lastMsg;
        }
    }

    public String findOldestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the oldest mail present in the inbox
        if (received.isEmpty()){
            return null;
        }
        else {
            mail Mail=received.get(0);
            String lastMsg=Mail.message;
            return lastMsg;
        }

    }

    public int findMailsBetweenDates(Date start, Date end){
        //find number of mails in the inbox which are received between given dates
        //It is guaranteed that start date <= end date
        int count=0;

       for (mail m:received){
           Date currentDate=m.date;
           if(currentDate.before(end) && currentDate.after(start)){
             count++;
           }
       }

        return count;


    }

    public int getInboxSize(){
        // Return number of mails in inbox
      return received.size();
    }

    public int getTrashSize(){
        // Return number of mails in Trash
       return trash.size();
    }

    public void emptyTrash(){
        // clear all mails in the trash
        trash.clear();
    }

    public int getInboxCapacity() {
        // Return the maximum number of mails that can be stored in the inbox
        return inboxCapacity;
    }
}
