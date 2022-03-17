import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StrangeGameTest {
    private Player testPlayer = new Player();
    private StrangeGame testGame = new StrangeGame();

    @Mock
    Hour hour ;
    @Spy
    Prison prison ;
    @Spy
    Prison prison_c;
    @Mock
    GAMEDb myGameDb;



    @Test
    void test_a() throws InterruptedException {
        testGame.hour = hour;
        testGame.setPrison(prison);
        when(hour.getHour()).thenReturn(11);
        assertEquals("The game is not yet open!",testGame.enterGame(testPlayer));
        verify(prison,never()).imprisonment(testPlayer);
    }
    @Test
    void test_b() throws InterruptedException{
        when(hour.getHour()).thenReturn(12);
        testGame.hour = hour;
        testGame.setPrison(prison);

        doNothing().when(prison).imprisonment(testPlayer);
        assertEquals("After a long period of punishment, the player can leave! :)",testGame.enterGame(testPlayer));
        verify(prison).imprisonment(testPlayer);
    }
    @Test
    void test_c() throws InterruptedException{
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        testGame.hour = hour;
        testGame.setPrison(prison_c);
        when(hour.getHour()).thenReturn(12);
        doNothing().when(prison_c).imprisonment(player1);
        doNothing().when(prison_c).imprisonment(player2);
        doNothing().when(prison_c).imprisonment(player3);
        List prisonList = new ArrayList();
        prisonList.add(player1.getPlayerId());
        prisonList.add(player2.getPlayerId());
        prisonList.add(player3.getPlayerId());
        testGame.enterGame(player1);
        testGame.enterGame(player2);
        testGame.enterGame(player3);
        assertEquals(prisonList,prison_c.getLog());
    }
    @Test
    void test_d() throws InterruptedException{

        final String myId = "310555008";
        final int score = 100;
        when(myGameDb.getScore(myId)).thenReturn(score);
        assertEquals(score,myGameDb.getScore(myId));
    }
    @Test
    void test_e() throws InterruptedException{
        paypalService myPaypalService = new myPaypalService();
        assertEquals(testGame.donate(myPaypalService),"Thank you");
    }
}

class myPaypalService implements paypalService{

    @Override
    public String doDonate() {
        return "Success";
    }
}