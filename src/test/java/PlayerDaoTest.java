import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.NikitaPopovskiy.config.ApplicationContext;
import ru.NikitaPopovskiy.dao.PlayerDao;
import ru.NikitaPopovskiy.entity.Player;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerDaoTest {
    private PlayerDao playerDao;
    private Player player;


    @BeforeEach
    void init () {
        ApplicationContext applicationContext = new ApplicationContext();
        this.playerDao = applicationContext.getPlayerHibernateDao();
        this.player = new Player("Test");
    }

    @Test
    void testSave () {
        Player savedPlayer =  playerDao.save(player);
        assertNotNull(savedPlayer);
        assertTrue(savedPlayer.getId() > 0);
        assertEquals("Test",savedPlayer.getName());
    }

    @Test
    void testGetByName() {
        Player savedPlayer =  playerDao.save(player);
        Optional<Player> receivedPlayer = playerDao.getByName(player.getName());
        assertTrue(receivedPlayer.isPresent());
        assertTrue(receivedPlayer.get().getId() > 0);
        assertEquals("Test",receivedPlayer.get().getName());
    }


}
