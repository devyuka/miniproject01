import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Questions {
    private List<String> cityNames;
    private int cityNamesCount;
    private String cityName;
    private String underscores;
    private StringBuilder wrongLetters = new StringBuilder();
    private int guessCount;

    Questions(){
        fileToList();
    }

    /**
     * Return a city name randomly chosen.
     * @return String city name
     */
    public String pickCity(){
        int randomNum = (int)(Math.random() * cityNamesCount);
        cityName = cityNames.get(randomNum);
        // Delete the below code as it shows the answer when the game starts.
        System.out.println(cityName);
        return cityName;
    }

    /**
     * Return underscores (_) the city name is converted to.
     * @return String underscores
     */
    public String gameStart(){
        underscores = pickCity().replaceAll("[a-zA-Z]", "_");
        return underscores;
    }

    /**
     * Reassign a newly created underscores that replaced an underscore with a correct letter user entered.
     * @param letter
     */
    public void guessCorrect(String letter){
        StringBuilder sbUnderscores = new StringBuilder();
        sbUnderscores.append(underscores);

            for(int i = 0; i < cityName.length(); i++){
                if(Character.toString(cityName.charAt(i)).equals(letter)){
                    sbUnderscores.replace(i , i + 1, letter);
                    underscores = sbUnderscores.toString();
                }
            }
    }

    /**
     * Add a wrong letter to wrongLetters and increment a guessCount.
     * @param letter
     */
    public void guessWrong(String letter){
        if((letter.length() == 1) && (letter != null) && (!letter.equals(""))){
            wrongLetters.append(letter + " ");
            guessCount++;
        }
    }

    /**
     * Read a text file and store the list and its size to variables.
     */
    public void fileToList() {
        try (Stream<String> lines = Files.lines(Paths.get("cities.txt"))) {
            cityNames = lines.collect(Collectors.toList());
            cityNamesCount = cityNames.size();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getCityNames() {
        return cityNames;
    }

    public String getCityName() {
        return cityName;
    }

    public String getUnderscores() {
        return underscores;
    }

    public StringBuilder getWrongLetters() {
        return wrongLetters;
    }

    public int getGuessCount() {
        return guessCount;
    }

    public void setCityNames(List<String> cityNames) {
        this.cityNames = cityNames;
    }

    public void setCityNamesCount(int cityNamesCount) {
        this.cityNamesCount = cityNamesCount;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setUnderscores(String underscores) {
        this.underscores = underscores;
    }

    public void setWrongLetters(StringBuilder wrongLetters) {
        this.wrongLetters = wrongLetters;
    }

    public void setGuessCount(int guessCount) {
        this.guessCount = guessCount;
    }
}