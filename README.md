# LivingWorld Simulation

## Opis projektu

LivingWorld to symulacja ekosystemu, w której różne organizmy (zwierzęta i rośliny) współistnieją, poruszają się po planszy oraz wchodzą ze sobą w interakcje. Symulacja pozwala na rozwój populacji, tworzenie grup oraz zjawiska takie jak kolizje, reprodukcja roślin czy ataki między zwierzętami.

## Główne funkcje

- **Symulacja ruchu organizmów**: Zwierzęta poruszają się po planszy, a ich kierunek i prędkość mogą się zmieniać w wyniku kolizji z innymi organizmami lub krawędziami mapy.
- **Kolizje i interakcje**:
  - Zwierzęta mogą atakować inne zwierzęta, co skutkuje zmianą punktów życia.
  - Zwierzęta jedzą rośliny, aby odzyskać energię.
  - Przyjaźnie między zwierzętami prowadzą do tworzenia grup.
- **Reprodukcja roślin**: Rośliny mogą się rozmnażać w oparciu o czas generacji.
- **Tworzenie grup**: Zwierzęta mogą tworzyć grupy, które poruszają się i koordynują swoje działania.

## Struktura projektu

### Główne klasy i ich funkcjonalności:

#### `SimulationDisplay.java`

Główna klasa odpowiedzialna za renderowanie symulacji. Obsługuje ruch organizmów, kolizje, reprodukcję roślin oraz aktualizację stanu symulacji.

Metody:
- `nextStep()` - wykonuje krok symulacji.
- `charactersMove()` - porusza zwierzęta na planszy.
- `plantsReproduction()` - dodaje nowe rośliny.
- `ifCollided()` - obsługuje kolizje między organizmami.
- `borderCheck()` - sprawdza granice mapy.
- `groupsChecker()` - aktualizuje położenie grup zwierząt.
- `pregnantCheck()` - dodaje potomstwo zwierząt do symulacji.

#### `OrganismsAbstract`

Abstrakcyjne klasy i interfejsy dla organizmów:
- `IAnimal` - interfejs dla zwierząt.
- `IPlant` - interfejs dla roślin.
- `Animal` - klasa bazowa dla zwierząt.
- `Plant` - klasa bazowa dla roślin.

#### Fabryki

- `AnimalFactory.java` - generuje instancje zwierząt.
- `PlantFactory.java` - generuje instancje roślin.

#### Klasy zwierząt i roślin

Zwierzęta:
- `Human.java`
- `Llama.java`
- `Sheep.java`
- `Tiger.java`
- `Wolf.java`

Rośliny:
- `Daisy.java`
- `Flower.java`
- `SosnowskiBorsch.java`
- `LongGrass.java`

#### Inne klasy pomocnicze

- `Group.java` - reprezentuje grupy zwierząt.
- `PlaceHolder.java` - klasa pomocnicza (do uzupełnienia).

## Wymagania

- Java 8+
- Biblioteka Swing - do renderowania grafiki.
- Obrazy tła i ikon organizmów znajdują się w katalogu `src/main/resources`.
