package test.dbIntegrationTest;

import data.model.Film;
import db.dao.FilmDao;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class MockWithAnnotation {
    @Mock
    FilmDao filmDao;

    @BeforeMethod
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testPeopleDAO(){
        Mockito.when(filmDao.findFilmByName("название1")).thenReturn(new Film("название1", "ссылка1", "год1"));
        Film film = filmDao.findFilmByName("название1");
        assertThat(film.getName()).isEqualTo("название1");
    }
}
