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

#### `LivingSimulation`

- **`ClosePanel.java`** - Panel, który pozwala na zamknięcie aplikacji.
- **`CloseWindow.java`** - Okno zamykające aplikację, które pojawia się po zakończeniu symulacji.
- **`MenuPanel.java`** - Panel menu głównego, zawierający opcje dla użytkownika.
- **`MenuPanelListener.java`** - Listener dla menu, odpowiada za reagowanie na akcje użytkownika w menu.
- **`OrganismSetListener.java`** - Listener odpowiedzialny za akcje związane z zestawem organizmów.
- **`OrganismSlider.java`** - Kontrolka suwaka do dostosowywania liczby organizmów w symulacji.
- **`SettingsFrame.java`** - Okno ustawień aplikacji.
- **`SettingsListener.java`** - Listener odpowiedzialny za reagowanie na zmiany ustawień.
- **`SettingsPanel.java`** - Panel, w którym użytkownik może zmieniać ustawienia symulacji.
- **`SimulationDisplay.java`** - Główna klasa odpowiedzialna za renderowanie symulacji.
- **`SimulationFrame.java`** - Ramka, która otacza symulację, zawierająca elementy interfejsu użytkownika.
- **`SimulatorApp.java`** - Główna aplikacja uruchamiająca symulację.

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

## Wymagania

- Java 8+
- Biblioteka Swing - do renderowania grafiki.
- Obrazy tła i ikon organizmów znajdują się w katalogu `src/main/resources`.
