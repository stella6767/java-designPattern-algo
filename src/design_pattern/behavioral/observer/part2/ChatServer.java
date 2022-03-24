package design_pattern.behavioral.observer.part2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChatServer {

    private Map<String, List<Subscriber>> subscribers= new HashMap<>();

    public void register(String subject, Subscriber subscriber){
        if (this.subscribers.containsKey(subject)){
            subscribers.get(subject).add(subscriber);
        }else{
            List<Subscriber> list = new ArrayList<>();
            list.add(subscriber);
            this.subscribers.put(subject,list);

        }
    }


    public void unRegister(String subject, Subscriber subscriber){
        if (this.subscribers.containsKey(subject)){
            subscribers.get(subject).remove(subscriber);
        }
    }

    public void sendMsg(User user, String subject, String msg){
        String userMsg = user.getName() + " : " + msg;
        if (this.subscribers.containsKey(subject)){
            this.subscribers.get(subject).forEach(subscriber -> subscriber.handleMessage(userMsg));
        }
    }



}
