package calendarApp.json;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.io.Reader;
import com.fasterxml.jackson.databind.module.SimpleModule;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import calendarApp.core.Calendar;
/* For running main-method
import calendarApp.core.DaysOfTheWeek;
import calendarApp.core.Appointment;
*/
import calendarApp.core.CalendarLogic;

//Handles saving and loading of calendars.
public class CalendarSaveHandler {
    
    private ObjectMapper fileMapper;
    public CalendarSaveHandler() {
        fileMapper = new ObjectMapper();
        fileMapper.registerModule(new CalendarAppModule());
    }

    //Stores the string of the path to the directory where calendars are stored - in a CONSTANT.
    public final static String SAVE_FOLDER = "/workspace/gr2230/2230/data/src/main/java/calendarApp/data/savedCalendars/";

    /**
     * @param filename - filename of calendar to be retrieved.
     * @return path to .json calendar file.
     */
    public static String getFilePath(String filename) {
		return SAVE_FOLDER + filename + ".json";
	}

    /**
     * @param filename - name of calendar one wants to see if exists (name of calendar is same as its filename (w.out .filetype)).
     * @return - true if the calendar exists, false if it doesn't.
     */
    public boolean checkIfFileExists(String filename) {
        File file = new File(getFilePath(filename));
            if(file.isFile()) { 
                return true;
            }
            else {
                return false;
            }
    }

    /**
     * Saves a calendar object in a json file with serialization
     * @param calendar - calendar object
     * @throws IOException - throws IOException
     */
    public static void save(Calendar calendar) throws IOException, JsonProcessingException{
        
        // Serializes the calendar through CalendarAppModule
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new CalendarAppModule());
        
        // Serializes to a string 
        String json = mapper.writeValueAsString(calendar);

        // The name of the json file created / updated is equal to the calendar object's name + ".json"
        File calendarJson = new File(getFilePath(calendar.getCalendarName()));
        if (calendarJson.createNewFile()) {
            System.out.println("File created: " + calendarJson.getName());
          } else {
            System.out.println("File already exists.");
          }
        
        FileOutputStream outputStream = new FileOutputStream(calendarJson);
        OutputStreamWriter writer = new OutputStreamWriter(outputStream, "UTF-8");
        
        // Writes the serialized string (json) to the file
        try {
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }   

    public static ObjectMapper createObjectMapper() {
        return new ObjectMapper().registerModule(createJacksonModule());
    }

    public static SimpleModule createJacksonModule() {
        return new CalendarAppModule();
    }
    
    /**
     * Creates a calendar object with respective appointment objects from a json file.
     * @param calendarName - the name of the calendar one wants to retrieve.
     * @throws IOException
     * @throws JsonMappingException
     * @throws JsonParseException
     */
    public static Calendar load(String calendarName) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new CalendarAppModule());

        Path filePath = Path.of(getFilePath(calendarName));
        String calendarString = Files.readString(filePath);

        Calendar calendar = mapper.readValue(calendarString, Calendar.class);

        return calendar;
    } 

    /**
     * @return an ArrayList of all filenames in the savedCalendars directory.
     */
    public ArrayList<String> getAllFileNames() {
		ArrayList<String> filenames = new ArrayList<String>();

        ResourceBundle bundle = ResourceBundle.getBundle(SAVE_FOLDER);
        String saveFolderPath = bundle.getString(SAVE_FOLDER);

        File[] files = new File(saveFolderPath).listFiles();
        //If this pathname does not contain a directory, then listFiles() returns null. 
        if (files == null) {
            return new ArrayList<String>();
        }
		
		for (File file : files) {
		    if (file.isFile()) {
		        filenames.add(file.getName());
		    }
		}
		
		return filenames;
	}

    private Path saveFilePath = null;

    /**
     * 
     * @param saveFile
     */
    public void setSaveFile(String saveFile) {
        this.saveFilePath = Paths.get(System.getProperty("user.home"), saveFile);
    }

    /**
     * 
     * @return saveFilePath
     */
    public Path getSaveFilePath() {
        return this.saveFilePath;
    }

    public CalendarLogic readCalendarLogic(Reader reader) throws IOException {
        return fileMapper.readValue(reader, CalendarLogic.class);
    }

    //For practical testing.
    /*public static void main(String[] args) throws IOException {
        CalendarSaveHandler fileHandler = new CalendarSaveHandler();
        Calendar calendar = new Calendar("Steinar");
        Appointment appointment = new Appointment("Musikk", DaysOfTheWeek.MONDAY, 8, 9, 0, 0);
        calendar.addAppointment(appointment);
        CalendarSaveHandler.save(calendar);
        System.out.println(fileHandler.checkIfFileExists("Steinar"));


        CalendarSaveHandler.load("Steinar");
        //ERROR
        // System.out.println(fileHandler.getAllFileNames());
    }
    */
}