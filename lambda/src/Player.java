import java.util.ArrayList;
import java.util.Comparator;

public class Player {

    public class Message {
        
        Integer priority;
        String message;

        public Message( int priority , String message ) {
            this.priority = priority;
            this.message = message;
        }
        int getPriority() {
            return priority; 
        }
        String getMessage( ) {
            return message;
        }
    }
    // comparator for player messages in ascending order
    public class MessageComparatorAscending implements Comparator<Message> {

        @Override
        public int compare(final Message o1, final Message o2) {
            return o1.priority - o2.priority;
        }
    }
    // comparator for player messages in descending order
    public class MessageComparatorDescending implements Comparator<Message> {
    
        @Override
        public int compare(final Message o1, final Message o2) {
            return -o1.priority + o2.priority;
        }
    }
    public class MessageComparatorName implements Comparator<Message> {
    
        @Override
        public int compare(final Message o1, final Message o2) {
            return o1.message.compareTo(o2.message);
        }
    }
    public MessageComparatorName nameComparator = new MessageComparatorName();
    public MessageComparatorAscending ascComparator = new MessageComparatorAscending();
    public MessageComparatorDescending desComparator = new MessageComparatorDescending();

    public ArrayList<Message> getMessages() {
        ArrayList<Message> listOfMessages = new ArrayList<Message>();
        
        listOfMessages.add( new Message( 0, "Player killed" ) );
        listOfMessages.add( new Message( 20, "Player is under attack") );
        listOfMessages.add( new Message( 2, "Player injured") );
        listOfMessages.add( new Message( 8, "Fire in a hall") );
        listOfMessages.add( new Message( 11, "Go to the plane") );
        listOfMessages.add( new Message( 11, "Find a car") );
        listOfMessages.add( new Message( 11, "Find a knight") );



        return listOfMessages;
    }
}
