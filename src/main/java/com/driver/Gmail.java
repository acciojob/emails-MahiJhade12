package com.driver;

import org.apache.commons.lang3.tuple.Triple;

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

    public Gmail(String emailId, int inboxCapacity) {
        super(emailId);
        this.inboxCapacity=inboxCapacity;
        this.received=new ArrayList<>();
        this.trash=new ArrayList<>();
    }

    public void receiveMail(Date date, String sender, String message){

         mail newMail=new mail(date,sender,message);
        if(received.size()>=inboxCapacity){
             mail oldMail=received.remove(0);
             trash.add(oldMail);
             received.add(newMail);
         }
         else {
             received.add(newMail);
         }

    }

    public void deleteMail(String message){
        // Each message is distinct
        // If the given message is found in any mail in the inbox, move the mail to trash, else do nothing
           for(int i=0;i<received.size();i++){
            if(received.get(i).message==message){
                trash.add(received.remove(i));
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
           if(currentDate.compareTo(start)>=0 && currentDate.compareTo(end)<=0){
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
        int capacity=this.inboxCapacity;
        return capacity;
    }
}

   /* int inboxCapacity;
    private ArrayList<Triple<Date, String, String>> Inbox; //triple of date (Date), sender (String), message (String)
    private ArrayList<Triple<Date, String, String>> Trash;
    public Gmail(String emailId, int inboxCapacity) {
        super(emailId);
        this.inboxCapacity = inboxCapacity;
        this.Inbox = new ArrayList<>();
        this.Trash = new ArrayList<>();
    }

    public void receiveMail(Date date, String sender, String message){
        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
        // It is guaranteed that:
        // 1. Each mail in the inbox is distinct.
        // 2. The mails are received in non-decreasing order. This means that the date of a new mail is greater than equal to the dates of mails received already.
        if(Inbox.size() == inboxCapacity){
            Triple<Date, String, String> oldestMail = Inbox.get(0);
            Inbox.remove(0);
            Trash.add(oldestMail);
        }
        Triple<Date, String, String> mail = Triple.of(date, sender, message);
        Inbox.add(mail);
    }

    public void deleteMail(String message){
        // Each message is distinct
        // If the given message is found in the inbox, move the mail to trash, else do nothing
        int index = -1;
        for(int i = 0; i<Inbox.size(); i++){
            if(message.equals(Inbox.get(i).getRight())){
                index = i;
                break;
            }
        }

        if(index != -1){
            Trash.add(Inbox.get(index));
            Inbox.remove(index);
        }
    }

    public String findLatestMessage(){
        // If the inbox is empty, return null
        // Else, return the latest message present in the inbox
        if(Inbox.isEmpty())
            return null;
        return Inbox.get(Inbox.size()-1).getRight();
    }

    public String findOldestMessage(){
        // If the inbox is empty, return null
        // Else, return the oldest message present in the inbox
        if(Inbox.isEmpty())
            return null;
        return Inbox.get(0).getRight();
    }

    public int findMailsBetweenDates(Date start, Date end){
        //find number of emails between given dates
        //It is guaranteed that start date <= end date
        int cnt = 0;
        for(int i = 0; i<Inbox.size(); i++){
            if((Inbox.get(i).getLeft().compareTo(start) >= 0) && (Inbox.get(i).getLeft().compareTo(end) <= 0)){
                cnt += 1;
            }
        }
        return cnt;
    }

    public int getInboxSize(){
        // Return number of mails in inbox
        return Inbox.size();
    }

    public int getTrashSize(){
        // Return number of mails in Trash
        return Trash.size();
    }

    public void emptyTrash(){
        // clear all mails in the trash
        Trash.clear();
    }

    public int getInboxCapacity() {
        return inboxCapacity;
    }
}*/