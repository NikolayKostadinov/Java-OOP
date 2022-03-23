package heroRepository;

import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class HeroRepositoryTests {
    public static final Hero HERO = new Hero("TestHero", 1);
    private static final Hero HERO_HIGHEST_LEVEL = new Hero("TestHero10", 10);
    HeroRepository repository;

    @Before
    public void Init() {
        this.repository = new HeroRepository();
    }

    @Test
    public void getCountWillReturnOneMoreAfterCreate() {
        // Arrange
        int initialCount = repository.getCount();

        // Act
        repository.create(HERO);

        // Assert
        assertEquals(initialCount + 1, repository.getCount());
    }

    @Test
    public void createWillAddHero() {
        // Arrange
        int initialCount = repository.getCount();

        // Act
        repository.create(HERO);
        var added = repository.getHeroes().stream().collect(Collectors.toList())
                .get(repository.getHeroes().size() - 1);
        // Assert
        assertEquals(initialCount + 1, repository.getCount());
        assertEquals(HERO.getName(), added.getName());
        assertEquals(HERO.getLevel(), added.getLevel());
    }

    @Test
    public void createWillReturnMessage() {
        // Arrange
        String expectedMessage =
                String.format("Successfully added hero %s with level %d", HERO.getName(), HERO.getLevel());
        int initialCount = repository.getCount();

        // Act
        String message = repository.create(HERO);

        // Assert
        assertEquals(expectedMessage, message);
    }

    @Test(expected = NullPointerException.class)
    public void createThrowsExceptionWhenAddNullHero() {
        this.repository.create(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createThrowsExceptionWhenAddExistingHero() {
        this.repository.create(HERO);
        this.repository.create(HERO);
    }

    @Test
    public void removeWillRemoveHero() {
        // Arrange
        repository.create(HERO);
        int initialCount = repository.getCount();

        // Act
        boolean result = repository.remove(HERO.getName());

        // Assert
        assertEquals(initialCount - 1, repository.getCount());
        assertEquals(true, result);
    }

    @Test(expected = NullPointerException.class)
    public void removeThrowsExceptionWhenNameIsNull() {
        this.repository.remove(null);
    }

    @Test
    public void getHeroWithHighestLevelWillReturnHeroWithHighestLevel() {
        // Arrange
        repository.create(HERO);
        repository.create(HERO_HIGHEST_LEVEL);


        // Act
        Hero resultHero = repository.getHeroWithHighestLevel();

        // Assert
        assertEquals(HERO_HIGHEST_LEVEL, resultHero);
    }

    @Test
    public void getHeroWithHighestLevelWillReturnNullIfRepoIsEmpty() {

        // Act
        Hero resultHero = repository.getHeroWithHighestLevel();

        // Assert
        assertNull(resultHero);
    }

    @Test
    public void getHeroWillReturnHero() {
        // Arrange
        repository.create(HERO);
        repository.create(HERO_HIGHEST_LEVEL);


        // Act
        Hero resultHero = repository.getHero(HERO.getName());

        // Assert
        assertEquals(HERO, resultHero);
    }

    @Test
    public void getHeroNullIfNoHeroWithThisNameFound() {
        // Arrange
        this.repository.create(HERO);
        // Act
        Hero resultHero = repository.getHero(HERO_HIGHEST_LEVEL.getName());

        // Assert
        assertNull(resultHero);
    }

    @Test
    public void getHeroNullIfRepositoryIsEmpty() {

        // Act
        Hero resultHero = repository.getHero(HERO_HIGHEST_LEVEL.getName());

        // Assert
        assertNull(resultHero);
    }

    @Test
    public void getHeroesWillReturnAllHeroes() {
        // Arrange
        Hero[] heroes = {HERO, HERO_HIGHEST_LEVEL};
        for (Hero hero : heroes) {
            this.repository.create(hero);
        }

        // Act
        Hero[] resultHeroes = this.repository.getHeroes().toArray(Hero[]::new);

        // Assert
        assertArrayEquals(heroes, resultHeroes);

    }


}
