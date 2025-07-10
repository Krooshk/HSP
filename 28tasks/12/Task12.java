import java.util.*;

public class Task12
{
    public static String MassVote(int N, int [] Votes) {
        String MAJOR_WINNER = "majority winner";
        String MINOR_WINNER = "minority winner";
        String NO_WINNER = "no winner";

        if (N == 0) return NO_WINNER;

        int indexMax = 0;
        int sumVotes = 0;
        int people = 0;

        for (int i = 0; i < N; i++) {
            int vote = Votes[i];
            sumVotes += vote;
            if (vote == Votes[indexMax]) {
                people++;
            }
            if (vote > Votes[indexMax]) {
                indexMax = i;
                people = 1;
            }
        }

        double percent = Votes[indexMax] * 1.0 / sumVotes;

        if (people > 1) {
            return NO_WINNER;
        }

        if (percent > 0.5) {
            return  MAJOR_WINNER + " " + (indexMax + 1);
        }
        return  MINOR_WINNER + " " + (indexMax + 1);
    }

}

