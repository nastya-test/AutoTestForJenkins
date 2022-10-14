package test.mockitoTest;

public class MockWithAnnotation {
   /*
   //Первый способ. First way to do mocking, by @Mock annotation
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
        assertThat(film.getLink()).isEqualTo("ссылка1");
        assertThat(film.getYearAndGenre()).isEqualTo("год1");
    }*/

/*
    //Второй способ. Used the mock method
   @Test
   public void testPeopleDAO(){
       FilmDao filmDAO = Mockito.mock(FilmDao.class);
       Mockito.when(filmDAO.findFilmByName("название1")).thenReturn(new Film("название1", "ссылка1", "год1"));
       Film film = filmDAO.findFilmByName("название1");
       assertThat(film.getName()).isEqualTo("название1");
       assertThat(film.getLink()).isEqualTo("ссылка1");
       assertThat(film.getYearAndGenre()).isEqualTo("год1");
   }*/

/*    //Mock в зависимости от паметров
    @Test
    public void testPeopleDAO(){
        FilmDao filmDAO = Mockito.mock(FilmDao.class);
        Mockito.when(filmDAO.findFilmByName("название1")).thenReturn(new Film("название1", "ссылка1", "год1"));
        Mockito.when(filmDAO.findFilmByName("название2")).thenReturn(new Film("название2", "ссылка2", "год2"));
        Film film = filmDAO.findFilmByName("название1");
        assertThat(film.getName()).isEqualTo("название1");
        assertThat(film.getLink()).isEqualTo("ссылка1");
        assertThat(film.getYearAndGenre()).isEqualTo("год1");
        Film film2 = filmDAO.findFilmByName("название2");
        assertThat(film2.getName()).isEqualTo("название2");
        assertThat(film2.getLink()).isEqualTo("ссылка2");
        assertThat(film2.getYearAndGenre()).isEqualTo("год2");
    }*/

/*    //Mock всегда возвращающий одно и тоже Mockito.anyString()
    @Test
    public void testPeopleDAO() {
        FilmDao filmDAO = Mockito.mock(FilmDao.class);
        Mockito.when(filmDAO.findFilmByName(Mockito.anyString())).thenReturn(new Film("название1", "ссылка1", "год1"));
        Film film = filmDAO.findFilmByName("название1");
        assertThat(film.getName()).isEqualTo("название1");
        assertThat(film.getLink()).isEqualTo("ссылка1");
        assertThat(film.getYearAndGenre()).isEqualTo("год1");
        Film film2 = filmDAO.findFilmByName("название2");
        assertThat(film2.getName()).isEqualTo("название1");
        assertThat(film2.getLink()).isEqualTo("ссылка1");
        assertThat(film2.getYearAndGenre()).isEqualTo("год1");
    }*/

/*    //Генерация исключений
    @Test
    public void testPeopleDAO(){
        FilmDao filmDAO = Mockito.mock(FilmDao.class);
        Mockito.when(filmDAO.findFilmByName("название1")).thenThrow(new IllegalArgumentException());
        Throwable thrown = catchThrowable(() -> {
            filmDAO.findFilmByName("название1");
        });
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
        //Assertions.assertThrows(IllegalArgumentException.class, () -> peopleDAO.getPeopleById(1_000_000L));
    }*/

/*    //Spy. Mock для одного метода, остальные работают как раньше
    @Test
    public void testPeopleDAO(){
        FilmDao filmDAO = new FilmDao();
        FilmDao spiedDAO = Mockito.spy(filmDAO);
        Mockito.when(spiedDAO.findFilmByName(Mockito.anyString())).thenReturn(new Film("название1", "ссылка1", "год1"));
        Film p = spiedDAO.findFilmByName("any name");
        System.out.println(p.getName());
        Film p2 = spiedDAO.getFilm();
        System.out.println(p2.getName());
    }*/

/*
    //Проверка вызовов методов
// never()	Метод никогда не должен вызываться
// times(n)	n раз
// atLeast(n)	n или больше раз
// atLeastOnce()	1 или больше раз
// atMost(n)	n или меньше раз
// 	only()	Должен быть только один вызов и только к этому методу
    @Test
    public void testPeopleDAO(){
        FilmDao filmDAO = Mockito.mock(FilmDao.class);
        Mockito.when(filmDAO.findFilmByName(Mockito.anyString())).thenReturn(new Film("название1", "ссылка1", "год1"));
        Film film = filmDAO.findFilmByName("название1");
        Film film2 = filmDAO.findFilmByName("название2");
        // check whether this method is called twice.
        Mockito.verify(filmDAO, Mockito.times(2)).findFilmByName(Mockito.anyString());
        // check whether the getPeopleByName is never called.
        Mockito.verify(filmDAO, Mockito.never()).getFilm();
    }
*/

/*
    //Для теста
    @Mock
    private FilmDao filmDAO;
    @InjectMocks
    private DbInteraction dbInteraction;

    @BeforeMethod
    public void openPage() {
        MockitoAnnotations.initMocks(this);
        BaseTest.baseOpenPage("web",8);
        mockSetting();
    }

    private void mockSetting() {
        Mockito.when(filmDAO.findFilmByName(Mockito.anyString())).thenReturn(new Film("названиеMock", "ссылкаMock", "год1"));
        Mockito.when(filmDAO.insertFilm(Mockito.any(Film.class))).thenReturn(true);
    }

    @Test
    @Description("Добавление в DB одного фильма с баннера")
    public void checkDbInsertFilm(){
        dbInteraction.InsertFilm(
                new Film("название3Mock", "ссылка3", "год3")
        );
        Film film = filmDAO.findFilmByName("названиеMock");
        System.out.println("Get mock trailer: " + film);
    }
*/

}
