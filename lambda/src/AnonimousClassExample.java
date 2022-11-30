import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;


public class AnonimousClassExample {

    public static void printResult(List<Player.Message>  messages)  {

         for ( Player.Message message: messages ){
            System.out.println( message.getMessage()  );
        }

        System.out.println("------------------------- ");
    }
    public static void main(String[] args) throws Exception {

// This is part of code with standard comparator interface
        Player player = new Player();

        List<Player.Message> playersMessages1 = player.getMessages();
        List<Player.Message> playersMessages2 = player.getMessages();
        List<Player.Message> playersMessages3 = player.getMessages();


        playersMessages1.sort( player.ascComparator );
        playersMessages2.sort( player.desComparator );
        playersMessages3.sort( player.nameComparator );

        printResult(playersMessages1);
        printResult(playersMessages2);
        printResult(playersMessages3);
              
// In this part of code sorting will be done with Comparable class as anonymus

        List<Player.Message> m1 = player.getMessages();
        
        m1.sort( new Comparator<Player.Message>() {

            @Override
            public int compare(Player.Message o1, Player.Message o2) {
                int res = o1.getPriority() - o2.getPriority();
                return res == 0 ? o1.getMessage().compareTo(o2.getMessage()): res;
            }       
        });
        printResult( m1 );

    }
}
